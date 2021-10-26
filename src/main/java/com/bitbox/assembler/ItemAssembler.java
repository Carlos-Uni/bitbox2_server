package com.bitbox.assembler;

import com.bitbox.dto.ItemDTO;
import com.bitbox.model.Item;
import org.modelmapper.ModelMapper;

public class ItemAssembler {

    public ItemDTO pojo2dto(Item pojo) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pojo, ItemDTO.class);
    }

    public Item dto2pojo(ItemDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, Item.class);
    }
}
