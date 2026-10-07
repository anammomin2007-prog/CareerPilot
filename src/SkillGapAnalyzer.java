import java.util.ArrayList;
public class SkillGapAnalyzer {
    public ArrayList<String> findMissingSkills(
            StudentProfile profile,
            Career career) {

        ArrayList<String> missingSkills =
                new ArrayList<>();

        for (String requiredSkill :
                career.getRequiredSkills()) {

            boolean found = false;

            for (String studentSkill :
                    profile.getSkills()) {

                if (studentSkill.equalsIgnoreCase(requiredSkill)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                missingSkills.add(requiredSkill);
            }
        }

        return missingSkills;
    }
    public boolean isCgpaEligible(StudentProfile profile, Career career) {
        double studentCgpa = profile.getEducation().getCgpa();
        double minimumCgpa = career.getMinimumCgpa();

        return studentCgpa >= minimumCgpa;
    }
}
