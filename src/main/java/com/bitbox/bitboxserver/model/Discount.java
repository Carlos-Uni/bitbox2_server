package com.bitbox.bitboxserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "discount")
public class Discount{

    @Id
    @SequenceGenerator(name = "discount_id_seq", sequenceName = "discount_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discount_id_seq")
    @Column(name = "iddiscount")
    private Long idDiscount;

    @Column(name = "discountcode", unique = true, nullable = false)
    private Long discountCode;

    @Column(name = "reducedprice", nullable = false)
    private Double reducedPrice;

    @Column(name = "startdate", nullable = false)
    private Date startDate;

    @Column(name = "enddate", nullable = false)
    private Date endDate;

    @ManyToMany(mappedBy = "discounts")
    private Set<Item> items;

    public void addItem(Item item) {
        if(items == null) {
            items = new HashSet<>();
        }
        item.getDiscounts().add(this);
        items.add(item);
    }
}
