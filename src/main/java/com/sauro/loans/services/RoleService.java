package com.sauro.loans.services;

import com.sauro.loans.dal.models.access.RoleEntity;
import com.sauro.loans.dal.repositories.IRoleRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@GraphQLApi
public class RoleService {

    @Autowired
    IRoleRepository roleRepository;

    @GraphQLMutation(name = "createRole")
    public RoleEntity createRole(@GraphQLArgument(name = "role") RoleEntity roleEntity) {
        return roleRepository.save(roleEntity);
    }

    @GraphQLQuery(name = "role")
    public Optional<RoleEntity> getRoleById(@GraphQLArgument(name = "id") int id) {
        return roleRepository.findById(id);
    }

    @GraphQLQuery(name = "roles")
    public List<RoleEntity> getAllRoles() {
        return roleRepository.findAll();
    }
}
