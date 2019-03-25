package com.sauro.loans.dal.models;

import com.sauro.loans.dal.models.access.UserEntity;
import com.sauro.manageloans.dal.models.enums.TypeStatusLoan;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "book")
@Getter @Setter
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String code;
    private Boolean active = true;
    private Date createdAt = new Date();
    private Date deletedAt;
    private Date updatedAt;

    private String title;
    private String author;
    private int year;
    private String edited;
    private int pages;
    private String language;
    private LocalDate fromDate = LocalDate.now();
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "office_id", nullable = false)
    private BranchOfficeEntity branchOffice;

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private PhisicalBookEntity phisicalBook;

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private DigitalBookEntity digitalBook;
}
