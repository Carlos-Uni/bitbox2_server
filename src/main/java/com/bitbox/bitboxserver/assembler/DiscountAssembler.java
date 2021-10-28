package com.bitbox.bitboxserver.assembler;

import com.bitbox.bitboxserver.dto.DiscountDTO;
import com.bitbox.bitboxserver.model.Discount;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiscountAssembler {

    private final ModelMapper modelMapper = new ModelMapper();

    public DiscountDTO pojo2dto(Discount pojo) {

        return modelMapper.map(pojo, DiscountDTO.class);
    }

    public Discount dto2pojo(DiscountDTO dto) {

        return modelMapper.map(dto, Discount.class);
    }
}
