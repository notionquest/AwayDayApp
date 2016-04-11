package com.deloitte.awayday.activity;

import java.util.List;
import java.util.Random;

import com.deloitte.awayday.exception.AwayDayException;

/**
 * Get the random activity from list
 * 
 * @author Sampath
 *
 */
public class BaseActivity {

	protected Boolean preValidation(List<String> activityList) throws AwayDayException {
		if (activityList == null || activityList.isEmpty()) {
			throw new AwayDayException("No activity list is null or empty");
		}
		return true;
	}

	protected String getRandomActivity(List<String> activityList) throws AwayDayException {

		String returnValue = null;
		if (preValidation(activityList)) {

			Random randomNumber = new Random();
			Integer selectActivity = randomNumber.nextInt(activityList.size());

			returnValue = activityList.get(selectActivity);
		}
		return returnValue;

	}

}
