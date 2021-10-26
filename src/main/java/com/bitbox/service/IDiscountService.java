package com.bitbox.service;

import com.bitbox.dto.DiscountDTO;

public interface IDiscountService {

    public Iterable<DiscountDTO> findAllDiscounts();
}
