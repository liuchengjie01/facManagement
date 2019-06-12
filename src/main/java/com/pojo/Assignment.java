package com.pojo;

public class Assignment {
	private String task_id; //primary key
    private String project_id; //primary key
    private String task_content;
    private String task_completion;
    private String task_EFTime;
    private String task_RFTime;
    private String task_log;
	public String getTask_id() {
		return task_id;
	}
	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}
	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public String getTask_content() {
		return task_content;
	}
	public void setTask_content(String task_content) {
		this.task_content = task_content;
	}
	public String getTask_completion() {
		return task_completion;
	}
	public void setTask_completion(String task_completion) {
		this.task_completion = task_completion;
	}
	public String getTask_EFTime() {
		return task_EFTime;
	}
	public void setTask_EFTime(String task_EFTime) {
		this.task_EFTime = task_EFTime;
	}
	public String getTask_RFTime() {
		return task_RFTime;
	}
	public void setTask_RFTime(String task_RFTime) {
		this.task_RFTime = task_RFTime;
	}
	public String getTask_log() {
		return task_log;
	}
	public void setTask_log(String task_log) {
		this.task_log = task_log;
	}
}
