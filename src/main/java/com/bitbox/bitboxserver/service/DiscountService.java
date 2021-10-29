package com.bitbox.bitboxserver.service;

import com.bitbox.bitboxserver.assembler.DiscountAssembler;
import com.bitbox.bitboxserver.dao.DiscountDAO;
import com.bitbox.bitboxserver.dto.DiscountDTO;
import com.bitbox.bitboxserver.model.Discount;
import com.bitbox.bitboxserver.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DiscountService implements IDiscountService {

    @Autowired
    DiscountDAO discountDAO;

    private DiscountAssembler discountAssembler = new DiscountAssembler();

    @Override
    public List<DiscountDTO> findAllDiscounts() {
        List<DiscountDTO> discountDTO = new ArrayList<>();
        for (Discount discount : discountDAO.findAll()) {
            discountDTO.add(discountAssembler.pojo2dto(discount));
        }
        return discountDTO;
    }

    @Override
    public DiscountDTO findByDiscountCode(Long code) {
        Discount discount = discountDAO.findByDiscountCode(code);
        if (discount != null) {
            return discountAssembler.pojo2dto(discount);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("The discount '%s' does not exist", code));
        }
    }
}
