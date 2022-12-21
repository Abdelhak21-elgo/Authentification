package com.learnjwt.jwt_learn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learnjwt.jwt_learn.Entity.Product;
import com.learnjwt.jwt_learn.Service.ProductService;

@RestController
public class ProductController {
    
    @Autowired
    private ProductService productService ;
    @PostMapping({"/addnewProduct"})
    public Product addProduct(@RequestBody Product product){
        return productService.addnewProduct(product);
    }
}
