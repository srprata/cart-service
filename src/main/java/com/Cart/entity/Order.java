package com.Cart.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Order {

	private Integer orderId;
	private Float totalPrice;
	private List<Product> products;
	
}
