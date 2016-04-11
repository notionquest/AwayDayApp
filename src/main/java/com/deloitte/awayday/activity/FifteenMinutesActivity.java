package com.deloitte.awayday.activity;

import java.util.List;
import java.util.stream.Collectors;

import com.deloitte.awayday.constants.ActivityEnum;
import com.deloitte.awayday.exception.AwayDayException;

/**
 * Get the fifteen mins activity
 * 
 * @author Sampath
 *
 */
public class FifteenMinutesActivity extends BaseActivity implements IActivityStrategy {

	@Override
	public String getActivity(List<String> activityList) throws AwayDayException {

		String returnValue = null;
		ActivityEnum fifteenMinutesActivity = ActivityEnum.FIFTEENMINS;
		ActivityEnum sprintActivity = ActivityEnum.SPRINT;

		if (preValidation(activityList)) {
			List<String> hourActivityList = activityList.stream()
					.filter(s -> s.contains(fifteenMinutesActivity.getActivity()) ||
							s.contains(sprintActivity.getActivity()))
					.collect(Collectors.toList());

			returnValue = getRandomActivity(hourActivityList);
		}
		return returnValue;
	}

}
