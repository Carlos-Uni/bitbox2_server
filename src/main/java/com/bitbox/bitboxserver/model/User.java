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
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private Long idUser;

    @Column(name = "usercode", unique = true)
    private Integer userCode;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @OneToMany(targetEntity = Item.class, mappedBy = "creator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Item> items;

    public void addItem(Item item){
        if (items == null) {
            items = new HashSet<>();
        }
        item.setCreator(this);
        items.add(item);
    }
}