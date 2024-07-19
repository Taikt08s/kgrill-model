package com.swd392.group2.kgrill_model.repository;

import com.swd392.group2.kgrill_model.model.Shipper;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ShipperRepository extends JpaRepository<Shipper, Long> {
    Page<Shipper> findAllByStatus(String status, Pageable pageable);
}
