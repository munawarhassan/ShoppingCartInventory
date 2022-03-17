package com.ibm.demo.shoppingcartproductinventory.service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ibm.demo.shoppingcartproductinventory.controller.ShoppingCartProductController;
import com.ibm.demo.shoppingcartproductinventory.model.Product;
import com.ibm.demo.shoppingcartproductinventory.repo.ShoppingCartProductRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Service
public class ShoppingCartProductService {
	
@Autowired	
  private ShoppingCartProductRepository  productrepo;
	
private static org.slf4j.Logger log = LoggerFactory.getLogger(ShoppingCartProductService.class);
	
	public ResponseEntity<?> addproduct(Product promo) {
		try {
			productrepo.save(promo);
		} catch (Exception ex) {
			//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new PromoEngineException(ex.getMessage()));
		}

		return ResponseEntity.ok("successfully added in DB");
	}

	
	public ResponseEntity<?> updateproduct(Product updatedproduct) {
		try {
			Product product = productrepo.findById(updatedproduct.getId());

			if (product != null) {
				productrepo.save(updatedproduct);
				log.info(" Record Updated Successfully");
				return ResponseEntity.ok("Record Updated Successfully");
			} else {
				return ResponseEntity.ok("Record Not Found");
			}
		} catch (Exception ex) {
			//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new PromoEngineException(ex.getMessage()));
			return null;
		}
	}
	public List<Product> getproducts() {
		
		return productrepo.findAll();
	}
	
	public Product findproduct(long id) {
		
		return productrepo.findById(id);
	}
}
