package com.bitbox.bitboxserver.controller;

import com.bitbox.bitboxserver.dto.SupplierDTO;
import com.bitbox.bitboxserver.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping("/supplier/supplierList")
    public List<SupplierDTO> getSuppliers() {
        return supplierService.findAllSuppliers();
    }

    @GetMapping("/supplier/search({code}")
    public SupplierDTO getSupplierBySupplierCode(@PathVariable(value = "code") int code) {
        return supplierService.findBySupplierCode(code);
    }
}
