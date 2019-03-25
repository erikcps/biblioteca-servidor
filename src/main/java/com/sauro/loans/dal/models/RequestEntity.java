package com.sauro.loans.dal.models;

import com.sauro.loans.dal.models.access.UserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "request")
@Getter
@Setter
public class RequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String code;
    private Boolean active = true;
    private Date createdAt = new Date();
    private Date deletedAt;
    private Date updatedAt;

    private LocalDate date;
    private LocalDate fromDate;
    private LocalDate endDate;
    private Boolean state;
    private String note;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "office_id", nullable = false)
    private BranchOfficeEntity branchOffice;

}
