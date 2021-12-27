package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IProductRepository {
    List<Product> findAll();
    void save(Product product);
    Product findById(String id);
    void update(String id, Product product);
    void remove(String id);
}
