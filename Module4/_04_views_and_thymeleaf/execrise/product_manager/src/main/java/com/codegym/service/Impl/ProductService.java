package com.codegym.service.Impl;

import com.codegym.model.Product;
import com.codegym.service.IProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private static final List<Product> products;

    static{
        products = new ArrayList<>();
        products.add(new Product("1","Bánh",10000,"Bánh này ăn rất ngon"));
        products.add(new Product("2","Bánh kẹo",123000,"Bánh này ăn rất ngon"));
        products.add(new Product("3","Kẹo dẻo",1600,"Bánh này ăn rất ngon"));
        products.add(new Product("4","Socola",12000,"Bánh này ăn rất ngon"));
        products.add(new Product("5","Nước ngọt",10000,"Bánh này ăn rất ngon"));
        products.add(new Product("6","Sting",12000,"Bánh này ăn rất ngon"));
        products.add(new Product("7","Revice",15000,"Bánh này ăn rất ngon"));
    }
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(String id) {
        for (Product product: products) {
            if(product.getId().equals(id))
                return product;
        }
        return null;
    }

    @Override
    public void update(String id, Product product) {
        for(int i=0;i<products.size();i++){
            if(id.equals(products.get(i).getId())){
                products.get(i).setId(product.getId());
                products.get(i).setName(product.getName());
                products.get(i).setPrice(product.getPrice());
                products.get(i).setDescription(product.getDescription());
            }
        }
    }

    @Override
    public void remove(String id) {
         for(int i=0;i<products.size();i++){
             if(id.equals(products.get(i).getId())){
                 products.remove(i);
             }
         }
    }
}
