import java.util.ArrayList;

public class StudyPlanGenerator {

    public StudyPlan generatePlan(
            LearningRoadmap roadmap,
            StudentProfile profile) {

        StudyPlan plan = new StudyPlan(
                roadmap.getTargetCareer(),
                profile.getStudyHoursPerDay(),
                profile.getStudyDaysPerWeek()
        );

        for (SkillRoadmap skillRoadmap :
                roadmap.getSkillRoadmaps()) {

            ArrayList<LearningTopic> topics =
                    skillRoadmap.getTopics();

            for (LearningTopic topic : topics) {

                StudyPlanItem item =
                        new StudyPlanItem(
                                skillRoadmap.getSkillName(),
                                topic.getTopicName(),
                                2
                        );

                plan.addItem(item);
            }
        }

        return plan;
    }
}