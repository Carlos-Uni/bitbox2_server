package com.bitbox.bitboxserver.service;

import com.bitbox.bitboxserver.dto.DiscountDTO;

import java.util.List;

public interface IDiscountService {

    public List<DiscountDTO> findAllDiscounts();
    public DiscountDTO findByDiscountCode(Long code);
}
