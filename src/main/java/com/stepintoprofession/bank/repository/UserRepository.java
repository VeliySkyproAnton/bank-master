package com.stepintoprofession.bank.repository;

import com.stepintoprofession.bank.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Override
    @Query("SELECT u FROM User u WHERE u.deleted = FALSE")
    List<User> findAll();
}

