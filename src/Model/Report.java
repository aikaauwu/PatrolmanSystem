package Model;

public class Report{
	
	private int reportnum;
	private String reportId;
	private String patrolmanId;
	private String reportDescription;
	private String reportDateSubmit;
	
	public int getReportnum() {
		return reportnum;
	}
	public void setReportnum(int reportnum) {
		this.reportnum = reportnum;
	}
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	public String getPatrolmanId() {
		return patrolmanId;
	}
	public void setPatrolmanId(String patrolmanId) {
		this.patrolmanId = patrolmanId;
	}
	public String getReportDescription() {
		return reportDescription;
	}
	public void setReportDescription(String reportDescription) {
		this.reportDescription = reportDescription;
	}
	public String getreportDateSubmit() {
		return reportDateSubmit;
	}
	public void setreportDateSubmit(String reportDateSubmit) {
		this.reportDateSubmit = reportDateSubmit;
	}
}