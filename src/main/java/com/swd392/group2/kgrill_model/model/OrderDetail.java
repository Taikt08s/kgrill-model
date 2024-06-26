package com.swd392.group2.kgrill_model.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import jakarta.persistence.*;

import java.util.List;

@Data
@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("order_id")
    private Integer id;

    private Integer quantity;
    @JsonProperty("combo_price")
    private Float comboPrice;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private DeliveryOrder order;

    @ManyToOne
    @JoinColumn(name = "package_id")
    private Package packageEntity;

    @OneToMany(mappedBy = "orderDetail")
    private List<Feedback> feedbacks;
}

