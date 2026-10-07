public class StudyPlanItem {

    private String skill;
    private String topic;
    private int estimatedHours;

    public StudyPlanItem(
            String skill,
            String topic,
            int estimatedHours) {

        this.skill = skill;
        this.topic = topic;
        this.estimatedHours = estimatedHours;
    }

    public String getSkill() {
        return skill;
    }

    public String getTopic() {
        return topic;
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }
}