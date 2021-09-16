package advance.oop_person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ManagerSchool {
    static Scanner sc = new Scanner(System.in);
    // Khai báo Scanner
    private static List<Person> studentList = new ArrayList<>();
    private static List<Person> teacherList = new ArrayList<>();

    // Khai báo list mảng Person
    static String id, name, classes, address, conduct, classification;
    static double salary;
    static int age;

    //------------------INPUT DATA ---------------------------------------
    public static void inputDataStudent() {
        boolean flag = true;
        do {
            System.out.print("ID:");
            id = sc.nextLine();
            System.out.print("Tên:");
            name = sc.nextLine();
            System.out.print("Tuổi:");
            age = Integer.parseInt(sc.nextLine());
            System.out.print("Lớp:");
            classes = sc.nextLine();
            System.out.print("Địa chỉ:");
            address = sc.nextLine();
            System.out.print("Hạnh kiểm:");
            conduct = sc.nextLine();
            System.out.print("Học lực:");
            classification = sc.nextLine();
            if (id == null || name == null || age == 0 || classes == null || address == null || conduct == null || classification == null) {
                System.out.println("Vui lòng không bỏ trống");
            }
        }
        while (id == null || name == null || age == 0 || classes == null || address == null || conduct == null || classification == null);
    }

    public static void inputDataTeacher() {
        do {
            System.out.print("ID:");
            id = sc.nextLine();
            System.out.print("Tên:");
            name = sc.nextLine();
            System.out.print("Tuổi:");
            age = Integer.parseInt(sc.nextLine());
            System.out.print("Lớp:");
            classes = sc.nextLine();
            System.out.print("Địa chỉ:");
            address = sc.nextLine();
            System.out.print("Lương cơ bản:");
            salary = Double.parseDouble(sc.nextLine());
            if (id == null || name == null || classes == null || address == null || age == 0 || salary == 0) {
                System.out.println("Vui lòng không bỏ trống");
            }
        }
        while (id == null || name == null || classes == null || address == null || age == 0 || salary == 0);
    }

    //------------------------ADD -----------------------------------------
    public static void addStudent() {
        boolean check = false;
        do {
            inputDataStudent();
            for (int i = 0; i < studentList.size(); i++) {
                if ((((Student) studentList.get(i)).getId()).equals(id)) {
                    check = true;
                    break;
                } else {
                    check = false;
                }
            }
            if (check) {
                System.out.println("Trùng ID Sinh Viên, Vui lòng nhập lại");
            }
        } while (check);
        /*
         *
         * Kiểm tra ID của sinh viên mới nhập vào có trùng id của sinh viên có sẵn không?
         */
        Student student = new Student(id, name, age, address, conduct, classification, classes);
        studentList.add(student);
    }

    public static void addTeacher() {
        boolean check = false;
        do {
            inputDataTeacher();
            for (int i = 0; i < teacherList.size(); i++) {
                if ((((Teacher) teacherList.get(i)).getId()).equals(id)) {
                    check = true;
                    break;
                } else {
                    check = false;
                }
            }
            if (check) {
                System.out.println("Trùng ID Giáo Viên, Vui lòng nhập lại");
            }
        }
        while (check);
        /*
         *
         * Kiểm tra ID của giáo viên mới nhập vào có trùng id của sinh viên có sẵn không?
         */
        Teacher teacher = new Teacher(id, name, age, address, classes, salary);
        teacherList.add(teacher);
    }

    //------------------------------DISPLAY--------------------------------
    public static void displayStudent() {
        for(int i=0;i<studentList.size();i++){
            ((Student)studentList.get(i)).display();
        }
    }


    public static void displayTeacher() {
        for(int i=0;i<teacherList.size();i++){
            ((Teacher) teacherList.get(i)).display();
        }
    }

    //-------------------------------SEARCH--------------------------------
    public static void searchStudent() {
        String inputid;
        System.out.println("Vui lòng nhập vào id học sinh cần tìm:");
        inputid = sc.nextLine();
        boolean check = false;
        int local = 0;
        for (int i = 0; i < studentList.size(); i++) {
                if ((((Student) studentList.get(i)).getId()).equals(inputid)) {
                    check = true;
                    local = i;
                }
        }
        if (!check) {
            System.out.println("Không tìm thấy giáo viên cần sửa");
        } else {
            ((Student) studentList.get(local)).display();
        }
    }

    public static void searchTeacher() {
        String inputid;
        System.out.println("Vui lòng nhập vào id giáo viên cần tìm:");
        inputid = sc.nextLine();
        boolean check = false;
        int local = 0;
        for (int i = 0; i < teacherList.size(); i++) {
            if ((((Student) teacherList.get(i)).getId()).equals(inputid)) {
                check = true;
                local = i;
            }
        }
        if (!check) {
            System.out.println("Không tìm thấy giáo viên cần sửa");
        } else {
            ((Teacher) teacherList.get(local)).display();
        }
    }

    //------------------------------ EDIT ---------------------------------
    public static void editStudent() {
        String inputid;
        System.out.println("Vui lòng nhập vào id học sinh cần tìm:");
        inputid = sc.nextLine();
        int local = 0;
        boolean check = false;
        for (int i = 0; i < studentList.size(); i++) {
            if ((((Student) studentList.get(i)).getId()).equals(inputid)) {
                    local = i;
                    check = true;
                    break;
                }
        }
        if (check) {
            boolean flag = true;
            do {
                System.out.println("Vui lòng nhập thông tin sinh viên");
                inputDataStudent();
                for (int i = 0; i < studentList.size(); i++) {
                        if ((((Student) studentList.get(i)).getId()).equals(id)) {
                            flag = true;
                            break;
                        } else {
                            flag = false;
                        }
                }
                if (flag) {
                    System.out.println("Trùng ID Sinh Viên, Vui lòng nhập lại");
                }
            }
            while (flag);
            /*
            * Kiểm tra sinh viên cần sửa có tồn tại trong mảng không
            *
            * */
            Student student = new Student(id, name, age, address, conduct, classification, classes);
            studentList.set(local,student);
        }
    }

    public static void editTeacher() {
        String inputid;
        System.out.println("Vui lòng nhập vào id giáo viên cần tìm:");
        inputid = sc.nextLine();
        int local = 0;
        boolean check = false;
        for (int i = 0; i < teacherList.size(); i++) {
            if ((((Teacher) teacherList.get(i)).getId()).equals(inputid)) {
                local = i;
                check = true;
                break;
            }
        }
        if (check) {
            boolean flag = true;
            do {
                System.out.println("Vui lòng nhập thông tin sinh viên");
                inputDataTeacher();
                for (int i = 0; i < teacherList.size(); i++) {
                    if ((((Teacher) teacherList.get(i)).getId()).equals(id)) {
                        flag = true;
                        break;
                    } else {
                        flag = false;
                    }
                }
                if (flag) {
                    System.out.println("Trùng ID Sinh Viên, Vui lòng nhập lại");
                }
            }
            while (flag);
            /*
             * Kiểm tra sinh viên cần sửa có tồn tại trong mảng không
             *
             * */
            Teacher teacher = new Teacher(id, name, age, address, classes, salary);
            teacherList.set(local,teacher);
        }
    }

    //--------------------------------DELETE-------------------------------
    public static void deleteStudent() {
        String inputid;
        System.out.println("Vui lòng nhập vào id học sinh cần xoá:");
        inputid = sc.nextLine();
        boolean check = false;
        int local = 0;
        for (int i = 0; i < studentList.size(); i++) {
                if ((((Student) studentList.get(i)).getId()).equals(inputid)) {
                    check = true;
                    local = i;
                }
        }
        if (!check) {
            System.out.println("Không tìm thấy học sinh cần xoá");
        } else {
            studentList.remove(local);
        }
    }

    public static void deleteTeacher() {
        String inputid;
        System.out.println("Vui lòng nhập vào id giáo viên cần xoá:");
        inputid = sc.nextLine();
        boolean check = false;
        int local = 0;
        for (int i = 0; i < teacherList.size(); i++) {
                if ((((Teacher) teacherList.get(i)).getId()).equals(inputid)) {
                    check = true;
                    local = i;
                }
        }
        if (!check) {
            System.out.println("Không tìm thấy giáo viên cần xoá");
        } else {
            teacherList.remove(local);
        }
    }

}



