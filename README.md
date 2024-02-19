# SSMS API

Simple Student Management System to go through SRE bootcamp exercises. (https://playbook.one2n.in/sre-bootcamp/sre-bootcamp-exercises)

## Architecture Diagram

![alt c4-context-diagram](./docs/ssms-c4-context.png)

## Application Structure (Code)

![alt code-organization](./docs/ssms-app-structure.png)


## Hexagonal Architecture (Dependency Graph)
![alt dependency-graph](./docs/dependency-graph.png)
## Domain Driven Design

Aggregate Root: Student

Attributes: StudentID, StudentName, EmailAddress, EnrollmentDate

Methods
- updateEmailAddress(Student student, String newEmail)
- updateStudentName(Student student, String firstName, String lastName)

ValueObjects
- StudentID
- StudentName
- EmailAddress


NB: This project uses [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/)
