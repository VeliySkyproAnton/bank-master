package com.stepintoprofession.bank.repository;

import com.stepintoprofession.bank.model.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
    @Query("SELECT r FROM Request r WHERE r.account.user.id = :userId")
    List<Request> findAllByUser(Integer userId);
}