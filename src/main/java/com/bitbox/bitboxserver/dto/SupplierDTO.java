package com.bitbox.bitboxserver.dto;

import com.bitbox.bitboxserver.model.Item;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "items"})
public class SupplierDTO implements Serializable {

    private Long idSupplier;
    private Integer supplierCode;
    private String name;
    private String country;
    private Set<ItemDTO> items;

    public void addItem(ItemDTO itemDTO) {
        if(items == null) {
            items = new HashSet<>();
        }
        itemDTO.getSuppliers().add(this);
        items.add(itemDTO);
    }
}
