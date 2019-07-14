# Password update
This repository contains automated test for testing password change functionality.

## Getting Started
These instructions will allow you to develop and conduct tests on your local machine.

### Prerequisites
Our tests are written using Cucumber and the Gherkin syntax; they are executed using Java's cucumber-java library. All Java dependencies are defined in our pom.xml and are resolved using Maven.


The development tools below are available online
* Java 8
* Maven
* Cucumber -enable cucumber plugin in intellij, cucumber jar used-cucumber-core-1.2.5, cucumber-java-4.3.0, cucumber-junit-4.3.0

## Installation
To install all Java dependencies, run
```console
$ mvn clean install
```

## Running tests
$ mvn test

## Test structure

`src\test\resources\feature\PasswordValidator` - Contains all Cucumber features.
`src\test\java\com\RunCucumberTest.java` - Main class that executes Cucumber tests.
`src\test\java\com\java.com.Stepdef.java\` - Each class in this directory is aligned to a Cucumber feature file. These classes contain step defintions that is only in scope of the connected feature.

`src\test\java\com\PasswordValidator.java\` - Contains system password validation checks

`src\test\java\com\PasswordComparator.java\` - Contains old and new password comparison checks
