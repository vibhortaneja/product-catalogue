package com.sapient.productCatalogue.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_details_entity")
public class Product {
	@Id
	@GeneratedValue(generator = "product_details_seq")
	@GenericGenerator(name = "product_details_seq", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequence_name", value = "product_details_entity_id_seq"),
			@org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "productname")
	private String productName;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "size")
	private int size;
	
}
