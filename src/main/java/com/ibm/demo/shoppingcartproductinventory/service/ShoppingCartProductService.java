package com.ibm.demo.shoppingcartproductinventory.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ibm.demo.shoppingcartproductinventory.model.Product;
import com.ibm.demo.shoppingcartproductinventory.repo.ShoppingCartProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;


@Component
@RibbonClient(name = "currencyconversionfactorservice")
@RequiredArgsConstructor
@Log
@Service
public class ShoppingCartProductService {
	
	final private ShoppingCartProductRepository  productrepo;
	
	public   Page<Product>  getproducts(Pageable pageable) {		
		return productrepo.findAll(pageable);
	
	}
	
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
		
	

}
