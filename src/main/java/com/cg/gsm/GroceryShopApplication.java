package com.cg.gsm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.cg.gsm")
public class GroceryShopApplication {

	public static void main(String[] args) {
	SpringApplication.run(GroceryShopApplication.class, args);	
	}
}
