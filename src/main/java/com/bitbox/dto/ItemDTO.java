package com.bitbox.dto;

import com.bitbox.globaldata.StateItemEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    private Long idItem;
    private Integer itemCode;
    private String description;
    private Double price;
    private StateItemEnum state;
    private Set<SupplierDTO> suppliers;
    private List<DiscountDTO> discounts;
    private Date creationDate;
    private UserDTO creator;


}
