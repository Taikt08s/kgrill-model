package com.swd392.group2.kgrill_model.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String method;
}

