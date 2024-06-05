package com.swd392.group2.kgrill_model.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class DishIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;
}

