package com.deloitte.awayday.organizer;

import java.util.ArrayList;
import java.util.List;

import com.deloitte.awayday.exception.AwayDayException;

public abstract class ActivitiesOrganizer {

	protected List<String> activityScheduleList = new ArrayList<>();

	public abstract List<String> morningActivities(List<String> activitiesList) throws AwayDayException;

	public abstract List<String> lunchActivity();

	public abstract List<String> afternoonActivities(List<String> activitiesList) throws AwayDayException;

	public abstract List<String> staffMovitationActivity();

	public final List<String> organize(List<String> activitiesList) throws AwayDayException {

		morningActivities(activitiesList);

		lunchActivity();

		afternoonActivities(activitiesList);

		staffMovitationActivity();

		return activityScheduleList;
	}

	public List<String> getActivityScheduleList() {
		return activityScheduleList;
	}

	public void setActivityScheduleList(List<String> activityScheduleList) {
		this.activityScheduleList = activityScheduleList;
	}

}
