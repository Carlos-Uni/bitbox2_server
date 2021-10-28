package com.bitbox.bitboxserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "supplier")
public class Supplier{

    @Id
    @SequenceGenerator(name = "supplier_id_seq", sequenceName = "supplier_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_id_seq")
    @Column(name = "idsupplier")
    private Long idSupplier;

    @Column(name = "suppliercode", unique = true, nullable = false)
    private Long supplierCode;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "country", nullable = false)
    private String country;

    @ManyToMany(mappedBy = "suppliers")
    private Set<Item> items;

    public void addItem(Item item) {
        if(items == null) {
            items = new HashSet<>();
        }
        item.getSuppliers().add(this);
        items.add(item);
    }

}
