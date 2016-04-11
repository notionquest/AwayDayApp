package com.deloitte.awayday.organizer;

import java.util.List;

import com.deloitte.awayday.activity.FifteenMinutesActivity;
import com.deloitte.awayday.activity.FourtyFiveMinutesActivity;
import com.deloitte.awayday.activity.FourtyMinutesActivity;
import com.deloitte.awayday.activity.IActivityStrategy;
import com.deloitte.awayday.activity.SixtyMinutesActivity;
import com.deloitte.awayday.activity.ThirtyMinutesActivity;
import com.deloitte.awayday.constants.IAwayDayConstants;
import com.deloitte.awayday.exception.AwayDayException;

/**
 * Away Day Activities Organizer to organize the activities for various teams
 * 
 * @author Sampath
 *
 */
public class AwayDayActivitiesOrganizer extends ActivitiesOrganizer {

	private SixtyMinutesActivity sixtyMinutesActivity;
	private FourtyFiveMinutesActivity fourtyFiveMinutesActivity;
	private FourtyMinutesActivity fourtyMinutesActivity;
	private ThirtyMinutesActivity thirtyMinutesActivity;
	private FifteenMinutesActivity fifteenMinutesActivity;

	@Override
	public List<String> morningActivities(List<String> activitiesList) throws AwayDayException {

		// 60mins
		activityScheduleList.add(sixtyMinutesActivity.getActivity(activitiesList));
		// 30mins
		activityScheduleList.add(thirtyMinutesActivity.getActivity(activitiesList));
		activityScheduleList.add(getNextActivity(thirtyMinutesActivity, activitiesList));
		// 15mins
		activityScheduleList.add(fifteenMinutesActivity.getActivity(activitiesList));
		// 45mins
		activityScheduleList.add(fourtyFiveMinutesActivity.getActivity(activitiesList));

		return activityScheduleList;
	}

	@Override
	public List<String> lunchActivity() {
		activityScheduleList.add(IAwayDayConstants.LUNCH_ACTIVITY);
		return activityScheduleList;
	}

	@Override
	public List<String> afternoonActivities(List<String> activitiesList) throws AwayDayException {

		// 60mins
		activityScheduleList.add(getNextActivity(sixtyMinutesActivity, activitiesList));
		// 15mins
		activityScheduleList.add(getNextActivity(fifteenMinutesActivity, activitiesList));
		// 30mins
		activityScheduleList.add(getNextActivity(thirtyMinutesActivity, activitiesList));
		// 45mins
		activityScheduleList.add(getNextActivity(fourtyFiveMinutesActivity, activitiesList));
		// 40mins
		activityScheduleList.add(getNextActivity(fourtyMinutesActivity, activitiesList));
		// 15mins
		activityScheduleList.add(getNextActivity(fifteenMinutesActivity, activitiesList));

		// 45mins - should be shortened for 35 mins
		activityScheduleList.add(getNextActivity(fourtyFiveMinutesActivity, activitiesList));

		return activityScheduleList;
	}

	@Override
	public List<String> staffMovitationActivity() {
		activityScheduleList.add(IAwayDayConstants.STAFF_MOTIVATION_ACTIVITY);
		return activityScheduleList;
	}

	public AwayDayActivitiesOrganizer(SixtyMinutesActivity sixtyMinutesActivity,
			FourtyFiveMinutesActivity fourtyFiveMinutesActivity, FourtyMinutesActivity fourtyMinutesActivity,
			ThirtyMinutesActivity thirtyMinutesActivity, FifteenMinutesActivity fifteenMinutesActivity) {
		super();
		this.sixtyMinutesActivity = sixtyMinutesActivity;
		this.fourtyFiveMinutesActivity = fourtyFiveMinutesActivity;
		this.fourtyMinutesActivity = fourtyMinutesActivity;
		this.thirtyMinutesActivity = thirtyMinutesActivity;
		this.fifteenMinutesActivity = fifteenMinutesActivity;
	}

	public AwayDayActivitiesOrganizer() {
		super();
		this.sixtyMinutesActivity = new SixtyMinutesActivity();
		this.fourtyFiveMinutesActivity = new FourtyFiveMinutesActivity();
		this.fourtyMinutesActivity = new FourtyMinutesActivity();
		this.thirtyMinutesActivity = new ThirtyMinutesActivity();
		this.fifteenMinutesActivity = new FifteenMinutesActivity();
	}

	private String getNextActivity(IActivityStrategy activityStrategy, List<String> activitiesList)
			throws AwayDayException {

		String selectedActivity = activityStrategy.getActivity(activitiesList);

		while (activityScheduleList.contains(selectedActivity)) {
			selectedActivity = activityStrategy.getActivity(activitiesList);
		}

		return selectedActivity;

	}

}
