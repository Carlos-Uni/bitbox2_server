package com.bitbox.assembler;

import com.bitbox.dto.SupplierDTO;
import com.bitbox.model.Supplier;
import org.modelmapper.ModelMapper;

public class SupplierAssembler {
    public SupplierDTO pojo2dto(Supplier pojo) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pojo, SupplierDTO.class);
    }

    public Supplier dto2pojo(SupplierDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, Supplier.class);
    }
}
