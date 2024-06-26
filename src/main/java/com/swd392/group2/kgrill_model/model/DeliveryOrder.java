package com.swd392.group2.kgrill_model.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class DeliveryOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("delivery_id")
    private Integer id;
    @JsonProperty("order_date")
    private Date orderDate;
    @JsonProperty("order_value")
    private Float orderValue;
    @JsonProperty("shipper_date")
    private Date shippedDate;
    @JsonProperty("shipped_address")
    private String shippedAddress;
    private Double latitude;
    private Double longitude;
    @JsonProperty("shipping_fee ")
    private Float shippingFee;
    private String status;
    private String code;
    private Float rating;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private User account;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "shipper_id")
    private Shipper shipper;

    @OneToMany(mappedBy = "order")
    @Column(name = "order_details")
    private List<OrderDetail> orderDetails;

    @OneToOne(mappedBy = "currentOrder")
    private User accountWithCurrentOrder;
}
