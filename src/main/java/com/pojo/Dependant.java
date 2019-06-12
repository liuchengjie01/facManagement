package com.pojo;

public class Dependant {

    private String dependant_id;
    private String employee_id;
    private String dependant_name;
    private String dependant_sex;
    private String dependant_birthday;
    private String relationship;
    private String dependant_IDnumber;
    private String dependant_SSnumber;

    @Override
    public String toString(){
        return "Dependant{" +
                "dependant_id='" + dependant_id + '\'' +
                ", employee_id='" + employee_id + '\'' +
                ", dependant_name='" + dependant_name + '\'' +
                ", dependant_sex='" + dependant_sex + '\'' +
                ", dependant_brithday='" + dependant_birthday + '\'' +
                ", relationship='" + relationship + '\'' +
                ", dependant_IDnumber'" + dependant_IDnumber + '\'' +
                ", dependant_SSnumber'" + dependant_SSnumber + '\'' +
                '}';
    }

    public String getDependant_id() {
        return dependant_id;
    }

    public void setDependant_id(String dependant_id) {
        this.dependant_id = dependant_id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getDependant_name() {
        return dependant_name;
    }

    public void setDependant_name(String dependant_name) {
        this.dependant_name = dependant_name;
    }

    public String getDependant_sex() {
        return dependant_sex;
    }

    public void setDependant_sex(String dependant_sex) {
        this.dependant_sex = dependant_sex;
    }

    public String getDependant_birthday() {
        return dependant_birthday;
    }

    public void setDependant_birthday(String dependant_birthday) {
        this.dependant_birthday = dependant_birthday;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getDependant_IDnumber() {
        return dependant_IDnumber;
    }

    public void setDependant_IDnumber(String dependant_IDnumber) {
        this.dependant_IDnumber = dependant_IDnumber;
    }

    public String getDependant_SSnumber() {
        return dependant_SSnumber;
    }

    public void setDependant_SSnumber(String dependant_SSnumber) {
        this.dependant_SSnumber = dependant_SSnumber;
    }
}
