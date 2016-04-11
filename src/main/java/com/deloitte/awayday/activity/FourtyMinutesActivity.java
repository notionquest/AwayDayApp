package com.deloitte.awayday.activity;

import java.util.List;
import java.util.stream.Collectors;

import com.deloitte.awayday.constants.ActivityEnum;
import com.deloitte.awayday.exception.AwayDayException;

/**
 * Get the fourty minutes activity
 * 
 * @author Sampath
 *
 */
public class FourtyMinutesActivity extends BaseActivity implements IActivityStrategy {

	@Override
	public String getActivity(List<String> activityList) throws AwayDayException {

		String returnValue = null;
		ActivityEnum activityType = ActivityEnum.FOURTYMINS;

		if (preValidation(activityList)) {
			List<String> hourActivityList = activityList.stream().filter(s -> s.contains(activityType.getActivity()))
					.collect(Collectors.toList());

			returnValue = getRandomActivity(hourActivityList);
		}
		return returnValue;
	}

}
