package com.swd392.group2.kgrill_model.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference
    private List<Dish> dishes;
}
