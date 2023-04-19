package com.ismaelviss.nttdata.adapter.out.persistence.repository;

import com.ismaelviss.nttdata.adapter.out.persistence.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}
