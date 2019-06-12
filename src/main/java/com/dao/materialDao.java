package com.dao;

import com.pojo.Material;

import java.util.List;

public interface materialDao {
    List<Material> queryAllMaterial();

    Material queryMaterialByID(String materialID);

    int addMaterial(Material mmaterial);

    int deleteMaterialByID(String materialID);

    int updateMaterial(Material mmaterial);

}
