package com.deloitte.awayday.io;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.deloitte.awayday.domain.TeamSchedule;
import com.deloitte.awayday.exception.AwayDayException;

public class FileOperationTest {

	private IOperation fileOperation;
	private List<TeamSchedule> teamScheduleList;

	@Before
	public void setup() {
		fileOperation = new FileOperation();
		teamScheduleList = new ArrayList<>();

		List<String> activities = new ArrayList<>();
		activities.add("Duck Herding 60min");
		activities.add("Human Table Football 30min");
		activities.add("Buggy Driving 30min");
		activities.add("Salsa & Pickles sprint");
		activities.add("2-wheeled Segways 45min");
		activities.add("Lunch Break 60min");
		activities.add("Viking Axe Throwing 60min");
		activities.add("Wine Tasting sprint");
		activities.add("Giant Puzzle Dinosaurs 30min");
		activities.add("Enigma Challenge 45min");
		activities.add("Learning Magic Tricks 40min");
		activities.add("Time Tracker sprint");
		activities.add("Indiano Drizzle 45min");
		activities.add("Staff Motivation Presentation");

		TeamSchedule teamSchedule = new TeamSchedule("Team 1:", activities);

		teamScheduleList.add(teamSchedule);
	}

	@Test
	public void readDataFromFile() throws AwayDayException {

		String fileName = getClass().getClassLoader().getResource("activities.txt").toString();
		List<String> activitiesList = fileOperation.readFile(fileName.substring(6));
		Assert.assertNotNull(activitiesList);
		Assert.assertEquals(20, activitiesList.size());

	}

	@Test(expected = AwayDayException.class)
	public void readDataFromInvalidFilePath() throws AwayDayException {

		fileOperation.readFile("activitiesss.txt");

	}

	@Test
	public void readDataFromEmptyFile() throws AwayDayException {

		String fileName = getClass().getClassLoader().getResource("activities_empty.txt").toString();
		List<String> activitiesList = fileOperation.readFile(fileName.substring(6));
		Assert.assertNotNull(activitiesList);
		Assert.assertEquals(0, activitiesList.size());

	}

	@Test
	public void writeToConsole() throws AwayDayException {

		List<String> activitiesList = fileOperation.writeToConsole(teamScheduleList);
		Assert.assertNotNull(activitiesList);
		Assert.assertEquals(15, activitiesList.size());

	}

	@Test
	public void writeToFile() throws AwayDayException {

		String filePath = getClass().getClassLoader().getResource("activities_file_output.txt").toString().substring(6);

		List<String> activitiesList = fileOperation.writeToFile(teamScheduleList, filePath);
		Assert.assertNotNull(activitiesList);
		Assert.assertEquals(15, activitiesList.size());

	}

}
