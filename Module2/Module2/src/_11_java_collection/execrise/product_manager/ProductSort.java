package _11_java_collection.execrise.product_manager;

import java.util.Comparator;

public class ProductSort implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return (int) o1.getId().compareTo(o2.getId());
    }
}
