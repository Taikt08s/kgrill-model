package com.swd392.group2.kgrill_model.repository;


import com.swd392.group2.kgrill_model.model.DeliveryOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryOrderRepository extends JpaRepository<DeliveryOrder, Long> {

    @Query("""
            SELECT COUNT(d) FROM DeliveryOrder d WHERE d.orderDate >= CURRENT_DATE
            """)
    Long countByCurrentDay();

    @Query("""
                SELECT COUNT(d) 
                FROM DeliveryOrder d 
                WHERE d.orderDate >= DATE_TRUNC('day', CURRENT_DATE)
            """)
    int countByDaily();

    @Query("""
                SELECT COUNT(d) 
                FROM DeliveryOrder d 
                WHERE d.orderDate >= DATE_TRUNC('week', CURRENT_DATE)
            """)
    int countByWeekly();

    @Query("""
                SELECT COUNT(d) 
                FROM DeliveryOrder d 
                WHERE d.orderDate >= DATE_TRUNC('month', CURRENT_DATE)
            """)
    int countByMonthly();

    @Query("""
                SELECT COUNT(d) 
                FROM DeliveryOrder d 
                WHERE d.orderDate >= DATE_TRUNC('year', CURRENT_DATE)
            """)
    int countByYearly();

    @Query("""
            SELECT d 
            FROM DeliveryOrder d 
            WHERE d.orderDate >= DATE_TRUNC('day', CURRENT_DATE)
            """)
    Page<DeliveryOrder> getDeliveryOrderByDaily(Pageable pageable);

    @Query("""
            SELECT d 
            FROM DeliveryOrder d 
            WHERE d.orderDate >= DATE_TRUNC('month', CURRENT_DATE)
            """)
    Page<DeliveryOrder> getDeliveryOrderByMonthly(Pageable pageable);

    @Query("""
            SELECT d 
            FROM DeliveryOrder d 
            WHERE d.orderDate >= DATE_TRUNC('year', CURRENT_DATE)
            """)
    Page<DeliveryOrder> getDeliveryOrderByYearly(Pageable pageable);

}
