import java.util.ArrayList;

public class LearningRoadmapGenerator {

    private RoadmapRepository roadmapRepository;

    public LearningRoadmapGenerator() {
        roadmapRepository = new RoadmapRepository();
    }

    public LearningRoadmap generateRoadmap(
            CareerAnalysisResult result,
            StudentProfile profile) {

        LearningRoadmap roadmap =
                new LearningRoadmap(result.getCareer());

        for (String missingSkill : result.getMissingSkills()) {

            SkillRoadmap skillRoadmap =
                    roadmapRepository.getRoadmap(missingSkill);

            if (skillRoadmap != null) {

                for (String prerequisite :
                        skillRoadmap.getPrerequisites()) {

                    if (!profile.getSkills()
                            .contains(prerequisite)) {

                        SkillRoadmap prerequisiteRoadmap =
                                roadmapRepository.getRoadmap(prerequisite);

                        if (prerequisiteRoadmap != null) {

                            roadmap.addSkillRoadmap(
                                    prerequisiteRoadmap
                            );
                        }
                    }
                }

                roadmap.addSkillRoadmap(skillRoadmap);
            }
        }

        return roadmap;
    }
}