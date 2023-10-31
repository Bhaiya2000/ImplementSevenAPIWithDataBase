package com.anand.implementsevenapiwithdatabase.repositories;

import com.anand.implementsevenapiwithdatabase.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SelfCategoryRepository extends JpaRepository<Category, Long> {

}
