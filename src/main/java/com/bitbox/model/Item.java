package com.bitbox.model;


import com.bitbox.globaldata.StateItemEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iditem")
    private Long idItem;

    @Column(name = "itemcode")
    private Integer itemCode;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private StateItemEnum state;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "supplieditem",
            joinColumns = {@JoinColumn(name = "item_id")},
            inverseJoinColumns = {@JoinColumn(name = "supplier_id")})
    private Set<Supplier> suppliers;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "discounteditem",
            joinColumns = {@JoinColumn(name = "item_id")},
            inverseJoinColumns = {@JoinColumn(name = "discount_id")})
    private Set<Discount> discounts;

    @Column(name = "creationdate")
    private Date creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    private User creator;
}
