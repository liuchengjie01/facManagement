package com.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * employee
 * @author 
 */
public class Employee implements Serializable {
    private String employeeId;

    private String curDepartmentid;

    private String employPosition;

    private String employeeName;

    private String employeeSex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date employeeBirthday;

    private String employeeTel;

    private String employeeAdd;

    private String employeeQq;

    private String employeeMail;

    private String employeeIdnumber;

    private String employeeSsnumber;

    private Long employeeSalary;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date employeeLtime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date employeeEtime;

    private static final long serialVersionUID = 1L;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getCurDepartmentid() {
        return curDepartmentid;
    }

    public void setCurDepartmentid(String curDepartmentid) {
        this.curDepartmentid = curDepartmentid;
    }

    public String getEmployPosition() {
        return employPosition;
    }

    public void setEmployPosition(String employPosition) {
        this.employPosition = employPosition;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSex() {
        return employeeSex;
    }

    public void setEmployeeSex(String employeeSex) {
        this.employeeSex = employeeSex;
    }

    public Date getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(Date employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeTel() {
        return employeeTel;
    }

    public void setEmployeeTel(String employeeTel) {
        this.employeeTel = employeeTel;
    }

    public String getEmployeeAdd() {
        return employeeAdd;
    }

    public void setEmployeeAdd(String employeeAdd) {
        this.employeeAdd = employeeAdd;
    }

    public String getEmployeeQq() {
        return employeeQq;
    }

    public void setEmployeeQq(String employeeQq) {
        this.employeeQq = employeeQq;
    }

    public String getEmployeeMail() {
        return employeeMail;
    }

    public void setEmployeeMail(String employeeMail) {
        this.employeeMail = employeeMail;
    }

    public String getEmployeeIdnumber() {
        return employeeIdnumber;
    }

    public void setEmployeeIdnumber(String employeeIdnumber) {
        this.employeeIdnumber = employeeIdnumber;
    }

    public String getEmployeeSsnumber() {
        return employeeSsnumber;
    }

    public void setEmployeeSsnumber(String employeeSsnumber) {
        this.employeeSsnumber = employeeSsnumber;
    }

    public Long getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Long employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public Date getEmployeeLtime() {
        return employeeLtime;
    }

    public void setEmployeeLtime(Date employeeLtime) {
        this.employeeLtime = employeeLtime;
    }

    public Date getEmployeeEtime() {
        return employeeEtime;
    }

    public void setEmployeeEtime(Date employeeEtime) {
        this.employeeEtime = employeeEtime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Employee other = (Employee) that;
        return (this.getEmployeeId() == null ? other.getEmployeeId() == null : this.getEmployeeId().equals(other.getEmployeeId()))
            && (this.getCurDepartmentid() == null ? other.getCurDepartmentid() == null : this.getCurDepartmentid().equals(other.getCurDepartmentid()))
            && (this.getEmployPosition() == null ? other.getEmployPosition() == null : this.getEmployPosition().equals(other.getEmployPosition()))
            && (this.getEmployeeName() == null ? other.getEmployeeName() == null : this.getEmployeeName().equals(other.getEmployeeName()))
            && (this.getEmployeeSex() == null ? other.getEmployeeSex() == null : this.getEmployeeSex().equals(other.getEmployeeSex()))
            && (this.getEmployeeBirthday() == null ? other.getEmployeeBirthday() == null : this.getEmployeeBirthday().equals(other.getEmployeeBirthday()))
            && (this.getEmployeeTel() == null ? other.getEmployeeTel() == null : this.getEmployeeTel().equals(other.getEmployeeTel()))
            && (this.getEmployeeAdd() == null ? other.getEmployeeAdd() == null : this.getEmployeeAdd().equals(other.getEmployeeAdd()))
            && (this.getEmployeeQq() == null ? other.getEmployeeQq() == null : this.getEmployeeQq().equals(other.getEmployeeQq()))
            && (this.getEmployeeMail() == null ? other.getEmployeeMail() == null : this.getEmployeeMail().equals(other.getEmployeeMail()))
            && (this.getEmployeeIdnumber() == null ? other.getEmployeeIdnumber() == null : this.getEmployeeIdnumber().equals(other.getEmployeeIdnumber()))
            && (this.getEmployeeSsnumber() == null ? other.getEmployeeSsnumber() == null : this.getEmployeeSsnumber().equals(other.getEmployeeSsnumber()))
            && (this.getEmployeeSalary() == null ? other.getEmployeeSalary() == null : this.getEmployeeSalary().equals(other.getEmployeeSalary()))
            && (this.getEmployeeLtime() == null ? other.getEmployeeLtime() == null : this.getEmployeeLtime().equals(other.getEmployeeLtime()))
            && (this.getEmployeeEtime() == null ? other.getEmployeeEtime() == null : this.getEmployeeEtime().equals(other.getEmployeeEtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEmployeeId() == null) ? 0 : getEmployeeId().hashCode());
        result = prime * result + ((getCurDepartmentid() == null) ? 0 : getCurDepartmentid().hashCode());
        result = prime * result + ((getEmployPosition() == null) ? 0 : getEmployPosition().hashCode());
        result = prime * result + ((getEmployeeName() == null) ? 0 : getEmployeeName().hashCode());
        result = prime * result + ((getEmployeeSex() == null) ? 0 : getEmployeeSex().hashCode());
        result = prime * result + ((getEmployeeBirthday() == null) ? 0 : getEmployeeBirthday().hashCode());
        result = prime * result + ((getEmployeeTel() == null) ? 0 : getEmployeeTel().hashCode());
        result = prime * result + ((getEmployeeAdd() == null) ? 0 : getEmployeeAdd().hashCode());
        result = prime * result + ((getEmployeeQq() == null) ? 0 : getEmployeeQq().hashCode());
        result = prime * result + ((getEmployeeMail() == null) ? 0 : getEmployeeMail().hashCode());
        result = prime * result + ((getEmployeeIdnumber() == null) ? 0 : getEmployeeIdnumber().hashCode());
        result = prime * result + ((getEmployeeSsnumber() == null) ? 0 : getEmployeeSsnumber().hashCode());
        result = prime * result + ((getEmployeeSalary() == null) ? 0 : getEmployeeSalary().hashCode());
        result = prime * result + ((getEmployeeLtime() == null) ? 0 : getEmployeeLtime().hashCode());
        result = prime * result + ((getEmployeeEtime() == null) ? 0 : getEmployeeEtime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        //sb.append(" [");
        //sb.append("Hash = ").append(hashCode());
        sb.append(" {");
        sb.append("employeeId=").append(employeeId);
        sb.append(", curDepartmentid=").append(curDepartmentid);
        sb.append(", employPosition=").append(employPosition);
        sb.append(", employeeName=").append(employeeName);
        sb.append(", employeeSex=").append(employeeSex);
        sb.append(", employeeBirthday=").append(employeeBirthday);
        sb.append(", employeeTel=").append(employeeTel);
        sb.append(", employeeAdd=").append(employeeAdd);
        sb.append(", employeeQq=").append(employeeQq);
        sb.append(", employeeMail=").append(employeeMail);
        sb.append(", employeeIdnumber=").append(employeeIdnumber);
        sb.append(", employeeSsnumber=").append(employeeSsnumber);
        sb.append(", employeeSalary=").append(employeeSalary);
        sb.append(", employeeLtime=").append(employeeLtime);
        sb.append(", employeeEtime=").append(employeeEtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("}");
        return sb.toString();
    }
}