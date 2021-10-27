package com.bitbox.bitboxserver.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO implements Serializable {

    private Long idSupplier;
    private Integer discountCode;
    private String name;
    private String country;
    private Set<ItemDTO> items;

}
