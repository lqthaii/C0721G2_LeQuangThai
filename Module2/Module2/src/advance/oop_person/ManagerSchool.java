package advance.oop_person;

import java.util.Scanner;

public class ManagerSchool {
    static Scanner sc = new Scanner(System.in);
    // Khai báo Scanner
    private static Person[] personList = new Person[0];
    // Khai báo mảng Person
    static String id, name, classes, address, conduct, classification;
    static double salary;
    static int age;

    //------------------INPUT DATA ------------------------------------
    public static void inputDataStudent() {
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

    public static void inputDataTeacher() {
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

    //------------------------ADD --------------------------------
    public static void addStudent() {
        boolean check = false;
        do {
            inputDataStudent();
            for (int i = 0; i < personList.length; i++) {
                if (personList[i] instanceof Student) {
                    if ((((Student) personList[i]).getId()).equals(id)) {
                        check = true;
                        break;
                    } else {
                        check = false;
                    }
                }
            }
            if (check) {
                System.out.println("Trùng ID Sinh Viên, Vui lòng nhập lại");
            }
        }
        while (check);
        Person[] addSV = new Person[personList.length + 1];
        for (int i = 0; i < personList.length; i++) {
            addSV[i] = personList[i];
        }
        Student student = new Student(id, name, age, address, conduct, classification, classes);
        addSV[addSV.length - 1] = student;
        personList = addSV;
    }

    public static void addTeacher() {
        boolean check = false;
        do {
            inputDataTeacher();
            for (int i = 0; i < personList.length; i++) {
                if (personList[i] instanceof Teacher) {
                    if ((((Teacher) personList[i]).getId()).equals(id)) {
                        check = true;
                        break;
                    } else {
                        check = false;
                    }
                }
            }
            if (check) {
                System.out.println("Trùng ID Giáo Viên, Vui lòng nhập lại");
            }
        }
        while (check);
        Person[] addTC = new Person[personList.length + 1];
        for (int i = 0; i < personList.length; i++) {
            addTC[i] = personList[i];
        }
        Teacher teacher = new Teacher(id, name, age, address, classes, salary);
        addTC[addTC.length - 1] = teacher;
        personList = addTC;
    }

    //------------------------------DISPLAY--------------------------------
    public static void displayStudent() {
        for (int i = 0; i < personList.length; i++) {
            if (personList[i] instanceof Student) {
                System.out.println(((Student) personList[i]).display());
            }
        }
    }


    public static void displayTeacher() {
        for (int i = 0; i < personList.length; i++) {
            if (personList[i] instanceof Teacher) {
                System.out.println(((Teacher) personList[i]).display());
            }
        }
    }

    //-------------------------------SEARCH----------------------------------
    public static void searchStudent() {
        String inputid;
        System.out.println("Vui lòng nhập vào id học sinh cần tìm:");
        inputid = sc.nextLine();
        boolean check = false;
        int local = 0;
        for (int i = 0; i < personList.length; i++) {
            if (personList[i] instanceof Student) {
                if ((((Student) personList[i]).getId()).equals(inputid)) {
                    check = true;
                    local = i;
                }
            }
        }
        if (!check) {
            System.out.println("Không tìm thấy giáo viên cần sửa");
        } else {
            System.out.println(((Student) personList[local]).display());
        }
    }

    public static void searchTeacher() {
        String inputid;
        System.out.println("Vui lòng nhập vào id giáo viên cần tìm:");
        inputid = sc.nextLine();
        boolean check = false;
        int local = 0;
        for (int i = 0; i < personList.length; i++) {
            if (personList[i] instanceof Teacher) {
                if ((((Teacher) personList[i]).getId()).equals(inputid)) {
                    local = i;
                    check = true;
                }
            }
        }
        if (!check) {
            System.out.println("Không tìm thấy giáo viên cần sửa");
        } else {
            System.out.println(((Teacher) personList[local]).display());
        }
    }

    //------------------------------ EDIT ------------------------------------
    public static void editStudent() {
        String inputid;
        System.out.println("Vui lòng nhập vào id học sinh cần tìm:");
        inputid = sc.nextLine();
        int local = 0;
        boolean check = false;
        for (int i = 0; i < personList.length; i++) {
            if (personList[i] instanceof Student) {
                if ((((Student) personList[i]).getId()).equals(inputid)) {
                    local = i;
                    check = true;
                    break;
                }
            }
        }
        if (check) {
            boolean flag = true;
            ((Student) personList[local]).setId(null);
            do {
                System.out.println("Vui lòng nhập thông tin sinh viên");
                inputDataStudent();
                for (int i = 0; i < personList.length; i++) {
                    if (personList[i] instanceof Student) {
                        if ((((Student) personList[i]).getId()).equals(id)) {
                            flag = true;
                            break;
                        } else {
                            flag = false;
                        }
                    }
                }
                if (flag) {
                    System.out.println("Trùng ID Sinh Viên, Vui lòng nhập lại");
                }
            }
            while (flag);
            ((Student) personList[local]).setId(id);
            ((Student) personList[local]).setName(name);
            ((Student) personList[local]).setAge(age);
            ((Student) personList[local]).setAddress(address);
            ((Student) personList[local]).setConduct(conduct);
            ((Student) personList[local]).setClasses(classes);
            ((Student) personList[local]).setClassification(classification);
        }
    }
    public static void editTeacher() {
        String inputid;
        System.out.println("Vui lòng nhập vào id học sinh cần tìm:");
        inputid = sc.nextLine();
        int local = 0;
        boolean check = false;
        for (int i = 0; i < personList.length; i++) {
            if (personList[i] instanceof Teacher) {
                if ((((Teacher) personList[i]).getId()).equals(inputid)) {
                    local = i;
                    check = true;
                    break;
                }
            }
        }
        if (check) {
            boolean flag = true;
            ((Teacher) personList[local]).setId(null);
            do {
                System.out.println("Vui lòng nhập thông tin sinh viên");
                inputDataTeacher();
                for (int i = 0; i < personList.length; i++) {
                    if (personList[i] instanceof Teacher) {
                        if ((((Teacher) personList[i]).getId()).equals(id)) {
                            flag = true;
                            break;
                        } else {
                            flag = false;
                        }
                    }
                }
                if (flag) {
                    System.out.println("Trùng ID Sinh Viên, Vui lòng nhập lại");
                }
            }
            while (flag);
            ((Teacher) personList[local]).setId(id);
            ((Teacher) personList[local]).setName(name);
            ((Teacher) personList[local]).setAge(age);
            ((Teacher) personList[local]).setAddress(address);
            ((Teacher) personList[local]).setClasses(classes);
            ((Teacher) personList[local]).setSalary(salary);
        }
    }
}



