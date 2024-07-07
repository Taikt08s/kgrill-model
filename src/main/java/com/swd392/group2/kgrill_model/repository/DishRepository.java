package com.swd392.group2.kgrill_model.repository;

import com.swd392.group2.kgrill_model.model.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish,Integer> {
    List<Dish> findByIdIn(List<Integer> ids);
    @Query("SELECT d FROM Dish d WHERE "
            + "CONCAT(d.name, d.price)"
            + " LIKE %?1%")
    Page<Dish> findByNameAndPrice(String keyword, Pageable pageable);
}
