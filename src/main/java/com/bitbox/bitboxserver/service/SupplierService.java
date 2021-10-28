package com.bitbox.bitboxserver.service;

import com.bitbox.bitboxserver.assembler.SupplierAssembler;
import com.bitbox.bitboxserver.dao.SupplierDAO;
import com.bitbox.bitboxserver.dto.SupplierDTO;
import com.bitbox.bitboxserver.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierService implements ISupplierService{

    @Autowired
    SupplierDAO supplierDAO;

    private SupplierAssembler supplierAssembler = new SupplierAssembler();

    @Override
    public List<SupplierDTO> findAllSuppliers() {
        List<SupplierDTO> supplierDTO = new ArrayList<>();
        for (Supplier supplier : supplierDAO.findAll()) {
            supplierDTO.add(supplierAssembler.pojo2dto(supplier));
        }
        return supplierDTO;
    }

    @Override
    public SupplierDTO findBySupplierCode(int code) {
        return supplierAssembler.pojo2dto(supplierDAO.findBySupplierCode(code));
    }
}
