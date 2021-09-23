package _15_io_text_file.exercise.copy_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CopyFile {
    public void writeFile(String patch, boolean flag,List<String> list) {
        File file = new File(patch);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(String str : list){
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> readFile(String patch) {
        File file = new File(patch);
        String readLine = "";
        List list = new ArrayList();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((readLine = bufferedReader.readLine())!=null){
                list.add(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Lỗi đọc file");
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CopyFile copyFile = new CopyFile();
        System.out.println("Nhập đường dẫn nguồn:");
        String from = sc.nextLine();
        System.out.println("Nhập đường dẫn đích:");
        String to = sc.nextLine();
        List <String> list = new ArrayList<>();
        list = copyFile.readFile(from);
        copyFile.writeFile(to,true,list);
    }
}
