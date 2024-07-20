package com.swd392.group2.kgrill_model.repository;


import com.swd392.group2.kgrill_model.model.DeliveryOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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
            WHERE d.orderDate <= CAST(:date AS date)  
             """)
    Page<DeliveryOrder> getDeliveryOrder(Pageable pageable, @Param("date") LocalDate date);

    @Query("""
            SELECT d
            FROM DeliveryOrder d
            WHERE d.orderDate <= CAST(:date AS date)  
            AND d.status = 'Delivered' 
            OR d.status = 'Cancelled'
             """)
    List<DeliveryOrder> getDeliveryOrder(@Param("date") LocalDate date);


    @Query("""
            SELECT d
            FROM DeliveryOrder d
            WHERE FUNCTION('DATE',d.orderDate) = FUNCTION('DATE',CAST(:date AS DATE))  AND (d.status = 'Delivered' 
            OR d.status = 'Cancelled')
            """)
    Page<DeliveryOrder> getDeliveryOrderByDaily(Pageable pageable, @Param("date") LocalDate date);

    @Query(value = """
            SELECT d
            FROM DeliveryOrder d
            WHERE EXTRACT(YEAR FROM d.orderDate) = :year
            AND EXTRACT(MONTH FROM d.orderDate) = :month  AND ( d.status = 'Delivered' 
            OR d.status = 'Cancelled')
            """)
    Page<DeliveryOrder> getDeliveryOrderByMonth(Pageable pageable, @Param("year") int year, @Param("month") int month);

    @Query(value = """
            SELECT d
            FROM DeliveryOrder d
            WHERE EXTRACT(YEAR FROM d.orderDate) = :year  AND (d.status = 'Delivered' 
            OR d.status = 'Cancelled')
            """)
    Page<DeliveryOrder> getDeliveryOrderByYear(Pageable pageable, @Param("year") int year);

    @Query("""
            SELECT COUNT(d)
            FROM DeliveryOrder d
            WHERE d.status = :status AND d.shipper.id = :shipperId
            """)
    int countDeliveryOrderByStatusAndShipperId(String status, int shipperId );
    int countByShipperIdAndStatus(int shipperId, String status);
    int countByShipperId(int shipperId);

    Page<DeliveryOrder> getByShipperId(int shipperId, Pageable pageable);

    @Query("""
            SELECT d
            FROM DeliveryOrder d
            WHERE d.status = 'Preparing' OR d.status = 'Processing'
            """)
    Page<DeliveryOrder> getDeliveryOrder(Pageable pageable);

    List<DeliveryOrder> findAllByAccount_UserId(UUID userId);

    List<DeliveryOrder> findAllByShipper_Id(int shipperId);
}
