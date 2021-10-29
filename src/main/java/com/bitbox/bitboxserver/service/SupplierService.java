package com.bitbox.bitboxserver.service;

import com.bitbox.bitboxserver.assembler.SupplierAssembler;
import com.bitbox.bitboxserver.dao.SupplierDAO;
import com.bitbox.bitboxserver.dto.SupplierDTO;
import com.bitbox.bitboxserver.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
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
    public SupplierDTO findBySupplierCode(Long code) {
        Supplier supplier = supplierDAO.findBySupplierCode(code);
        if (supplier != null) {
            return supplierAssembler.pojo2dto(supplier);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("The supplier '%s' does not exist", code));
        }
    }
}
