package com.sauro.loans.dal.repositories;

import com.sauro.loans.dal.models.access.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query("SELECT user from UserEntity user WHERE user.username= ?1 AND user.password = ?2")
    UserEntity loginUser(String username, String password);
}
