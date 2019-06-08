package com.pojo;

public class supplier {

    private String supplier_id;
    private String supplier_cname;
    private String supplier_contact;
    private String supplier_tel;

    @Override
    public String toString() {
        return "supplier{" +
                "supplier_id='" + supplier_id + '\'' +
                ", supplier_cname='" + supplier_cname + '\'' +
                ", supplier_contact='" + supplier_contact + '\'' +
                ", supplier_tel='" + supplier_tel + '\'' +
                '}';
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getSupplier_cname() {
        return supplier_cname;
    }

    public void setSupplier_cname(String supplier_cname) {
        this.supplier_cname = supplier_cname;
    }

    public String getSupplier_contact() {
        return supplier_contact;
    }

    public void setSupplier_contact(String supplier_contact) {
        this.supplier_contact = supplier_contact;
    }

    public String getSupplier_tel() {
        return supplier_tel;
    }

    public void setSupplier_tel(String supplier_tel) {
        this.supplier_tel = supplier_tel;
    }
}
