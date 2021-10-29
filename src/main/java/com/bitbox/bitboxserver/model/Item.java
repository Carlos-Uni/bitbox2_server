package com.bitbox.bitboxserver.model;


import com.bitbox.bitboxserver.globaldata.StateItemEnum;
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
@Table(name = "item")
public class Item {

    @Id
    @SequenceGenerator(name = "item_id_seq", sequenceName = "item_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_seq")
    @Column(name = "iditem")
    private Long idItem;

    @Column(name = "itemcode", unique = true, nullable = false)
    private Long itemCode;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "state" , columnDefinition = " varchar default 'ACTIVE'")
    private StateItemEnum state;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "supplieditem",
            joinColumns = { @JoinColumn(name = "item_id") },
            inverseJoinColumns = { @JoinColumn(name = "supplier_id")})
    private Set<Supplier> suppliers;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "discounteditem",
            joinColumns = { @JoinColumn(name = "item_id") },
            inverseJoinColumns = { @JoinColumn(name = "discount_id")})
    private Set<Discount> discounts;

    @Column(name = "creationdate")
    private Date creationDate;

    @ManyToOne()
    @JoinColumn(name="user_id")
    private User creator;

    @Column(name = "discontinuedreason")
    private String discontinuedReason;

    public void addSupplier(Supplier supplier) {
        if(suppliers == null) {
            suppliers = new HashSet<>();
        }
        supplier.addItem(this);
        suppliers.add(supplier);
    }

    public void addPriceReduction(Discount discount) {
        if(discounts == null) {
            discounts = new HashSet<>();
        }
        discount.addItem(this);
        discounts.add(discount);
    }

    public void addDeactivationReason(String reason) {

        discontinuedReason = reason;
    }
}
