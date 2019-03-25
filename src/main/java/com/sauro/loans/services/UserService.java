package com.sauro.loans.services;

import com.sauro.loans.dal.models.BranchOfficeEntity;
import com.sauro.loans.dal.models.ProfileEntity;
import com.sauro.loans.dal.models.access.ModuleEntity;
import com.sauro.loans.dal.models.access.RoleEntity;
import com.sauro.loans.dal.models.access.UserEntity;
import com.sauro.loans.dal.repositories.ProfileRepository;
import com.sauro.loans.dal.repositories.UserRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@GraphQLApi
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProfileService profileService;

    @Autowired
    RoleService roleService;

    @Autowired
    BranchOfficeService branchOfficeService;

    @Autowired
    ModuleService moduleService;

    @Autowired
    ProfileRepository profileRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @GraphQLQuery(name = "doLogin")
    public UserEntity doLogin(@GraphQLArgument(name = "username") String username,
                              @GraphQLArgument(name = "password") String password) {
        return userRepository.loginUser(username, password);
    }

    @GraphQLMutation(name = "createUser")
    public UserEntity createUser(@GraphQLArgument(name = "username") String username,
                                 @GraphQLArgument(name = "password") String password,
                                 @GraphQLArgument(name = "profile") ProfileEntity profile,
                                 @GraphQLArgument(name = "roleId") int roleId,
                                 @GraphQLArgument(name = "branchOfficeId") Integer branchOfficeId,
                                 @GraphQLArgument(name = "modulesId") List<Integer> modulesId) {
        ProfileEntity profileEntity = profileRepository.save(profile);
        BranchOfficeEntity branchOfficeEntity = branchOfficeService.getBranchOfficeById(branchOfficeId);
        RoleEntity roleEntity = roleService.getRoleById(roleId).get();
        Set<ModuleEntity> modules = getModules(modulesId);

        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(password);
        user.setBranchOffice(branchOfficeEntity);
        user.setProfile(profileEntity);
        user.setRole(roleEntity);
        user.setModules(modules);
        return userRepository.save(user);
    }

    private Set<ModuleEntity> getModules(List<Integer> listModulesId) {
        Set<ModuleEntity> modulesToAdd = new HashSet<>();
        listModulesId.forEach(moduleId -> {
            modulesToAdd.add(moduleService.getModuleById(moduleId).get());
        });

        return modulesToAdd;
    }

    @GraphQLQuery(name = "userById")
    public UserEntity getUserById(@GraphQLArgument(name = "userId") Integer userId) {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        return userEntity.isPresent() ? userEntity.get() : null;
    }
}
