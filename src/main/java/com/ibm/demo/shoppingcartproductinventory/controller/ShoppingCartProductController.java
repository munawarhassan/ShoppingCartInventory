package com.ibm.demo.shoppingcartproductinventory.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.demo.shoppingcartproductinventory.model.Product;
import com.ibm.demo.shoppingcartproductinventory.service.ShoppingCartProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@RestController
@RequiredArgsConstructor
@RequestMapping("/inventory")
public class ShoppingCartProductController {
	
	private final ShoppingCartProductService productservice;
	
	@RequestMapping(path = "/default", method = RequestMethod.GET)
	public String getDefaultMessage() {		
		
		return	"Hello , I am ready for Productinventory";
	}
	
	
	@RequestMapping(path = "/addpoduct", method = RequestMethod.POST)
	public ResponseEntity<?> addproduct(@RequestBody Product product) {
		log.info("*Inside add Promo**");
		return productservice.addproduct(product);
	}

	@RequestMapping(path = "/updateproduct", method = RequestMethod.PUT)
	public ResponseEntity<?> updateproduct(@RequestBody Product product) {
		log.info("*Inside update Product**");
		return productservice.updateproduct(product);
	}
}
