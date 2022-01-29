package com.naman.springmvcrest.api.v1.controllers;

import com.naman.springmvcrest.model.CategoryDTO;
import com.naman.springmvcrest.model.CategoryListDTO;
import com.naman.springmvcrest.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/api/v1/categories"})
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryListDTO getAllCategories() {
        return new CategoryListDTO(categoryService.getAllCategories());
    }

    @GetMapping({"/{name}"})
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategoryByName(@PathVariable String name) {
        return categoryService.getCategoryByName(name);
    }


}
