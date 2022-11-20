package com.simplilearn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplilearn.entity.Product;
import com.simplilearn.service.ProductService;

@Controller
@RequestMapping("/company")
public class ProductController {

	@Autowired
	ProductService productservice;
	
	@RequestMapping("/product")
	public String getAllProduct(Model model){
		List<Product> product=productservice.getAllProducts();
		model.addAttribute("product", product);
		System.out.println(product);
		return "index";
	}
	
	@GetMapping("/addProduct")
	public String addProduct(Model model) {
		Product theProduct=new Product();
		model.addAttribute("product", theProduct);
	
		return "product";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product theProduct) {
		productservice.saveProduct(theProduct);
		System.out.println("theProduct"+theProduct.getProductName());
		return "redirect:/company/product";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productId")int productId,Model model) {
		Optional<Product> product=productservice.getProductById(productId);
		model.addAttribute("product", product);
		return "product";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("productId")int productId) {
		productservice.delete(productId);
		return "redirect:/company/product";
	}
	
}
