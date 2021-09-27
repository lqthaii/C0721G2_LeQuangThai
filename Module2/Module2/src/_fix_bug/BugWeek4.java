package _fix_bug;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BugWeek4 {

    static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student(1, "John", 5.6));
        studentList.add(new Student(2, "David", 7.6));
        studentList.add(new Student(3, "Katherine", 8));
        studentList.add(new Student(4, "Sally", 2.0));
        studentList.add(new Student(5, "Banana", 7.0));
    }

    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("src/_fix_bug/data_student.csv",false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String[] str=null;
            for (Student studentObj: studentList) {
                str = studentObj.getName().split("");
                for(int i=0;i<str.length;i++){
                    if ("i".equals(str[i])) {
                        bufferedWriter.write(studentObj.toString());
                        bufferedWriter.write("\r\n");
                    }
                }
            }
        bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
