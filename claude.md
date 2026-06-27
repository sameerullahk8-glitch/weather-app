# CLAUDE.md

## Project
This repository contains the weather-app project for Professional Java Development.

Goals:
- Keep the project buildable with Maven.
- Keep quality tools green or improving.
- Keep commits small, meaningful, and reviewable.
- Use Claude Code as a co-pilot, not as an unchecked code generator.

## Beginner-safe mode
Follow these rules unless explicitly told otherwise:
- Do not make large refactors.
- Do not change unrelated files.
- Do not change application behavior unless the task explicitly requires it.
- Prefer the smallest possible change that solves the task.
- Show the exact file changes before making further edits when asked.
- After completing a task, summarize what changed and what did not change.

## Files to treat carefully
Do not change these unless explicitly requested:
- README.md
- claude.md
- pom.xml
- Java source files unrelated to the current task

## Workflow rules
For each task:
1. Read the relevant files first.
2. Explain the minimal plan briefly.
3. Change only the files needed for that task.
4. Do not create extra files unless asked.
5. Run the relevant checks after changes.
6. Report the result clearly.

## Git rules
- Prefer small, logical commits.
- Keep unrelated changes out of the same commit.
- Suggest commit messages, but do not commit unless explicitly asked.
- If unrelated local files are modified, point them out and exclude them from the suggested commit.

## Java rules
- Keep the existing package structure.
- Do not change method signatures or class structure unless explicitly requested.
- Do not add unnecessary complexity.
- Keep code easy for a beginner to explain in an exam.
- When fixing style issues, avoid changing logic.

## Testing rules
- Prefer meaningful tests over many trivial tests.
- Cover edge cases and input validation.
- Explain what each new test is proving.
- Do not remove existing tests unless explicitly requested.

## Quality rules
When working on quality issues:
- Fix only the reported violations for the current task.
- Prefer manual, minimal fixes over broad rewrites.
- Do not “clean up” unrelated code.
- After fixes, run:
  - mvn checkstyle:check
  - mvn pmd:check
  - mvn spotbugs:check
  - mvn clean install

## Jenkins rules
When working on CI:
- Use the simplest Declarative Pipeline possible.
- Include only the required stages unless explicitly asked for more:
  - Build
  - Test
  - Quality
- Use Maven commands that already work in the project.
- Do not add deployment, secrets, or extra CI complexity.

## Approval rules
If the task could affect multiple files or project behavior:
- Show the proposed change first.
- Wait for approval before continuing to other files.
- If a file already satisfies the requirement, say so and leave it untouched.

## Explanation rules
Always answer in a way the student can present in class:
- State what changed.
- State why it was changed.
- State how it was verified.
- Mention if behavior stayed the same.

## Commands commonly used in this project
- mvn test
- mvn clean package
- mvn clean install
- mvn checkstyle:check
- mvn pmd:check
- mvn spotbugs:check
- git status
- git log --oneline

## What Claude must not do
- Do not invent requirements.
- Do not claim a file was changed if it was not changed.
- Do not say a check passed unless it was actually run.
- Do not commit, push, or delete files unless explicitly asked.
- Do not hide unrelated modified files from the status report.

## AI usage principle
Claude may help generate drafts, tests, and configuration, but the final decisions must stay understandable and reviewable by the student.