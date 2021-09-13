package advance.oop_person;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Menu();
    }

    public static void nhap(String str) {
        System.out.println(str);
    }

    public static void Menu() {
        boolean flag = true;
        int choose, choose1;
        while (flag) {
            nhap("-----------------------------------------");
            nhap("|Vui lòng chọn chức năng:                |");
            nhap("|1. Thêm                                 |");
            nhap("|2. Xoá                                  |");
            nhap("|3. Sửa                                  |");
            nhap("|4. Tìm kiếm                             |");
            nhap("|5. Hiển thị                             |");
            nhap("|6. Thoát                                |");
            nhap("-----------------------------------------");
            System.out.print("Chọn: ");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1: {
                    do {
                        nhap("Vui lòng chọn đối tượng muốn thêm");
                        nhap("1. Sinh Viên");
                        nhap("2. Giáo Viên");
                        nhap("3. Quay lại");
                        nhap("Chọn:");
                        choose1 = Integer.parseInt(sc.nextLine());
                    } while (choose1 < 1 || choose1 > 3);
                    if (choose1 == 1) {
                        ManagerSchool.addStudent();
                    } else if (choose1 == 2) {
                        ManagerSchool.addTeacher();
                    } else {
                        break;
                    }
                    break;
                }
                case 2:
                {
                    do {
                        nhap("Vui lòng chọn đối tượng muốn xoá");
                        nhap("1. Sinh Viên");
                        nhap("2. Giáo Viên");
                        nhap("3. Quay lại");
                        nhap("Chọn:");
                        choose1 = Integer.parseInt(sc.nextLine());
                    } while (choose1 < 1 || choose1 > 3);
                    if (choose1 == 1) {
                        ManagerSchool.deleteStudent();
                    } else if (choose1 == 2) {
                        ManagerSchool.deleteTeacher();
                    } else {
                        break;
                    }
                    break;
                }
                case 3: {
                    do {
                        nhap("Vui lòng chọn đối tượng muốn sửa");
                        nhap("1. Sinh Viên");
                        nhap("2. Giáo Viên");
                        nhap("3. Quay lại");
                        nhap("Chọn:");
                        choose1 = Integer.parseInt(sc.nextLine());
                    } while (choose1 < 1 || choose1 > 3);
                    if (choose1 == 1) {
                        ManagerSchool.editStudent();
                    } else if (choose1 == 2) {
                        ManagerSchool.editTeacher();
                    } else {
                        break;
                    }
                    break;
                }
                case 4: {
                    do {
                        nhap("Vui lòng chọn đối tượng muốn tìm kiếm");
                        nhap("1. Sinh Viên");
                        nhap("2. Giáo Viên");
                        nhap("3. Quay lại");
                        nhap("Chọn:");
                        choose1 = Integer.parseInt(sc.nextLine());
                    } while (choose1 < 1 || choose1 > 3);
                    if (choose1 == 1) {
                        ManagerSchool.searchStudent();
                    } else if (choose1 == 2) {
                        ManagerSchool.searchTeacher();
                    } else {
                        break;
                    }
                    break;
                }
                case 5: {
                    do {
                        nhap("Vui lòng chọn đối tượng muốn hiển thị");
                        nhap("1. Sinh Viên");
                        nhap("2. Giáo Viên");
                        nhap("3. Tất cả đối tượng");
                        nhap("4. Quay lại");
                        nhap("Chọn:");
                        choose1 = Integer.parseInt(sc.nextLine());
                    } while (choose1 < 1 || choose1 > 4);
                    if (choose1 == 1) {
                        ManagerSchool.displayStudent();
                    } else if (choose1 == 2) {
                        ManagerSchool.displayTeacher();
                    }
                    if (choose1 == 3) {
                        nhap("Danh sách giáo viên");
                        ManagerSchool.displayTeacher();
                        nhap("-------------------");
                        nhap("Danh sách sinh viên");
                        ManagerSchool.displayStudent();
                    } else {
                        break;
                    }
                    break;
                }

                case 6: {
                    flag = false;
                    break;
                }
                default:
                    continue;
            }
        }
    }
}
