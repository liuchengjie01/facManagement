package com.pojo;

public class Customer {

    private String customer_id;
    private String customer_cname;
    private String customer_contact;
    private String customer_tel;

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id='" + customer_id + '\'' +
                ", customer_cname='" + customer_cname + '\'' +
                ", customer_contact='" + customer_contact + '\'' +
                ", customer_tel='" + customer_tel + '\'' +
                '}';
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_cname() {
        return customer_cname;
    }

    public void setCustomer_cname(String customer_cname) {
        this.customer_cname = customer_cname;
    }

    public String getCustomer_contact() {
        return customer_contact;
    }

    public void setCustomer_contact(String customer_contact) {
        this.customer_contact = customer_contact;
    }

    public String getCustomer_tel() {
        return customer_tel;
    }

    public void setCustomer_tel(String customer_tel) {
        this.customer_tel = customer_tel;
    }
}