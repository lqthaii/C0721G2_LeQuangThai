package _16_io_binary_file_serialization.exercise;

import java.io.Serializable;

public class Product implements Serializable {
    String id;
    String name;
    String made;
    double price;
    String description;

    public Product() {
    }

    public Product(String id, String name, String made, double price, String description) {
        this.id = id;
        this.name = name;
        this.made = made;
        this.price = price;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", made='" + made + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
