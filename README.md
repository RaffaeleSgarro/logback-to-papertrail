Requirements
============

* Java 11
* A text editor


Usage instructions
==================

* To configure Papertrail host and port please copy `application.properties.example`
  to `application.properties` and edit according to your settings
* Start the application with `./gradlew bootRun`
* App has been developed with SpringBoot. Source files in `src/main/java/`
* Logback is configured in `src/main/resources/logback-spring.xml`
* Once the app is running you can generate multiline ASCII art or error with stack traces by
  typing `1` or `2` in the controlling console window

