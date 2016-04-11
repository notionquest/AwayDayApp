package com.deloitte.awayday.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.deloitte.awayday.activity.FifteenMinutesActivity;
import com.deloitte.awayday.activity.FourtyFiveMinutesActivity;
import com.deloitte.awayday.activity.FourtyMinutesActivity;
import com.deloitte.awayday.activity.SixtyMinutesActivity;
import com.deloitte.awayday.activity.ThirtyMinutesActivity;
import com.deloitte.awayday.domain.TeamSchedule;
import com.deloitte.awayday.exception.AwayDayException;
import com.deloitte.awayday.io.FileOperation;
import com.deloitte.awayday.io.IOperation;
import com.deloitte.awayday.organizer.AwayDayActivitiesOrganizer;

public class AwayDayServiceTest {

	private AwayDayActivitiesOrganizer awayDayActivitiesOrganizer;
	private IOperation fileOperation;
	private IService awayDayService;

	@Before
	public void setup() {
		awayDayActivitiesOrganizer = new AwayDayActivitiesOrganizer(new SixtyMinutesActivity(),
				new FourtyFiveMinutesActivity(), new FourtyMinutesActivity(), new ThirtyMinutesActivity(),
				new FifteenMinutesActivity());
		fileOperation = new FileOperation();

		awayDayService = new AwayDayService(fileOperation, awayDayActivitiesOrganizer);
	}

	@Test
	public void organizeTheActivitiesForATeam() throws AwayDayException {

		String filePath = getClass().getClassLoader().getResource("activities.txt").toString();

		List<TeamSchedule> teamScheduleList = awayDayService.teamScheduleList(filePath.substring(6), 1);

		Assert.assertNotNull(teamScheduleList);
		Assert.assertEquals(1, teamScheduleList.size());
		Assert.assertEquals("Team 1:", teamScheduleList.get(0).getTeamName());
		Assert.assertEquals(14, teamScheduleList.get(0).getActivities().size());

	}
	
	@Test
	public void organizeTheActivitiesForTwoTeam() throws AwayDayException {

		String filePath = getClass().getClassLoader().getResource("activities.txt").toString();

		List<TeamSchedule> teamScheduleList = awayDayService.teamScheduleList(filePath.substring(6), 2);

		Assert.assertNotNull(teamScheduleList);
		Assert.assertEquals(2, teamScheduleList.size());
		
		Assert.assertEquals("Team 1:", teamScheduleList.get(0).getTeamName());
		Assert.assertEquals(14, teamScheduleList.get(0).getActivities().size());
		
		Assert.assertEquals("Team 2:", teamScheduleList.get(1).getTeamName());
		Assert.assertEquals(14, teamScheduleList.get(1).getActivities().size());


	}

}
