package com.service;

import com.pojo.Material;

import java.util.List;

public interface materialService{
    List<Material> queryAllMaterial();

    Material queryMaterialByID(String materialID);

    int addMaterial(Material mmaterial);

    int deleteMaterial(String materialID);

    int updateMaterial(Material mmaterial);
}