package com.pojo;

public class supply {

    private String supplier_id;
    private String material_id;
    private String price;
    private String amount;
    private String unit;
    private String Date;

    @Override
    public String toString() {
        return "supply{" +
                "supplier_id='" + supplier_id + '\'' +
                ", material_id='" + material_id + '\'' +
                ", price='" + price + '\'' +
                ", amount='" + amount + '\'' +
                ", unit='" + unit + '\'' +
                ", Date='" + Date + '\'' +
                '}';
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(String material_id) {
        this.material_id = material_id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
