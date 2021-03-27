package com.Cart.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Data;

@Data
@Document
public class Product {

    @GraphQLQuery(name = "productId", description = "Product id")
	private Integer productId;
	
	@GraphQLQuery(name = "title", description = "Product")
	private String title;
	
	@GraphQLQuery(name = "description", description = "Product description")
	private String description;
	
	@GraphQLQuery(name = "price", description = "Product price")
	private Float price;
	
	@GraphQLQuery(name = "qty", description = "Product quantity")
	private Integer qty;
	
	@GraphQLQuery(name = "imgId", description = "Product image Id")
	private Integer imgId;
	
}