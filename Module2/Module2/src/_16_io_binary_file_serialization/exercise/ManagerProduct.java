package _16_io_binary_file_serialization.exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerProduct {
    List<Product> list = new ArrayList<>();
    public void addProductToFile(String patch, Product product) throws IOException  {
        FileOutputStream fo = null;
        list.add(product);
        try {
            fo = new FileOutputStream(patch);
            ObjectOutputStream os = new ObjectOutputStream(fo);
            os.writeObject(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Product inputDataProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input ID:");
        String id = sc.nextLine();
        System.out.println("Input Name:");
        String name = sc.nextLine();
        System.out.println("Input Made:");
        String made = sc.nextLine();
        System.out.println("Input Price:");
        double price = Double.parseDouble(sc.nextLine());
        System.out.println("Input Description:");
        String description = sc.nextLine();
        return new Product(id, name, made, price, description);
    }
    public List<Product> displayProductFromFile(String patch){
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream fi = new FileInputStream(patch);
            ObjectInputStream oi = new ObjectInputStream(fi);
              products = (List<Product>)oi.readObject();
              fi.close();
              oi.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }
    public void searchProduct(String patch, String id){
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream fi = new FileInputStream(patch);
            ObjectInputStream oi = new ObjectInputStream(fi);
            products = (List<Product>)oi.readObject();
            fi.close();
            oi.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for(Product product:list){
            if(product.getId().equals(id)){
                System.out.println(product);
            }
        }
    }
}
