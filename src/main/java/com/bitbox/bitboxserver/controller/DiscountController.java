package com.bitbox.bitboxserver.controller;

import com.bitbox.bitboxserver.dto.DiscountDTO;
import com.bitbox.bitboxserver.service.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class DiscountController {

    @Autowired
    IDiscountService discountService;

    @GetMapping("/discount/discountList")
    public List<DiscountDTO> getDiscount() {

        return discountService.findAllDiscounts();
    }

    @GetMapping("/discount/search/{code}")
    public DiscountDTO getSupplierByDiscountCode(@PathVariable(value = "code") Long code) {
        return discountService.findByDiscountCode(code);
    }
}
