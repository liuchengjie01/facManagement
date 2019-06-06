package com.dao;

import com.pojo.admin;

public interface adminDao {
    admin queryByUsername(String username);
}
