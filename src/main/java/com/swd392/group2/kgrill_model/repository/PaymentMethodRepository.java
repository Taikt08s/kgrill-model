package com.swd392.group2.kgrill_model.repository;

import com.swd392.group2.kgrill_model.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Integer> {
    PaymentMethod findByMethod(String method);
}
