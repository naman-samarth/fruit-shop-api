package com.naman.springmvcrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CategoryDTO {

    @JsonIgnore
    public static final String BASE_URL = "api/v1/categories";

    private String name;

    @JsonProperty("category_url")
    private String categoryUrl;
}
