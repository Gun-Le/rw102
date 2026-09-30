package frontend;

import backend.QuanLySach;

import java.util.Scanner;

public class Exercise5 {
    public static void question4() {
        Scanner sc = new Scanner(System.in);
        QuanLySach ql = new QuanLySach();

        while (true) {
            System.out.println("\n===== QUẢN LÝ THƯ VIỆN =====");
            System.out.println("1. Thêm mới tài liệu");
            System.out.println("2. Xoá tài liệu theo mã");
            System.out.println("3. Hiển thị thông tin tài liệu");
            System.out.println("4. Tìm kiếm gần đúng theo mã");
            System.out.print("Chọn chức năng: ");

            int chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1:
                    ql.themTaiLieu(sc);
                    break;
                case 2:
                    System.out.print("Nhập mã cần xoá: ");
                    ql.xoaTaiLieu(sc.nextLine());
                    break;
                case 3:
                    ql.hienThi();
                    break;
                case 4:
                    System.out.print("Nhập mã cần tìm: ");
                    ql.timKiem(sc.nextLine());
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ!");
            }
        }
    }
}
