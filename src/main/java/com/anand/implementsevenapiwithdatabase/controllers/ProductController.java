package com.anand.implementsevenapiwithdatabase.controllers;
import com.anand.implementsevenapiwithdatabase.dtos.ProductDto;
import com.anand.implementsevenapiwithdatabase.models.Category;
import com.anand.implementsevenapiwithdatabase.models.Product;
import com.anand.implementsevenapiwithdatabase.services.SelfProductService;
import com.anand.implementsevenapiwithdatabase.services.SelfProductServiceImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class ProductController {
    private SelfProductServiceImpl selfProductService;
    public ProductController(SelfProductServiceImpl selfProductService)
    {
        this.selfProductService = selfProductService;
    }
    @PostMapping("/products/create")
    public Product addNewProduct(@RequestBody  ProductDto productDto)
    {
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setImage(productDto.getImage());
        Category category = new Category();
        category.setName(productDto.getCategoryDto().getName());
        product.setCategory(category);
//        product.getCategory().setName(productDto.getCategory());
        Product finalProduct =  selfProductService.addNewProduct(product);
        return finalProduct;
    }
    @PatchMapping("/products/update/{id}")
    public Product updateAProduct(@RequestBody  ProductDto productDto, @PathVariable("id") Long id)
    {
        Product product = new Product();
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        Product updatedProduct = selfProductService.updateAProduct(product,id);
        return updatedProduct;
    }
    @DeleteMapping("/products/delete/{id}")
    public void deleteAProduct(@PathVariable("id") Long id){
        selfProductService.deleteAProduct(id);
    }
    @GetMapping("/product/get/{id}")
    public Product getASingleProduct( @PathVariable("id") Long id){
//        Product product= new Product();
        return selfProductService.getASingleProduct(id);
    }
    @GetMapping("/products/getAll")
    public List<Product> getAllProduct( Long id)
    {
        return selfProductService.getAllProduct(id);
    }
}
