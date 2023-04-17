package com.univiser.inventory.service;

import java.util.List;
import com.univiser.inventory.entity.Product;
import com.univiser.inventory.exceptions.ResourceAlreadyFoundException;
import com.univiser.inventory.exceptions.ResourceNotFoundException;

/**
 * The Interface ProductService.
 */
public interface ProductService {
	
	/**
	 * Post product.
	 *
	 * @param product the product
	 * @return the product
	 * @throws ResourceAlreadyFoundException the resource already found exception
	 */
	public Product saveProduct(Product product) throws ResourceAlreadyFoundException;
	
	/**
	 * Edit product.
	 *
	 * @param productData the product data
	 * @param id the id
	 * @return the product
	 * @throws Exception the exception
	 */
	public Product updateProduct(Product productData, Long id) throws Exception;
	
	/**
	 * Retrieve products.
	 *
	 * @return List of products
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	public List<Product> getAllProducts() throws ResourceNotFoundException;
	
	/**
	 * Delete product.
	 *
	 * @param id the id
	 * @return void
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	public String deleteProduct(Long id) throws ResourceNotFoundException;

}
