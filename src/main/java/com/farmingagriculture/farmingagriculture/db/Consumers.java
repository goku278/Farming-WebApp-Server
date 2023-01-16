package com.farmingagriculture.farmingagriculture.db;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Table(name = "consumers")
@Entity
@Data
public class Consumers {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long consumersId;

    @OneToOne(mappedBy = "consumers", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Users user;

    @ManyToMany(mappedBy = "consumer")
    Set<Products> products;
}
