package com.monkmaze.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monkmaze.ecommerce.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	

}
