package com.deloitte.awayday.activity;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.deloitte.awayday.activity.FourtyFiveMinutesActivity;
import com.deloitte.awayday.exception.AwayDayException;

public class FourtyFiveMinutesActivityTest {
	
	private FourtyFiveMinutesActivity fourtyFiveMinutesActivity;
	
	@Before
	public void setup() {
		fourtyFiveMinutesActivity = new FourtyFiveMinutesActivity();
	}

	@Test
	public void getRandomActivityForSingleActivity() throws AwayDayException {
		List<String> activityList = new ArrayList<>();
		activityList.add("Indiano Drizzle 45min");
		
		Assert.assertEquals("Indiano Drizzle 45min", fourtyFiveMinutesActivity.getActivity(activityList));
	}
	
	@Test
	public void getRandomActivityForTwoActivities() throws AwayDayException {
		List<String> activityList = new ArrayList<>();
		activityList.add("Learning Magic Tricks 40min");
		activityList.add("Archery 45min");
		
		Assert.assertEquals("Archery 45min", fourtyFiveMinutesActivity.getActivity(activityList));
	}
	
	@Test
	public void getRandomActivityForThreeActivities() throws AwayDayException {
		List<String> activityList = new ArrayList<>();
		
		activityList.add("Archery 45min");
		activityList.add("Learning Magic Tricks 40min");
		activityList.add("Laser Clay Shooting 60min");
		
		
		Assert.assertEquals("Archery 45min", fourtyFiveMinutesActivity.getActivity(activityList));
	}
	
	@Test(expected = AwayDayException.class)
	public void getRandomActivityNotFound() throws AwayDayException {
		List<String> activityList = new ArrayList<>();
		
		activityList.add("Salsa & Pickles sprint");
		activityList.add("Learning Magic Tricks 40min");
		activityList.add("Laser Clay Shooting 60min");
		
		
		fourtyFiveMinutesActivity.getActivity(activityList);
	}	
	
	@Test(expected = AwayDayException.class)
	public void getRandomActivityThrowExceptionForNullActivity() throws AwayDayException {
		
		fourtyFiveMinutesActivity.getActivity(null);
	}
	
	@Test(expected = AwayDayException.class)
	public void getRandomActivityThrowExceptionForEmptyActivity() throws AwayDayException {
		List<String> activityList = new ArrayList<>();
		
		fourtyFiveMinutesActivity.getActivity(activityList);
	}
	
}
