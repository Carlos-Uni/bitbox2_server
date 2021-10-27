package com.bitbox.bitboxserver.model;


import com.bitbox.bitboxserver.globaldata.StateItemEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
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

//    @SequenceGenerator(name = "sequence_code", sequenceName = "DB_SEQUENCE", initialValue = 100, allocationSize = 100)
//    @GeneratedValue(generator = "sequence_code")
    @Column(name = "itemcode", unique = true)
    private Integer itemCode;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private StateItemEnum state;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "supplieditem")
    private Set<Supplier> suppliers;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "discounteditem")
    private Set<Discount> discounts;

    @Column(name = "creationdate")
    private Date creationDate;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name="user_id")
    private User creator;

    @Column(name = "discontinuedreason")
    private String discontinuedReason;
}
