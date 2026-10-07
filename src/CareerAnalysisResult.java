import java.util.ArrayList;

public class CareerAnalysisResult {

    private Career career;
    private ArrayList<String> matchedSkills;
    private ArrayList<String> missingSkills;
    private ArrayList<String> matchedCareerInterests;
    private ArrayList<String> relevantProjectTechnologies;

    private double studentCgpa;
    private double requiredCgpa;
    private boolean cgpaEligible;
    private boolean roleMatches;

    public CareerAnalysisResult(
            Career career,
            ArrayList<String> matchedSkills,
            ArrayList<String> missingSkills,
            ArrayList<String> matchedCareerInterests,
            ArrayList<String> relevantProjectTechnologies,
            double studentCgpa,
            double requiredCgpa,
            boolean cgpaEligible,
            boolean roleMatches) {

        this.career = career;
        this.matchedSkills = matchedSkills;
        this.missingSkills = missingSkills;
        this.matchedCareerInterests = matchedCareerInterests;
        this.relevantProjectTechnologies = relevantProjectTechnologies;
        this.studentCgpa = studentCgpa;
        this.requiredCgpa = requiredCgpa;
        this.cgpaEligible = cgpaEligible;
        this.roleMatches = roleMatches;
    }

    public Career getCareer() {
        return career;
    }

    public ArrayList<String> getMatchedSkills() {
        return matchedSkills;
    }

    public ArrayList<String> getMissingSkills() {
        return missingSkills;
    }

    public ArrayList<String> getMatchedCareerInterests() {
        return matchedCareerInterests;
    }

    public ArrayList<String> getRelevantProjectTechnologies() {
        return relevantProjectTechnologies;
    }

    public double getStudentCgpa() {
        return studentCgpa;
    }

    public double getRequiredCgpa() {
        return requiredCgpa;
    }

    public boolean isCgpaEligible() {
        return cgpaEligible;
    }

    public boolean isRoleMatches() {
        return roleMatches;
    }

    public int getTotalRequiredSkills() {
        return matchedSkills.size() + missingSkills.size();
    }

    public int getKnownSkillCount() {
        return matchedSkills.size();
    }

    public int getMissingSkillCount() {
        return missingSkills.size();
    }

    public double getSkillCoverage() {

        int totalRequiredSkills = getTotalRequiredSkills();

        if (totalRequiredSkills == 0) {
            return 0;
        }

        return (double) getKnownSkillCount()
                / totalRequiredSkills * 100;
    }
}