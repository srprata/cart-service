package com.Cart.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Cart.entity.Product;

public interface ProductRepository extends MongoRepository<Product, Integer> {

	List<Product> findAllByOrderByTitleAsc();

	List<Product> findAllProductIdNotNullByOrderByTitleAsc();
	

}