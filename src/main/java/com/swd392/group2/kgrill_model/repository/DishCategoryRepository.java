package com.swd392.group2.kgrill_model.repository;

import com.swd392.group2.kgrill_model.model.DishCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishCategoryRepository extends JpaRepository<DishCategory, Integer> {
}
