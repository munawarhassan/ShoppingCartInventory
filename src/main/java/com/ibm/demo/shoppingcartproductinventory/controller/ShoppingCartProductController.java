package com.ibm.demo.shoppingcartproductinventory.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ibm.demo.shoppingcartproductinventory.model.Product;
import com.ibm.demo.shoppingcartproductinventory.service.ShoppingCartProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inventory")
public class ShoppingCartProductController {
	
	@Autowired
	private  ShoppingCartProductService productservice;
	
	private static org.slf4j.Logger log = LoggerFactory.getLogger(ShoppingCartProductController.class);
	
	@RequestMapping(path = "/default", method = RequestMethod.GET)
	public String getDefaultMessage() {		
		
		return	"Hello , I am ready for Productinventory";
	}
	
	
	@RequestMapping(path = "/addpoduct", method = RequestMethod.POST)
	public ResponseEntity<?> addproduct(@RequestBody Product product) {
		
		return productservice.addproduct(product);
	}

	@RequestMapping(path = "/updateproduct", method = RequestMethod.PUT)
	public ResponseEntity<?> updateproduct(@RequestBody Product product) {
		log.info("*Inside update Product**");
		return productservice.updateproduct(product);
	}
	
	@RequestMapping(path = "/getproducts", method = RequestMethod.GET)
	public List<Product> getproducts() {
		log.info("*Inside  getproducts**");
		return productservice.getproducts();
	}
	
	@RequestMapping(path = "/findproduct/{productid}", method = RequestMethod.GET)
	public Product findproduct(@PathVariable long productid) {
		log.info("*Inside  findproduct**");
		return productservice.findproduct(productid);
	}


}