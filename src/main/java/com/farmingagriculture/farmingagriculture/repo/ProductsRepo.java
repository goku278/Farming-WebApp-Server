package com.farmingagriculture.farmingagriculture.repo;

import com.farmingagriculture.farmingagriculture.db.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepo extends JpaRepository<Products,Long> {

    @Query(value = "select * from products where p_added_by like ?1",nativeQuery = true)
    List<Products> getAllProductItemsByUserType(String userType);

    @Query(value = "select * from products where p_added_by_id like ?1",nativeQuery = true)
    List<Products> getAllProductItemsByUserId(String userId);
}