package com.bitbox.bitboxserver.assembler;

import com.bitbox.bitboxserver.dto.SupplierDTO;
import com.bitbox.bitboxserver.model.Supplier;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SupplierAssembler {

    private final ModelMapper modelMapper = new ModelMapper();

    public SupplierDTO pojo2dto(Supplier pojo) {
        return modelMapper.map(pojo, SupplierDTO.class);
    }

    public Supplier dto2pojo(SupplierDTO dto) {
        return modelMapper.map(dto, Supplier.class);
    }
}
