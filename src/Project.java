import java.util.ArrayList;

public class Project {

    private String projectName;
    private String problemStatement;
    private String solution;
    private ArrayList<String> technologiesUsed;
    private String role;

    public Project(String projectName, String problemStatement, String solution,
                   ArrayList<String> technologiesUsed, String role) {

        this.projectName = projectName;
        this.problemStatement = problemStatement;
        this.solution = solution;
        this.technologiesUsed = technologiesUsed;
        this.role = role;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProblemStatement() {
        return problemStatement;
    }

    public void setProblemStatement(String problemStatement) {
        this.problemStatement = problemStatement;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public ArrayList<String> getTechnologiesUsed() {
        return technologiesUsed;
    }

    public void addTechnology(String technology) {
        technologiesUsed.add(technology);
    }

    public void removeTechnology(String technology) {
        technologiesUsed.remove(technology);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}