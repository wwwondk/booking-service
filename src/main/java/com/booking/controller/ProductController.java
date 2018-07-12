package com.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.booking.service.ProductService;

@Controller
@RequestMapping("/product-detail")
public class ProductController {
	
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
    @GetMapping("/{productId:[\\d]+}")
    public String detail(Model model, @PathVariable int productId) {
    	model.addAttribute("product", productService.selectProductDetail(productId));
        return "detail";
    }

}
