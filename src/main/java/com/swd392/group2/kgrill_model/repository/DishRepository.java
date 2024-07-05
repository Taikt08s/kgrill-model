package com.swd392.group2.kgrill_model.repository;

import com.swd392.group2.kgrill_model.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish,Integer> {
    List<Dish> findByIdIn(List<Integer> ids);
}
