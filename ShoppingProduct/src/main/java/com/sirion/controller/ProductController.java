package com.sirion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sirion.entity.Product;
import com.sirion.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {
	@Autowired
	ProductService service;

	@GetMapping("all")
	public List<Product> getAllProduct() {
		return service.viewAllProducts();
	}

	@GetMapping("id/{id}")
	public Product getProductById(@PathVariable int id) {
		return service.viewProduct(id);
	}

	@GetMapping("category/{category}")
	public List<Product> getProductByCategory(@PathVariable String category) {
		return service.viewProductsByCategory(category);
	}

	@PostMapping
	public List<Product> saveProduct(@RequestBody Product product) {
		service.addProduct(product);
		return service.viewAllProducts();
	}

	@PutMapping("/update/{id}")
	public Product updateProduct(@RequestBody Product product, @PathVariable int id) {
		return service.updateProduct(product, id);
	}

	@DeleteMapping("delete/{id}")
	public List<Product> deleteProduct(@PathVariable int id) {
		return service.removeProduct(id);
	}
}
