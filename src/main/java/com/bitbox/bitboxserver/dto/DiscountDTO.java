package com.bitbox.bitboxserver.dto;

import com.bitbox.bitboxserver.model.Item;
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
public class DiscountDTO implements Serializable {

    private Long idDiscount;
    private Long discountCode;
    private Double reducedPrice;
    private Date startDate;
    private Date endDate;
    private Set<ItemDTO> items;

    public void addItem(ItemDTO itemDTO) {
        if(items == null) {
            items = new HashSet<>();
        }
        itemDTO.getDiscounts().add(this);
        items.add(itemDTO);
    }

}
