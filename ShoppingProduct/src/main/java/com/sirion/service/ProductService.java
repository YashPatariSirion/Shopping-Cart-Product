package com.sirion.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirion.entity.Product;
import com.sirion.repo.ProductRepo;

@Service
public class ProductService implements IProductService {

	@Autowired
	ProductRepo prodRepo;

	@Override
	public List<Product> viewAllProducts() {
		return prodRepo.findAll();
	}

	@Override
	public Product viewProduct(int id) {
		Optional<Product> obj = prodRepo.findById(id);
		if (obj.isPresent()) {
			return obj.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Product> viewProductsByCategory(String cat) {
		return prodRepo.findByCategoryName(cat);
	}

	@Override
	public Product updateProduct(Product newProduct, int id) {
		Optional<Product> obj = prodRepo.findById(id);
		if (obj.isPresent()) {
			prodRepo.saveAndFlush(newProduct);
			return obj.get();
		}
		return null;
	}

	@Override
	public Product addProduct(Product product) {
		prodRepo.saveAndFlush(product);
		return product;
	}

	@Override
	public List<Product> removeProduct(int id) {
		Optional<Product> obj = prodRepo.findById(id);
		if (obj.isPresent()) {
			prodRepo.deleteById(id);
		}

		return prodRepo.findAll();
	}

}
