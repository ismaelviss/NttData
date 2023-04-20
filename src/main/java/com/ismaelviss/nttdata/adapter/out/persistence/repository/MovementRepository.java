package com.ismaelviss.nttdata.adapter.out.persistence.repository;

import com.ismaelviss.nttdata.adapter.out.persistence.entity.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovementRepository extends JpaRepository<MovementEntity, Long> {

    public MovementEntity findFirstByAccountEntity_AccountNumberOrderByDateDesc(String accountNumber);

    public List<MovementEntity> findAllByAccountEntity_AccountNumberAndDateBetween(String accountNumber, LocalDateTime startDate, LocalDateTime endDate);
}
