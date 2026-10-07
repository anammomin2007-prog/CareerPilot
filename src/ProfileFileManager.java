import java.io.*;
import java.util.ArrayList;

public class ProfileFileManager {

    private static final String FILE_PATH =
            "data/profile.txt";


    // =========================
    // SAVE PROFILE
    // =========================

    public void saveProfile(StudentProfile profile) {

        File dataFolder = new File("data");

        if (!dataFolder.exists()) {
            dataFolder.mkdir();
        }

        try (FileWriter writer =
                     new FileWriter(FILE_PATH)) {

            // Personal Information
            writer.write("NAME=" +
                    profile.getPersonalInfo().getName() + "\n");

            writer.write("EMAIL=" +
                    profile.getPersonalInfo().getEmail() + "\n");


            // Education
            writer.write("COLLEGE=" +
                    profile.getEducation().getCollege() + "\n");

            writer.write("DEGREE=" +
                    profile.getEducation().getDegree() + "\n");

            writer.write("BRANCH=" +
                    profile.getEducation().getBranch() + "\n");

            writer.write("CURRENT_YEAR=" +
                    profile.getEducation().getCurrentYear() + "\n");

            writer.write("CGPA=" +
                    profile.getEducation().getCgpa() + "\n");

            writer.write("PASSING_YEAR=" +
                    profile.getEducation().getPassingYear() + "\n");


            // Career Preference
            writer.write("TARGET_ROLE=" +
                    profile.getCareerPreference().getTargetRole() + "\n");

            writer.write("CAREER_GOAL=" +
                    profile.getCareerPreference().getLookingFor() + "\n");


            // Study Availability
            writer.write("STUDY_HOURS_PER_DAY=" +
                    profile.getStudyHoursPerDay() + "\n");

            writer.write("STUDY_DAYS_PER_WEEK=" +
                    profile.getStudyDaysPerWeek() + "\n");


            // Career Interests
            writer.write("INTEREST_COUNT=" +
                    profile.getCareerPreference()
                            .getCareerInterests()
                            .size() + "\n");

            for (String interest :
                    profile.getCareerPreference()
                            .getCareerInterests()) {

                writer.write("INTEREST=" +
                        interest + "\n");
            }


            // Skills
            writer.write("SKILL_COUNT=" +
                    profile.getSkills().size() + "\n");

            for (String skill : profile.getSkills()) {

                writer.write("SKILL=" +
                        skill + "\n");
            }


            // Projects
            writer.write("PROJECT_COUNT=" +
                    profile.getProjects().size() + "\n");

            for (Project project :
                    profile.getProjects()) {

                writer.write("PROJECT_NAME=" +
                        project.getProjectName() + "\n");

                writer.write("PROJECT_PROBLEM=" +
                        project.getProblemStatement() + "\n");

                writer.write("PROJECT_SOLUTION=" +
                        project.getSolution() + "\n");

                writer.write("PROJECT_ROLE=" +
                        project.getRole() + "\n");

                writer.write("TECHNOLOGY_COUNT=" +
                        project.getTechnologiesUsed().size() + "\n");

                for (String technology :
                        project.getTechnologiesUsed()) {

                    writer.write("TECHNOLOGY=" +
                            technology + "\n");
                }
            }


            System.out.println(
                    "\nProfile saved successfully."
            );

        } catch (IOException e) {

            System.out.println(
                    "\nUnable to save profile."
            );

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }


    // =========================
    // LOAD PROFILE
    // =========================

    public StudentProfile loadProfile() {

        File file = new File(FILE_PATH);

        if (!file.exists()) {

            System.out.println(
                    "\nNo saved profile found."
            );

            return null;
        }


        String name = "";
        String email = "";

        String college = "";
        String degree = "";
        String branch = "";
        int currentYear = 0;
        double cgpa = 0;
        int passingYear = 0;

        String targetRole = "";
        CareerGoal careerGoal = null;

        // Default values keep older profile files compatible
        double studyHoursPerDay = 0;
        int studyDaysPerWeek = 0;

        ArrayList<String> interests =
                new ArrayList<>();

        ArrayList<String> skills =
                new ArrayList<>();

        ArrayList<Project> projects =
                new ArrayList<>();


        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(FILE_PATH))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts =
                        line.split("=", 2);

                String key = parts[0];
                String value = parts[1];

                switch (key) {

                    case "NAME":
                        name = value;
                        break;

                    case "EMAIL":
                        email = value;
                        break;


                    case "COLLEGE":
                        college = value;
                        break;

                    case "DEGREE":
                        degree = value;
                        break;

                    case "BRANCH":
                        branch = value;
                        break;

                    case "CURRENT_YEAR":
                        currentYear =
                                Integer.parseInt(value);
                        break;

                    case "CGPA":
                        cgpa =
                                Double.parseDouble(value);
                        break;

                    case "PASSING_YEAR":
                        passingYear =
                                Integer.parseInt(value);
                        break;


                    case "TARGET_ROLE":
                        targetRole = value;
                        break;

                    case "CAREER_GOAL":
                        careerGoal =
                                CareerGoal.valueOf(value);
                        break;


                    case "STUDY_HOURS_PER_DAY":
                        studyHoursPerDay =
                                Double.parseDouble(value);
                        break;

                    case "STUDY_DAYS_PER_WEEK":
                        studyDaysPerWeek =
                                Integer.parseInt(value);
                        break;


                    case "INTEREST":
                        interests.add(value);
                        break;

                    case "SKILL":
                        skills.add(value);
                        break;


                    case "PROJECT_NAME":

                        String projectName = value;

                        String problemStatement =
                                reader.readLine()
                                        .split("=", 2)[1];

                        String solution =
                                reader.readLine()
                                        .split("=", 2)[1];

                        String role =
                                reader.readLine()
                                        .split("=", 2)[1];

                        int technologyCount =
                                Integer.parseInt(
                                        reader.readLine()
                                                .split("=", 2)[1]
                                );

                        ArrayList<String> technologies =
                                new ArrayList<>();

                        for (int i = 0;
                             i < technologyCount;
                             i++) {

                            String technology =
                                    reader.readLine()
                                            .split("=", 2)[1];

                            technologies.add(technology);
                        }

                        Project project =
                                new Project(
                                        projectName,
                                        problemStatement,
                                        solution,
                                        technologies,
                                        role
                                );

                        projects.add(project);

                        break;
                }
            }


            // =========================
            // REBUILD OBJECTS
            // =========================

            PersonalInfo personalInfo =
                    new PersonalInfo(
                            name,
                            email
                    );


            Education education =
                    new Education(
                            EducationLevel.UNDERGRADUATE,
                            college,
                            degree,
                            branch,
                            currentYear,
                            cgpa,
                            passingYear
                    );


            CareerPreference careerPreference =
                    new CareerPreference(
                            targetRole,
                            careerGoal
                    );

            for (String interest : interests) {

                careerPreference
                        .addCareerInterest(interest);
            }


            StudentProfile profile =
                    new StudentProfile(
                            personalInfo,
                            education,
                            careerPreference
                    );


            // Restore study availability
            profile.setStudyHoursPerDay(
                    studyHoursPerDay
            );

            profile.setStudyDaysPerWeek(
                    studyDaysPerWeek
            );


            for (String skill : skills) {

                profile.addSkill(skill);
            }


            for (Project project : projects) {

                profile.addProject(project);
            }


            System.out.println(
                    "\nProfile loaded successfully."
            );

            return profile;


        } catch (IOException |
                 IllegalArgumentException e) {

            System.out.println(
                    "\nUnable to load profile."
            );

            System.out.println(
                    "Error: " + e.getMessage()
            );

            return null;
        }
    }
}