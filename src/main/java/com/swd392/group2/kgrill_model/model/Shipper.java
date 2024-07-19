package com.swd392.group2.kgrill_model.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("shipper_id")
    private Integer id;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private User accountId;
    private String status;

    @OneToMany(mappedBy = "shipper")
    private List<DeliveryOrder> orders;
}

