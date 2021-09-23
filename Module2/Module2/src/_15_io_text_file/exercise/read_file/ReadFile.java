package _15_io_text_file.exercise.read_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class ReadFile {
    public TreeMap readFile(String patch) {
        TreeMap<String, QuocGia> value = new TreeMap();
        String str ="";
        String [] arr = new String[2];
        File file = new File(patch);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((str = bufferedReader.readLine())!=null){
             arr = str.split(",");
             QuocGia quocGia = new QuocGia(Integer.parseInt(arr[0]),arr[1],arr[2]);
             value.put(arr[1],quocGia);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Lỗi đọc file");
        }
        return value;
    }

    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        TreeMap<String, QuocGia> value = new TreeMap();
        value = readFile.readFile("src\\_15_io_text_file\\exercise\\read_file\\QuocGia.csv");
        for(String quocGia : value.keySet()){
            System.out.println(value.get(quocGia));
        }
    }
}
