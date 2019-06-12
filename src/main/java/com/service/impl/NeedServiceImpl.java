package com.service.impl;

import com.dao.NeedDao;
import com.pojo.Need;
import com.service.NeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("NeedService")
public class NeedServiceImpl implements NeedService {

    //注入Dao
    @Autowired
    private NeedDao Ndao;

    @Override
    public List<Need> queryAllNeed()
    {
        return Ndao.queryAllNeed();
    }

    @Override
    public int insert(Need NeedRecord){
        return Ndao.insert(NeedRecord);
    }

    @Override
    public int deleteByPrimaryKey(String id1, String id2){
        return Ndao.deleteByPrimaryKey(id1,id2);
    }

    @Override
    public int updateByPrimaryKey(Need Need){return Ndao.updateByPrimaryKey(Need);}

    @Override
    public Need selectByPrimaryKey(String id1, String id2){return Ndao.selectByPrimaryKey(id1,id2);}


}
