package Model;

public class Patrolman {
	
	private int patrolnum;
	private String patrolmanId;
	private String residentId;
	private String patrolmanUsername;
	private String patrolmanPassword;
	private String loginUsername;
	

	public int getPatrolnum() {
		return patrolnum;
	}
	public void setPatrolnum(int patrolnum) {
		this.patrolnum = patrolnum;
	}
	public String getPatrolmanId() {
		return patrolmanId;
	}
	public void setPatrolmanId(String patrolmanId) {
		this.patrolmanId = patrolmanId;
	}
	public String getResidentId() {
		return residentId;
	}
	public void setResidentId(String residentId) {
		this.residentId = residentId;
	}
	public String getPatrolmanUsername() {
		return patrolmanUsername;
	}
	public void setPatrolmanUsername(String patrolmanUsername) {
		this.patrolmanUsername = patrolmanUsername;
	}
	public String getPatrolmanPassword() {
		return patrolmanPassword;
	}
	public void setPatrolmanPassword(String patrolmanPassword) {
		this.patrolmanPassword = patrolmanPassword;
	}
	
	public String getPatrolmanLoginUsername() {
		return loginUsername;
	}
	public void setPatrolmanLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}
}