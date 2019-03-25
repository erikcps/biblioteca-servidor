package com.sauro.loans.dal.repositories;


import com.sauro.loans.dal.models.access.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Integer> { }
