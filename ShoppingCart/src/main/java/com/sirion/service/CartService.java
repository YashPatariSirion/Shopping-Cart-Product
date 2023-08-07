package com.sirion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirion.entity.Cart;
import com.sirion.entity.Product;
import com.sirion.proxy.ProductProxy;
import com.sirion.repo.CartRepo;

@Service
public class CartService implements ICartService {
	@Autowired
	CartRepo cartRepo;

	@Autowired
	ProductProxy prodProxy;
	
	@Override
	public Cart addProductToCart(int cartId, int productId, int qty) {
		Optional<Cart> cart = cartRepo.findById(cartId);
		if(cart.isPresent()) {
			Product product = prodProxy.getProduct(productId);
			System.out.println(product);
			cart.get().setProducts(product, qty);
			return cart.get();
		}
		return null;
	}

	@Override
	public Cart removeProductFromCart(int cartId, int productId) {
		Optional<Cart> cart = cartRepo.findById(cartId);
		if(cart.isPresent()) {
			Map<Product, Integer> product_map=  cart.get().getProducts();
			Product product = prodProxy.getProduct(productId);
			product_map.remove(product);
			return cart.get();
		}
		return null;
	}

	@Override
	public Cart updateProductQuantity(int cartId, int productId, int qty) {
		Optional<Cart> cart = cartRepo.findById(cartId);
		if(cart.isPresent()) {
			Product product = prodProxy.getProduct(productId);
			Map<Product, Integer> product_map=  cart.get().getProducts();
			product_map.replace(product, qty);
			return cart.get();
		}
		return null;
	}

	@Override
	public Cart removeAllProducts(int cartId) {
		Optional<Cart> obj = cartRepo.findById(cartId);
		if(obj.isPresent()) {
			obj.get().getProducts().clear();
			return obj.get();
		}
		return null;
	}

	@Override
	public List<Product> viewAllProducts(int cartId) {
		Optional<Cart> obj = cartRepo.findById(cartId);
		if(obj.isPresent()) {
			List<Product> prod = new ArrayList<>(obj.get().getProducts().keySet());
			return prod;
		}
		return null;
	}

}
