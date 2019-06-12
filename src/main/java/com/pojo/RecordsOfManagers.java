package com.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * records_of_managers
 * @author 
 */
public class RecordsOfManagers{
    private String departmentId;

    private String employeeId;

    private Date takeofficeDate;

    private String agentManager;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Date getTakeofficeDate() {
        return takeofficeDate;
    }

    public void setTakeofficeDate(Date takeofficeDate) {
        this.takeofficeDate = takeofficeDate;
    }

    public String getAgentManager() {
        return agentManager;
    }

    public void setAgentManager(String agentManager) {
        this.agentManager = agentManager;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("departmentId=").append(departmentId);
        sb.append(", employeeId=").append(employeeId);
        sb.append(", takeofficeDate=").append(takeofficeDate);
        sb.append(", agentManager=").append(agentManager);
        sb.append("]");
        return sb.toString();
    }
}