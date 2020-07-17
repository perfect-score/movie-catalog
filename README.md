# movie-catalog

## Introduction
A Spring Boot Application demonstrating a simple REST service for a movie catalog.

## Project Structure

| Module        | Description |
| ------------- | ------------------------------------------------------------------   |
| movie-app     | Module containing the core application and REST controllers.         |
| movie-domain  | Module containing the persistence tier repositories and entities.    |
| movie-service | Module containing  services (largely) calling the persistennce tier. |

## Lombok
The project uses Project Lombok for automating the generation of getters/setters, as well as other methods such as "equals", "hashCode" and "toString".
Lombok is a Maven dependency which runs during compile-time to generate these methods. Plugins for IDE's (i.e. Eclipse/IntelliJ), must be installed to avoid syntax errors within the IDE.

## Dependency Management
Dependencies are defined in the parent pom file and in the module (child) pom files. The parent pom file contains both the dependencies for all modules and the required dependency versions. Changing the version numbers in the parent pom file will affect all modules.

## Building
To build the application JAR file, run the Maven build process against the parent pom file. This will pull in all the required dependencies and generate an application JAR file in the **movie-app\target** directory.

## Running
To run the software, run the application directly using the Java command line as below:

```
java -jar movie-catalog.jar
```

## Testing
Sample Postman messages can be found in the **movie-app\src\test\resources\postman** directory.