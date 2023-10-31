package com.anand.implementsevenapiwithdatabase.services;

import com.anand.implementsevenapiwithdatabase.dtos.ProductDto;
import com.anand.implementsevenapiwithdatabase.models.Category;
import com.anand.implementsevenapiwithdatabase.models.Product;
import com.anand.implementsevenapiwithdatabase.repositories.SelfProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class SelfProductServiceImpl {
     private SelfProductRepository selfProductRepository;
     public SelfProductServiceImpl(SelfProductRepository selfProductRepository)
     {
          this.selfProductRepository = selfProductRepository;
     }
     public Product addNewProduct(Product product)
     {
           Product product1 = selfProductRepository.save(product);
           return product1;
     }
     public Product updateAProduct(Product product, Long id)
     {
         Optional<Product> productOptional = selfProductRepository.findById(id);
         Product product1 = productOptional.get();
         product1.setTitle(product.getTitle());
         product1.setPrice(product.getPrice());
         Product product2 = selfProductRepository.save(product1);
         return product2;
     }

     public void deleteAProduct(Long id){
         selfProductRepository.deleteById(id);
     }

     public Product getASingleProduct( Long id)
     {
         Optional<Product> productOptional = selfProductRepository.findById(id);
         Product product1 = productOptional.get();
         return product1;
     }

     public List<Product> getAllProduct(Long id)
     {
         return selfProductRepository.findAll();
     }
}

