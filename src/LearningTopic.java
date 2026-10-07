public class LearningTopic {

    private String topicName;
    private String skill;
    private String description;
    private int order;

    public LearningTopic(
            String topicName,
            String skill,
            String description,
            int order) {

        this.topicName = topicName;
        this.skill = skill;
        this.description = description;
        this.order = order;
    }

    public String getTopicName() {
        return topicName;
    }

    public String getSkill() {
        return skill;
    }

    public String getDescription() {
        return description;
    }

    public int getOrder() {
        return order;
    }
}