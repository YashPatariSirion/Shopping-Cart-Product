package com.sirion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sirion.entity.Cart;
import com.sirion.entity.Product;
import com.sirion.service.CartService;
import java.util.List;

@RestController
@RequestMapping("cart")
public class CartController {
	@Autowired
	CartService cartService;

	@GetMapping("add/cartId/{cartId}/productId/{productId}/qty/{qty}")
	public Cart getAddProduct(@PathVariable int cartId, @PathVariable int productId, @PathVariable int qty) {
		return cartService.addProductToCart(cartId, productId, qty);
	}

	@DeleteMapping("delete/cartId/{cartId}/productId/{productId}")
	public Cart deleteProduct(@PathVariable int cartId, @PathVariable int productId) {
		return cartService.removeProductFromCart(cartId, productId);
	}

	@PutMapping("update/cartId/{cartId}/productId/{productId}/qty/{qty}")
	public Cart updateCart(@PathVariable int cartId, @PathVariable int productId, @PathVariable int qty) {
		return cartService.updateProductQuantity(cartId, productId, qty);
	}

	@DeleteMapping("deleteall/cartId/{cartId}")
	public Cart deleteAllProducts(@PathVariable int cartId) {
		return cartService.removeAllProducts(cartId);
	}
	
	@GetMapping("viewall/cartId/{cartId}")
	public List<Product> viewAll(@PathVariable int cartId){
		return cartService.viewAllProducts(cartId);
	}
}
