package com.swd392.group2.kgrill_model.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("ingredient_id")
    private Integer id;
    @JsonProperty("ingredient_name")
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "ingredient")
    private List<DishIngredient> dishIngredients;
}

