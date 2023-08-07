package com.sirion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sirion.entity.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer>{

}
