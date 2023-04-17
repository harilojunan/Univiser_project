package com.univiser.shopping.service;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.univiser.shopping.util.AppConstants;

/**
 * The Class ShoppingService.
 */
@Service
public class ShoppingService {

	/** The rest template. */
	RestTemplate restTemplate = new RestTemplate();

	/**
	 * All products.
	 *
	 * @return the response entity
	 */
	public ResponseEntity<String> allProducts() {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<String> response = restTemplate.exchange(AppConstants.PRODUCTS_URL, HttpMethod.GET, entity,
				String.class);
		return response;
	}

}
