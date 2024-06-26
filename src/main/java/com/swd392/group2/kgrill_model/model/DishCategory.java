package com.swd392.group2.kgrill_model.model;

import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
public class DishCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String category;

    @OneToMany(mappedBy = "category")
    private List<Dish> dishes;
}
