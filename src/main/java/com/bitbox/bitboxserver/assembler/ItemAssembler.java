package com.bitbox.bitboxserver.assembler;

import com.bitbox.bitboxserver.dto.ItemDTO;
import com.bitbox.bitboxserver.model.Item;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemAssembler {

    private final ModelMapper modelMapper = new ModelMapper();

    public ItemDTO pojo2dto(Item pojo) {
        return modelMapper.map(pojo, ItemDTO.class);
    }

    public Item dto2pojo(ItemDTO dto) {
        return modelMapper.map(dto, Item.class);
    }
}
