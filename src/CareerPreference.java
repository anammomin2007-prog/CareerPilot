import java.util.ArrayList;

public class CareerPreference {

    private String targetRole;
    private CareerGoal lookingFor;
    private ArrayList<String> careerInterests;

    public CareerPreference(String targetRole, CareerGoal lookingFor) {
        this.targetRole = targetRole;
        this.lookingFor = lookingFor;
        this.careerInterests = new ArrayList<>();
    }

    public String getTargetRole() {
        return targetRole;
    }

    public void setTargetRole(String targetRole) {
        this.targetRole = targetRole;
    }

    public CareerGoal getLookingFor() {
        return lookingFor;
    }

    public void setLookingFor(CareerGoal lookingFor) {
        this.lookingFor = lookingFor;
    }

    public void addCareerInterest(String interest) {
        careerInterests.add(interest);
    }

    public void removeCareerInterest(String interest) {
        careerInterests.remove(interest);
    }

    public ArrayList<String> getCareerInterests() {
        return careerInterests;
    }
}