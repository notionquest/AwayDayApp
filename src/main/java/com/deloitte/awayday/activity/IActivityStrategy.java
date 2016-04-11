package com.deloitte.awayday.activity;

import java.util.List;

import com.deloitte.awayday.exception.AwayDayException;

public interface IActivityStrategy {

	public String getActivity(List<String> activityList) throws AwayDayException;

}
