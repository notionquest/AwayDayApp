package com.deloitte.awayday.constants;

public enum ActivityEnum {
	SIXTYMINS("60min"), THIRTYMINS("30min"), FIFTEENMINS("15min"), SPRINT("sprint"), 
	FOURTYFIVEMINS("45min"), FOURTYMINS("40min");

	private String activityValue;

	private ActivityEnum(String value) {
		this.activityValue = value;
	}
	
	public String getActivity() {
		return this.activityValue;
	}

	public static ActivityEnum getActivityEnumType(String activityValue) {
		
		for (ActivityEnum activityEnum : ActivityEnum.values()) {
			if (activityValue.equals(activityEnum.name())) {
				return activityEnum;
			}
		}
		return null;
	}

}
