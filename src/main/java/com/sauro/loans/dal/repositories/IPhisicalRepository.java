package com.sauro.loans.dal.repositories;

import com.sauro.loans.dal.models.PhisicalBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPhisicalRepository extends JpaRepository<PhisicalBookEntity, Integer> {
}
