# CareerPilot

> A Java-based career preparation system that helps students analyze career fit, identify skill gaps, build learning roadmaps, analyze job descriptions, and create personalized study plans.

## Overview

CareerPilot is a **console-based Java application** built around a central student profile. The same profile data is used across career analysis, skill-gap detection, learning roadmap generation, job-description analysis, and study planning.

The current **V1** focuses on building a modular Java foundation that can later evolve into a larger career-preparation platform.

## Key Features

* **Student Profile Management** — Manage education, CGPA, career goals, skills, projects, interests, and study availability.
* **Career Analysis** — Compare a student's profile with career requirements and identify matches, gaps, and eligibility.
* **Career Recommendation** — Recommend career options using a scoring-based matching system.
* **Skill Gap Analysis** — Calculate missing skills and skill coverage for a target career.
* **Learning Roadmap** — Generate prerequisite-aware learning paths for missing skills.
* **Job Description Analyzer** — Extract relevant requirements and compare them against the student's skills and projects.
* **Personalized Study Plan** — Convert learning roadmaps into study plans based on available study time.
* **Profile Editing & Persistence** — Update profiles and save/load local profile data.

## Architecture

CareerPilot uses a modular, object-oriented design with separate classes for profile management, analysis, recommendations, roadmaps, job-description analysis, and study planning.

```text
                         StudentProfile
                              │
              ┌───────────────┼───────────────┐
              │               │               │
        Career Analysis   Skill Gap      Job Description
              │               │           Analysis
              │               │               │
              └───────────────┼───────────────┘
                              │
                       Learning Roadmap
                              │
                       Personalized Plan
```

A core design principle is:

> **Store information once, use it across multiple modules.**

For example, skills stored in `StudentProfile` can be reused by career analysis, skill-gap analysis, roadmap generation, and job-description analysis.

## Technologies & Concepts

* **Java 21**
* Object-Oriented Programming
* Classes, objects, constructors, and encapsulation
* Composition and separation of responsibilities
* Enums and `ArrayList`
* Collections
* Exception handling and input validation
* `Scanner`
* File I/O
* `FileReader`, `FileWriter`, `BufferedReader`
* Try-with-resources
* Multi-class application architecture

## Project Structure

```text
CareerPilot/
├── src/
│   ├── Career & career analysis
│   ├── Student profile management
│   ├── Skill-gap analysis
│   ├── Learning roadmap generation
│   ├── Job-description analysis
│   └── Study-plan generation
│
├── data/
│   └── profile.txt
│
├── .gitignore
└── README.md
```

`data/profile.txt` stores local user data and is excluded from version control.

## How to Run

### Requirements

* JDK 21+
* IntelliJ IDEA or another Java IDE

### IntelliJ IDEA

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Configure JDK 21 or later.
4. Run `src/Main.java`.

### Command Line

From the project directory:

```bash
javac -d out src/*.java
java -cp out Main
```

## Example Workflow

```text
Create Profile
      ↓
Select Target Career
      ↓
Analyze Career
      ↓
Identify Skill Gaps
      ↓
Generate Learning Roadmap
      ↓
Create Study Plan
      ↓
Analyze Job Description
      ↓
Identify Job-Specific Gaps
```

## Current Version — V1

CareerPilot V1 includes:

* Student profile management
* Local profile persistence
* Profile editing
* Career analysis
* Career recommendation
* Skill-gap analysis
* Prerequisite-aware learning roadmaps
* Job-description analysis
* Relevant project identification
* Personalized study plans

## Future Development

The project is designed to evolve beyond the current console-based Java application.

Planned areas include:

* AI/LLM-powered career analysis
* Resume parsing and optimization
* Job-specific resume tailoring
* Database integration
* Java backend
* Kotlin Android application
* AI-powered interview preparation
* Job and internship alerts
* Progress and career-readiness tracking
* Deployment for real users

These features are **not part of the current V1 implementation**.

---

**Built with Java as a portfolio project.**
