package com.sapient.productCatalogue.service;

import java.util.List;

import com.sapient.productCatalogue.dto.ProductInputDto;
import com.sapient.productCatalogue.dto.ProductOutputDto;
import com.sapient.productCatalogue.exception.ProductNotFoundException;

public interface ProductServiceInterface {

	ProductOutputDto saveProduct(ProductInputDto product);

	void deleteProduct(int id);

	List<ProductOutputDto> getProductByBrand(String brand);

	List<ProductOutputDto> getProductByColor(String color);

	List<ProductOutputDto> getProductBySize(int size);

	List<ProductOutputDto> getProductByPrice(Double price) throws ProductNotFoundException;

}
