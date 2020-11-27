package com.sapient.productCatalogue.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOutputDto {
	
	private String productId;
	
	private String productName;

	private String price;

	private String color;

	private String brand;

	private String size;
}
