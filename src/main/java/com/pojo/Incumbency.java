package com.pojo;


import java.util.Date;

/**
 * incumbency
 * @author 
 */
public class Incumbency{
    private String employeeId;

    private String departmentId;

    private Date departmentEtime;

    private String departmentPosition;

    private Date departmentLtime;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Date getDepartmentEtime() {
        return departmentEtime;
    }

    public void setDepartmentEtime(Date departmentEtime) {
        this.departmentEtime = departmentEtime;
    }


    public String getDepartmentPosition() {
        return departmentPosition;
    }

    public void setDepartmentPosition(String departmentPosition) {
        this.departmentPosition = departmentPosition;
    }

    public Date getDepartmentLtime() {
        return departmentLtime;
    }

    public void setDepartmentLtime(Date departmentLtime) {
        this.departmentLtime = departmentLtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" [");
        sb.append("employeeId=").append(employeeId);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", departmentPosition=").append(departmentPosition);
        sb.append(", departmentEtime=").append(departmentEtime);
        sb.append(", departmentLtime=").append(departmentLtime);
        sb.append("]");
        return sb.toString();
    }

    public Incumbency(String employeeId, String departmentId, Date departmentEtime, String departmentPosition, Date departmentLtime) {
        this.employeeId = employeeId;
        this.departmentId = departmentId;
        this.departmentEtime = departmentEtime;
        this.departmentPosition = departmentPosition;
        this.departmentLtime = departmentLtime;
    }
}