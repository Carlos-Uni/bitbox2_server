package com.bitbox.bitboxserver.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscountDTO implements Serializable {

    private Long idDiscount;
    private Integer discountCode;
    private Integer reducedPrice;
    private Date startDate;
    private Date endDate;
    private Set<ItemDTO> items;

}
