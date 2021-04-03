package com.Cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Cart.entity.Order;
import com.Cart.repository.OrderRepository;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@Service
@GraphQLApi
@CrossOrigin(origins = "*", allowedHeaders = "*" )
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ProductService productService;
	
	@GraphQLQuery(name = "getOrders", description = "List of all orders")
    public List<Order> getOrders() {
		return orderRepository.findAllByOrderByIdAsc();
    }
	
	@GraphQLMutation(name = "saveOrder", description = "Save orders in database")
	public Order saveOrder(@GraphQLArgument(name = "order") Order order) {
		
		Order orderData = new Order();
		
		boolean response = productService.verifyProductStock(order.getProducts());
		
		if(response){
			orderData = orderRepository.save(order);
		}else{
			orderData.setMsg("Estoque de produtos insuficiente");
		}
		
		return order;
		
	}
	
}