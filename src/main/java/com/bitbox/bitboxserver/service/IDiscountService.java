package com.bitbox.bitboxserver.service;

import com.bitbox.bitboxserver.dto.DiscountDTO;

public interface IDiscountService {

    public Iterable<DiscountDTO> findAllDiscounts();
    public DiscountDTO findByDiscountCode(Long code);
}
