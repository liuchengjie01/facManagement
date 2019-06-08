package com.service;

import com.pojo.supplier;

import java.util.List;

public interface supplierService {
    List<supplier> queryAllSupplier();

    int addSupplier(supplier sp);

    int deleteSupplierByID(String supplier_id);

    int updateSupplier(supplier sp);

    supplier querySupplierByID(String supplier_id);
}
