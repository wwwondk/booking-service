package com.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {
    @GetMapping("/product-detail/{productId:[\\d]+}")
    public String detail(Model model, @PathVariable int productId) {
        //model.addAttribute("product", productService.getDetail(productId));
        return "detail";
    }

}
