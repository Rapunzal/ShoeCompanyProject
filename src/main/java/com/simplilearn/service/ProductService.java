package com.simplilearn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Product;
import com.simplilearn.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProducts(){
		List<Product> products=new ArrayList<Product>();
		productRepository.findAll().forEach(p->products.add(p));
		return products;
	}
	
	public void saveProduct(Product product) {
		productRepository.save(product);
	}
	
	public void delete(int id) {
		productRepository.deleteById(id);
	}
	
	public Optional<Product> getProductById(int id){
		Optional<Product> p=productRepository.findById(id);
		return p;
	}
}
