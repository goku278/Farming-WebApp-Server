package com.farmingagriculture.farmingagriculture.db;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Table(name = "farmer")
@Entity
@Data
public class Farmer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long farmerId;

    @OneToOne(mappedBy = "farmer", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Users user;

    @ManyToMany(mappedBy = "farmers")
    Set<Products> products;
}
