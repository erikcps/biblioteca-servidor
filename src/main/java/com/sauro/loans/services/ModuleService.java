package com.sauro.loans.services;

import com.sauro.loans.dal.models.access.ModuleEntity;
import com.sauro.loans.dal.repositories.IModuleRepository;
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
public class ModuleService {
    @Autowired
    IModuleRepository moduleRepository;

    @GraphQLMutation(name = "createModule")
    public ModuleEntity createModule(@GraphQLArgument(name = "module") ModuleEntity moduleEntity) {
        return moduleRepository.save(moduleEntity);
    }

    @GraphQLQuery(name = "module")
    public Optional<ModuleEntity> getModuleById(@GraphQLArgument(name = "id") int id) {
        return moduleRepository.findById(id);
    }

    @GraphQLQuery(name = "modules")
    public List<ModuleEntity> getAllModules() {
        return moduleRepository.findAll();
    }
}
