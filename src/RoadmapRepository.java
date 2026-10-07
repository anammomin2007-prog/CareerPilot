import java.util.ArrayList;

public class RoadmapRepository {

    public SkillRoadmap getOopRoadmap() {

        ArrayList<String> prerequisites = new ArrayList<>();

        prerequisites.add("Java");

        ArrayList<LearningTopic> topics = new ArrayList<>();

        topics.add(new LearningTopic(
                "Classes and Objects",
                "OOP",
                "Understand classes, objects, fields, methods, and how objects are created.",
                1
        ));

        topics.add(new LearningTopic(
                "Encapsulation",
                "OOP",
                "Learn how to protect data using private fields and controlled access through methods.",
                2
        ));

        topics.add(new LearningTopic(
                "Inheritance",
                "OOP",
                "Learn how one class can inherit properties and behavior from another class.",
                3
        ));

        topics.add(new LearningTopic(
                "Polymorphism",
                "OOP",
                "Learn how the same method or reference can behave differently depending on the object.",
                4
        ));

        topics.add(new LearningTopic(
                "Abstraction",
                "OOP",
                "Learn how to hide implementation details using abstract classes and interfaces.",
                5
        ));

        return new SkillRoadmap(
                "OOP",
                prerequisites,
                topics
        );
    }

    public SkillRoadmap getGitRoadmap() {

        ArrayList<String> prerequisites = new ArrayList<>();

        prerequisites.add("Basic Command Line");

        ArrayList<LearningTopic> topics = new ArrayList<>();

        topics.add(new LearningTopic(
                "Git Basics",
                "Git",
                "Understand what Git is, why version control is used, and how a Git repository works.",
                1
        ));

        topics.add(new LearningTopic(
                "Repository and Commits",
                "Git",
                "Learn how to initialize a repository, stage changes, and create commits.",
                2
        ));

        topics.add(new LearningTopic(
                "Branches",
                "Git",
                "Learn how branches allow different versions of development to be managed separately.",
                3
        ));

        topics.add(new LearningTopic(
                "Merging",
                "Git",
                "Learn how changes from different branches can be combined.",
                4
        ));

        topics.add(new LearningTopic(
                "GitHub Workflow",
                "Git",
                "Learn how to connect a local Git repository with GitHub and work with remote repositories.",
                5
        ));

        return new SkillRoadmap(
                "Git",
                prerequisites,
                topics
        );
    }

    public SkillRoadmap getBasicCommandLineRoadmap() {

        ArrayList<String> prerequisites = new ArrayList<>();

        ArrayList<LearningTopic> topics = new ArrayList<>();

        topics.add(new LearningTopic(
                "Command Line Basics",
                "Basic Command Line",
                "Understand what the command line is and how commands are used to interact with a computer.",
                1
        ));

        topics.add(new LearningTopic(
                "Navigation Commands",
                "Basic Command Line",
                "Learn basic commands for moving between folders and viewing files.",
                2
        ));

        topics.add(new LearningTopic(
                "File and Folder Commands",
                "Basic Command Line",
                "Learn how to create, rename, copy, move, and delete files and folders using commands.",
                3
        ));

        topics.add(new LearningTopic(
                "Working Directory",
                "Basic Command Line",
                "Understand the current working directory and how paths are represented.",
                4
        ));

        topics.add(new LearningTopic(
                "Command Line for Development",
                "Basic Command Line",
                "Learn how developers use the command line to run programs and development tools.",
                5
        ));

        return new SkillRoadmap(
                "Basic Command Line",
                prerequisites,
                topics
        );
    }

    public SkillRoadmap getRoadmap(String skillName) {

        if (skillName.equalsIgnoreCase("OOP")) {
            return getOopRoadmap();
        }

        if (skillName.equalsIgnoreCase("Git")) {
            return getGitRoadmap();
        }

        if (skillName.equalsIgnoreCase("Basic Command Line")) {
            return getBasicCommandLineRoadmap();
        }

        return null;
    }
}