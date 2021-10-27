package com.bitbox.bitboxserver.service;

import com.bitbox.bitboxserver.assembler.DiscountAssembler;
import com.bitbox.bitboxserver.dao.DiscountDAO;
import com.bitbox.bitboxserver.dto.DiscountDTO;
import com.bitbox.bitboxserver.model.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscountService implements IDiscountService {

    @Autowired
    DiscountDAO discountDAO;

    private DiscountAssembler discountAssembler = new DiscountAssembler();

    @Override
    public Iterable<DiscountDTO> findAllDiscounts() {
        List<DiscountDTO> discountDTO = new ArrayList<>();
        for (Discount discount : discountDAO.findAll()) {
            discountDTO.add(discountAssembler.pojo2dto(discount));
        }
        return discountDTO;
    }

    @Override
    public DiscountDTO findByDiscountCode(int code) {
        return discountAssembler.pojo2dto(discountDAO.findByDiscountCode(code));
    }
}
