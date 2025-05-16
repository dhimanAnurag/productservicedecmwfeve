package com.scaler.productservicedecmwfeve.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    @OneToMany(mappedBy = "category") // being already mapped the attribute called category
    private List<Product> products;
    private String name;

//    public String getName() {
//        System.out.println( userName + " has called this method.");
//        System.out.println("nothi");
//    }
}

// categories
// name | base_model_id

// basemodels
// id | created_at | last_updated_at | is_deleted
