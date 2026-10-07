import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ProfileInputHandler {

    private Scanner scanner;

    public ProfileInputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    // Reads a whole number safely
    private int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return scanner.nextInt();

            } catch (InputMismatchException e) {

                System.out.println(
                        "Invalid input. Please enter a whole number."
                );

                scanner.nextLine();
            }
        }
    }

    // Reads a decimal number safely
    private double readDouble(String message) {

        while (true) {

            try {

                System.out.print(message);

                return scanner.nextDouble();

            } catch (InputMismatchException e) {

                System.out.println(
                        "Invalid input. Please enter a number."
                );

                scanner.nextLine();
            }
        }
    }

    // Reads a whole number that cannot be negative
    private int readNonNegativeInt(String message) {

        while (true) {

            int value = readInt(message);

            if (value >= 0) {
                return value;
            }

            System.out.println(
                    "Please enter a number greater than or equal to 0."
            );
        }
    }

    private double readStudyHoursPerDay(String message) {
        while (true) {
            double hours = readDouble(message);

            if (hours >= 1 && hours <= 24) {
                return hours;
            }

            System.out.println(
                    "Invalid study time. Please enter a value between 1 and 24 hours."
            );
        }
    }

    private int readStudyDaysPerWeek(String message) {
        while (true) {
            int days = readInt(message);

            if (days >= 1 && days <= 7) {
                return days;
            }

            System.out.println(
                    "Invalid number of days. Please enter a value between 1 and 7."
            );
        }
    }

    // Reads CGPA between 0 and 10
    private double readCgpa(String message) {

        while (true) {

            double cgpa = readDouble(message);

            if (cgpa >= 0 && cgpa <= 10) {
                return cgpa;
            }

            System.out.println(
                    "Invalid CGPA. Please enter a value between 0 and 10."
            );
        }
    }

    private int readCurrentYear(String message) {

        while (true) {

            int year = readInt(message);

            if (year >= 1 && year <= 10) {
                return year;
            }

            System.out.println(
                    "Invalid year. Please enter a year between 1 and 10."
            );
        }
    }

    private int readPassingYear(String message) {

        while (true) {

            int year = readInt(message);

            if (year >= 2000 && year <= 2100) {
                return year;
            }

            System.out.println(
                    "Invalid passing year. Please enter a year between 2000 and 2100."
            );
        }
    }

    // Reads text and prevents empty input
    private String readRequiredText(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println(
                    "This field cannot be empty. Please try again."
            );
        }
    }

    private String readEmail(String message) {

        while (true) {

            String email = readRequiredText(message);

            if (email.contains("@") && email.contains(".")) {
                return email;
            }

            System.out.println(
                    "Invalid email. Please enter a valid email address."
            );
        }
    }

    public StudentProfile createProfile() {

        System.out.println("======================================");
        System.out.println("          CAREERPILOT");
        System.out.println("       CREATE YOUR PROFILE");
        System.out.println("======================================");


        // ======================================
        // Personal Information
        // ======================================

        System.out.println("\n--- Personal Information ---");

        String name =
                readRequiredText("Enter your name: ");

        String email =
                readEmail("Enter your email: ");

        PersonalInfo personalInfo =
                new PersonalInfo(name, email);


        // ======================================
        // Education
        // ======================================

        System.out.println("\n--- Education ---");

        String college =
                readRequiredText("Enter college: ");

        String degree =
                readRequiredText("Enter degree: ");

        String branch =
                readRequiredText("Enter branch: ");

        int currentYear =
                readCurrentYear("Enter current year: ");

        double cgpa =
                readCgpa("Enter CGPA: ");

        int passingYear =
                readPassingYear("Enter passing year: ");

        // Remove leftover newline after nextInt()/nextDouble()
        scanner.nextLine();

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


        // ======================================
        // Career Preference
        // ======================================

        System.out.println("\n--- Career Preference ---");

        String targetRole =
                readRequiredText("Enter target role: ");

        String careerGoalInput;

        CareerGoal careerGoal = null;

        while (careerGoal == null) {

            careerGoalInput =
                    readRequiredText(
                            "Are you looking for Internship, Job, or Both? "
                    );

            if (careerGoalInput.equalsIgnoreCase("Internship")) {

                careerGoal = CareerGoal.INTERNSHIP;

            } else if (careerGoalInput.equalsIgnoreCase("Job")) {

                careerGoal = CareerGoal.JOB;

            } else if (careerGoalInput.equalsIgnoreCase("Both")) {

                careerGoal = CareerGoal.BOTH;

            } else {

                System.out.println(
                        "Invalid choice. Please enter Internship, Job, or Both."
                );
            }
        }

        CareerPreference careerPreference =
                new CareerPreference(
                        targetRole,
                        careerGoal
                );


        // ======================================
// Study Availability
// ======================================

        System.out.println("\n--- Study Availability ---");

        double studyHoursPerDay =
                readStudyHoursPerDay(
                        "How many hours can you study per day? "
                );

        int studyDaysPerWeek =
                readStudyDaysPerWeek(
                        "How many days per week can you study? "
                );

        scanner.nextLine();

        // ======================================
        // Career Interests
        // ======================================

        System.out.println("\n--- Career Interests ---");

        int interestCount =
                readNonNegativeInt(
                        "How many career interests do you want to enter? "
                );

        scanner.nextLine();

        for (int i = 1; i <= interestCount; i++) {

            String interest =
                    readRequiredText(
                            "Enter career interest " + i + ": "
                    );

            careerPreference.addCareerInterest(interest);
        }


        // ======================================
        // Skills
        // ======================================

        System.out.println("\n--- Skills ---");

        int skillCount =
                readNonNegativeInt(
                        "How many skills do you want to enter? "
                );

        scanner.nextLine();

        StudentProfile profile =
                new StudentProfile(
                        personalInfo,
                        education,
                        careerPreference

                );

        profile.setStudyHoursPerDay(studyHoursPerDay);
        profile.setStudyDaysPerWeek(studyDaysPerWeek);

        for (int i = 1; i <= skillCount; i++) {

            String skill =
                    readRequiredText(
                            "Enter skill " + i + ": "
                    );

            profile.addSkill(skill);
        }


        // ======================================
        // Projects
        // ======================================

        System.out.println("\n--- Projects ---");

        int projectCount =
                readNonNegativeInt(
                        "How many projects do you want to enter? "
                );

        scanner.nextLine();

        for (int i = 1; i <= projectCount; i++) {

            System.out.println("\nProject " + i);

            String projectName =
                    readRequiredText(
                            "Enter project name: "
                    );

            String problemStatement =
                    readRequiredText(
                            "Enter problem statement: "
                    );

            String solution =
                    readRequiredText(
                            "Enter solution: "
                    );

            int technologyCount =
                    readNonNegativeInt(
                            "How many technologies were used? "
                    );

            scanner.nextLine();

            ArrayList<String> technologies =
                    new ArrayList<>();

            for (int j = 1; j <= technologyCount; j++) {

                String technology =
                        readRequiredText(
                                "Enter technology " + j + ": "
                        );

                technologies.add(technology);
            }

            String role =
                    readRequiredText(
                            "Enter your role in the project: "
                    );

            Project project =
                    new Project(
                            projectName,
                            problemStatement,
                            solution,
                            technologies,
                            role
                    );

            profile.addProject(project);
        }

        return profile;
    }
}