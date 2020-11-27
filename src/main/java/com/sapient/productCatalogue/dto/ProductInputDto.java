package com.sapient.productCatalogue.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductInputDto {

	@NotNull
	@NotEmpty
	private String productName;

	@NotNull
	private double price;

	@NotNull
	@NotEmpty
	private String color;

	@NotNull
	@NotEmpty
	private String brand;

	@NotNull
	private int size;

}
