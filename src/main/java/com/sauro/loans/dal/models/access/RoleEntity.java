package com.sauro.loans.dal.models.access;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "role")
@Getter @Setter
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GraphQLQuery(name = "id", description = "An identifier of entity")
    private Integer id;
    @GraphQLQuery(name = "code", description = "codigo")
    private String code;
    private Boolean active = true;
    private Date createdAt = new Date();
    private Date deletedAt;
    private Date updatedAt;

    private String name;
    private String description;
    private Boolean canCreate;
    private Boolean canUpdate;
    private Boolean canDelete;
    private Boolean canPrint;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "role_id")
    private Set<UserEntity> users;
}
