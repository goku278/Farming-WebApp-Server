package com.farmingagriculture.farmingagriculture.repo;

import com.farmingagriculture.farmingagriculture.db.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, Long> {
    @Query(
            value = "select * from orders where buyer_id like ?1 and order_status not like ?2", nativeQuery = true
    )
    List<Orders> findOrderById(Long id, String status);
}