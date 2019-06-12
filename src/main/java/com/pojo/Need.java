package com.pojo;

/**
 * need
 * @author 
 */
public class Need {
    private String projectId;

    private String materialId;

    private String materialDemand;

    private String materialSupply;

    private String materialBalance;

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

    public String getMaterialDemand() {
        return materialDemand;
    }

    public void setMaterialDemand(String materialDemand) {
        this.materialDemand = materialDemand;
    }

    public String getMaterialSupply() {
        return materialSupply;
    }

    public void setMaterialSupply(String materialSupply) {
        this.materialSupply = materialSupply;
    }

    public String getMaterialBalance() {
        return materialBalance;
    }

    public void setMaterialBalance(String materialBalance) {
        this.materialBalance = materialBalance;
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