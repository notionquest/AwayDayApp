# AwayDayApp
### AwayDayApp to organize the activities for teams

#####Assumptions:
1. Team size is assumed to be between 1 and 5

#####Design:
1. IOperation          - Interface to handle all IO operations
2. FileOperation       - To write to console and file
3. ActivitiesOrganizer - To organize the activities for a team. Template Design Pattern is used.
	                 Activities are divided into four : morning, lunch, afternoon and staff motivation
4. BaseActivity        - All the activities present in the input file are loaded to List
                         Based on the mins (60, 45. 40, 30 and 15 mins), the child classes will give an activity randomly within the range of the list size
		         The same activitiy will not be scheduled twice for a team as well
5. IService            - Interface to the service
6. AwayDayService      - The whole functionality is exposed as service to client application/programs   


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

__The output file location will be same as input with "_output" added to the end of the file name__

![Image of File Output for five teams](https://github.com/notionquest/ProjectDocumentation/blob/master/Images/AwayDayApp_File_output_for_five_teams.JPG)


#####Classes:
1. AwayDayApp - Main application class
2. BaseActivity - Base class to select the activity randomly
3. SixtyMinutesActivity - Get the 1 hour activity randomly
4. FourtyFiveMinutesActivity - Get the 45mins activity randomly
5. FourtyMinutesActivity - Get the 40mins activity randomly
6. ThirtyMinutesActivity - Get the 30mins activity randomly
7. FifteenMinutesActivity - Get the 15mins activity randomly
8. AwayDayException - AwayDay Exception 
9. ActivitiesOrganizer - Base class to organize the activities based on timing 
10. AwayDayActivitiesOrganizer - Organize the activities based on timing (morning, afternoon)
11. IService - AwayDay service interface
12. AwayDayService - AwayDay Service to organize the activities for various teams
13. IOperation - Interface for IO operations
14. FileOperation - Handles IO operations


#####Technology Stack:
1. Java 8
2. Maven - Build
3. JUnit - Unit Testing

#####Future enhancements:
1. The external libraries can be used to inject the dependencies (i.e. Spring DI or Guice)
2. Hamcrest can be used for better assertion 
