package com.deloitte.awayday.service;

import java.util.List;

import com.deloitte.awayday.domain.TeamSchedule;
import com.deloitte.awayday.exception.AwayDayException;

public interface IService {
	
	List<TeamSchedule> teamScheduleList (String filePath, Integer teamSize) throws AwayDayException;

}
