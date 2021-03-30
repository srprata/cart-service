package com.Cart.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.Cart.util.Util;

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
	
	@GraphQLQuery(name = "stock", description = "Product stock")
	private Integer stock;
	
	public String getPriceBRL() {
		if(this.price == null)
			return null;
		else
			return Util.currencyBrasil(this.price);
	}
	
}