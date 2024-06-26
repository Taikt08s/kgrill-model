package com.swd392.group2.kgrill_model.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
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

    @ManyToOne
    @JoinColumn(name = "package_type_id")
    private PackageType packageType;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private PackageSize size;

    @OneToMany(mappedBy = "packageEntity")
    private List<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "packageEntity")
    private List<PackageDish> packageDishes;
}

