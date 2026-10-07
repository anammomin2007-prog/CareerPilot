import java.util.ArrayList;

public class StudyPlan {

    private Career targetCareer;
    private ArrayList<StudyPlanItem> items;
    private double hoursPerDay;
    private int daysPerWeek;

    public StudyPlan(
            Career targetCareer,
            double hoursPerDay,
            int daysPerWeek) {

        this.targetCareer = targetCareer;
        this.hoursPerDay = hoursPerDay;
        this.daysPerWeek = daysPerWeek;
        this.items = new ArrayList<>();
    }

    public void addItem(StudyPlanItem item) {
        items.add(item);
    }

    public Career getTargetCareer() {
        return targetCareer;
    }

    public ArrayList<StudyPlanItem> getItems() {
        return items;
    }

    public double getHoursPerDay() {
        return hoursPerDay;
    }

    public int getDaysPerWeek() {
        return daysPerWeek;
    }

    public double getWeeklyStudyHours() {
        return hoursPerDay * daysPerWeek;
    }

    public int getTotalEstimatedHours() {

        int total = 0;

        for (StudyPlanItem item : items) {
            total += item.getEstimatedHours();
        }

        return total;
    }

    public int getEstimatedWeeks() {

        double weeklyHours = getWeeklyStudyHours();

        if (weeklyHours <= 0) {
            return 0;
        }

        return (int) Math.ceil(
                getTotalEstimatedHours() / weeklyHours
        );
    }
}