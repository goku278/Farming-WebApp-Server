package com.farmingagriculture.farmingagriculture.db;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Table(name = "shopkeeper")
@Entity
@Data
public class ShopKeeper {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long shopKeeperId;

    @OneToOne(mappedBy = "shopKeeper", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Users user;

    @ManyToMany(mappedBy = "shopKeepers")
    Set<Products> products;
}