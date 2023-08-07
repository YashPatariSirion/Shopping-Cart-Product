package com.sirion.entity;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.annotations.MapKeyCompositeType;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	@Id
	private int cartId;
	private int userId;
	@ElementCollection
	@MapKeyJoinColumn
	Map<Product, Integer> products = new HashMap<>(); // product and quantity
//	private Object prodcuts;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setProducts(Product p, int q) {
		products.put(p, q);
	}

	public Map<Product, Integer> getProducts() {
		return products;
	}

	public void setProducts(Map<Product, Integer> products) {
		this.products = products;
	}

}
