package com.swd392.group2.kgrill_model.repository;

import com.swd392.group2.kgrill_model.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish,Integer> {
}
