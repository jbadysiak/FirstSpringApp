package com.packt.webstore.controller;

import com.packt.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public String allProducts(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @GetMapping()
    public String list (Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @GetMapping("/product")
    public String getProductById(@RequestParam("id") String productId, Model model){
        model.addAttribute("product", productService.getProductById(productId));
        return "product";
    }

    @GetMapping("/{category}")
    public String getProductsByCategory(Model model, @PathVariable("category") String productCategory){
        model.addAttribute("products", productService.getProductsByCategory(productCategory));
        return "products";
    }

    @GetMapping("/filter/{ByCriteria}")
    public String getProductsByFilter(Model model, @MatrixVariable(pathVar = "ByCriteria")
            Map<String, List<String>> filterParams){
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        return "products";
    }
}