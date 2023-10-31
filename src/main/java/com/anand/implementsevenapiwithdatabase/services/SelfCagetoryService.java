package com.anand.implementsevenapiwithdatabase.services;

import com.anand.implementsevenapiwithdatabase.dtos.CategoryDto;
import com.anand.implementsevenapiwithdatabase.dtos.ProductDto;
import com.anand.implementsevenapiwithdatabase.models.Category;
import com.anand.implementsevenapiwithdatabase.models.Product;

import java.util.List;

public interface SelfCagetoryService {
    List<CategoryDto> getAllCategory();
    List<ProductDto> getProductsInCategory(String name);
}
