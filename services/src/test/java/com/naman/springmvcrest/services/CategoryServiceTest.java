package com.naman.springmvcrest.services;

import com.naman.springmvcrest.domain.Category;
import com.naman.springmvcrest.mapper.CategoryMapper;
import com.naman.springmvcrest.model.CategoryDTO;
import com.naman.springmvcrest.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CategoryServiceTest {

    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Mock
    CategoryRepository categoryRepository;

    CategoryService categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        categoryService = new CategoryServiceImpl(categoryMapper, categoryRepository);
    }

    @Test
    void getAllCategories() {

        List<Category> categories = Arrays.asList(new Category(), new Category(), new Category());

        when(categoryRepository.findAll()).thenReturn(categories);

        List<CategoryDTO> categoryDTOS = categoryService.getAllCategories();

        assertEquals(3, categoryDTOS.size());
    }

    @Test
    void getCategoryByName() {

        Category category = new Category();
        category.setId(1L);
        category.setName("Fruits");

        when(categoryRepository.findByName("Fruits")).thenReturn(category);

        CategoryDTO categoryDTO = categoryService.getCategoryByName("Fruits");

        assertEquals("Fruits", categoryDTO.getName());
    }
}