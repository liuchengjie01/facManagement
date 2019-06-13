package com.pojo;

public class Material{
    private String material_id;
    private String material_name;
    private int material_storage;
    public String getMaterial_id() {
        return material_id;
    }
    public void setMaterial_id(String material_id) {
        this.material_id = material_id;
    }
    public String getMaterial_name() {
        return material_name;
    }
    public void setMaterial_name(String material_name) {
        this.material_name = material_name;
    }

    public int getMaterial_storage() {
        return material_storage;
    }

    public void setMaterial_storage(int material_storage) {
        this.material_storage = material_storage;
    }
}