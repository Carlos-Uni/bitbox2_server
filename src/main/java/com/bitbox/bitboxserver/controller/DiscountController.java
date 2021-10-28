package com.bitbox.bitboxserver.controller;

import com.bitbox.bitboxserver.dto.DiscountDTO;
import com.bitbox.bitboxserver.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DiscountController {

    @Autowired
    DiscountService discountService;

    @GetMapping("/discount/discountList")
    public List<DiscountDTO> getDiscount() {
        return discountService.findAllDiscounts();
    }

    @GetMapping("/discount/search({code}")
    public DiscountDTO getSupplierBySupplierCode(@PathVariable(value = "code") int code) {
        return discountService.findByDiscountCode(code);
    }
}
