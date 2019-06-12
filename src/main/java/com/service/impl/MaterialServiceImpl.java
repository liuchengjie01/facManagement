package com.service.impl;

import com.dao.materialDao;
import com.pojo.Material;
import com.service.materialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("materialService")
public class MaterialServiceImpl implements materialService{

    @Autowired
    private materialDao mmaterialDao;

    @Override
    public List<Material> queryAllMaterial(){ return mmaterialDao.queryAllMaterial(); }

    @Override
    public Material queryMaterialByID(String materialID){
        return mmaterialDao.queryMaterialByID(materialID);
    }

    @Override
    public int addMaterial(Material mmaterial){return mmaterialDao.addMaterial(mmaterial);}

    @Override
    public int deleteMaterial(String materialID){return mmaterialDao.deleteMaterialByID(materialID);}

    @Override
    public int updateMaterial(Material mmaterial){return mmaterialDao.updateMaterial(mmaterial);}
}
