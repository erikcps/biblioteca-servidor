package com.sauro.loans.services;

import com.sauro.loans.dal.models.ProfileEntity;
import com.sauro.loans.dal.repositories.ProfileRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@GraphQLApi
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    @GraphQLMutation(name = "createProfile")
    public ProfileEntity createProfile(@GraphQLArgument(name = "profileDto") ProfileEntity profileEntity) {
        return profileRepository.save(profileEntity);
    }
}
