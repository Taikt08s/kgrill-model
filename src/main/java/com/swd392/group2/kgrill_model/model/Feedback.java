package com.swd392.group2.kgrill_model.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("feedback_id")
    private Integer id;
    private String content;
    private Float rating;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private User account;

    @ManyToOne
    @JoinColumn(name = "order_detail_id")
    private OrderDetail orderDetail;
}

