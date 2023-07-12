package Model;

public class scheduleModel {
	private String scheduleId;
	private String scheduleDate;
	private String patrolmanId;
	private String scheduleTime;
	private int locationId;
	//ajax
	
	public String getScheduleId() { 
		return scheduleId;
	}
	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}
	
	public String getPatrolmanId() { 
		return patrolmanId;
	}
	public void setPatrolmanId(String patrolmanId) {
		this.patrolmanId = patrolmanId;
	}
	
	public String getScheduleTime() {
		return scheduleTime;
	}
	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	



	public String getscheduleDate() {

		return scheduleDate;
	}



	public void setscheduleDate(String scheduleDate) {

		this.scheduleDate = scheduleDate;
	}
	
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

}