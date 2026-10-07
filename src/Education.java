public class Education {

    private EducationLevel educationLevel;
    private String college;
    private String degree;
    private String branch;
    private int currentYear;
    private double cgpa;
    private int passingYear;

    public Education(EducationLevel educationLevel, String college, String degree,
                     String branch, int currentYear, double cgpa, int passingYear) {

        this.educationLevel = educationLevel;
        this.college = college;
        this.degree = degree;
        this.branch = branch;
        this.currentYear = currentYear;
        this.cgpa = cgpa;
        this.passingYear = passingYear;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public int getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(int passingYear) {
        this.passingYear = passingYear;
    }
}