package com.bitbox.bitboxserver.dto;

import com.bitbox.bitboxserver.model.Item;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({ "items"})
public class DiscountDTO implements Serializable {

    private Long idDiscount;
    private Long discountCode;
    private Double reducedPrice;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern="yyyy-MM-dd")
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
