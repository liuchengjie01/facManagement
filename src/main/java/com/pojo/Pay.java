package com.pojo;

import java.io.Serializable;

/**
 * pay
 * @author 
 */
public class Pay{
    private String customerId;

    private String projectId;

    private Long projectPayable;

    private Long projectRealpayment;

    private Long projectRestpayment;


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Long getProjectPayable() {
        return projectPayable;
    }

    public void setProjectPayable(Long projectPayable) {
        this.projectPayable = projectPayable;
    }

    public Long getProjectRealpayment() {
        return projectRealpayment;
    }

    public void setProjectRealpayment(Long projectRealpayment) {
        this.projectRealpayment = projectRealpayment;
    }

    public Long getProjectRestpayment() {
        return projectRestpayment;
    }

    public void setProjectRestpayment(Long projectRestpayment) {
        this.projectRestpayment = projectRestpayment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("customerId=").append(customerId);
        sb.append(", projectId=").append(projectId);
        sb.append(", projectPayable=").append(projectPayable);
        sb.append(", projectRealpayment=").append(projectRealpayment);
        sb.append(", projectRestpayment=").append(projectRestpayment);
        sb.append("]");
        return sb.toString();
    }
}