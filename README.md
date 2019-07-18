# Password update
This repository contains automated test for testing password change functionality.

## Getting Started
These instructions will allow you to develop and conduct tests on your local machine.

### Prerequisites
Our tests are written using Cucumber and the Gherkin syntax; they are executed using Java's cucumber-java library. All Java dependencies are defined in our pom.xml and are resolved using Maven.


The development tools below are available online
* Java 8
* Maven
* Cucumber -enable cucumber plugin in intellij,

## Installation
To install all Java dependencies, run
```console
$ mvn clean install
```

## Running tests
```console
$ mvn test
```

## Test structure

`src\test\resources\feature\PasswordValidator` - Contains all Cucumber features.
`src\test\java\TestRunner\RunCucumberTest.java` - Main class that executes Cucumber tests.
`src\test\java\Stepdefs\Stepdef.java\` - This class is aligned to a Cucumber feature file. These classes contain step defintions that is only in scope of the connected feature.
`src\test\java\Stepdefs\PasswordValidator.java\` - Contains system password validation checks
`src\test\java\Stepdefs\PasswordComparator.java\` - Contains old and new password comparison checks
`src\test\java\utils\ConnectingDatabase.java\ - Contains database connectivity code. Required if fetching system password from db.
`src\test\java\utils\PropertyReader.java\ - reads the property file. Required if fetching system password from properties file.
