package com.univiser.inventory.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univiser.inventory.entity.Product;
import com.univiser.inventory.exceptions.ResourceAlreadyFoundException;
import com.univiser.inventory.exceptions.ResourceNotFoundException;
import com.univiser.inventory.repo.ProductRepo;

/**
 * The Class ProductServiceImpl.
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	/** The product repo. */
	@Autowired
	private ProductRepo productRepo;

	/**
	 * Instantiates a new product service impl.
	 *
	 * @param productRepo the product repo
	 */
	public ProductServiceImpl(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	/**
	 * Save product.
	 *
	 * @param product the product
	 * @return the product
	 * @throws ResourceAlreadyFoundException the resource already found exception
	 */
	public Product saveProduct(Product product) throws ResourceAlreadyFoundException {
		logger.info("Logging Stated!!! Inside Product Service @Save Product Method Running");
		if (productRepo.existsById(product.getId())) {
			throw new ResourceAlreadyFoundException("Product already found");
		}
		Product savedProduct = productRepo.save(product);
		return savedProduct;
	}

	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 */
	public List<Product> getAllProducts() {
		logger.info("Logging Stated!!! Inside Product Service @Get All Products Method Running");
		return productRepo.findAll();
	}

	/**
	 * Update product.
	 *
	 * @param productRequest the product request
	 * @param id the id
	 * @return the product
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	public Product updateProduct(Product productRequest, Long id) throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside Product Service @Find By ID Employee Method Running");

		if (productRepo.existsById(productRequest.getId()) == false) {
			throw new ResourceNotFoundException("Product not found with id :" + id);
		} else {
			Optional<Product> product = productRepo.findById(id);
			logger.info("Loggig Stated!!! Inside Product Service @Update Product Method Running");
			product.get().setId(productRequest.getId());
			return productRepo.save(productRequest);
		}
	}

	/**
	 * Delete product.
	 *
	 * @param id the id
	 * @return the string
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	public String deleteProduct(Long id) throws ResourceNotFoundException {
		logger.info("Logging Stated!!! Inside Products Service @Find By ID Product Method Started");
		if (productRepo.findById(id).isEmpty()) {
			throw new ResourceNotFoundException("Product not found with id :" + id);
		} else {
			logger.info("Logging Stated!!! Inside Product Service @Delete Product Method Started");
			productRepo.deleteById(id);
		}
		return "Products Deleted Successfully with id : "+id;
	}

}
