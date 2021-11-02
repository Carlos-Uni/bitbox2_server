package com.bitbox.bitboxserver.controller;

import com.bitbox.bitboxserver.dto.SupplierDTO;
import com.bitbox.bitboxserver.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class SupplierController {

    @Autowired
    ISupplierService supplierService;

    @GetMapping("/supplier/supplierList")
    public List<SupplierDTO> getSuppliers() {

        return supplierService.findAllSuppliers();
    }

    @GetMapping("/supplier/search/{code}")
    public SupplierDTO getSupplierBySupplierCode(@PathVariable(value = "code") Long code) {
        return supplierService.findBySupplierCode(code);
    }
}
