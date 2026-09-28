package Frontend;

import Backend.Quanlysach;

import java.util.Scanner;

public class Exercise5 {

    static Scanner scanner = new Scanner(System.in);

    // Question 4: Chương trình quản lý tài liệu thư viện (QLTV)
    public static void question4() {
        System.out.println("===== Exercise 5 - Question 4: QUẢN LÝ THƯ VIỆN =====");

        while (true) {
            // Bước 1: in menu
            System.out.println();
            System.out.println("Mời bạn chọn chức năng:");
            System.out.println("1. Thêm mới tài liệu");
            System.out.println("2. Xóa tài liệu theo mã");
            System.out.println("3. Hiển thị thông tin tài liệu");
            System.out.println("4. Tìm kiếm tài liệu theo loại");
            System.out.println("5. Thoát khỏi chương trình");

            // Đọc lựa chọn, chặn trường hợp người dùng gõ chữ
            int chucNang;
            if (scanner.hasNextInt()) {
                chucNang = scanner.nextInt();
                scanner.nextLine();          // dọn dấu Enter còn sót
            } else {
                System.out.println("Xin hãy nhập một số!");
                scanner.nextLine();
                continue;
            }

            // Bước 2: thực hiện chức năng
            if (chucNang == 1) {
                Quanlysach.themTaiLieu();
            } else if (chucNang == 2) {
                Quanlysach.xoaTaiLieu();
            } else if (chucNang == 3) {
                Quanlysach.hienThiTatCa();
            } else if (chucNang == 4) {
                timKiemTheoLoai();
            } else if (chucNang == 5) {
                System.out.println("Kết thúc chương trình. Tạm biệt!");
                return;                       // return để thoát khỏi chương trình
            } else {
                System.out.println("Không có chức năng này, mời bạn nhập lại");
            }
        }
    }

    // Hỏi người dùng muốn tìm loại tài liệu nào rồi gọi QuanLySach
    static void timKiemTheoLoai() {
        while (true) {
            System.out.println("Bạn muốn tìm loại tài liệu nào?");
            System.out.println("1. Sách");
            System.out.println("2. Tạp chí");
            System.out.println("3. Báo");

            if (!scanner.hasNextInt()) {
                System.out.println("Xin hãy nhập một số!");
                scanner.nextLine();
                continue;
            }

            int loai = scanner.nextInt();
            scanner.nextLine();

            if (loai >= 1 && loai <= 3) {
                Quanlysach.timKiemTheoLoai(loai);
                return;
            }
            System.out.println("Không có loại này, mời bạn nhập lại");
        }
    }
}
