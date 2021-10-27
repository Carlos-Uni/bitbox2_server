package com.bitbox.bitboxserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "supplier")
public class Supplier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsupplier")
    private Long idSupplier;

    @SequenceGenerator(name = "sequence_code", sequenceName = "DB_SEQUENCE", initialValue = 100, allocationSize = 100)
    @GeneratedValue(generator = "sequence_code")
    @Column(name = "suppliercode", unique = true)
    private Integer supplierCode;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @ManyToMany(mappedBy = "suppliers", fetch = FetchType.LAZY)
    private Set<Item> items;

}
