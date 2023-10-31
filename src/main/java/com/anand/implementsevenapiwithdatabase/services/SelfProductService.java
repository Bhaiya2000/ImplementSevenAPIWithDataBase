package com.anand.implementsevenapiwithdatabase.services;

import com.anand.implementsevenapiwithdatabase.dtos.ProductDto;
import com.anand.implementsevenapiwithdatabase.models.Product;

import java.util.List;

public interface SelfProductService {
        Product addNewProduct(Product product);
        Product updateAProduct(Product product, Long id);
        public void deleteAProduct( Long id);
        Product getaSingleProduct(Long id);
        List<Product> getAllProduct(Long id);
}
