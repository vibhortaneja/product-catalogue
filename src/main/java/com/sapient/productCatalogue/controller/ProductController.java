package com.sapient.productCatalogue.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.productCatalogue.dto.EmptyJsonResponse;
import com.sapient.productCatalogue.dto.ProductInputDto;
import com.sapient.productCatalogue.dto.ProductOutputDto;
import com.sapient.productCatalogue.exception.ProductNotFoundException;
import com.sapient.productCatalogue.service.ProductServiceInterface;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductServiceInterface productService;
	
	@PostMapping("/save")
	public ResponseEntity<ProductOutputDto> saveProduct(@Valid @RequestBody ProductInputDto productInputDto) {
		ProductOutputDto product = productService.saveProduct(productInputDto);
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<EmptyJsonResponse> deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/getByBrand/{brand}")
	public ResponseEntity<List<ProductOutputDto>> getProductByBrand(@PathVariable String brand) {
		List<ProductOutputDto> result = productService.getProductByBrand(brand);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/getByColor/{color}")
	public ResponseEntity<List<ProductOutputDto>> getProductByColor(@PathVariable String color) {
		List<ProductOutputDto> result = productService.getProductByColor(color);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/getBySize/{size}")
	public ResponseEntity<List<ProductOutputDto>> getProductBySize(@PathVariable int size) {
		List<ProductOutputDto> result = productService.getProductBySize(size);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/getByPrice/{price}")
	public ResponseEntity<List<ProductOutputDto>> getProductByPrice(@PathVariable Double price) throws ProductNotFoundException {
		List<ProductOutputDto> result = productService.getProductByPrice(price);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
