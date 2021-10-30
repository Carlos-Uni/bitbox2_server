package com.bitbox.bitboxserver.dto;

import com.bitbox.bitboxserver.globaldata.StateItemEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO implements Serializable {

    private Long idItem;
    private Long itemCode;
    private String description;
    private Double price;
    private StateItemEnum state;
    private Set<SupplierDTO> suppliers;
    private Set<DiscountDTO> discounts;
    private Date creationDate;
    @JsonManagedReference
    private UserDTO creator;
    private String discontinuedReason;

    public void addSupplier(SupplierDTO supplierDTO) {
        if(suppliers == null) {
            suppliers = new HashSet<>();
        }
        supplierDTO.addItem(this);
        suppliers.add(supplierDTO);
    }

    public void addPriceReduction(DiscountDTO discountDTO) {
        if(discounts == null) {
            discounts = new HashSet<>();
        }
        discountDTO.addItem(this);
        discounts.add(discountDTO);
    }

    public void addDeactivationReason(String reason) {
        discontinuedReason = reason;
    }
}
