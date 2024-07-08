package com.swd392.group2.kgrill_model.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class PackageDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonProperty("dish_price")
    @Column(name = "dish_price")
    private Float dishPrice;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "package_id")
    @JsonBackReference
    private Package packageEntity;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    @JsonBackReference
    private Dish dish;
}

