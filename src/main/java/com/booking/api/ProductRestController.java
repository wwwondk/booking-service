package com.booking.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.dto.ProductDto;
import com.booking.service.ProductService;

@RestController
@RequestMapping("/categories")
public class ProductRestController {

	private ProductService productService;
	
	@Autowired
	public ProductRestController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/{id}/products")
	public List<ProductDto> getList(@PathVariable("id") int categoryId, @RequestParam int page) {
		return productService.getList(categoryId, page);
	}
}
