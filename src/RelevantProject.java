import java.util.ArrayList;

public class RelevantProject {

    private Project project;
    private ArrayList<String> matchedTechnologies;

    public RelevantProject(
            Project project,
            ArrayList<String> matchedTechnologies) {

        this.project = project;
        this.matchedTechnologies = matchedTechnologies;
    }

    public Project getProject() {
        return project;
    }

    public ArrayList<String> getMatchedTechnologies() {
        return matchedTechnologies;
    }
}