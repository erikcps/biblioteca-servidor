package com.sauro.loans.dal.repositories;

import com.sauro.loans.dal.models.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ILoanRepository extends JpaRepository<BookEntity, Integer> {

    @Query("SELECT books from BookEntity books WHERE books.branchOffice.id= ?1 AND books.active = true")
    List<BookEntity> findAllActivesByBranchId(Integer branchOfficeId);
}
