package com.swd392.group2.kgrill_model.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("package_id")
    private Integer id;
    private String name;
    private String description;
    private String code;
    private Float price;
    private boolean active;
    private String thumbnailUrl;
    private String packageType;
    private String packageSize;

    @OneToMany(mappedBy = "packageEntity", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "packageEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<PackageDish> packageDishes;
}

