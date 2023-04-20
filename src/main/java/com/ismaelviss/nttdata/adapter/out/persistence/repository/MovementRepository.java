package com.ismaelviss.nttdata.adapter.out.persistence.repository;

import com.ismaelviss.nttdata.adapter.out.persistence.entity.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository<MovementEntity, Long> {
}
