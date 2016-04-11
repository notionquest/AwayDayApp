package com.deloitte.awayday.organizer;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.deloitte.awayday.activity.FifteenMinutesActivity;
import com.deloitte.awayday.activity.FourtyFiveMinutesActivity;
import com.deloitte.awayday.activity.FourtyMinutesActivity;
import com.deloitte.awayday.activity.SixtyMinutesActivity;
import com.deloitte.awayday.activity.ThirtyMinutesActivity;
import com.deloitte.awayday.constants.IAwayDayConstants;
import com.deloitte.awayday.exception.AwayDayException;
import com.deloitte.awayday.io.FileOperation;
import com.deloitte.awayday.io.IOperation;

public class AwayDayActivitiesOrganizerTest {

	private AwayDayActivitiesOrganizer awayDayActivitiesOrganizer;
	private IOperation fileOperation;

	@Before
	public void setup() {
		awayDayActivitiesOrganizer = new AwayDayActivitiesOrganizer(new SixtyMinutesActivity(),
				new FourtyFiveMinutesActivity(), new FourtyMinutesActivity(), new ThirtyMinutesActivity(),
				new FifteenMinutesActivity());

		fileOperation = new FileOperation();
	}

	@Test
	public void organizeTheActivitiesForATeam() throws AwayDayException {

		String fileName = getClass().getClassLoader().getResource("activities.txt").toString();
		List<String> activitiesList = fileOperation.readFile(fileName.substring(6));

		List<String> scheduledActivitiesList = awayDayActivitiesOrganizer.organize(activitiesList);

		Assert.assertNotNull(scheduledActivitiesList);
		Assert.assertEquals(14, scheduledActivitiesList.size());
		Assert.assertEquals(IAwayDayConstants.LUNCH_ACTIVITY, scheduledActivitiesList.get(5));
		Assert.assertEquals(IAwayDayConstants.STAFF_MOTIVATION_ACTIVITY, scheduledActivitiesList.get(13));

	}

	@Test
	public void organizeMorningActivities() throws AwayDayException {

		String fileName = getClass().getClassLoader().getResource("activities.txt").toString();
		List<String> activitiesList = fileOperation.readFile(fileName.substring(6));

		List<String> scheduledActivitiesList = awayDayActivitiesOrganizer.morningActivities(activitiesList);

		Assert.assertNotNull(scheduledActivitiesList);
		Assert.assertEquals(5, scheduledActivitiesList.size());
	}

	@Test
	public void organizeLunchActivity() throws AwayDayException {

		List<String> scheduledActivitiesList = awayDayActivitiesOrganizer.lunchActivity();

		Assert.assertNotNull(scheduledActivitiesList);
		Assert.assertEquals(1, scheduledActivitiesList.size());
		Assert.assertEquals(IAwayDayConstants.LUNCH_ACTIVITY, scheduledActivitiesList.get(0));
	}

	@Test
	public void organizeAfternoonActivities() throws AwayDayException {

		String fileName = getClass().getClassLoader().getResource("activities.txt").toString();
		List<String> activitiesList = fileOperation.readFile(fileName.substring(6));

		List<String> scheduledActivitiesList = awayDayActivitiesOrganizer.afternoonActivities(activitiesList);

		Assert.assertNotNull(scheduledActivitiesList);
		Assert.assertEquals(7, scheduledActivitiesList.size());
	}

	@Test
	public void organizeStaffMotivationActivity() throws AwayDayException {

		List<String> scheduledActivitiesList = awayDayActivitiesOrganizer.staffMovitationActivity();

		Assert.assertNotNull(scheduledActivitiesList);
		Assert.assertEquals(1, scheduledActivitiesList.size());
		Assert.assertEquals(IAwayDayConstants.STAFF_MOTIVATION_ACTIVITY, scheduledActivitiesList.get(0));
	}

}
