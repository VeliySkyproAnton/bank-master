package com.stepintoprofession.bank.repository;

import com.stepintoprofession.bank.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query("SELECT a FROM Account a WHERE a.user.id = :userId")
    List<Account> findAllByUser(Integer userId);
}