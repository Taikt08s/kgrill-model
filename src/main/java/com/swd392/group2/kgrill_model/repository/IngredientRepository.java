package com.swd392.group2.kgrill_model.repository;

import com.swd392.group2.kgrill_model.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient,Integer> {
}
