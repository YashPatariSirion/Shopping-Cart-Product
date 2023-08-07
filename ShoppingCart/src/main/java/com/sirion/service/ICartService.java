package com.sirion.service;

import java.util.List;

import com.sirion.entity.Cart;
import com.sirion.entity.Product;

public interface ICartService {

	public Cart addProductToCart(int cartId, int productId, int qty);

	public Cart removeProductFromCart(int cartId, int productId);

	public Cart updateProductQuantity(int cartId, int productId, int quantity);

	public Cart removeAllProducts(int cartId);

	public List<Product> viewAllProducts(int cartId);
}
