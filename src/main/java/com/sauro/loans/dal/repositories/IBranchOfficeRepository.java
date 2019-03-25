package com.sauro.loans.dal.repositories;

import com.sauro.loans.dal.models.BranchOfficeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IBranchOfficeRepository extends JpaRepository<BranchOfficeEntity, Integer> {
}
