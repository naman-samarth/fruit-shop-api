package com.naman.springmvcrest.mapper;

import com.naman.springmvcrest.domain.Category;
import com.naman.springmvcrest.model.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(target = "categoryUrl", ignore = true)
    CategoryDTO categoryToCategoryDTO(Category category);
}
