package com.deloitte.awayday.io;

import java.util.List;

import com.deloitte.awayday.domain.TeamSchedule;
import com.deloitte.awayday.exception.AwayDayException;

public interface IOperation {
	
	List<String> readFile (String filePath) throws AwayDayException;
	
	List<String> writeToConsole (List<TeamSchedule> teamSchedule) throws AwayDayException;

	List<String> writeToFile (List<TeamSchedule> teamSchedule, String outputFile) throws AwayDayException;
	
}
