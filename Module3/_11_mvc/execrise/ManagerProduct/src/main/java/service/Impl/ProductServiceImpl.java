package service.Impl;
import model.Product;
import repository.Impl.ProductRepositoryImpl;
import repository.IProductRepository;
import service.IProductService;

import java.util.List;
public class ProductServiceImpl implements IProductService {
    IProductRepository IProductRepository = new ProductRepositoryImpl();
    @Override
    public List<Product> findAll() {
        return IProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        IProductRepository.save(product);
    }

    @Override
    public Product findById(String id) {
        return IProductRepository.findById(id);
    }

    @Override
    public void update(String id, Product product) {
        IProductRepository.update(id,product);
    }

    @Override
    public void remove(String id) {
        IProductRepository.remove(id);
    }
}
