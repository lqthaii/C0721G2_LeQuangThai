package advance.oop_person;

import java.util.Scanner;

public class ManagerSchool {
    static Scanner sc = new Scanner(System.in);
    // Khai báo Scanner
    private static Person[] studentList = new Person[0];
    private static Person[] teacherList = new Person[0];
    // Khai báo mảng Person
    static String id,name, classes, address, conduct, classification;
    static double salary;
    static int age;

    public static void inputDataStudent(){
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
    }
    public static void inputDataTeacher(){
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
        salary = sc.nextDouble();
    }
    public static void addStudent() {
        inputDataStudent();
        Person[] addSV = new Person[studentList.length + 1];
        for (int i = 0; i < studentList.length; i++) {
            addSV[i] = studentList[i];
        }
        Student student = new Student(id,name, age, address, conduct, classification, classes);
        addSV[addSV.length - 1] = student;
        studentList = addSV;
    }

    public static void displayStudent() {
        for (int i = 0; i < studentList.length; i++) {
            System.out.println(((Student) studentList[i]).display());
        }
    }
    public static void addTeacher() {
        inputDataStudent();
        Person[] addTC = new Person[teacherList.length + 1];
        for (int i = 0; i < teacherList.length; i++) {
            addTC[i] = teacherList[i];
        }
        Teacher teacher = new Teacher(id,name,age,address,classes,salary);
        addTC[addTC.length - 1] = teacher;
        teacherList = addTC;
    }

    public static void displayTeacher() {
        for (int i = 0; i < teacherList.length; i++) {
            System.out.println(((Teacher) teacherList[i]).display());
        }
    }
    public static void searchStudent(){
        String inputid;
        System.out.println("Vui lòng nhập vào id học sinh cần tìm:");
        inputid = sc.nextLine();
        //System.out.println(((Student)studentList[1]).getId());
        for(int i=0;i<studentList.length;i++){
            if((((Student)studentList[i]).getId()).equals(inputid)){
                System.out.println(((Student) studentList[i]).display());
            }
        }
    }
    public static void searchTeacher(){
        String inputid;
        System.out.println("Vui lòng nhập vào id giáo viên cần tìm:");
        inputid = sc.nextLine();
        for(int i=0;i<teacherList.length;i++){
            if((((Teacher)teacherList[i]).getId()).equals(inputid)){
                System.out.println(((Teacher) teacherList[i]).display());
            }
        }
    }
}
