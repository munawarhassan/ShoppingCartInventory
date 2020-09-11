package com.ibm.demo.shoppingcartproductinventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.demo.shoppingcartproductinventory.model.Product;

@Repository
public interface ShoppingCartProductRepository extends JpaRepository<Product, Integer> {
	
	Product findById(Long id);

}
