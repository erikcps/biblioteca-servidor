package com.sauro.loans.dal.models.access;

import com.sauro.loans.dal.models.BaseEntities.BaseEntity;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "module")
@Getter @Setter
public class ModuleEntity {
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
    private Boolean checked;

    @ManyToMany(mappedBy = "modules")
    private Set<UserEntity> usrs;
}
