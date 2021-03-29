package com.Cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Cart.entity.Product;
import com.Cart.repository.ProductRepository;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@Service
@GraphQLApi
@CrossOrigin(origins = "*", allowedHeaders = "*" )
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GraphQLQuery(name = "getProducts", description = "List of all products")
    public List<Product> getProducts() {
		return productRepository.findAllByOrderByTitleAsc();
    }
	
	@GraphQLQuery(name = "getProductById", description = "List of all products")
	public Product getProductById(@GraphQLArgument(name = "productId") Integer productId) {
		return productRepository.findByProductId(productId);
    }
	
	@GraphQLMutation(name = "saveProduct", description = "Save products in database")
	public Product saveProduct(@GraphQLArgument(name = "product") Product product) {
		return productRepository.save(product);
	}

}