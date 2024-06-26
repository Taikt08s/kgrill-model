package com.swd392.group2.kgrill_model.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class PackageType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @JsonProperty("meal_type")
    @Column(name = "meal_type")
    private String mealType;
}
