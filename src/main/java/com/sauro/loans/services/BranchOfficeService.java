package com.sauro.loans.services;

import com.sauro.loans.dal.models.BookEntity;
import com.sauro.loans.dal.models.BranchOfficeEntity;
import com.sauro.loans.dal.repositories.IBranchOfficeRepository;
import com.sauro.loans.dal.repositories.ILoanRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@GraphQLApi
public class BranchOfficeService {
    @Autowired
    IBranchOfficeRepository branchOfficeRepository;

    @Autowired
    ILoanRepository loanRepository;

    @GraphQLMutation(name = "createBranchOffice")
    public BranchOfficeEntity createBranchOffice(@GraphQLArgument(name = "branchOffice") BranchOfficeEntity branchOfficeEntity) {
        return branchOfficeRepository.save(branchOfficeEntity);
    }

    @GraphQLQuery(name = "branchOffices")
    public List<BranchOfficeEntity> getAllBranchOffices() {
        return branchOfficeRepository.findAll();
    }

    @GraphQLQuery(name = "branchOfficeById")
    public BranchOfficeEntity getBranchOfficeById(@GraphQLArgument(name = "brandOfficeId") Integer branchOfficeId) {
        Optional<BranchOfficeEntity> branchOfficeEntity = branchOfficeRepository.findById(branchOfficeId);
        return branchOfficeEntity.isPresent() ? branchOfficeEntity.get() : null;
    }

    @GraphQLQuery(name = "booksByBranchId")
    public List<BookEntity> getBooksByBranchId(@GraphQLArgument(name = "brandOfficeId") Integer branchOfficeId) {
        List<BookEntity> books = loanRepository.findAllActivesByBranchId(branchOfficeId);
        return books;
    }
}
