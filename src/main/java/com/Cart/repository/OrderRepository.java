package com.Cart.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Cart.entity.Order;

public interface OrderRepository extends MongoRepository<Order, Integer>  {

	List<Order> findAllByOrderByIdAsc();

}