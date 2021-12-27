package com.codegym.repository.Impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @Override
    public List<Product> findAll() {
        List<Product> products = BaseRepository.entityManager.createQuery("select p from product p",Product.class).getResultList();
        return products;
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(String id) {
        return null;
    }

    @Override
    public void update(String id, Product product) {

    }

    @Override
    public void remove(String id) {

    }
}
