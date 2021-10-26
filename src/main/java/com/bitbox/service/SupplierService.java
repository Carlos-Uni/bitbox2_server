package com.bitbox.service;

import com.bitbox.dao.SupplierDAO;
import com.bitbox.dto.SupplierDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    SupplierDAO supplierDAO;

    public List<SupplierDTO> findllSuppliers(){
        return (List<SupplierDTO>)supplierDAO.findAll();
    }

}
