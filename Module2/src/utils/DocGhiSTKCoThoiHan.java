package utils;

import models.STKCoThoiHan;
import models.STKDaiHan;
import services.DichVuKhachHang;

import java.io.*;
import java.util.ArrayList;

public class DocGhiSTKCoThoiHan {
    public static final String PATH_STK_NGAN_HAN = "src\\data\\shortTerm.csv";
    public static ArrayList<STKCoThoiHan> readFile() {
        ArrayList<STKCoThoiHan> stkCoThoiHans = new ArrayList<>();
        try {
            File file = new File(PATH_STK_NGAN_HAN);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            String[] arr;
            while ((line = br.readLine()) != null) {
                arr = line.split(",");
                if(!arr[6].equals("")){
                    stkCoThoiHans.add(new STKCoThoiHan(arr[0],DichVuKhachHang.getKhachHang(arr[1]),arr[2],arr[3],Double.parseDouble(arr[4]),Float.parseFloat(arr[5]),Integer.parseInt(arr[6])));
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
        return stkCoThoiHans;
    }
    public static void writeFile(String filePath, ArrayList<STKCoThoiHan> stkCoThoiHans) {
        try {
            FileWriter writer = new FileWriter(filePath, false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (STKCoThoiHan stkCoThoiHan : stkCoThoiHans) {
                bufferedWriter.write(stkCoThoiHan.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
