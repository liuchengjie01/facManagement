package com.pojo;

public class project {

    private String project_id;
    private String employee_id;
    private String department_id;
    private String project_name;
    private String project_starttime;
    private String project_budget;
    private String project_expenditure;
    private String outsourcing;

    @Override
    public String toString() {
        return "project{" +
                "project_id='" + project_id + '\'' +
                ", employee_id='" + employee_id + '\'' +
                ", department_id='" + department_id + '\'' +
                ", project_name='" + project_name + '\'' +
                ", project_starttime='" + project_starttime + '\'' +
                ", project_budget='" + project_budget + '\'' +
                ", project_expenditure='" + project_expenditure + '\'' +
                ", outsourcing='" + outsourcing + '\'' +
                '}';
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_starttime() {
        return project_starttime;
    }

    public void setProject_starttime(String project_starttime) {
        this.project_starttime = project_starttime;
    }

    public String getProject_budget() {
        return project_budget;
    }

    public void setProject_budget(String project_budget) {
        this.project_budget = project_budget;
    }

    public String getProject_expenditure() {
        return project_expenditure;
    }

    public void setProject_expenditure(String project_expenditure) {
        this.project_expenditure = project_expenditure;
    }

    public String getOutsourcing() {
        return outsourcing;
    }

    public void setOutsourcing(String outsourcing) {
        this.outsourcing = outsourcing;
    }
}
