import java.util.ArrayList;

public class Career {

    private String name;
    private ArrayList<String> requiredSkills;
    private double minimumCgpa;
    private ArrayList<String> relevantTechnologies;
    private ArrayList<String> careerInterests;

    public Career(String name,
                  double minimumCgpa,
                  ArrayList<String> requiredSkills,
                  ArrayList<String> relevantTechnologies,
                  ArrayList<String> careerInterests) {

        this.name = name;
        this.minimumCgpa = minimumCgpa;
        this.requiredSkills = requiredSkills;
        this.relevantTechnologies = relevantTechnologies;
        this.careerInterests = careerInterests;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getRequiredSkills() {
        return requiredSkills;
    }

    public double getMinimumCgpa() {
        return minimumCgpa;
    }

    public ArrayList<String> getRelevantTechnologies() {
        return relevantTechnologies;
    }

    public ArrayList<String> getCareerInterests() {
        return careerInterests;
    }
}