package com.deloitte.awayday.service;

import java.util.ArrayList;
import java.util.List;

import com.deloitte.awayday.constants.IAwayDayConstants;
import com.deloitte.awayday.domain.TeamSchedule;
import com.deloitte.awayday.exception.AwayDayException;
import com.deloitte.awayday.io.IOperation;
import com.deloitte.awayday.organizer.AwayDayActivitiesOrganizer;

/**
 * Away Day Service to schedule the activities for the team
 * 
 * @author Sampath
 *
 */
public class AwayDayService implements IService {

	private IOperation fileOperarion;
	private AwayDayActivitiesOrganizer awayDayActivitiesOrganizer;

	@Override
	public List<TeamSchedule> teamScheduleList(String filePath, Integer teamSize) throws AwayDayException {

		List<TeamSchedule> teamScheduleList = null;

		if (preValidation(teamSize)) {
			teamScheduleList = new ArrayList<TeamSchedule>();
			List<String> activitiesList = fileOperarion.readFile(filePath);

			for (Integer teamIndex = 1; teamIndex <= teamSize; teamIndex++) {
				TeamSchedule teamSchedule = new TeamSchedule(
						IAwayDayConstants.TEAM.concat(teamIndex.toString()).concat(IAwayDayConstants.COLON),
						awayDayActivitiesOrganizer.organize(activitiesList));
				teamScheduleList.add(teamSchedule);
				awayDayActivitiesOrganizer.setActivityScheduleList(new ArrayList<>());
			}

		}
		return teamScheduleList;
	}

	private Boolean preValidation(Integer teamSize) throws AwayDayException {
		if (teamSize < 0 && teamSize > 5) {
			throw new AwayDayException("Team size should be between 1 to 5");
		}

		return true;
	}

	public AwayDayService(IOperation fileOperarion, AwayDayActivitiesOrganizer awayDayActivitiesOrganizer) {
		super();
		this.fileOperarion = fileOperarion;
		this.awayDayActivitiesOrganizer = awayDayActivitiesOrganizer;
	}

}
