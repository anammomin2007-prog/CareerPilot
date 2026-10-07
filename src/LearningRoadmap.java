import java.util.ArrayList;

public class LearningRoadmap {

    private Career targetCareer;
    private ArrayList<SkillRoadmap> skillRoadmaps;

    public LearningRoadmap(Career targetCareer) {
        this.targetCareer = targetCareer;
        this.skillRoadmaps = new ArrayList<>();
    }

    public Career getTargetCareer() {
        return targetCareer;
    }

    public void addSkillRoadmap(SkillRoadmap skillRoadmap) {
        skillRoadmaps.add(skillRoadmap);
    }

    public ArrayList<SkillRoadmap> getSkillRoadmaps() {
        return skillRoadmaps;
    }

    public int getTotalSkills() {
        return skillRoadmaps.size();
    }

    public int getTotalTopics() {

        int totalTopics = 0;

        for (SkillRoadmap skillRoadmap : skillRoadmaps) {
            totalTopics += skillRoadmap.getTopics().size();
        }

        return totalTopics;
    }

    public ArrayList<String> getSkillNames() {

        ArrayList<String> skillNames = new ArrayList<>();

        for (SkillRoadmap skillRoadmap : skillRoadmaps) {
            skillNames.add(skillRoadmap.getSkillName());
        }

        return skillNames;
    }
}