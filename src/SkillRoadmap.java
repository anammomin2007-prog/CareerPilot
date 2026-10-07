import java.util.ArrayList;

public class SkillRoadmap {

    private String skillName;
    private ArrayList<String> prerequisites;
    private ArrayList<LearningTopic> topics;

    public SkillRoadmap(
            String skillName,
            ArrayList<String> prerequisites,
            ArrayList<LearningTopic> topics) {

        this.skillName = skillName;
        this.prerequisites = prerequisites;
        this.topics = topics;
    }

    public String getSkillName() {
        return skillName;
    }

    public ArrayList<String> getPrerequisites() {
        return prerequisites;
    }

    public ArrayList<LearningTopic> getTopics() {
        return topics;
    }
}