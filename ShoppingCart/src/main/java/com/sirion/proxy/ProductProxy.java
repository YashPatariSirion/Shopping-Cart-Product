package com.sirion.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sirion.entity.Product;

@FeignClient(name="product-service")
public interface ProductProxy {
	@GetMapping("/product/id/{id}")
	public Product getProduct(@PathVariable int id);
}
