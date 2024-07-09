package com.swd392.group2.kgrill_model.repository;


import com.swd392.group2.kgrill_model.model.DishIngredient;

import com.swd392.group2.kgrill_model.model.PackageDish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishIngredientRepository extends JpaRepository<DishIngredient,Integer> {
    List<DishIngredient> findAllByDish_Id(int id);

    DishIngredient findByIngredient_IdAndDish_Id(int ingredientId, int dishId);
}
