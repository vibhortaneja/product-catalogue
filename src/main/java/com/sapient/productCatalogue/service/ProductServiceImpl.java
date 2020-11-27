package com.sapient.productCatalogue.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.productCatalogue.dto.ProductInputDto;
import com.sapient.productCatalogue.dto.ProductOutputDto;
import com.sapient.productCatalogue.exception.ProductNotFoundException;
import com.sapient.productCatalogue.model.Product;
import com.sapient.productCatalogue.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductServiceInterface {

	@Autowired
	ProductRepository productRepo;
	
	@Override
	public ProductOutputDto saveProduct(ProductInputDto productInputDto) {
		Product product = new Product();
		product.setBrand(productInputDto.getBrand().toLowerCase());
		product.setColor(productInputDto.getColor().toLowerCase());
		product.setPrice(productInputDto.getPrice());
		product.setProductName(productInputDto.getProductName().toLowerCase());
		product.setSize(productInputDto.getSize());
		
		Product productOutput = productRepo.save(product);
		ProductOutputDto productOutputDto = setProductOutputDto(productOutput);
		return productOutputDto;
	}
	
	@Override
	public void deleteProduct(int id) {
		productRepo.deleteById(id);
	}
	
	@Override
	public List<ProductOutputDto> getProductByBrand(String brand){
		List<Product> productOutputList = productRepo.findByBrand(brand.toLowerCase());
		List<ProductOutputDto> outputDtoList = setOutputList(productOutputList);
		return outputDtoList;
	}
	
	private List<ProductOutputDto> setOutputList(List<Product> productOutputList) {
		List<ProductOutputDto> outputDtoList = new ArrayList<>();
		for(Product productOutput : productOutputList ) {
			ProductOutputDto productOutputDto = setProductOutputDto(productOutput);
			outputDtoList.add(productOutputDto);
		}
		return outputDtoList;
	}

	private ProductOutputDto setProductOutputDto(Product productOutput) {
		ProductOutputDto productOutputDto = new ProductOutputDto();
		productOutputDto.setBrand(productOutput.getBrand());
		productOutputDto.setColor(productOutput.getColor());
		productOutputDto.setProductId(String.valueOf(productOutput.getId()));
		productOutputDto.setProductName(productOutput.getProductName());
		productOutputDto.setPrice(String.valueOf(productOutput.getPrice()));
		productOutputDto.setSize(String.valueOf(productOutput.getSize()));
		return productOutputDto;
	}

	@Override
	public List<ProductOutputDto> getProductByColor(String color){
		List<Product> productOutputList = productRepo.findByColor(color.toLowerCase());
		List<ProductOutputDto> outputDtoList = setOutputList(productOutputList);
		return outputDtoList;
	}
	
	@Override
	public List<ProductOutputDto> getProductBySize(int size){
		List<Product> productOutputList = productRepo.findBySize(size);
		List<ProductOutputDto> outputDtoList = setOutputList(productOutputList);
		return outputDtoList;
	}
	
	@Override
	public List<ProductOutputDto> getProductByPrice(Double price) throws ProductNotFoundException{
		List<Product> productOutputList = productRepo.findByPrice(price);
		if(productOutputList.isEmpty()) {
			throw new ProductNotFoundException("Tum gareeb ho");
		}
		List<ProductOutputDto> outputDtoList = setOutputList(productOutputList);
		return outputDtoList;
	}
}
