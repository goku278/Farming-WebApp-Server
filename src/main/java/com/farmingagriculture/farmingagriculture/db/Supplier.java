package com.farmingagriculture.farmingagriculture.db;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Table(name = "supplier")
@Entity
@Data
public class Supplier {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long supplierId;

    @OneToOne(mappedBy = "supplier", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Users user;

    @ManyToMany(mappedBy = "suppliers")
    Set<Products> products;
}
