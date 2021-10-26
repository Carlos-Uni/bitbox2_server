package com.bitbox.service;

import com.bitbox.dao.DiscountDAO;
import com.bitbox.dto.DiscountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService implements IDiscountService{

    @Autowired
    DiscountDAO discountDAO;

    public List<DiscountDTO> findAllDiscounts(){
        return (List<DiscountDTO>)discountDAO.findAll();
    }
}
