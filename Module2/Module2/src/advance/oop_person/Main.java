package advance.oop_person;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean flag = true;
        int choose, choose1;
        while (flag) {
            nhap("---------------------------------------");
            nhap("|Vui lòng chọn đối tượng bạn quản lý:  |");
            nhap("|1. Học Sinh                           |");
            nhap("|2. Giáo viên                          |");
            nhap("|3. Thoát!                             |");
            nhap("---------------------------------------");
            System.out.print("Chọn: ");
            choose = sc.nextInt();
            if (choose == 1) {
                nhap("---------------------------------------");
                nhap("Các chức năng quản lý sinh viên");
                nhap("1.Thêm sinh viên");
                nhap("2.Xoá sinh viên");
                nhap("3.Sửa thông tin sinh viên");
                nhap("4.Tìm kiếm sinh viên");
                nhap("5.Hiển thị tất cả thông tin sinh viên");
                nhap("6. Thoát");
                nhap("---------------------------------------");
                System.out.print("Chọn: ");
                choose1 = sc.nextInt();
                switch (choose1) {
                    case 1:
                        ManagerSchool.addStudent();
                        break;
                    case 2:
                    case 3:
                    case 4:
                        ManagerSchool.searchStudent();
                        break;
                    case 5:
                        ManagerSchool.displayStudent();
                        break;
                    case 6:
                        System.exit(0);
                    default:
                        continue;
                }
            } else if (choose == 2) {
                nhap("---------------------------------------");
                nhap("Các chức năng quản lý giáo viên");
                nhap("1.Thêm giáo viên");
                nhap("2.Xoá giáo viên");
                nhap("3.Sửa thông tin giáo viên");
                nhap("4.Tìm kiếm giáo viên");
                nhap("5.Hiển thị tất cả thông tin giáo viên");
                nhap("6. Thoát");
                nhap("---------------------------------------");
                System.out.print("Chọn: ");
                choose1 = sc.nextInt();
                switch (choose1) {
                    case 1:
                        ManagerSchool.addTeacher();
                        break;
                    case 2:
                    case 3:
                    case 4:ManagerSchool.searchTeacher();
                        break;

                    case 5:
                        ManagerSchool.displayTeacher();
                        break;
                    case 6:
                        System.exit(0);
                    default:
                        continue;
                }
            } else if (choose == 3) {
                System.exit(0);
            } else {
                nhap("");
                nhap("Bạn đã chọn sai, vui lòng chọn lại");
                continue;
            }
        }
    }

    public static void nhap(String str) {
        System.out.println(str);
    }

}
