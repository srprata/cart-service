package com.Cart.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Order {

	@Id
	private String id;
	private Float totalPrice;
	private Integer totalItens;
	private String msg;
	private List<Product> products;
	
}
