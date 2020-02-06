# Ben Schaefer Indie Project

This repository will hold my individual project for the semester.

### Problem Statement
This program will be a task list / time tracker for the game *Path of Exile*. It will help optimize speedrunning
through the first portion of the game. 

![Path of Exile Logo](src/main/webapp/images/poeLogo.png)

**Main Features**:
* Task List (Quest Watcher)
* Timer and Sets
* User Set Goals / Tasks
* User Profile and Build Planner

**Secondary Features**:
* Item Search
* Stash Tab Viewer
* Player Search 

>"When the time comes to strike an emperor strikes without hesitation. 
>To entertain doubt is to dance with death." -Emperor Izaro

### Project Technologies/Techniques 

* Security/Authentication
  * Tomcat's JDBC Realm Authentication
  * Admin role: create/read/update/delete (crud) of all data
  * User role: create and personalize user page, can add / remove tasks
  * All: anyone can view users and stash tabs. Can look up items.
* Database
  * MySQL
  * Store users and roles
  * Store all data for items and tasks.
* ORM Framework
  * Hibernate 5
* Dependency Management
  * Maven
* Web Services consumed using Java
  *
* CSS 
  * 
* Data Validation
  * Bootstrap Validator for front end
  * Explore Hibernate's validation
* Logging
  * Configurable logging using Log4J2. In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting. 
* Hosting
  * AWS
* Independent Research Topic/s
  * POE Item List API
  * POE Player List API
  * POE Stash Tab API
* Project Lombok to eliminate boilerplate code like getters/setters/equals
* Unit Testing
  * JUnit tests to achieve 80%+ code coverage 
* IDE: IntelliJ IDEA


### Design

* [User Stories](DesignDocuments/userStories.md)
* [Screen Design](DesignDocuments/screens.md)
* [Application Flow](DesignDocuments/applicationFlow.md)
* [Database Design](DesignDocuments/databaseDiagram.png)

### [Project Plan](projectPlan.md)

### [Weekly Reflection](TimeLog.md)