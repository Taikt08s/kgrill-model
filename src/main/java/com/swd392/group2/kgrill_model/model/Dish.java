package com.swd392.group2.kgrill_model.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("dish_id")
    private Integer id;

    private String name;

    private Float price;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonManagedReference
    private DishCategory category;
    @JsonIgnore
    @OneToMany(mappedBy = "dish")
    @JsonManagedReference
    private List<PackageDish> packageDishes;
    @JsonIgnore
    @OneToMany(mappedBy = "dish")
    @JsonManagedReference
    private List<DishIngredient> dishIngredients;
}

