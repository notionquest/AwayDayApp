package com.deloitte.awayday.activity;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.deloitte.awayday.activity.SixtyMinutesActivity;
import com.deloitte.awayday.exception.AwayDayException;

public class SixtyMinutesActivityTest {
	
	private SixtyMinutesActivity sixtyMinutesActivity;
	
	@Before
	public void setup() {
		sixtyMinutesActivity = new SixtyMinutesActivity();
	}

	@Test
	public void getRandomActivityForSingleActivity() throws AwayDayException {
		List<String> activityList = new ArrayList<>();
		activityList.add("Duck Herding 60min");
		
		Assert.assertEquals("Duck Herding 60min", sixtyMinutesActivity.getActivity(activityList));
	}
	
	@Test
	public void getRandomActivityForTwoActivities() throws AwayDayException {
		List<String> activityList = new ArrayList<>();
		activityList.add("Duck Herding 60min");
		activityList.add("Archery 45min");
		
		Assert.assertEquals("Duck Herding 60min", sixtyMinutesActivity.getActivity(activityList));
	}
	
	@Test
	public void getRandomActivityForThreeActivities() throws AwayDayException {
		List<String> activityList = new ArrayList<>();
		activityList.add("Duck Herding 60min");
		activityList.add("Archery 45min");
		activityList.add("Laser Clay Shooting 60min");
		
		
		Assert.assertNotNull(sixtyMinutesActivity.getActivity(activityList));
	}
	
	@Test(expected = AwayDayException.class)
	public void getRandomActivityNotFound() throws AwayDayException {
		List<String> activityList = new ArrayList<>();
		activityList.add("Archery 45min");
		
		sixtyMinutesActivity.getActivity(activityList);
	}	
	
	@Test(expected = AwayDayException.class)
	public void getRandomActivityThrowExceptionForNullActivity() throws AwayDayException {
		
		sixtyMinutesActivity.getActivity(null);
	}
	
	@Test(expected = AwayDayException.class)
	public void getRandomActivityThrowExceptionForEmptyActivity() throws AwayDayException {
		List<String> activityList = new ArrayList<>();
		
		sixtyMinutesActivity.getActivity(activityList);
	}
	
}
