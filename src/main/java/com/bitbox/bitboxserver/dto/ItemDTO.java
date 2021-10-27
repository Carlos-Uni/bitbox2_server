package com.bitbox.bitboxserver.dto;

import com.bitbox.bitboxserver.globaldata.StateItemEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO implements Serializable {

    private Long idItem;
    private Integer itemCode;
    private String description;
    private BigDecimal price;
    private StateItemEnum state;
    private Set<SupplierDTO> suppliers;
    private List<DiscountDTO> discounts;
    private Date creationDate;
    private UserDTO creator;
    private String discontinuedReason;

}
