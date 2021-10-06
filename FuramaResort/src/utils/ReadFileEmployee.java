package utils;

import models.Employee;

import java.io.*;
import java.util.ArrayList;

public class ReadFileEmployee {
    public static final String PATH_EMPLOYEE = "src\\data\\employee.csv";

    public static ArrayList<Employee> readFile() {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            File file = new File(PATH_EMPLOYEE);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            String[] arr;
            while ((line = br.readLine()) != null) {
                arr = line.split(",");
                employees.add(new Employee(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], Double.parseDouble(arr[9])));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            //System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
        return employees;
    }

    public static void writeFile(String filePath, ArrayList<Employee> employees) {
        try {
            FileWriter writer = new FileWriter(filePath, false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Employee employee : employees) {
                bufferedWriter.write(employee.writeFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
