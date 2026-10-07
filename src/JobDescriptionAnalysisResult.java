import java.util.ArrayList;

public class JobDescriptionAnalysisResult {

    private JobDescription jobDescription;

    private ArrayList<String> requirements;
    private ArrayList<String> matchedSkills;
    private ArrayList<String> missingSkills;
    private ArrayList<String> relevantProjectTechnologies;
    private ArrayList<RelevantProject> relevantProjects;

    public JobDescriptionAnalysisResult(
            JobDescription jobDescription,
            ArrayList<String> requirements,
            ArrayList<String> matchedSkills,
            ArrayList<String> missingSkills,
            ArrayList<String> relevantProjectTechnologies,
            ArrayList<RelevantProject> relevantProjects) {

        this.jobDescription = jobDescription;
        this.requirements = requirements;
        this.matchedSkills = matchedSkills;
        this.missingSkills = missingSkills;
        this.relevantProjectTechnologies =
                relevantProjectTechnologies;
        this.relevantProjects = relevantProjects;
    }

    public JobDescription getJobDescription() {
        return jobDescription;
    }

    public ArrayList<String> getRequirements() {
        return requirements;
    }

    public ArrayList<String> getMatchedSkills() {
        return matchedSkills;
    }

    public ArrayList<String> getMissingSkills() {
        return missingSkills;
    }

    public ArrayList<String> getRelevantProjectTechnologies() {
        return relevantProjectTechnologies;
    }

    public int getRequirementCount() {
        return requirements.size();
    }

    public ArrayList<RelevantProject> getRelevantProjects() {
        return relevantProjects;
    }

    public int getMatchedSkillCount() {
        return matchedSkills.size();
    }

    public int getMissingSkillCount() {
        return missingSkills.size();
    }
}