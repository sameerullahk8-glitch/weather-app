# Weather App

Command-line Java weather application for the Professional Java Development module.

## Features
- Reads a city name from the console
- Validates the input
- Creates a weather report
- Formats the result as XML
- Uses Maven for build and dependency management
- Includes automated tests and quality checks

## Project structure
- `src/main/java` - application source code
- `src/test/java` - JUnit test code
- `pom.xml` - Maven configuration
- `Jenkinsfile` - CI pipeline with build, test, and quality stages
- `CLAUDE.md` - project-specific rules for Claude Code usage

## Requirements
- Java 17 or newer
- Maven 3.9 or newer

## Build and run

Compile the project:
```bash
mvn clean compile
```

Run tests:
```bash
mvn test
```

Build the project:
```bash
mvn clean package
```

## Quality checks

Run Checkstyle:
```bash
mvn checkstyle:check
```

Run PMD:
```bash
mvn pmd:check
```

Run SpotBugs:
```bash
mvn spotbugs:check
```

Run all quality checks together:
```bash
mvn checkstyle:check pmd:check spotbugs:check
```

## Test coverage

Generate the JaCoCo coverage report:
```bash
mvn clean test jacoco:report
```

The project target is at least 70% test coverage. [file:319]

## Jenkins pipeline

The project includes a minimal Declarative Jenkins pipeline in `Jenkinsfile` with these stages:
- Build
- Test
- Quality [file:319]

## Git workflow

Development was done on a feature branch with meaningful commits. The project should be reviewable with:
```bash
git log --oneline
``` 
This matches the course expectation that Git history should show a clear and professional workflow. [file:319]

## AI usage

Claude Code may be used as a coding assistant for small, reviewable changes, test support, and pipeline help, but all committed changes must remain understandable and reviewable by the student. The course rules also require that design decisions, manual quality fixes, and explanation of the final code remain the student’s responsibility. [file:319]

## Notes
- No secrets should be committed to the repository. [file:319]
- The `.gitignore` should exclude generated build output such as `target/`. [file:319]
- Quality fixes should prefer minimal changes without changing application behavior. [file:319]