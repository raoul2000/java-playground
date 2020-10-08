# Hello World
This is a basic "hello world" example to prepare VSCode environment and test everything works fine.

## Pre requisite

- having Manven installed and available from the command line
- VSCode installed with [Java language](https://code.visualstudio.com/docs/languages/java) extensions
- Java 11 installed

## About the Java version

Even if Java 11 is required by the Java VSCode extension, it doesn't mean you code has to be executed with this version. Use the *User Settings* add :

```json
    "java.home": "C:/Program Files/Java/java-11-openjdk-11.0.3.7-1",
    "java.configuration.runtimes": [
    
      {
        "name": "JavaSE-1.8",
        "path": "C:/Program Files/Java/jdk1.8.0_101",
        "default": true
      },
    ]
```    

In this case, Java 11 being set by the `java.home` property, it will be used by VSCode. Then you can define any other Java version as runtime environment for your Java applications.

## The Project

This incedrible project was created from Maven archetype in interactive mode. From the folder where you want to create your project, open a console and enter the following command: 
```
mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4
```

Note that this operation is aso available from VSCode, using the maven extension provided with the Java Language Support Package.

