#### Ben Schaefer's
# Exile Tracker


### Problem Statement
This program will be a task list / time tracker for the game *Path of Exile*. It will help optimize speedrunning
through the first portion of the game. It will come packed with extra features for versatility and fun.

Path of Exile is an online Action RPG set in a dark fantasy world created by Grinding Gear Games.
With a focus on visceral action combat, powerful items and deep character customization, players 
can change the way they play the game from start to finish. 

![Path of Exile Logo](src/main/webapp/images/poeLogo.png)

There are two portions to the game. The story and the end game. Players are constantly pushing to get through
the story as fast as possible because 90% of the games content falls in the end game. This tool serves to make 
getting through the story portion as fast as possible by eliminating useless quests and recommending 
useful tactics and items to aid the player. 

**Main Features**:
* Task List and Quest Watcher
* User Set Goals / Tasks
* User Profile and Build Planner
* Tips and More Page

**Secondary Features**:
* Item Search
* Player Search 

>"When the time comes to strike an emperor strikes without hesitation. 
>To entertain doubt is to dance with death." -Emperor Izaro

![Path of Exile Art](src/main/webapp/images/poeArt.png)
### Project Technologies/Techniques 

* Security/Authentication
  * Tomcat's JDBC Realm Authentication
  * Admin role: create/read/update/delete (crud) of all data
  * User role: create and personalize user page, can add / remove tasks
  * All: anyone can view users and stash tabs. Can look up items, users, and view the tips page
* Database
  * MySQL
  * Store users and roles
  * Store all data tasks and builds.
  * Store item data and item list
* ORM Framework
  * Hibernate 5
* Dependency Management
  * Maven
* Web Services consumed using Java
  * POE Item API
* CSS 
  * github.com/necolas/normalize.css
* Data Validation
  * Bootstrap Validator for front end
* Logging
  * Configurable logging using Log4J2. 
* Hosting
  * AWS
* Independent Research Topic/s
  * POE Item List API
  * POE Player List API
  * POE Stash Tab API
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