package com.stepintoprofession.bank.repository;

import com.stepintoprofession.bank.model.Request;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends CrudRepository<Request, Integer> {
}