package com.univiser.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The Class UnivisorInventoryApplication.
 */
@SpringBootApplication
@ComponentScan({"com.univiser.inventory.*"})
public class UnivisorInventoryApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(UnivisorInventoryApplication.class, args);
	}

}
