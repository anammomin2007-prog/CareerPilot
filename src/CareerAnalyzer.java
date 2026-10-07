import java.util.ArrayList;
public class CareerAnalyzer {
    private SkillGapAnalyzer skillGapAnalyzer;

    public CareerAnalyzer() {
        skillGapAnalyzer = new SkillGapAnalyzer();
    }

    public boolean isEligible(StudentProfile profile, Career career) {

        boolean cgpaEligible =
                skillGapAnalyzer.isCgpaEligible(profile, career);

        boolean skillsComplete =
                skillGapAnalyzer.findMissingSkills(profile, career).isEmpty();

        return cgpaEligible && skillsComplete;
    }

    public ArrayList<String> getMissingSkills(
            StudentProfile profile, Career career) {

        return skillGapAnalyzer.findMissingSkills(profile, career);
    }

    public ArrayList<String> getMatchedSkills(
            StudentProfile profile, Career career) {

        ArrayList<String> matchedSkills = new ArrayList<>();

        for (String requiredSkill : career.getRequiredSkills()) {

            if (profile.getSkills().contains(requiredSkill)) {
                matchedSkills.add(requiredSkill);
            }
        }

        return matchedSkills;
    }
    public ArrayList<String> getRelevantProjectTechnologies(
            StudentProfile profile,
            Career career) {

        ArrayList<String> relevantTechnologies = new ArrayList<>();

        for (Project project : profile.getProjects()) {

            for (String technology : project.getTechnologiesUsed()) {

                if (career.getRelevantTechnologies().contains(technology)) {
                    relevantTechnologies.add(technology);
                }
            }
        }

        return relevantTechnologies;
    }
    public ArrayList<String> getMatchedCareerInterests(
            StudentProfile profile,
            Career career) {

        ArrayList<String> matchedInterests = new ArrayList<>();

        for (String studentInterest :
                profile.getCareerPreference().getCareerInterests()) {

            if (career.getCareerInterests().contains(studentInterest)) {
                matchedInterests.add(studentInterest);
            }
        }

        return matchedInterests;
    }
    public CareerAnalysisResult analyze(
            StudentProfile profile,
            Career career) {

        ArrayList<String> matchedSkills =
                getMatchedSkills(profile, career);

        ArrayList<String> missingSkills =
                getMissingSkills(profile, career);

        ArrayList<String> matchedCareerInterests =
                getMatchedCareerInterests(profile, career);

        ArrayList<String> relevantProjectTechnologies =
                getRelevantProjectTechnologies(profile, career);

        boolean cgpaEligible =
                skillGapAnalyzer.isCgpaEligible(profile, career);

        double studentCgpa =
                profile.getEducation().getCgpa();

        double requiredCgpa =
                career.getMinimumCgpa();

        boolean roleMatches =
                profile.getCareerPreference()
                        .getTargetRole()
                        .equalsIgnoreCase(career.getName());

        return new CareerAnalysisResult(
                career,
                matchedSkills,
                missingSkills,
                matchedCareerInterests,
                relevantProjectTechnologies,
                studentCgpa,
                requiredCgpa,
                cgpaEligible,
                roleMatches
        );
    }
}