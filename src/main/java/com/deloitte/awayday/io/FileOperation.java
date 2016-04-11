package com.deloitte.awayday.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.deloitte.awayday.constants.IAwayDayConstants;
import com.deloitte.awayday.domain.TeamSchedule;
import com.deloitte.awayday.exception.AwayDayException;

/**
 * Handles IO operations
 * 
 * @author Sampath
 *
 */
public class FileOperation implements IOperation {

	/**
	 * Produce a {@link List<String>} instance from filePath
	 * 
	 * @param filePath
	 *            Location of the file
	 * @return List<String> instance
	 */
	@Override
	public List<String> readFile(String filePath) throws AwayDayException {

		List<String> activities = null;

		if (preValidation(filePath, IAwayDayConstants.FILE_PATH_NULL_ERROR)) {

			try {
				BufferedReader br = Files.newBufferedReader(Paths.get(filePath));
				activities = br.lines().collect(Collectors.toList());

			} catch (FileNotFoundException fe) {
				throw new AwayDayException("File not found", fe);
			} catch (IOException e) {
				throw new AwayDayException("File IO exception", e);
			}
		}

		return activities;
	}

	private Boolean preValidation(Object inputObject, String errorMessage) throws AwayDayException {
		if (inputObject == null) {
			throw new AwayDayException(errorMessage);
		}

		return true;
	}

	/**
	 * Produce a {@link List<String>} instance from teamScheduleList
	 * 
	 * @param teamScheduleList
	 *            List of team schedules
	 * @return List<String> instance
	 */
	@Override
	public List<String> writeToConsole(List<TeamSchedule> teamScheduleList) throws AwayDayException {

		List<String> outputToConsole = convertToPrintableFormat(teamScheduleList);
		outputToConsole.forEach(System.out::println);
		;

		return outputToConsole;
	}

	/**
	 * Produce a {@link List<String>} instance from teamScheduleList
	 * 
	 * @param teamScheduleList
	 *            List of team schedules
	 * @param outputFile
	 *            Location of the output file
	 * @return List<String> instance
	 */
	@Override
	public List<String> writeToFile(List<TeamSchedule> teamScheduleList, String outputFile) throws AwayDayException {
		List<String> outputToConsole = convertToPrintableFormat(teamScheduleList);

		try {
			Files.write(Paths.get(outputFile), outputToConsole);
		} catch (IOException e) {
			throw new AwayDayException("Error while trying to write to file", e);
		}

		return outputToConsole;
	}

	private List<String> convertToPrintableFormat(List<TeamSchedule> teamScheduleList) throws AwayDayException {

		List<String> outputToConsole = null;
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

		if (preValidation(teamScheduleList, IAwayDayConstants.TEAM_SCHEDULE_NULL_ERROR)) {
			outputToConsole = new ArrayList<>();
			for (TeamSchedule teamSchedule : teamScheduleList) {
				outputToConsole.add(teamSchedule.getTeamName());
				LocalTime localTime = LocalTime.parse(IAwayDayConstants.ACTIVITY_START_TIME);

				for (int activityIndex = 0; activityIndex < teamSchedule.getActivities().size(); activityIndex++) {

					localTime = localTime.plusMinutes(IAwayDayConstants.activityScheduleIntervals[activityIndex]);

					outputToConsole.add(localTime.format(dateTimeFormatter) + " "
							+ teamSchedule.getActivities().get(activityIndex));
				}

			}
		}

		return outputToConsole;

	}

}
