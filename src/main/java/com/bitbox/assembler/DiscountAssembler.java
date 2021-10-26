package com.bitbox.assembler;

import com.bitbox.dto.DiscountDTO;
import com.bitbox.model.Discount;
import org.modelmapper.ModelMapper;

public class DiscountAssembler {
    public DiscountDTO pojo2dto(Discount pojo) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pojo, DiscountDTO.class);
    }

    public Discount dto2pojo(DiscountDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, Discount.class);
    }
}
