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
            if(id == null || name == null ||age ==0|| classes == null || address == null || conduct == null || classification == null){
                System.out.println("Vui lòng không bỏ trống");
            }
        }
        while (id == null || name == null || age ==0 || classes == null || address == null || conduct == null || classification == null);
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
            if(id == null || name == null || classes == null || address == null||age==0||salary==0){
                System.out.println("Vui lòng không bỏ trống");
            }
        }
        while (id == null || name == null || classes == null || address == null||age==0||salary==0);
    }

    //------------------------ADD -----------------------------------------
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
        if (isNullStudent() == -1) {
            Person[] addSV = new Person[personList.length + 1];
            for (int i = 0; i < personList.length; i++) {
                addSV[i] = personList[i];
            }
            Student student = new Student(id, name, age, address, conduct, classification, classes);
            addSV[addSV.length - 1] = student;
            personList = addSV;
        } else {
            int local = isNullStudent();
            ((Student) personList[isNullStudent()]).setInformation(id, name, age, address, conduct, classification, classes);
        }

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
        if (isNullTeacher() == -1) {
            Person[] addTC = new Person[personList.length + 1];
            for (int i = 0; i < personList.length; i++) {
                addTC[i] = personList[i];
            }
            Teacher teacher = new Teacher(id, name, age, address, classes, salary);
            addTC[addTC.length - 1] = teacher;
            personList = addTC;
        } else {
            int local = isNullStudent();
            ((Teacher) personList[isNullTeacher()]).setInformation(id, name, age, address, classes, salary);
        }

    }

    //------------------------------DISPLAY--------------------------------
    public static void displayStudent() {
        for (int i = 0; i < personList.length; i++) {
            if (personList[i] instanceof Student) {
                if (((Student) personList[i]).getId() == null) {
                    continue;
                } else {
                    ((Student) personList[i]).display();
                }
            }
        }
    }


    public static void displayTeacher() {
        for (int i = 0; i < personList.length; i++) {
            if (personList[i] instanceof Teacher) {
                if (((Teacher) personList[i]).getId() == null) {
                    continue;
                } else {
                    ((Teacher) personList[i]).display();
                }
            }
        }
    }

    //-------------------------------SEARCH--------------------------------
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
            ((Student) personList[local]).display();
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
            ((Teacher) personList[local]).display();
        }
    }

    //------------------------------ EDIT ---------------------------------
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
            ((Student) personList[local]).setInformation(id, name, age, address, conduct, classification, classes);
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

    //--------------------------------DELETE-------------------------------
    public static void deleteStudent() {
        String inputid;
        System.out.println("Vui lòng nhập vào id học sinh cần xoá:");
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
            System.out.println("Không tìm thấy giáo viên cần xoá");
        } else {
            ((Student) personList[local]).setInformation(null, null, 0, null, null, null, null);
        }
    }

    public static void deleteTeacher() {
        String inputid;
        System.out.println("Vui lòng nhập vào id giáo viên cần xoá:");
        inputid = sc.nextLine();
        boolean check = false;
        int local = 0;
        for (int i = 0; i < personList.length; i++) {
            if (personList[i] instanceof Teacher) {
                if ((((Teacher) personList[i]).getId()).equals(inputid)) {
                    check = true;
                    local = i;
                }
            }
        }
        if (!check) {
            System.out.println("Không tìm thấy giáo viên cần xoá");
        } else {
            ((Teacher) personList[local]).setInformation(null, null, 0, null, null, 0);
        }
    }
    //------------------------------Check null-----------------------------
    public static int isNullStudent() {
        for (int i = 0; i < personList.length; i++) {
            if (personList[i] instanceof Student) {
                if ((((Student) personList[i]).getId()).equals(null)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int isNullTeacher() {
        for (int i = 0; i < personList.length; i++) {
            if (personList[i] instanceof Teacher) {
                if ((((Teacher) personList[i]).getId()).equals(null)) {
                    return i;
                }
            }
        }
        return -1;
    }
}



