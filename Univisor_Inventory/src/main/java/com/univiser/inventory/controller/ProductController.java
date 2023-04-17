package com.univiser.inventory.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univiser.inventory.entity.Product;
import com.univiser.inventory.exceptions.ResourceAlreadyFoundException;
import com.univiser.inventory.exceptions.ResourceNotFoundException;
import com.univiser.inventory.repo.ProductRepo;
import com.univiser.inventory.service.ProductService;
import com.univiser.inventory.util.AppConstants;

/**
 * The Class ProductController.
 */
@RestController
@RequestMapping(AppConstants.BASE_URL)
@CrossOrigin(origins = AppConstants.CROSS_ORIGIN_URL)
public class ProductController {

	/** The product service. */
	@Autowired
	private ProductService productService;

	/** The product repo. */
	@Autowired
	ProductRepo productRepo;

	/** The logger. */
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	/**
	 * add product.
	 *
	 * @param product the product
	 * @return HttpStatus OK
	 * @throws ResourceAlreadyFoundException the resource already found exception
	 */
	@PostMapping(AppConstants.PRODUCTS_URL)
	public ResponseEntity<?> saveProduct(@RequestBody Product product) throws ResourceAlreadyFoundException {
		logger.info("Logging Stated!!! Inside Product Controller @Save Product Method Initiated");
		Product savedProduct = productService.saveProduct(product);

		if (null != savedProduct) {
			return new ResponseEntity<Product>(savedProduct, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * Retrieve products.
	 *
	 * @return HttpStatus OK and the products list
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping(AppConstants.PRODUCTS_URL)
	public ResponseEntity<List<Product>> getAllProducts() throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside Product Controller @Get All Product Method Initiated");
		return new ResponseEntity<>(productService.getAllProducts().stream().collect(Collectors.toList()),
				HttpStatus.OK);
	}

	/**
	 * Edit product.
	 *
	 * @param product the product
	 * @param id the id
	 * @return HttpStatus OK
	 * @throws Exception the exception
	 */
	@PutMapping(AppConstants.PRODUCT_BY_ID_URL)
	public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable Long id) throws Exception {
		logger.info("Logging Stated!!! Inside Product Controller @Get Product By ID Employee Method Initiated");
		Optional<Product> productData = productRepo.findById(id);
		if (productData.isPresent() == true) {
			logger.info("Loggig Stated!!! Inside Product Controller @Update Product Method Initiated");
			return new ResponseEntity<>(productService.updateProduct(product, id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * Delete product.
	 *
	 * @param id the id
	 * @return void
	 */
	@DeleteMapping(AppConstants.PRODUCT_BY_ID_URL)
	public HttpStatus deleteProductById(@PathVariable("id") Long id) {
		logger.info("Logging Stated!!! Inside Product Controller @Delete Product Method Initiated");
		try {
			productService.deleteProduct(id);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return HttpStatus.OK;
	}

}
