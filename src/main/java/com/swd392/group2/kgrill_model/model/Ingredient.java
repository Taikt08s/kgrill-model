package com.swd392.group2.kgrill_model.model;

import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "ingredient")
    private List<DishIngredient> dishIngredients;
}

