package com.utils;

public class ID_manag {
    private int departmentID=7;

    public int getDepartmentID() {
        departmentID = departmentID+1;
        System.out.println(departmentID);
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

}

