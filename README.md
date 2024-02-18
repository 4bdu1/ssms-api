# SSMS API

Simple Student Management System to go through SRE bootcamp exercises. (https://playbook.one2n.in/sre-bootcamp/sre-bootcamp-exercises)

## Architecture Diagram

![alt c4-context-diagram](./docs/ssms-c4-context.png)

## Application Structure (Code)

![alt code-organization](./docs/ssms-app-structure.png)

## Domain Driven Design

Aggregate Root: Student
Attributes: StudentID, StudentName, EmailAddress, EnrollmentDate

Methods
- updateEmailAddress(EmailAddress newEmail)
- updateStudentName(StudentName newName)

ValueObjects
- StudentID
- StudentName
- EmailAddress


NB: This project uses [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/)
