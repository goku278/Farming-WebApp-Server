package com.farmingagriculture.farmingagriculture.repo;

import com.farmingagriculture.farmingagriculture.db.Consumers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumersRepo extends JpaRepository<Consumers,Long> {
}
