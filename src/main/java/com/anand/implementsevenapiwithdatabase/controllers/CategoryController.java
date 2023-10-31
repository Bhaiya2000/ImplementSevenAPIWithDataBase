package com.anand.implementsevenapiwithdatabase.controllers;

import com.anand.implementsevenapiwithdatabase.dtos.CategoryDto;
import com.anand.implementsevenapiwithdatabase.dtos.ProductDto;
import com.anand.implementsevenapiwithdatabase.models.Category;
import com.anand.implementsevenapiwithdatabase.models.Product;
import com.anand.implementsevenapiwithdatabase.services.SelfCategoryServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CategoryController {
    private SelfCategoryServiceImpl selfCategoryService;
    public CategoryController(SelfCategoryServiceImpl selfCategoryService)
    {
        this.selfCategoryService = selfCategoryService;
    }
    @GetMapping("/categories/get")
    List<CategoryDto> getAllCategory(){
        return selfCategoryService.getAllCategory();
    }
    @GetMapping("/getinProducts/{name}")
  List<ProductDto> getProductsInCategory(@PathVariable("name") String name){
        return selfCategoryService.getProductsInCategory(name);
  }
}
