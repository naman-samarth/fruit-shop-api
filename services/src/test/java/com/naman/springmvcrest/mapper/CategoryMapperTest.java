package com.naman.springmvcrest.mapper;

import com.naman.springmvcrest.domain.Category;
import com.naman.springmvcrest.model.CategoryDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryMapperTest {

    public static final Long ID = 1L;
    public static final String NAME = "Fruits";

    @Test
    void categoryToCategoryDTO() {

        CategoryMapper mapper = CategoryMapper.INSTANCE;

        Category category = new Category();
        category.setId(ID);
        category.setName(NAME);

        CategoryDTO expectedCategoryDTO = new CategoryDTO();
        expectedCategoryDTO.setId(ID);
        expectedCategoryDTO.setName(NAME);

        CategoryDTO actualCategoryDTO = mapper.categoryToCategoryDTO(category);

        assertEquals(expectedCategoryDTO, actualCategoryDTO);

    }
}