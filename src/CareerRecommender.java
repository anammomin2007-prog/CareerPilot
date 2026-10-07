import java.util.ArrayList;

public class CareerRecommender {

    private CareerAnalyzer careerAnalyzer;

    public CareerRecommender() {
        careerAnalyzer = new CareerAnalyzer();
    }

    public ArrayList<Career> recommendCareers(
            StudentProfile profile,
            ArrayList<Career> careers) {

        ArrayList<Career> recommendedCareers = new ArrayList<>();

        for (Career career : careers) {

            CareerAnalysisResult result =
                    careerAnalyzer.analyze(profile, career);

            int score = 0;

            boolean roleMatches = result.isRoleMatches();

            if (roleMatches) {
                score += 4;
            }

            int matchedSkillCount =
                    result.getMatchedSkills().size();

            score += matchedSkillCount;

            if (result.isCgpaEligible()) {
                score += 2;
            }

            int relevantProjectTechnologyCount =
                    result.getRelevantProjectTechnologies().size();

            score += relevantProjectTechnologyCount;

            int matchedCareerInterestCount =
                    result.getMatchedCareerInterests().size();

            score += matchedCareerInterestCount * 3;

            if (score >= 4) {
                recommendedCareers.add(career);
            }
        }

        return recommendedCareers;
    }
}