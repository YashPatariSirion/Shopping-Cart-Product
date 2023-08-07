package com.sirion.service;

import java.util.List;


import com.sirion.entity.Product;

public interface IProductService {
	public List<Product> viewAllProducts();

	public Product addProduct(Product product);

	public Product updateProduct(Product product, int id);

	public Product viewProduct(int id);

	public List<Product> viewProductsByCategory(String cat);

	public List<Product> removeProduct(int prodid);
}
