package _16_io_binary_file_serialization.exercise;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        ManagerProduct managerProduct = new ManagerProduct();
        int choose;
        do {
            System.out.println("Manager Product System");
            System.out.println("1.Add Product");
            System.out.println("2.Display Product");
            System.out.println("3.Search Product");
            System.out.println("4.Exit");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    Product product = managerProduct.inputDataProduct();
                    try {
                        managerProduct.addProductToFile("src\\_16_io_binary_file_serialization\\exercise\\ProductManager.txt", product);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Success...");
                    break;
                case 2:
                    List<Product> list = managerProduct.displayProductFromFile("src\\_16_io_binary_file_serialization\\exercise\\ProductManager.txt");
                    for(Product product1 : list){
                        System.out.println(product1);
                    }
                    break;
                case 3:
                    System.out.println("Vui lòng nhập vào id cần tìm");
                    String id = sc.nextLine();
                    managerProduct.searchProduct("src\\_16_io_binary_file_serialization\\exercise\\ProductManager.txt",id);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("ERROR 404\tPlease input number again");
            }
        } while (true);
    }
}
