package com.deloitte.awayday;

import java.util.List;

import com.deloitte.awayday.domain.TeamSchedule;
import com.deloitte.awayday.exception.AwayDayException;
import com.deloitte.awayday.io.FileOperation;
import com.deloitte.awayday.io.IOperation;
import com.deloitte.awayday.organizer.AwayDayActivitiesOrganizer;
import com.deloitte.awayday.service.AwayDayService;
import com.deloitte.awayday.service.IService;

/**
 * AwayDay app to organize the activities for various teams
 * 
 * 		arg [0] - Input file path which has the activities list. The input file should be in txt format
 * 		arg [1] - Team size. Team size can be 1 to 5
 *  	arg [2] - Output option i.e. whether the output should be written in console or file. Valid values are as follows
 *  			'c' - Write the output on Console
 *  			'w' - Write the output to file
 * 		
 * @author Sampath
 *
 */
public class AwayDayApp {
	public static void main(String[] args) throws AwayDayException {

		if (args != null && args.length != 3) {
			throw new IllegalArgumentException("Input file path, team size, output option (c/w) are mandatory");
		}

		String inputFilePath = args[0];
		Integer teamSize = Integer.valueOf(args[1]);
		String outputOption = args[2];
		
		if (!inputFilePath.substring(inputFilePath.lastIndexOf(".")+1).equals("txt")) {
			throw new IllegalArgumentException("File should be in txt format. Other file formats are not supported!!!");
		}	

		if (teamSize < 0 && teamSize > 5) {
			throw new IllegalArgumentException("Team size should be between 1 to 5");
		}		
		
		if (!outputOption.equals("c") && !outputOption.equals("w")) {
			throw new IllegalArgumentException("The third parameter (output option) should be either c or w");
		}

		IOperation fileOperarion = new FileOperation();
		AwayDayActivitiesOrganizer awayDayActivitiesOrganizer = new AwayDayActivitiesOrganizer();

		IService awayDayService = new AwayDayService(fileOperarion, awayDayActivitiesOrganizer);
		List<TeamSchedule> teamSchedule = awayDayService.teamScheduleList(inputFilePath, teamSize);

		if (outputOption.equals("c")) {
			fileOperarion.writeToConsole(teamSchedule);
		} else if (outputOption.equals("w")) {
			String outputFilePath = inputFilePath.substring(0, inputFilePath.indexOf(".txt")).concat("_output.txt");
			System.out.println("Output file location ==============> :" + outputFilePath);
			fileOperarion.writeToFile(teamSchedule, outputFilePath);
		}

	}
}
