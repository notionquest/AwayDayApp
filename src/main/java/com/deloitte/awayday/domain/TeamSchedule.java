package com.deloitte.awayday.domain;

import java.util.List;

/**
 * Team Schedule object
 * 
 * @author Sampath
 *
 */
public class TeamSchedule {
	
	private String teamName;
	private List<String> activities;
	
	public TeamSchedule(String teamName, List<String> activities) {
		super();
		this.teamName = teamName;
		this.activities = activities;
	}
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public List<String> getActivities() {
		return activities;
	}
	public void setActivities(List<String> activities) {
		this.activities = activities;
	}
	@Override
	public String toString() {
		return "TeamSchedule [teamName=" + teamName + ", activities=" + activities + "]";
	}

}
