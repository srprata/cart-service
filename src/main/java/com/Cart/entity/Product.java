package com.Cart.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Data;

@Data
@Document
public class Product {

    @Id
    @GraphQLQuery(name = "id", description = "Database id")
    private String id;
	
	@GraphQLQuery(name = "productId", description = "Product id")
	private Integer productId;
	
	@GraphQLQuery(name = "title", description = "Product")
	private String title;
	
	@GraphQLQuery(name = "description", description = "Product description")
	private String description;
	
	@GraphQLQuery(name = "price", description = "Product price")
	private Float price;
	
	@GraphQLQuery(name = "stock", description = "Product stock")
	private Integer stock;
	
	@GraphQLQuery(name = "qty", description = "Qty bought in a order")
	private Integer qty;
	
}