package com.sauro.loans.dal.models.access;

import com.sauro.loans.dal.models.BranchOfficeEntity;
import com.sauro.loans.dal.models.ProfileEntity;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usr")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
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

    private String username;
    private String password;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "profile_id", nullable = false)
    private ProfileEntity profile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_office_id")
    private BranchOfficeEntity branchOffice;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usr_module", joinColumns = @JoinColumn(name = "usr_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "module_id", referencedColumnName = "id"))
    private Set<ModuleEntity> modules = new HashSet<>();
}
