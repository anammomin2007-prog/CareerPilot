import java.util.ArrayList;

public class JobDescriptionAnalyzer {

    private JobRequirementExtractor requirementExtractor;

    public JobDescriptionAnalyzer() {
        requirementExtractor =
                new JobRequirementExtractor();
    }

    public JobDescriptionAnalysisResult analyze(
            JobDescription jobDescription,
            StudentProfile profile,
            Career career) {

        ArrayList<String> requirements =
                requirementExtractor.extractRequirements(
                        jobDescription,
                        career
                );

        ArrayList<String> matchedSkills =
                new ArrayList<>();

        ArrayList<String> missingSkills =
                new ArrayList<>();

        ArrayList<String> relevantProjectTechnologies =
                new ArrayList<>();

        ArrayList<RelevantProject> relevantProjects =
                new ArrayList<>();

        // Compare JD requirements with student skills
        for (String requirement : requirements) {

            boolean found = false;

            for (String studentSkill :
                    profile.getSkills()) {

                if (studentSkill.equalsIgnoreCase(requirement)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                matchedSkills.add(requirement);
            } else {
                missingSkills.add(requirement);
            }
        }

        // Check whether JD requirements appear in projects
        for (Project project : profile.getProjects()) {

            ArrayList<String> matchedTechnologies =
                    new ArrayList<>();

            for (String technology :
                    project.getTechnologiesUsed()) {

                for (String requirement :
                        requirements) {

                    if (technology.equalsIgnoreCase(requirement)) {

                        if (!matchedTechnologies.contains(technology)) {
                            matchedTechnologies.add(technology);
                        }

                        if (!relevantProjectTechnologies.contains(technology)) {
                            relevantProjectTechnologies.add(technology);
                        }

                        break;
                    }
                }
            }

            if (!matchedTechnologies.isEmpty()) {

                RelevantProject relevantProject =
                        new RelevantProject(
                                project,
                                matchedTechnologies
                        );

                relevantProjects.add(relevantProject);
            }
        }

        return new JobDescriptionAnalysisResult(
                jobDescription,
                requirements,
                matchedSkills,
                missingSkills,
                relevantProjectTechnologies,
                relevantProjects
        );
    }
}