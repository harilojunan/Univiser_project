package com.univiser.inventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univiser.inventory.entity.Product;

/**
 * The Interface ProductRepo.
 */
@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
}
