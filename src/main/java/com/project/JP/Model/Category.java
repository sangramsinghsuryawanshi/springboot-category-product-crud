package com.project.JP.Model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "Cat", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Category(int id, String name, String description, List<Product> products) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.products = products;
    }

    public Category() {
        super();
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", description=" + description + ", productCount=" + (products != null ? products.size() : 0) + "]";
    }
}
