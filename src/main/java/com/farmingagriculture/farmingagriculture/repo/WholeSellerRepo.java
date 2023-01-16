package com.farmingagriculture.farmingagriculture.repo;

import com.farmingagriculture.farmingagriculture.db.WholeSeller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WholeSellerRepo extends JpaRepository<WholeSeller,Long> {
}