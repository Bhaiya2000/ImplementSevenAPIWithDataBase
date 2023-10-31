package com.anand.implementsevenapiwithdatabase.services;

import com.anand.implementsevenapiwithdatabase.dtos.CategoryDto;
import com.anand.implementsevenapiwithdatabase.dtos.ProductDto;
import com.anand.implementsevenapiwithdatabase.models.Category;
import com.anand.implementsevenapiwithdatabase.models.Product;
import com.anand.implementsevenapiwithdatabase.repositories.SelfCategoryRepository;
import com.anand.implementsevenapiwithdatabase.repositories.SelfProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SelfCategoryServiceImpl {
    private SelfCategoryRepository selfCagetoryRepository;
    private SelfProductRepository selfProductRepository;
    public SelfCategoryServiceImpl(SelfCategoryRepository selfCagetoryRepository, SelfProductRepository selfProductRepository)
    {
        this.selfCagetoryRepository = selfCagetoryRepository;
        this.selfProductRepository = selfProductRepository;
    }
    public List<CategoryDto> getAllCategory()
    {

        List<Category> list=  selfCagetoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for(int i =0; i<list.size(); i++)
        {
            CategoryDto categoryDto = new CategoryDto();
            Category category = list.get(i);
            categoryDto.setName(category.getName());
            categoryDto.setDescription(category.getDescription());
            categoryDtos.add(categoryDto);
        }
        return categoryDtos;
    }
     public List<ProductDto> getProductsInCategory(String name)
    {
        List<Product> list = selfProductRepository.findByCategory_Name(name);
        List<ProductDto> list2 = new ArrayList<>();
        for(int i =0; i<list.size(); i++) {
            ProductDto productDto = new ProductDto();
            Product product = list.get(i);
            CategoryDto categoryDto = new CategoryDto();
            Category category = product.getCategory();
            categoryDto.setName(category.getName());
            categoryDto.setDescription(category.getDescription());
            productDto.setCategoryDto(categoryDto);
            productDto.setTitle(product.getTitle());
            productDto.setDescription(product.getDescription());
            productDto.setPrice(product.getPrice());
            productDto.setImage(product.getImage());
            productDto.setId(product.getId());
            list2.add(productDto);
        }
        return list2;
    }
}


/// need to  start implement Category again