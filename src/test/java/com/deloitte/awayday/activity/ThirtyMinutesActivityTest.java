package com.deloitte.awayday.activity;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.deloitte.awayday.activity.ThirtyMinutesActivity;
import com.deloitte.awayday.exception.AwayDayException;

public class ThirtyMinutesActivityTest {

	private ThirtyMinutesActivity thirtyMinutesActivity;

	@Before
	public void setup() {
		thirtyMinutesActivity = new ThirtyMinutesActivity();
	}

	@Test
	public void getRandomActivityForSingleActivity() throws AwayDayException {
		List<String> activityList = new ArrayList<>();
		activityList.add("Arduino Bonanza 30min");

		Assert.assertEquals("Arduino Bonanza 30min", thirtyMinutesActivity.getActivity(activityList));
	}

	@Test
	public void getRandomActivityForTwoActivities() throws AwayDayException {
		List<String> activityList = new ArrayList<>();
		activityList.add("Arduino Bonanza 30min");
		activityList.add("Archery 45min");

		Assert.assertEquals("Arduino Bonanza 30min", thirtyMinutesActivity.getActivity(activityList));
	}

	@Test
	public void getRandomActivityForThreeActivities() throws AwayDayException {
		List<String> activityList = new ArrayList<>();

		activityList.add("Archery 45min");
		activityList.add("Arduino Bonanza 30min");
		activityList.add("Laser Clay Shooting 60min");

		Assert.assertEquals("Arduino Bonanza 30min", thirtyMinutesActivity.getActivity(activityList));
	}

	@Test(expected = AwayDayException.class)
	public void getRandomActivityNotFound() throws AwayDayException {
		List<String> activityList = new ArrayList<>();

		activityList.add("Archery 45min");
		activityList.add("Laser Clay Shooting 60min");

		thirtyMinutesActivity.getActivity(activityList);
	}

	@Test(expected = AwayDayException.class)
	public void getRandomActivityThrowExceptionForNullActivity() throws AwayDayException {

		thirtyMinutesActivity.getActivity(null);
	}

	@Test(expected = AwayDayException.class)
	public void getRandomActivityThrowExceptionForEmptyActivity() throws AwayDayException {
		List<String> activityList = new ArrayList<>();

		thirtyMinutesActivity.getActivity(activityList);
	}

}
