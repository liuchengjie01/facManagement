package com.service;

import com.pojo.BuMen;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BuMenService {

    List<BuMen> queryAllBuMen();

    int addBumen(BuMen bumenRecord);

    int deleteBumenByID(String id);

    int updateBumen(BuMen bumen);

    BuMen queryByID(String id);

}
