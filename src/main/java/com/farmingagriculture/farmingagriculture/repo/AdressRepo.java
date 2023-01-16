package com.farmingagriculture.farmingagriculture.repo;

import com.farmingagriculture.farmingagriculture.db.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepo extends JpaRepository<UserAddress,Long> {
    @Query(value = "select * from address where user_id like ?1", nativeQuery = true)
    UserAddress getAddressByUserId(Long userId);
}