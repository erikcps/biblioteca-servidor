package com.sauro.loans.dal.repositories;

import com.sauro.loans.dal.models.access.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IModuleRepository extends JpaRepository<ModuleEntity, Integer> { }
