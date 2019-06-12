package com.pojo;

public class supplier {

    private String supplier_id;
    private String supplier_name;
    private String supplier_contact;
    private String supplier_list;

    @Override
    public String toString() {
        return "supplier{" +
                "supplier_id='" + supplier_id + '\'' +
                ", supplier_name='" + supplier_name + '\'' +
                ", supplier_contact='" + supplier_contact + '\'' +
                ", supplier_list='" + supplier_list + '\'' +
                '}';
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getSupplier_contact() {
        return supplier_contact;
    }

    public void setSupplier_contact(String supplier_contact) {
        this.supplier_contact = supplier_contact;
    }

    public String getSupplier_list() {
        return supplier_list;
    }

    public void setSupplier_list(String supplier_list) {
        this.supplier_list = supplier_list;
    }
}
