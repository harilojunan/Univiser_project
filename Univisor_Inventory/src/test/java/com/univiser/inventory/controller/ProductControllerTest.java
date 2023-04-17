package com.univiser.inventory.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.univiser.inventory.entity.Product;
import com.univiser.inventory.service.ProductService;
import com.univiser.inventory.util.AppConstants;
import com.univiser.inventory.util.MockDTOUtil;

@WebMvcTest(ProductController.class)
@TestPropertySource(locations = "classpath:test-application.properties")
public class ProductControllerTest extends MockDTOUtil {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;

	@InjectMocks
	private ProductController productController;

	@Mock
	ObjectMapper objectMapper;
	
	@Test
	void postProduct() throws Exception {

		final Product response = getPostProductResponse();
		Mockito.when(productService.saveProduct(ArgumentMatchers.isA(Product.class))).thenReturn(response);

		MvcResult mvcResult = this.mockMvc.perform(post(AppConstants.BASE_URL + AppConstants.PRODUCTS_URL)
				.contentType(MediaType.APPLICATION_JSON).content(this.objectMapper.writeValueAsString(getPostProductRequest()))).andExpect(status().isOk())
				.andReturn();

		assertEquals(mvcResult, response);

	}

	@Test
	public void retrieveProducts() throws Exception {

		final List<Product> response = getRetrieveProductResponse();
		Mockito.when(productService.getAllProducts()).thenReturn(response);

		final MvcResult mvcResult = this.mockMvc.perform(get(AppConstants.BASE_URL + AppConstants.PRODUCTS_URL))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();

		assertEquals(mvcResult, response);

	}

	

}
