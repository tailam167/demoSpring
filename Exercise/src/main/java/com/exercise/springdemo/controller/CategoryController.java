package com.exercise.springdemo.controller;

import com.exercise.springdemo.api.dto.CategoryDTO;
import com.exercise.springdemo.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.OutputKeys;
import java.util.Set;

@RestController
@RequestMapping({"","/category"})
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Set<CategoryDTO> getAllCaegory(){
        return categoryService.getAllCategory();
    }
}