package com.sauro.loans.dal.repositories;

import com.sauro.loans.dal.models.DigitalBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDigitalRepository extends JpaRepository<DigitalBookEntity, Integer> {
}
