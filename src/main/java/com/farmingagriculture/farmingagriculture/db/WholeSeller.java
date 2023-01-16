package com.farmingagriculture.farmingagriculture.db;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Table(name = "whole_seller")
@Entity
@Data
public class WholeSeller {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long wholeSellerId;

    @OneToOne(mappedBy = "wholeSeller", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Users user;

    @ManyToMany(mappedBy = "wholeSellers")
    Set<Products> products;
}