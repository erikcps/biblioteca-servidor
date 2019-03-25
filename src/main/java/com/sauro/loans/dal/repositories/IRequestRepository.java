package com.sauro.loans.dal.repositories;

import com.sauro.loans.dal.models.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRequestRepository extends JpaRepository<RequestEntity, Integer> {
}
