package _11_java_collection.execrise.product_manager;

import java.awt.*;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        ProductManager productManager = new ProductManager();
        boolean flag = true;
        do {
            System.out.println("***************Quản Lý Sản Phẩm****************");
            System.out.println("Vui lòng chọn chức năng");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Xoá sản phẩm");
            System.out.println("3. Hiển thị sản phẩm");
            System.out.println("4. Tìm kiếm sản phẩm");
            System.out.println("5. Sửa thông tin sản phẩm");
            System.out.println("6. Thoát");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    productManager.addProduct();
                    break;
                case 2:
                    productManager.deleteProduct();
                    break;
                case 3:
                    productManager.displayProduct();
                    break;
                case 4:
                    productManager.searchProduct();
                    break;
                case 5:
                    productManager.editProduct();
                    break;
                case 6:
                    flag = false;
                default:
                    System.out.println("Bạn đã nhập sai vui lòng nhập lại!");
            }
        } while (flag = true);
    }
}
