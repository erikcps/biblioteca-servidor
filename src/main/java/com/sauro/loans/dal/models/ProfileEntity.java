package com.sauro.loans.dal.models;

import com.sauro.loans.dal.models.BaseEntities.BaseEntity;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "profile")
@Data
public class ProfileEntity extends BaseEntity {
    private String name;
    private String lastName;
    private String ci;
    private String address;
    private String telephone;
    private String cellphone;
    private String country;
    private String city;
    private String email;
}
