package com.service.impl;

import com.dao.adminDao;
import com.pojo.admin;
import com.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("adminService")
public class adminServiceImpl implements adminService {

    @Autowired
    private adminDao aDao;

    @Override
    public admin queryByUsername(String username){
        return aDao.queryByUsername(username);
    }

}
