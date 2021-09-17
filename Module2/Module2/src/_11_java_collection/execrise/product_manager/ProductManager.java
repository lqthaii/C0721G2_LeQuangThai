package _11_java_collection.execrise.product_manager;

import java.util.*;

public class ProductManager {
    //Scanner sc = new Scanner(System.in);
    HashMap<String, Product> productList = new HashMap<>();

    public Product inputProduct() {
        Main.sc.nextLine();
        System.out.println("Nhập ID Sản Phẩm:");
        String id = Main.sc.nextLine();
        System.out.println("Nhập Tên Sản Phẩm:");
        String name = Main.sc.nextLine();
        System.out.println("Nhập giá của sản phẩm:");
        double price = Main.sc.nextDouble();
        return new Product(id, name, price);
    }

    public void addProduct() {
        Product product = inputProduct();
        productList.put(product.getId(), product);
    }

    public void displayProduct() {
        System.out.println("Danh sách sản phẩm:");
        for (Product product : productList.values()) {
            System.out.println(product);
        }
    }

    public void deleteProduct() {
        Main.sc.nextLine();
        System.out.println("Vui lòng nhập vào ID sản phẩm cần xoá:");
        String id = Main.sc.nextLine();
        if (isID(id, productList)) {
            System.out.println("Đã xoá thành công sản phẩm" + productList.get(id).getName());
            productList.remove(id);
        } else {
            System.out.println("Không tìm thấy phần tử cần xoá");
        }
    }

    public void searchProduct() {
        Main.sc.nextLine();
        System.out.println("Vui lòng nhập ID sản phẩm cần tìm:");
        String id = Main.sc.nextLine();
        if (!isID(id, productList)) {
            System.out.println("Không tìm thấy phần tử cần xoá");
        } else {
            System.out.println(productList.get(id));
        }
    }

    public void editProduct() {
        Main.sc.nextLine();
        System.out.println("Vui lòng nhập ID sản phẩm cần sửa:");
        String id = Main.sc.nextLine();
        if (!isID(id, productList)) {
            System.out.println("Không tìm thấy phần tử cần sửa");
        } else {
            System.out.println("Vui lòng nhập thông tin mới:");
            Product product = inputProduct();
            for (String keyProduct : productList.keySet()) {
                if (keyProduct.equals(id)) {
                    productList.remove(keyProduct);
                    productList.put(product.getId(), product);
                    System.out.println("Đã cập nhật mới thành công ^^");
                    break;
                }
            }
        }
    }

    private boolean isID(String id, Map<String, Product> productList) {
        for (String idProduct : productList.keySet()) {
            if (id.equals(idProduct)) {
                return true;
            }
        }
        return false;
    }
}
