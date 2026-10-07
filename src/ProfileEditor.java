import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProfileEditor {

    private Scanner scanner;

    public ProfileEditor(Scanner scanner) {
        this.scanner = scanner;
    }


    // =========================
    // MAIN UPDATE MENU
    // =========================

    public void updateProfile(StudentProfile profile) {

        while (true) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("            UPDATE PROFILE");
            System.out.println("========================================");

            displayProfileSummary(profile);

            System.out.println();
            System.out.println("What do you want to update?");
            System.out.println("1. Personal Information");
            System.out.println("2. Education");
            System.out.println("3. Career Preference");
            System.out.println("4. Skills");
            System.out.println("5. Projects");
            System.out.println("6. Study Availability");
            System.out.println("7. Back");

            int choice = readChoice(1, 7);

            switch (choice) {

                case 1:
                    updatePersonalInformation(profile);
                    break;

                case 2:
                    updateEducation(profile);
                    break;

                case 3:
                    updateCareerPreference(profile);
                    break;

                case 4:
                    updateSkills(profile);
                    break;

                case 5:
                    updateProjects(profile);
                    break;

                case 6:
                    updateStudyAvailability(profile);
                    break;

                case 7:
                    return;
            }
        }
    }


    // =========================
    // PROFILE SUMMARY
    // =========================

    private void displayProfileSummary(StudentProfile profile) {

        System.out.println();

        System.out.println("Name          : "
                + profile.getPersonalInfo().getName());

        System.out.println("Email         : "
                + profile.getPersonalInfo().getEmail());

        System.out.println("College       : "
                + profile.getEducation().getCollege());

        System.out.println("Degree        : "
                + profile.getEducation().getDegree());

        System.out.println("Branch        : "
                + profile.getEducation().getBranch());

        System.out.println("Current Year  : "
                + profile.getEducation().getCurrentYear());

        System.out.println("CGPA          : "
                + profile.getEducation().getCgpa());

        System.out.println("Passing Year  : "
                + profile.getEducation().getPassingYear());

        System.out.println("Target Role   : "
                + profile.getCareerPreference().getTargetRole());

        System.out.println("Looking For   : "
                + profile.getCareerPreference().getLookingFor());

        System.out.println("Study Hours   : "
                + profile.getStudyHoursPerDay()
                + " hours/day");

        System.out.println("Study Days    : "
                + profile.getStudyDaysPerWeek()
                + " days/week");

        System.out.println("Skills        : "
                + profile.getSkills());

        System.out.println("Projects      : "
                + profile.getProjects().size());
    }


    // =========================
    // PERSONAL INFORMATION
    // =========================

    private void updatePersonalInformation(StudentProfile profile) {

        while (true) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("       PERSONAL INFORMATION");
            System.out.println("========================================");

            System.out.println("1. Name: "
                    + profile.getPersonalInfo().getName());

            System.out.println("2. Email: "
                    + profile.getPersonalInfo().getEmail());

            System.out.println("3. Back");

            int choice = readChoice(1, 3);

            switch (choice) {

                case 1:

                    System.out.print("Enter new name: ");
                    String name = readRequiredText();

                    profile.getPersonalInfo().setName(name);

                    System.out.println("Name updated successfully.");
                    break;

                case 2:

                    String email = readEmail();

                    profile.getPersonalInfo().setEmail(email);

                    System.out.println("Email updated successfully.");
                    break;

                case 3:
                    return;
            }
        }
    }


    // =========================
    // EDUCATION
    // =========================

    private void updateEducation(StudentProfile profile) {

        while (true) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("              EDUCATION");
            System.out.println("========================================");

            System.out.println("1. Education Level: "
                    + profile.getEducation().getEducationLevel());

            System.out.println("2. College: "
                    + profile.getEducation().getCollege());

            System.out.println("3. Degree: "
                    + profile.getEducation().getDegree());

            System.out.println("4. Branch: "
                    + profile.getEducation().getBranch());

            System.out.println("5. Current Year: "
                    + profile.getEducation().getCurrentYear());

            System.out.println("6. CGPA: "
                    + profile.getEducation().getCgpa());

            System.out.println("7. Passing Year: "
                    + profile.getEducation().getPassingYear());

            System.out.println("8. Back");

            int choice = readChoice(1, 8);

            switch (choice) {

                case 1:

                    updateEducationLevel(profile);
                    break;

                case 2:

                    System.out.print("Enter new college: ");
                    String college = readRequiredText();

                    profile.getEducation().setCollege(college);

                    System.out.println("College updated successfully.");
                    break;

                case 3:

                    System.out.print("Enter new degree: ");
                    String degree = readRequiredText();

                    profile.getEducation().setDegree(degree);

                    System.out.println("Degree updated successfully.");
                    break;

                case 4:

                    System.out.print("Enter new branch: ");
                    String branch = readRequiredText();

                    profile.getEducation().setBranch(branch);

                    System.out.println("Branch updated successfully.");
                    break;

                case 5:

                    int currentYear =
                            readIntegerInRange(
                                    "Enter new current year: ",
                                    1,
                                    10
                            );

                    profile.getEducation().setCurrentYear(currentYear);

                    System.out.println("Current year updated successfully.");
                    break;

                case 6:

                    double cgpa =
                            readDoubleInRange(
                                    "Enter new CGPA: ",
                                    0,
                                    10
                            );

                    profile.getEducation().setCgpa(cgpa);

                    System.out.println("CGPA updated successfully.");
                    break;

                case 7:

                    int passingYear =
                            readIntegerInRange(
                                    "Enter new passing year: ",
                                    2000,
                                    2100
                            );

                    profile.getEducation().setPassingYear(passingYear);

                    System.out.println("Passing year updated successfully.");
                    break;

                case 8:
                    return;
            }
        }
    }


    // =========================
    // EDUCATION LEVEL
    // =========================

    private void updateEducationLevel(StudentProfile profile) {

        System.out.println();
        System.out.println("Select new education level:");

        EducationLevel[] levels = EducationLevel.values();

        for (int i = 0; i < levels.length; i++) {
            System.out.println(
                    (i + 1) + ". " + levels[i]
            );
        }

        int choice = readChoice(1, levels.length);

        profile.getEducation().setEducationLevel(
                levels[choice - 1]
        );

        System.out.println("Education level updated successfully.");
    }


    // =========================
    // CAREER PREFERENCE
    // =========================

    private void updateCareerPreference(StudentProfile profile) {

        while (true) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("          CAREER PREFERENCE");
            System.out.println("========================================");

            System.out.println("1. Change Target Role");
            System.out.println("2. Change Opportunity Type");
            System.out.println("3. Manage Career Interests");
            System.out.println("4. Back");

            int choice = readChoice(1, 4);

            switch (choice) {

                case 1:

                    System.out.print("Enter new target role: ");
                    String targetRole = readRequiredText();

                    profile.getCareerPreference()
                            .setTargetRole(targetRole);

                    System.out.println("Target role updated successfully.");
                    break;

                case 2:

                    updateCareerGoal(profile);
                    break;

                case 3:

                    updateCareerInterests(profile);
                    break;

                case 4:
                    return;
            }
        }
    }


    // =========================
    // CAREER GOAL
    // =========================

    private void updateCareerGoal(StudentProfile profile) {

        CareerGoal[] goals = CareerGoal.values();

        System.out.println();
        System.out.println("Select new career goal:");

        for (int i = 0; i < goals.length; i++) {
            System.out.println(
                    (i + 1) + ". " + goals[i]
            );
        }

        int choice = readChoice(1, goals.length);

        profile.getCareerPreference()
                .setLookingFor(goals[choice - 1]);

        System.out.println("Career goal updated successfully.");
    }


    // =========================
    // CAREER INTERESTS
    // =========================

    private void updateCareerInterests(StudentProfile profile) {

        while (true) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("          CAREER INTERESTS");
            System.out.println("========================================");

            ArrayList<String> interests =
                    profile.getCareerPreference()
                            .getCareerInterests();

            System.out.println("Current interests: " + interests);

            System.out.println();
            System.out.println("1. Add Interest");
            System.out.println("2. Remove Interest");
            System.out.println("3. Back");

            int choice = readChoice(1, 3);

            switch (choice) {

                case 1:

                    System.out.print("Enter interest to add: ");
                    String interest = readRequiredText();

                    if (interests.contains(interest)) {
                        System.out.println(
                                "That interest already exists."
                        );
                    } else {
                        profile.getCareerPreference()
                                .addCareerInterest(interest);

                        System.out.println(
                                "Interest added successfully."
                        );
                    }

                    break;

                case 2:

                    if (interests.isEmpty()) {
                        System.out.println(
                                "There are no interests to remove."
                        );
                        break;
                    }

                    System.out.print("Enter interest to remove: ");
                    String removeInterest = readRequiredText();

                    if (interests.remove(removeInterest)) {
                        System.out.println(
                                "Interest removed successfully."
                        );
                    } else {
                        System.out.println(
                                "Interest not found."
                        );
                    }

                    break;

                case 3:
                    return;
            }
        }
    }


    // =========================
    // SKILLS
    // =========================

    private void updateSkills(StudentProfile profile) {

        while (true) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("                SKILLS");
            System.out.println("========================================");

            System.out.println(
                    "Current skills: " + profile.getSkills()
            );

            System.out.println();
            System.out.println("1. Add Skill");
            System.out.println("2. Remove Skill");
            System.out.println("3. Back");

            int choice = readChoice(1, 3);

            switch (choice) {

                case 1:

                    System.out.print("Enter skill to add: ");
                    String skill = readRequiredText();

                    boolean skillAlreadyExists = false;

                    for (String existingSkill : profile.getSkills()) {

                        if (existingSkill.equalsIgnoreCase(skill)) {
                            skillAlreadyExists = true;
                            break;
                        }
                    }

                    if (skillAlreadyExists) {

                        System.out.println(
                                "That skill already exists."
                        );

                    } else {

                        profile.addSkill(skill);

                        System.out.println(
                                "Skill added successfully."
                        );
                    }

                    break;

                case 2:

                    if (profile.getSkills().isEmpty()) {

                        System.out.println(
                                "There are no skills to remove."
                        );

                        break;
                    }

                    System.out.print("Enter skill to remove: ");
                    String removeSkill = readRequiredText();

                    String matchedSkill = null;

                    for (String existingSkill : profile.getSkills()) {

                        if (existingSkill.equalsIgnoreCase(removeSkill)) {
                            matchedSkill = existingSkill;
                            break;
                        }
                    }

                    if (matchedSkill != null) {

                        profile.getSkills().remove(matchedSkill);

                        System.out.println(
                                "Skill removed successfully: "
                                        + matchedSkill
                        );

                    } else {

                        System.out.println(
                                "Skill not found."
                        );
                    }

                    break;

                case 3:
                    return;
            }
        }
    }


    // =========================
    // PROJECTS
    // =========================

    private void updateProjects(StudentProfile profile) {

        while (true) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("               PROJECTS");
            System.out.println("========================================");

            displayProjectList(profile);

            System.out.println();
            System.out.println("1. Add Project");
            System.out.println("2. Edit Project");
            System.out.println("3. Remove Project");
            System.out.println("4. Back");

            int choice = readChoice(1, 4);

            switch (choice) {

                case 1:
                    addProject(profile);
                    break;

                case 2:
                    editProject(profile);
                    break;

                case 3:
                    removeProject(profile);
                    break;

                case 4:
                    return;
            }
        }
    }


    // =========================
    // DISPLAY PROJECT LIST
    // =========================

    private void displayProjectList(StudentProfile profile) {

        ArrayList<Project> projects = profile.getProjects();

        if (projects.isEmpty()) {
            System.out.println("No projects added.");
            return;
        }

        for (int i = 0; i < projects.size(); i++) {

            System.out.println(
                    (i + 1) + ". "
                            + projects.get(i).getProjectName()
            );
        }
    }


    // =========================
    // ADD PROJECT
    // =========================

    private void addProject(StudentProfile profile) {

        System.out.println();
        System.out.println("========== ADD PROJECT ==========");

        System.out.print("Project name: ");
        String projectName = readRequiredText();

        System.out.print("Problem statement: ");
        String problemStatement = readRequiredText();

        System.out.print("Solution: ");
        String solution = readRequiredText();

        System.out.print("Role: ");
        String role = readRequiredText();

        ArrayList<String> technologies =
                new ArrayList<>();

        System.out.println();
        System.out.println(
                "Enter technologies one by one."
        );
        System.out.println(
                "Type DONE when finished."
        );

        while (true) {

            System.out.print("Technology: ");

            String technology =
                    scanner.nextLine().trim();

            if (technology.equalsIgnoreCase("DONE")) {
                break;
            }

            if (technology.isEmpty()) {
                System.out.println(
                        "Technology cannot be empty."
                );
                continue;
            }

            if (!technologies.contains(technology)) {
                technologies.add(technology);
            }
        }

        Project project =
                new Project(
                        projectName,
                        problemStatement,
                        solution,
                        technologies,
                        role
                );

        profile.addProject(project);

        System.out.println(
                "Project added successfully."
        );
    }


    // =========================
    // EDIT PROJECT
    // =========================

    private void editProject(StudentProfile profile) {

        if (profile.getProjects().isEmpty()) {

            System.out.println(
                    "There are no projects to edit."
            );

            return;
        }

        displayProjectList(profile);

        System.out.println();
        int projectNumber =
                readChoice(
                        1,
                        profile.getProjects().size()
                );

        Project project =
                profile.getProjects()
                        .get(projectNumber - 1);

        while (true) {

            System.out.println();
            System.out.println("========================================");
            System.out.println(
                    "EDIT PROJECT: "
                            + project.getProjectName()
            );
            System.out.println("========================================");

            System.out.println(
                    "1. Project Name: "
                            + project.getProjectName()
            );

            System.out.println(
                    "2. Problem Statement: "
                            + project.getProblemStatement()
            );

            System.out.println(
                    "3. Solution: "
                            + project.getSolution()
            );

            System.out.println(
                    "4. Technologies: "
                            + project.getTechnologiesUsed()
            );

            System.out.println(
                    "5. Role: "
                            + project.getRole()
            );

            System.out.println("6. Back");

            int choice = readChoice(1, 6);

            switch (choice) {

                case 1:

                    System.out.print("New project name: ");
                    project.setProjectName(
                            readRequiredText()
                    );

                    System.out.println(
                            "Project name updated."
                    );

                    break;

                case 2:

                    System.out.print(
                            "New problem statement: "
                    );

                    project.setProblemStatement(
                            readRequiredText()
                    );

                    System.out.println(
                            "Problem statement updated."
                    );

                    break;

                case 3:

                    System.out.print("New solution: ");

                    project.setSolution(
                            readRequiredText()
                    );

                    System.out.println(
                            "Solution updated."
                    );

                    break;

                case 4:

                    updateProjectTechnologies(project);
                    break;

                case 5:

                    System.out.print("New role: ");

                    project.setRole(
                            readRequiredText()
                    );

                    System.out.println(
                            "Role updated."
                    );

                    break;

                case 6:
                    return;
            }
        }
    }


    // =========================
    // PROJECT TECHNOLOGIES
    // =========================

    private void updateProjectTechnologies(Project project) {

        while (true) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("          PROJECT TECHNOLOGIES");
            System.out.println("========================================");

            System.out.println(
                    "Current: "
                            + project.getTechnologiesUsed()
            );

            System.out.println();
            System.out.println("1. Add Technology");
            System.out.println("2. Remove Technology");
            System.out.println("3. Back");

            int choice = readChoice(1, 3);

            switch (choice) {

                case 1:

                    System.out.print(
                            "Technology to add: "
                    );

                    String technology =
                            readRequiredText();

                    if (project.getTechnologiesUsed()
                            .contains(technology)) {

                        System.out.println(
                                "Technology already exists."
                        );

                    } else {

                        project.addTechnology(
                                technology
                        );

                        System.out.println(
                                "Technology added."
                        );
                    }

                    break;

                case 2:

                    if (project.getTechnologiesUsed()
                            .isEmpty()) {

                        System.out.println(
                                "No technologies to remove."
                        );

                        break;
                    }

                    System.out.print(
                            "Technology to remove: "
                    );

                    String removeTechnology =
                            readRequiredText();

                    if (project.getTechnologiesUsed()
                            .remove(removeTechnology)) {

                        System.out.println(
                                "Technology removed."
                        );

                    } else {

                        System.out.println(
                                "Technology not found."
                        );
                    }

                    break;

                case 3:
                    return;
            }
        }
    }


    // =========================
    // REMOVE PROJECT
    // =========================

    private void removeProject(StudentProfile profile) {

        if (profile.getProjects().isEmpty()) {

            System.out.println(
                    "There are no projects to remove."
            );

            return;
        }

        displayProjectList(profile);

        System.out.println();

        int projectNumber =
                readChoice(
                        1,
                        profile.getProjects().size()
                );

        Project project =
                profile.getProjects()
                        .get(projectNumber - 1);

        System.out.print(
                "Remove \"" +
                        project.getProjectName() +
                        "\"? (Y/N): "
        );

        String confirmation =
                scanner.nextLine().trim();

        if (confirmation.equalsIgnoreCase("Y")) {

            profile.removeProject(project);

            System.out.println(
                    "Project removed successfully."
            );

        } else {

            System.out.println(
                    "Project was not removed."
            );
        }
    }


    // =========================
    // STUDY AVAILABILITY
    // =========================

    private void updateStudyAvailability(
            StudentProfile profile) {

        while (true) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("          STUDY AVAILABILITY");
            System.out.println("========================================");

            System.out.println("1. Change Hours Per Day");
            System.out.println("2. Change Days Per Week");
            System.out.println("3. Back");

            int choice = readChoice(1, 3);

            switch (choice) {

                case 1:

                    System.out.println(
                            "Current hours per day: "
                                    + profile.getStudyHoursPerDay()
                    );

                    double hours =
                            readDoubleInRange(
                                    "Enter new hours per day: ",
                                    1,
                                    24
                            );

                    profile.setStudyHoursPerDay(hours);

                    System.out.println(
                            "Study hours updated successfully."
                    );

                    break;

                case 2:

                    System.out.println(
                            "Current study days per week: "
                                    + profile.getStudyDaysPerWeek()
                    );

                    int days =
                            readIntegerInRange(
                                    "Enter new study days per week: ",
                                    1,
                                    7
                            );

                    profile.setStudyDaysPerWeek(days);

                    System.out.println(
                            "Study days updated successfully."
                    );

                    break;

                case 3:
                    return;
            }
        }
    }


    // =========================
    // INPUT HELPERS
    // =========================

    private int readChoice(int min, int max) {

        while (true) {

            System.out.print("Enter choice: ");

            try {

                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice >= min && choice <= max) {
                    return choice;
                }

                System.out.println(
                        "Please enter a number between "
                                + min + " and " + max + "."
                );

            } catch (InputMismatchException e) {

                System.out.println(
                        "Please enter a valid number."
                );

                scanner.nextLine();
            }
        }
    }


    private int readIntegerInRange(
            String prompt,
            int min,
            int max) {

        while (true) {

            System.out.print(prompt);

            try {

                int value = scanner.nextInt();
                scanner.nextLine();

                if (value >= min && value <= max) {
                    return value;
                }

                System.out.println(
                        "Please enter a value between "
                                + min + " and " + max + "."
                );

            } catch (InputMismatchException e) {

                System.out.println(
                        "Please enter a valid number."
                );

                scanner.nextLine();
            }
        }
    }


    private double readDoubleInRange(
            String prompt,
            double min,
            double max) {

        while (true) {

            System.out.print(prompt);

            try {

                double value = scanner.nextDouble();
                scanner.nextLine();

                if (value >= min && value <= max) {
                    return value;
                }

                System.out.println(
                        "Please enter a value between "
                                + min + " and " + max + "."
                );

            } catch (InputMismatchException e) {

                System.out.println(
                        "Please enter a valid number."
                );

                scanner.nextLine();
            }
        }
    }


    private String readRequiredText() {

        while (true) {

            String input =
                    scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.print(
                    "This field cannot be empty. Try again: "
            );
        }
    }


    private String readEmail() {

        while (true) {

            System.out.print("Enter new email: ");

            String email =
                    scanner.nextLine().trim();

            if (email.contains("@")
                    && email.contains(".")) {

                return email;
            }

            System.out.println(
                    "Please enter a valid email address."
            );
        }
    }
}