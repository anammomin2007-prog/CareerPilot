import java.util.ArrayList;

public class StudentProfile {

    private PersonalInfo personalInfo;
    private Education education;
    private CareerPreference careerPreference;

    private ArrayList<String> skills;
    private ArrayList<Project> projects;

    private double studyHoursPerDay;
    private int studyDaysPerWeek;


    // =========================
    // CONSTRUCTOR
    // =========================

    public StudentProfile(
            PersonalInfo personalInfo,
            Education education,
            CareerPreference careerPreference) {

        this.personalInfo = personalInfo;
        this.education = education;
        this.careerPreference = careerPreference;

        this.skills = new ArrayList<>();
        this.projects = new ArrayList<>();

        this.studyHoursPerDay = 0;
        this.studyDaysPerWeek = 0;
    }


    // =========================
    // SKILLS
    // =========================

    public void addSkill(String skill) {
        this.skills.add(skill);
    }

    public void removeSkill(String skill) {
        this.skills.remove(skill);
    }

    public ArrayList<String> getSkills() {
        return skills;
    }


    // =========================
    // PROJECTS
    // =========================

    public void addProject(Project project) {
        this.projects.add(project);
    }

    public void removeProject(Project project) {
        this.projects.remove(project);
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }


    // =========================
    // STUDY TIME
    // =========================

    public void setStudyHoursPerDay(double studyHoursPerDay) {
        this.studyHoursPerDay = studyHoursPerDay;
    }

    public double getStudyHoursPerDay() {
        return studyHoursPerDay;
    }

    public void setStudyDaysPerWeek(int studyDaysPerWeek) {
        this.studyDaysPerWeek = studyDaysPerWeek;
    }

    public int getStudyDaysPerWeek() {
        return studyDaysPerWeek;
    }


    // =========================
    // PERSONAL INFORMATION
    // =========================

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }


    // =========================
    // EDUCATION
    // =========================

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }


    // =========================
    // CAREER PREFERENCE
    // =========================

    public CareerPreference getCareerPreference() {
        return careerPreference;
    }

    public void setCareerPreference(CareerPreference careerPreference) {
        this.careerPreference = careerPreference;
    }


    // =========================
    // DISPLAY PROJECTS
    // =========================

    public void displayProjects() {

        for (Project project : projects) {

            System.out.println(
                    "Project Name: "
                            + project.getProjectName()
            );

            System.out.println(
                    "Problem: "
                            + project.getProblemStatement()
            );

            System.out.println(
                    "Solution: "
                            + project.getSolution()
            );

            System.out.println(
                    "Technologies: "
                            + project.getTechnologiesUsed()
            );

            System.out.println(
                    "Role: "
                            + project.getRole()
            );
        }
    }
}