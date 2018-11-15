package com.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.booking.dto.CategoryDto;
import com.booking.service.CategoryService;
import com.booking.service.ProductService;

@Controller
@RequestMapping("/")
public class HomeController {

	private CategoryService categoryService;
	private ProductService productService;
	
	@Autowired
	public HomeController(CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}
	
	@GetMapping
	public String mvHome(Model model) {
		List<CategoryDto> categoryList = categoryService.selectAll();
		
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("productCount", categoryService.getTotalCount(categoryList));
		model.addAttribute("productList", productService.selectAll(0));
		
		return "main";
	}
}