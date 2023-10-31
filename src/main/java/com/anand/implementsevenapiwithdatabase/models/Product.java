package com.anand.implementsevenapiwithdatabase.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name ="category")
    private Category category;
    private double price;
}
