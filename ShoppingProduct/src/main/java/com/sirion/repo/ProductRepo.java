package com.sirion.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sirion.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
	public List<Product> findByCategoryName(String category);
}
