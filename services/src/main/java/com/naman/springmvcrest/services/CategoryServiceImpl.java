package com.naman.springmvcrest.services;

import com.naman.springmvcrest.domain.Category;
import com.naman.springmvcrest.mapper.CategoryMapper;
import com.naman.springmvcrest.model.CategoryDTO;
import com.naman.springmvcrest.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryMapper categoryMapper,
                               CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> {
                    CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);
                    categoryDTO.setCategoryUrl(CategoryDTO.BASE_URL + "/" + category.getId());
                    return categoryDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        Category category = categoryRepository.findByName(name);
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);
        categoryDTO.setCategoryUrl(CategoryDTO.BASE_URL + "/" + category.getId());
        return categoryDTO;
    }
}
