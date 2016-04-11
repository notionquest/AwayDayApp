package com.deloitte.awayday.activity;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.deloitte.awayday.activity.BaseActivity;
import com.deloitte.awayday.exception.AwayDayException;

public class BaseActivityTest {
	
	private BaseActivity baseActivity;
	
	@Before
	public void setup() {
		baseActivity = new BaseActivity();
	}

	@Test
	public void getRandomActivityForSingleActivity() throws AwayDayException {
		List<String> activityList = new ArrayList<>();
		activityList.add("Duck Herding 60min");
		
		Assert.assertEquals("Duck Herding 60min", baseActivity.getRandomActivity(activityList));
	}
	
	@Test
	public void getRandomActivityForTwoActivities() throws AwayDayException {
		List<String> activityList = new ArrayList<>();
		activityList.add("Duck Herding 60min");
		activityList.add("Archery 45min");
		
		Assert.assertNotNull(baseActivity.getRandomActivity(activityList));
	}
	
	@Test(expected = AwayDayException.class)
	public void getRandomActivityThrowExceptionForNullActivity() throws AwayDayException {
		
		baseActivity.getRandomActivity(null);
	}
	
	@Test(expected = AwayDayException.class)
	public void getRandomActivityThrowExceptionForEmptyActivity() throws AwayDayException {
		List<String> activityList = new ArrayList<>();
		
		baseActivity.getRandomActivity(activityList);
	}
	
}
