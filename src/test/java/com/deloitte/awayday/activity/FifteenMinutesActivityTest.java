package com.deloitte.awayday.activity;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.deloitte.awayday.activity.FifteenMinutesActivity;
import com.deloitte.awayday.exception.AwayDayException;

public class FifteenMinutesActivityTest {

	private FifteenMinutesActivity fifteenMinutesActivity;

	@Before
	public void setup() {
		fifteenMinutesActivity = new FifteenMinutesActivity();
	}

	@Test
	public void getRandomActivityForSingleActivity() throws AwayDayException {
		List<String> activityList = new ArrayList<>();
		activityList.add("Duck Herding 15min");

		Assert.assertEquals("Duck Herding 15min", fifteenMinutesActivity.getActivity(activityList));
	}

	@Test
	public void getRandomActivityForSingleSprintActivity() throws AwayDayException {
		List<String> activityList = new ArrayList<>();
		activityList.add("Duck Herding sprint");

		Assert.assertEquals("Duck Herding sprint", fifteenMinutesActivity.getActivity(activityList));
	}

	@Test
	public void getRandomActivityForSprintActivityFromTwoActivities() throws AwayDayException {
		List<String> activityList = new ArrayList<>();
		activityList.add("Duck Herding sprint");
		activityList.add("Archery 45min");

		Assert.assertEquals("Duck Herding sprint", fifteenMinutesActivity.getActivity(activityList));
	}

	@Test
	public void getRandomActivityForFifteenMinsActivityFromTwoActivities() throws AwayDayException {
		List<String> activityList = new ArrayList<>();
		activityList.add("Duck Herding 15min");
		activityList.add("Archery 45min");

		Assert.assertEquals("Duck Herding 15min", fifteenMinutesActivity.getActivity(activityList));
	}

	@Test
	public void getRandomActivityForSprintActivityFromThreeActivities() throws AwayDayException {
		List<String> activityList = new ArrayList<>();
		activityList.add("Duck Herding sprint");
		activityList.add("Archery 45min");
		activityList.add("Laser Clay Shooting 60min");

		Assert.assertEquals("Duck Herding sprint", fifteenMinutesActivity.getActivity(activityList));
	}

	@Test
	public void getRandomActivityForFifteenActivityFromThreeActivities() throws AwayDayException {
		List<String> activityList = new ArrayList<>();
		activityList.add("Archery 45min");
		activityList.add("Laser Clay Shooting 60min");
		activityList.add("Duck Herding 15min");

		Assert.assertEquals("Duck Herding 15min", fifteenMinutesActivity.getActivity(activityList));
	}

	@Test(expected = AwayDayException.class)
	public void getRandomActivityNotFound() throws AwayDayException {
		List<String> activityList = new ArrayList<>();
		activityList.add("Archery 45min");
		activityList.add("Laser Clay Shooting 60min");

		fifteenMinutesActivity.getActivity(activityList);
	}

	@Test(expected = AwayDayException.class)
	public void getRandomActivityThrowExceptionForNullActivity() throws AwayDayException {

		fifteenMinutesActivity.getActivity(null);
	}

	@Test(expected = AwayDayException.class)
	public void getRandomActivityThrowExceptionForEmptyActivity() throws AwayDayException {
		List<String> activityList = new ArrayList<>();

		fifteenMinutesActivity.getActivity(activityList);
	}

}
