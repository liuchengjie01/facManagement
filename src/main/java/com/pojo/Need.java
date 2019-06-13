package com.pojo;

import java.util.Date;

/**
 * need
 * @author 
 */
public class Need {
    private String projectId;

    private String materialId;

    private int materialDemand;

    private int materialSupply;

    private int materialBalance;

    private Date supplyTime;

    private String unit;

    private int havaSupply;

    public Date getSupplyTime() {
        return supplyTime;
    }

    public void setSupplyTime(Date supplyTime) {
        this.supplyTime = supplyTime;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getMaterialDemand() {
        return materialDemand;
    }

    public void setMaterialDemand(int materialDemand) {
        this.materialDemand = materialDemand;
    }

    public int getMaterialSupply() {
        return materialSupply;
    }

    public void setMaterialSupply(int materialSupply) {
        this.materialSupply = materialSupply;
    }

    public int getMaterialBalance() {
        return materialBalance;
    }

    public void setMaterialBalance(int materialBalance) {
        this.materialBalance = materialBalance;
    }

    public int getHavaSupply() {
        return havaSupply;
    }

    public void setHavaSupply(int havaSupply) {
        this.havaSupply = havaSupply;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("projectId=").append(projectId);
        sb.append(", materialId=").append(materialId);
        sb.append(", materialDemand=").append(materialDemand);
        sb.append(", materialSupply=").append(materialSupply);
        sb.append(", materialBalance=").append(materialBalance);
        sb.append("]");
        return sb.toString();
    }
}