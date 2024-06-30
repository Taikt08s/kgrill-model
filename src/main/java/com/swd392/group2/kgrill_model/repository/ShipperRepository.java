package com.swd392.group2.kgrill_model.repository;

import com.swd392.group2.kgrill_model.model.Shipper;
import io.micrometer.common.lang.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ShipperRepository extends JpaRepository<Shipper, Long> {

    @Query("SELECT s FROM Shipper s WHERE s.uuid = :uuid")
    Page<Shipper> findShipperByUuid(@Param("uuid") String uuid, @NonNull Pageable pageable);

}
