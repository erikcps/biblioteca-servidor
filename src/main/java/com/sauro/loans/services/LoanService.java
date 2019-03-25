package com.sauro.loans.services;

import com.sauro.loans.dal.models.*;
import com.sauro.loans.dal.models.access.UserEntity;
import com.sauro.loans.dal.repositories.*;
import com.sauro.manageloans.dal.models.enums.TypeStatusLoan;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@GraphQLApi
public class LoanService {
    @Autowired
    ILoanRepository loanRepository;

    @Autowired
    IPhisicalRepository phisicalRepository;

    @Autowired
    IDigitalRepository digitalRepository;

    @Autowired
    UserService userService;

    @Autowired
    BranchOfficeService branchOfficeService;

    @GraphQLMutation(name = "createBook")
    public BookEntity createBook(@GraphQLArgument(name = "book") BookEntity loanEntity,
                                 @GraphQLArgument(name = "copies") Integer copies,
                                 @GraphQLArgument(name = "pathToDownload") String pathToDownload,
                                 @GraphQLArgument(name = "branchOfficeId") Integer branchOfficeId) {
        BranchOfficeEntity branchOfficeEntity = branchOfficeService.getBranchOfficeById(branchOfficeId);
        loanEntity.setBranchOffice(branchOfficeEntity);
        BookEntity bookEntity = loanRepository.save(loanEntity);

        PhisicalBookEntity phisicalBookEntity = new PhisicalBookEntity();
        phisicalBookEntity.setNumberOfCopies(copies);
        phisicalBookEntity.setBook(bookEntity);
        phisicalRepository.save(phisicalBookEntity);

        DigitalBookEntity digitalBookEntity = new DigitalBookEntity();
        digitalBookEntity.setPathBook(pathToDownload);
        digitalBookEntity.setBook(bookEntity);
        digitalRepository.save(digitalBookEntity);

        return bookEntity;
    }

    @GraphQLQuery(name = "bookById")
    public BookEntity getBookById(@GraphQLArgument(name = "bookId") Integer bookId) {
        Optional<BookEntity> optional = loanRepository.findById(bookId);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    @GraphQLMutation(name = "deleteBook")
    public BookEntity deleteBook(@GraphQLArgument(name = "bookId") Integer bookId) {
        Optional<BookEntity> optional = loanRepository.findById(bookId);
        if(optional.isPresent()) {
            BookEntity bookEntity = optional.get();
            bookEntity.setActive(Boolean.FALSE);
            loanRepository.save(bookEntity);
            return bookEntity;
        } else {
            return null;
        }
    }
}
