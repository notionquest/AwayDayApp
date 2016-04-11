package com.deloitte.awayday.activity;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.deloitte.awayday.activity.FourtyMinutesActivity;
import com.deloitte.awayday.exception.AwayDayException;

public class FourtyMinutesActivityTest {

	private FourtyMinutesActivity fourtyMinutesActivity;

	@Before
	public void setup() {
		fourtyMinutesActivity = new FourtyMinutesActivity();
	}

	@Test
	public void getRandomActivityForSingleActivity() throws AwayDayException {
		List<String> activityList = new ArrayList<>();
		activityList.add("Learning Magic Tricks 40min");

		Assert.assertEquals("Learning Magic Tricks 40min", fourtyMinutesActivity.getActivity(activityList));
	}

	@Test
	public void getRandomActivityForTwoActivities() throws AwayDayException {
		List<String> activityList = new ArrayList<>();
		activityList.add("Learning Magic Tricks 40min");
		activityList.add("Archery 45min");

		Assert.assertEquals("Learning Magic Tricks 40min", fourtyMinutesActivity.getActivity(activityList));
	}

	@Test
	public void getRandomActivityForThreeActivities() throws AwayDayException {
		List<String> activityList = new ArrayList<>();

		activityList.add("Archery 45min");
		activityList.add("Learning Magic Tricks 40min");
		activityList.add("Laser Clay Shooting 60min");

		Assert.assertNotNull(fourtyMinutesActivity.getActivity(activityList));
	}

	@Test(expected = AwayDayException.class)
	public void getRandomActivityNotFound() throws AwayDayException {
		List<String> activityList = new ArrayList<>();

		activityList.add("Archery 45min");
		activityList.add("Laser Clay Shooting 60min");

		fourtyMinutesActivity.getActivity(activityList);
	}

	@Test(expected = AwayDayException.class)
	public void getRandomActivityThrowExceptionForNullActivity() throws AwayDayException {

		fourtyMinutesActivity.getActivity(null);
	}

	@Test(expected = AwayDayException.class)
	public void getRandomActivityThrowExceptionForEmptyActivity() throws AwayDayException {
		List<String> activityList = new ArrayList<>();

		fourtyMinutesActivity.getActivity(activityList);
	}

}
