package com.univiser.shopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univiser.shopping.exception.ResourceNotFoundException;
import com.univiser.shopping.service.ShoppingService;
import com.univiser.shopping.util.AppConstants;

/**
 * The Class ShoppingController.
 */
@RestController
@RequestMapping(AppConstants.BASE_URL)
@CrossOrigin(origins = AppConstants.CROSS_ORIGIN_URL)
public class ShoppingController {
	
	/** The shopping service. */
	@Autowired
	ShoppingService shoppingService;
	
	/** The logger. */
	private static final Logger logger = LoggerFactory.getLogger(ShoppingController.class);
	
	/**
	 * Retrieve products.
	 *
	 * @return HttpStatus OK and the products list
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping(AppConstants.SHOPPINGS_URL)
	public ResponseEntity<String> getAllShopings() throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside Product Controller @Get All Product Method Initiated");
		return shoppingService.allProducts();
	}

}
