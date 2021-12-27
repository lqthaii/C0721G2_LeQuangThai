package com.codegym.service.Impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.repository.Impl.ProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service(value = "productSv")
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(String id, Product product) {
        productRepository.update(id,product);
    }

    @Override
    public void remove(String id) {
         productRepository.remove(id);
    }
}
