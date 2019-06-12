package com.pojo;

public class Involve{
    private String employee_id;
	private String project_id;
	private String week_startdate;
	private int week_workhour;
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public String getWeek_startdate() {
		return week_startdate;
	}
	public void setWeek_startdate(String week_startdate) {
		this.week_startdate = week_startdate;
	}
	public int getWeek_workhour() {
		return week_workhour;
	}
	public void setWeek_workhour(int week_workhour) {
		this.week_workhour = week_workhour;
	}
}