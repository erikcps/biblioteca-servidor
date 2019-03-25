package com.sauro.loans.dal.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "phisical")
@Getter
@Setter
public class PhisicalBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String code;
    private Boolean active = true;
    private Date createdAt = new Date();
    private Date deletedAt;
    private Date updatedAt;

    private int numberOfCopies;
    private LocalDate date;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private BookEntity book;
}
