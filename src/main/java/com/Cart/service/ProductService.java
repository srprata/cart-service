package com.Cart.service;

import java.util.ArrayList;
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
	
	boolean verifyStock = true;
	
	@GraphQLQuery(name = "getProducts", description = "List of all products")
    public List<Product> getProducts() {
		return productRepository.findAllByStockGreaterThanOrderByTitleAsc(0);
    }
	
	@GraphQLQuery(name = "getProductById", description = "List of all products")
	public Product getProductById(@GraphQLArgument(name = "productId") String id) {
		return productRepository.findById(id);
    }
	
	@GraphQLMutation(name = "saveProduct", description = "Save products in database")
	public Product saveProduct(@GraphQLArgument(name = "product") Product product) {
		return productRepository.save(product);
	}
	
	//verify if theres stock for the products
	public boolean verifyProductStock(List<Product> productList) {
		
		List<Product> productsInStock = new ArrayList<Product>(); 
		
		//verify if theres stock for each product on list
		productList.forEach(product -> {
			Product productDB = getProductById(product.getId());
			if(productDB.getStock() < product.getQty()) {
				verifyStock = false;
			}else {
				productsInStock.add(product);
			}
		});
		
		//if theres stock for all products, update 
		if(verifyStock) {
			productsInStock.forEach(product -> {
				product.setStock(product.getStock() - product.getQty());
				productRepository.save(product);
			});
		}else {
			return verifyStock;
		}
		
		return verifyStock;
		
	}

}