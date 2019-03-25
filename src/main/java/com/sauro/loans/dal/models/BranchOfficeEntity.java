package com.sauro.loans.dal.models;

import com.sauro.loans.dal.models.access.UserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "branch_office")
@Getter @Setter
public class BranchOfficeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String code;
    private Boolean active = true;
    private Date createdAt = new Date();
    private Date deletedAt;
    private Date updatedAt;

    private String name;
    private String city;
    private String address;
    private String folder;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "office_id")
    private List<BookEntity> books;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "office_id")
    private Set<RequestEntity> requests;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "branch_office_id")
    private Set<UserEntity> users;
}
