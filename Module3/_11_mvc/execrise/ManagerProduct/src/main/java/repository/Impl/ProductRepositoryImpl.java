package repository.Impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements IProductRepository {
    private static Map<String, Product> products;

    static {
        products = new HashMap<>();
        products.put("1", new Product("1", "Keo Deo", 1000.0, "Keo rat chi la deo"));
        products.put("2", new Product("2", "Banh gao", 5000.0, "Banh duoc lam tu gao"));
        products.put("3", new Product("3", "Nuoc suoi", 4000.0, "Nuoc Tinh Khiet"));
        products.put("4", new Product("4", "Pepsi", 10000.0, "pepsi khong calo"));
        products.put("5", new Product("5", "Keo cung", 2000.0, "keo cung"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(String id) {
        return products.get(id);
    }

    @Override
    public void update(String id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(String id) {
        products.remove(id);
    }
}
