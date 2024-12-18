package com.stepintoprofession.bank.repository;

import com.stepintoprofession.bank.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.deleted = FALSE")
    @Override
    List<Product> findAll();
}
