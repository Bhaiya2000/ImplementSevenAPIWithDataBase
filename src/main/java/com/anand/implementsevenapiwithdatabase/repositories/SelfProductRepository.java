package com.anand.implementsevenapiwithdatabase.repositories;

import com.anand.implementsevenapiwithdatabase.models.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.function.Function;

public interface SelfProductRepository extends JpaRepository<Product, Long> {
      Product save(Product product);


      List<Product> findByCategory_Name(String name);
}
