import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Main {

    private static StudentProfile profile;
    private static ArrayList<Career> careers;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        createCareerDatabase();

        showWelcome();

        boolean running = true;

        while (running) {

            showMenu();

            int choice = readMenuChoice();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    createProfile();

                    ProfileFileManager fileManager =
                            new ProfileFileManager();

                    fileManager.saveProfile(profile);

                    break;

                case 2:
                    loadSavedProfile();
                    break;

                case 3:
                    updateProfile();
                    break;

                case 4:
                    showCareerAnalysis();
                    break;

                case 5:
                    showSkillGap();
                    break;

                case 6:
                    showLearningRoadmap();
                    break;

                case 7:
                    analyzeJobDescription();
                    break;

                case 8:
                    showProfile();
                    break;

                case 9:
                    showStudyPlan();
                    break;

                case 10:
                    running = false;
                    System.out.println("\nThank you for using CareerPilot!");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    // ==========================================
    // CAREER DATABASE
    // ==========================================

    private static void createCareerDatabase() {

        careers = new ArrayList<>();

        // Software Developer
        ArrayList<String> softwareDeveloperSkills =
                new ArrayList<>();

        softwareDeveloperSkills.add("Java");
        softwareDeveloperSkills.add("DSA");
        softwareDeveloperSkills.add("SQL");
        softwareDeveloperSkills.add("Git");
        softwareDeveloperSkills.add("OOP");

        ArrayList<String> softwareDeveloperTechnologies =
                new ArrayList<>();

        softwareDeveloperTechnologies.add("Java");
        softwareDeveloperTechnologies.add("C++");
        softwareDeveloperTechnologies.add("Python");
        softwareDeveloperTechnologies.add("JavaScript");

        ArrayList<String> softwareDeveloperInterests =
                new ArrayList<>();

        softwareDeveloperInterests.add("Software Development");
        softwareDeveloperInterests.add("AI / Machine Learning");

        Career softwareDeveloper =
                new Career(
                        "Software Developer",
                        7.5,
                        softwareDeveloperSkills,
                        softwareDeveloperTechnologies,
                        softwareDeveloperInterests
                );

        careers.add(softwareDeveloper);

        // Data Analyst
        ArrayList<String> dataAnalystSkills =
                new ArrayList<>();

        dataAnalystSkills.add("SQL");
        dataAnalystSkills.add("Excel");
        dataAnalystSkills.add("Data Visualization");
        dataAnalystSkills.add("Basic Programming");
        dataAnalystSkills.add("Data Cleaning");

        ArrayList<String> dataAnalystTechnologies =
                new ArrayList<>();

        dataAnalystTechnologies.add("SQL");
        dataAnalystTechnologies.add("Python");
        dataAnalystTechnologies.add("Excel");
        dataAnalystTechnologies.add("Power BI");

        ArrayList<String> dataAnalystInterests =
                new ArrayList<>();

        dataAnalystInterests.add("Data Analytics");
        dataAnalystInterests.add("Data Science");

        Career dataAnalyst =
                new Career(
                        "Data Analyst",
                        7.5,
                        dataAnalystSkills,
                        dataAnalystTechnologies,
                        dataAnalystInterests
                );

        careers.add(dataAnalyst);
    }

    // ==========================================
    // WELCOME
    // ==========================================

    private static void showWelcome() {

        System.out.println("======================================");
        System.out.println("             CAREERPILOT");
        System.out.println("     Your Personal Career Guide");
        System.out.println("======================================");
    }

    // ==========================================
    // MENU
    // ==========================================

    private static void showMenu() {

        System.out.println("\n======================================");
        System.out.println("             CAREERPILOT");
        System.out.println("======================================");

        System.out.println("1. Create Profile");
        System.out.println("2. Load Saved Profile");
        System.out.println("3. Update Profile");
        System.out.println("4. Career Analysis");
        System.out.println("5. Skill Gap");
        System.out.println("6. Learning Roadmap");
        System.out.println("7. Job Description Analyzer");
        System.out.println("8. View Profile");
        System.out.println("9. Personalized Study Plan");
        System.out.println("10. Exit");

    }

    private static int readMenuChoice() {

        while (true) {

            try {

                System.out.print("\nEnter your choice: ");

                int choice = scanner.nextInt();

                if (choice >= 1 && choice <= 10) {
                    return choice;
                }

                System.out.println(
                        "\nInvalid choice. Please enter a number from 1 to 10."
                );

            } catch (InputMismatchException e) {

                System.out.println(
                        "\nInvalid input. Please enter a number from 1 to 10."
                );

                scanner.nextLine();
            }
        }
    }

    // ==========================================
    // CREATE PROFILE
    // ==========================================

    private static void createProfile() {

        ProfileInputHandler inputHandler =
                new ProfileInputHandler(scanner);

        profile =
                inputHandler.createProfile();

        System.out.println(
                "\nCareerPilot profile created successfully!"
        );
    }

    // ==========================================
    // CAREER ANALYSIS
    // ==========================================

    private static void showCareerAnalysis() {

        if (!checkProfile()) {
            return;
        }

        CareerAnalyzer analyzer =
                new CareerAnalyzer();

        System.out.println(
                "\n======================================"
        );

        System.out.println(
                "          CAREER ANALYSIS"
        );

        System.out.println(
                "======================================"
        );

        for (Career career : careers) {

            CareerAnalysisResult result =
                    analyzer.analyze(
                            profile,
                            career
                    );

            System.out.println(
                    "\nCareer: "
                            + result.getCareer().getName()
            );

            System.out.println(
                    "Known Skills: "
                            + result.getMatchedSkills()
            );

            System.out.println(
                    "Skills To Learn: "
                            + result.getMissingSkills()
            );

            System.out.println(
                    "Skill Coverage: "
                            + result.getSkillCoverage()
                            + "%"
            );

            System.out.println(
                    "CGPA Eligible: "
                            + result.isCgpaEligible()
            );

            System.out.println(
                    "Matched Career Interests: "
                            + result.getMatchedCareerInterests()
            );
        }
    }


    // ==========================================
    // UPDATE PROFILE
    // ==========================================

    private static void updateProfile() {

        if (profile == null) {

            System.out.println();
            System.out.println(
                    "No active profile found."
            );

            System.out.println(
                    "Please create or load a profile first."
            );

            return;
        }

        ProfileEditor profileEditor =
                new ProfileEditor(scanner);

        profileEditor.updateProfile(profile);

        ProfileFileManager fileManager =
                new ProfileFileManager();

        fileManager.saveProfile(profile);

        System.out.println();
        System.out.println(
                "Profile changes saved successfully."
        );
    }


    // ==========================================
    // SKILL GAP
    // ==========================================

    private static void showSkillGap() {

        if (!checkProfile()) {
            return;
        }

        CareerAnalyzer analyzer =
                new CareerAnalyzer();

        System.out.println(
                "\n======================================"
        );

        System.out.println(
                "              SKILL GAP"
        );

        System.out.println(
                "======================================"
        );

        for (Career career : careers) {

            CareerAnalysisResult result =
                    analyzer.analyze(
                            profile,
                            career
                    );

            System.out.println(
                    "\nCareer: "
                            + career.getName()
            );

            System.out.println(
                    "Known Skills: "
                            + result.getMatchedSkills()
            );

            System.out.println(
                    "Skills To Learn: "
                            + result.getMissingSkills()
            );

            System.out.println(
                    "Known Skill Count: "
                            + result.getKnownSkillCount()
            );

            System.out.println(
                    "Skills To Learn Count: "
                            + result.getMissingSkillCount()
            );

            System.out.println(
                    "Skill Coverage: "
                            + result.getSkillCoverage()
                            + "%"
            );
        }
    }

    // ==========================================
    // LEARNING ROADMAP
    // ==========================================

    private static void showLearningRoadmap() {

        if (!checkProfile()) {
            return;
        }

        CareerAnalyzer analyzer =
                new CareerAnalyzer();

        Career targetCareer =
                getTargetCareer();

        if (targetCareer == null) {

            System.out.println(
                    "\nNo matching career found for your target role."
            );

            return;
        }

        CareerAnalysisResult result =
                analyzer.analyze(
                        profile,
                        targetCareer
                );

        LearningRoadmapGenerator roadmapGenerator =
                new LearningRoadmapGenerator();

        LearningRoadmap roadmap =
                roadmapGenerator.generateRoadmap(
                        result,
                        profile
                );

        System.out.println(
                "\n======================================"
        );

        System.out.println(
                "          LEARNING ROADMAP"
        );

        System.out.println(
                "======================================"
        );

        System.out.println(
                "\nCareer: "
                        + roadmap.getTargetCareer().getName()
        );

        System.out.println(
                "Total Skills To Learn: "
                        + roadmap.getTotalSkills()
        );

        System.out.println(
                "Total Learning Topics: "
                        + roadmap.getTotalTopics()
        );

        System.out.println(
                "Skills: "
                        + roadmap.getSkillNames()
        );

        for (SkillRoadmap skillRoadmap :
                roadmap.getSkillRoadmaps()) {

            System.out.println(
                    "\nSkill: "
                            + skillRoadmap.getSkillName()
            );

            if (!skillRoadmap.getPrerequisites().isEmpty()) {

                System.out.println("Prerequisites:");

                for (String prerequisite :
                        skillRoadmap.getPrerequisites()) {

                    System.out.println(
                            "- " + prerequisite
                    );
                }
            }

            System.out.println("Topics:");

            for (LearningTopic topic :
                    skillRoadmap.getTopics()) {

                System.out.println(
                        topic.getOrder()
                                + ". "
                                + topic.getTopicName()
                );

                System.out.println(
                        "   "
                                + topic.getDescription()
                );
            }
        }
    }

    // ==========================================
    // JOB DESCRIPTION ANALYZER
    // ==========================================

    private static void analyzeJobDescription() {

        if (!checkProfile()) {
            return;
        }

        System.out.println(
                "\n======================================"
        );

        System.out.println(
                "       JOB DESCRIPTION ANALYZER"
        );

        System.out.println(
                "======================================"
        );

        System.out.println(
                "Enter or paste the job description."
        );

        System.out.println(
                "Type END on a new line when finished."
        );

        StringBuilder jobDescriptionText =
                new StringBuilder();

        while (true) {

            String line =
                    scanner.nextLine();

            if (line.equalsIgnoreCase("END")) {
                break;
            }

            jobDescriptionText
                    .append(line)
                    .append("\n");
        }

        JobDescription jobDescription =
                new JobDescription(
                        jobDescriptionText.toString()
                );

        JobDescriptionAnalyzer analyzer =
                new JobDescriptionAnalyzer();

        Career targetCareer =
                getTargetCareer();

        if (targetCareer == null) {

            System.out.println(
                    "\nNo matching career found for your target role."
            );

            return;
        }

        JobDescriptionAnalysisResult result =
                analyzer.analyze(
                        jobDescription,
                        profile,
                        targetCareer
                );

        System.out.println(
                "\n--- Analysis Result ---"
        );

        System.out.println(
                "\nRequirements Found:"
        );

        System.out.println(
                result.getRequirements()
        );

        System.out.println(
                "\nMatched Skills:"
        );

        System.out.println(
                result.getMatchedSkills()
        );

        System.out.println(
                "\nMissing Skills:"
        );

        System.out.println(
                result.getMissingSkills()
        );

        System.out.println(
                "\nRelevant Project Technologies:"
        );

        System.out.println(
                result.getRelevantProjectTechnologies()
        );

        System.out.println(
                "\nRelevant Projects:"
        );

        for (RelevantProject relevantProject :
                result.getRelevantProjects()) {

            System.out.println(
                    "- "
                            + relevantProject
                            .getProject()
                            .getProjectName()
            );

            System.out.println(
                    "  Matched Technologies: "
                            + relevantProject
                            .getMatchedTechnologies()
            );
        }
    }

    // ==========================================
    // VIEW PROFILE
    // ==========================================

    private static void showProfile() {

        if (!checkProfile()) {
            return;
        }

        System.out.println(
                "\n======================================"
        );

        System.out.println(
                "             YOUR PROFILE"
        );

        System.out.println(
                "======================================"
        );

        System.out.println("\n--- Personal Information ---");

        System.out.println(
                "Name: "
                        + profile.getPersonalInfo().getName()
        );

        System.out.println(
                "Email: "
                        + profile.getPersonalInfo().getEmail()
        );

        System.out.println("\n--- Education ---");

        System.out.println(
                "Education Level: "
                        + profile.getEducation().getEducationLevel()
        );

        System.out.println(
                "College: "
                        + profile.getEducation().getCollege()
        );

        System.out.println(
                "Degree: "
                        + profile.getEducation().getDegree()
        );

        System.out.println(
                "Branch: "
                        + profile.getEducation().getBranch()
        );

        System.out.println(
                "Current Year: "
                        + profile.getEducation().getCurrentYear()
        );

        System.out.println(
                "CGPA: "
                        + profile.getEducation().getCgpa()
        );

        System.out.println(
                "Passing Year: "
                        + profile.getEducation().getPassingYear()
        );

        System.out.println("\n--- Career Preference ---");

        System.out.println(
                "Target Role: "
                        + profile.getCareerPreference().getTargetRole()
        );

        System.out.println(
                "Looking For: "
                        + profile.getCareerPreference().getLookingFor()
        );

        System.out.println(
                "Career Interests: "
                        + profile.getCareerPreference().getCareerInterests()
        );

        System.out.println("\n--- Skills ---");

        System.out.println(
                "Skills: "
                        + profile.getSkills()
        );

        System.out.println("\n--- Study Availability ---");

        System.out.println(
                "Study Hours Per Day: "
                        + profile.getStudyHoursPerDay()
        );

        System.out.println(
                "Study Days Per Week: "
                        + profile.getStudyDaysPerWeek()
        );

        System.out.println("\n--- Projects ---");

        if (profile.getProjects().isEmpty()) {

            System.out.println("No projects added.");

        } else {

            profile.displayProjects();
        }
    }

    private static void showStudyPlan() {

        if (!checkProfile()) {
            return;
        }

        Career targetCareer = getTargetCareer();

        if (targetCareer == null) {
            System.out.println(
                    "\nNo matching career found for your target role."
            );
            return;
        }

        CareerAnalyzer analyzer =
                new CareerAnalyzer();

        CareerAnalysisResult result =
                analyzer.analyze(
                        profile,
                        targetCareer
                );

        LearningRoadmapGenerator roadmapGenerator =
                new LearningRoadmapGenerator();

        LearningRoadmap roadmap =
                roadmapGenerator.generateRoadmap(
                        result,
                        profile
                );

        StudyPlanGenerator studyPlanGenerator =
                new StudyPlanGenerator();

        StudyPlan plan =
                studyPlanGenerator.generatePlan(
                        roadmap,
                        profile
                );

        System.out.println(
                "\n======================================"
        );

        System.out.println(
                "        PERSONALIZED STUDY PLAN"
        );

        System.out.println(
                "======================================"
        );

        System.out.println(
                "\nCareer: "
                        + plan.getTargetCareer().getName()
        );

        System.out.println(
                "Study Time: "
                        + plan.getHoursPerDay()
                        + " hours/day"
        );

        System.out.println(
                "Study Days: "
                        + plan.getDaysPerWeek()
                        + " days/week"
        );

        System.out.println(
                "Weekly Study Hours: "
                        + plan.getWeeklyStudyHours()
        );

        System.out.println(
                "Estimated Learning Hours: "
                        + plan.getTotalEstimatedHours()
        );

        System.out.println(
                "Estimated Completion: "
                        + plan.getEstimatedWeeks()
                        + " week(s)"
        );

        System.out.println("\nStudy Topics:");

        int count = 1;

        for (StudyPlanItem item : plan.getItems()) {

            System.out.println(
                    count + ". "
                            + item.getSkill()
                            + " → "
                            + item.getTopic()
                            + " ("
                            + item.getEstimatedHours()
                            + " hours)"
            );

            count++;
        }
    }

    private static Career getTargetCareer() {

        String targetRole =
                profile.getCareerPreference().getTargetRole();

        for (Career career : careers) {

            if (career.getName().equalsIgnoreCase(targetRole)) {
                return career;
            }
        }

        return null;
    }

    // ==========================================
    // PROFILE CHECK
    // ==========================================

    private static boolean checkProfile() {

        if (profile == null) {

            System.out.println(
                    "\nPlease create your profile first."
            );

            return false;
        }

        return true;
    }
    private static void loadSavedProfile() {

        ProfileFileManager fileManager =
                new ProfileFileManager();

        StudentProfile loadedProfile =
                fileManager.loadProfile();

        if (loadedProfile != null) {

            profile = loadedProfile;

            System.out.println(
                    "Saved profile is now active."
            );
        }
    }
}
