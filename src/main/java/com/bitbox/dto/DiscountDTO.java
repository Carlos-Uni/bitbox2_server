package com.bitbox.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscountDTO {

    private Long idDiscount;
    private Integer reducedPrice;
    private Date startDate;
    private Date endDate;
    private Set<ItemDTO> items;

}
