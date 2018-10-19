package com.exercise.springdemo.controller;

import com.exercise.springdemo.api.dto.ProductDTO;
import com.exercise.springdemo.api.dto.create.ProductCreateDTO;
import com.exercise.springdemo.api.dto.update.ProductUpdateDTO;
import com.exercise.springdemo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Set<ProductDTO> getAllProduct(){
        return productService.getAllProduct();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO addProduct(@RequestBody ProductCreateDTO productCreateDTO){
        return productService.createProduct(productCreateDTO);
    }

    @PatchMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO updateProduct(@RequestBody ProductUpdateDTO productUpdateDTO){
        return productService.updateProduct(productUpdateDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
        return;
    }
}
