# AwayDayApp
### AwayDayApp to organize the activities for teams

#####To compile and package the AwayDay application:

    mvn clean compile assembly:single

#####To execute the tests in the AwayDay App:

    mvn clean test
  
#####To execute the AwayDay App:

    mvn clean compile assembly:single

    java -jar target/AwayDayApp-jar-with-dependencies.jar D:\temp\AwayDayApp\activities.txt 2 c
    java -jar target/AwayDayApp-jar-with-dependencies.jar D:\temp\AwayDayApp\activities.txt 5 w

#####Compile:
    mvn clean compile assembly:single
	
![Image of Compile](https://github.com/notionquest/ProjectDocumentation/blob/master/Images/AwayDayApp_Compile.JPG)

#####Unit Test Result:
    mvn clean test

![Image of Unit Test Result](https://github.com/notionquest/ProjectDocumentation/blob/master/Images/AwayDayApp_UnitTestCasesExecution.JPG)
    
#####Sample Outputs:

**Organize the activities for two teams and print the output to console:**

    java -jar target/AwayDayApp-jar-with-dependencies.jar D:\temp\AwayDayApp\activities.txt 2 c

![Image of Organize for two teams](https://github.com/notionquest/ProjectDocumentation/blob/master/Images/AwayDayApp_Output_for_two_teams.JPG)

**Organize the activities for five teams and write the output to file:**

    java -jar target/AwayDayApp-jar-with-dependencies.jar D:\temp\AwayDayApp\activities.txt 5 w

![Image of Organize for five teams](https://github.com/notionquest/ProjectDocumentation/blob/master/Images/AwayDayApp_Output_for_five_teams.JPG)

![Image of File Output for five teams](https://github.com/notionquest/ProjectDocumentation/blob/master/Images/AwayDayApp_File_output_for_five_teams.JPG)


#####Classes:
1. AwayDayApp - Main application class
2. BaseActivity - Base class to select the activity randomly


#####Technology Stack:
1. Java 8
2. Maven - Build
3. JUnit - Unit Testing

#####Future enhancements:
1. The external libraries can be used to inject the dependencies (i.e. Spring DI or Guice)
2. Hamcrest can be used for better assertion 
