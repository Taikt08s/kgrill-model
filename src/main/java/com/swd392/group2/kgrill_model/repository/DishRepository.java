package com.swd392.group2.kgrill_model.repository;

import com.swd392.group2.kgrill_model.model.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish,Integer> {
    List<Dish> findByIdIn(List<Integer> ids);
    @Query("SELECT DISTINCT d FROM Dish d " +
            "LEFT JOIN d.category c " +
            "LEFT JOIN DishIngredient di ON di.dish.id = d.id " +
            "LEFT JOIN di.ingredient i " +
            "WHERE (:keyword IS NULL OR :keyword = '' OR d.name LIKE %:keyword% OR i.name LIKE %:keyword%) " +
            "AND (:category IS NULL OR c.category LIKE %:category%) " +
            "AND (:minPrice IS NULL OR d.price >= :minPrice) " +
            "AND (:maxPrice IS NULL OR d.price <= :maxPrice) ")
    Page<Dish> findByNameAndPrice(String keyword, String category,double minPrice, double maxPrice, Pageable pageable);
}
