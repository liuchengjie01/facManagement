package com.pojo;

public class departmentfield {
    private String departmentfieldID;
    private String departmentID;
    private String departAdd;


    public String getDepartmentfieldID() {
        return departmentfieldID;
    }

    public void setDepartmentfieldID(String departmentfieldID) {
        this.departmentfieldID = departmentfieldID;
    }



    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartAdd() {
        return departAdd;
    }

    public void setDepartAdd(String departAdd) {
        this.departAdd = departAdd;
    }

    @Override
    public String toString() {
        return "departmentfield{" +
                "departmentfieldID='" + departmentfieldID + '\'' +
                ", departmentID='" + departmentID + '\'' +
                ", departAdd='" + departAdd + '\'' +

                '}';
    }
}
