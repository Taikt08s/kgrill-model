package com.swd392.group2.kgrill_model.repository;

import com.swd392.group2.kgrill_model.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
