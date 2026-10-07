import java.util.ArrayList;

public class JobRequirementExtractor {

    public ArrayList<String> extractRequirements(
            JobDescription jobDescription,
            Career career) {

        ArrayList<String> requirements =
                new ArrayList<>();

        String text =
                jobDescription.getJobDescriptionText()
                        .toLowerCase();

        for (String skill :
                career.getRequiredSkills()) {

            if (text.contains(skill.toLowerCase())) {
                requirements.add(skill);
            }
        }

        return requirements;
    }
}