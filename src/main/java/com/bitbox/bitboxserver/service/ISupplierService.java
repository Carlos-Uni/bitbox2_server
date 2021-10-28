package com.bitbox.bitboxserver.service;

import com.bitbox.bitboxserver.dto.SupplierDTO;

import java.util.List;

public interface ISupplierService {

    public List<SupplierDTO> findllSuppliers();
    public SupplierDTO findBySupplierCode(Long code);
}
