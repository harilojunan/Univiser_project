package com.univiser.inventory.util;

import java.util.ArrayList;
import java.util.List;

import com.univiser.inventory.entity.Product;

public class MockDTOUtil {
	
	protected static List<Product> getRetrieveProductResponse() {
		List<Product> productsList = new ArrayList<>();
		Product product = new Product();
		product.setId(1L);
		product.setName("Rashmika");
		product.setQuantity(3);
		product.setPrice(135.5);
		Product product1 = new Product();
		product1.setId(2L);
		product1.setName("Harrish");
		product1.setQuantity(9);
		product1.setPrice(365.5);
		Product product2 = new Product();
		product2.setId(3L);
		product2.setName("Simbu");
		product2.setQuantity(26);
		product2.setPrice(335.5);
		Product product3 = new Product();
		product3.setId(4L);
		product3.setName("Vijay");
		product3.setQuantity(66);
		product3.setPrice(2568.5);
		productsList.add(product);
		productsList.add(product1);
		productsList.add(product2);
		productsList.add(product3);
        return productsList;
    }
	
	protected static Product getPostProductRequest() {
		Product product = new Product();
		product.setId(5L);
		product.setName("Ajith");
		product.setQuantity(33);
		product.setPrice(3333.33);
        return product;
    }
	
	protected static Product getPostProductResponse() {
		Product product = new Product();
		product.setId(6L);
		product.setName("Ajith");
		product.setQuantity(33);
		product.setPrice(3333.33);
        return product;
    }
	
	
	
	protected static String getUpdateProductResponse() {
        return "{\r\n"
        		+ "    \"id\": 6,\r\n"
        		+ "    \"name\": \"Surya\",\r\n"
        		+ "    \"quantity\": 32,\r\n"
        		+ "    \"price\": 2222.5\r\n"
        		+ "}";
    }
	
	protected static String getDeleteProductResponse() {
        return "OK";
    }

}
