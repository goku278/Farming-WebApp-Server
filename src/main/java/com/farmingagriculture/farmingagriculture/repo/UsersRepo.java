package com.farmingagriculture.farmingagriculture.repo;

import com.farmingagriculture.farmingagriculture.db.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepo extends JpaRepository<Users,Long> {
    @Query(value = "select * from users where mobile like ?1 and email like ?2", nativeQuery = true)
    List<Users> findUserByMobileAndEmail(String mobile, String email);
    @Query(value = "select * from users where user_id like ?1", nativeQuery = true)
    Users getProfileDetailsByUserId(Long userId);

    @Query(
            value = "select role from users where user_id like ?1", nativeQuery = true
    )
    String findRoleById(String buyerId);
    @Query(
            value = "select * from users where role like ?1", nativeQuery = true
    )
    List<Users> findUsersByRole(String role);
}