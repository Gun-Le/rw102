package Backend;

import Entity.Bao;
import Entity.Sach;
import Entity.Tailieu;
import Entity.Tapchi;

import java.time.LocalDate;

public class Quanlysach {

    // Danh sách tài liệu của thư viện
    private static Tailieu[] danhSachTaiLieu = taoDuLieuMau();

    public static Tailieu[] getDanhSachTaiLieu() {
        return danhSachTaiLieu;
    }

    // 1. Thêm mới tài liệu (chưa cần làm)
    public static void themTaiLieu() {
        System.out.println("Chức năng thêm mới tài liệu chưa được cài đặt.");
    }

    // 2. Xóa tài liệu theo mã (chưa cần làm)
    public static void xoaTaiLieu() {
        System.out.println("Chức năng xóa tài liệu chưa được cài đặt.");
    }

    // 3. Hiển thị thông tin về tài liệu
    public static void hienThiTatCa() {
        System.out.println("===== DANH SÁCH TẤT CẢ TÀI LIỆU =====");
        for (Tailieu taiLieu : danhSachTaiLieu) {
            // Java tự gọi đúng method hienThi() của Sách, Tạp chí hay Báo
            taiLieu.hienThi();
        }
    }

    // 4. Tìm kiếm tài liệu theo loại
    public static void timKiemTheoLoai(int loai) {
        boolean timThay = false;

        for (Tailieu taiLieu : danhSachTaiLieu) {
            // instanceof: kiểm tra tài liệu này có phải là Sách / Tạp chí / Báo không
            if (loai == 1 && taiLieu instanceof Sach) {
                taiLieu.hienThi();
                timThay = true;
            } else if (loai == 2 && taiLieu instanceof Tapchi) {
                taiLieu.hienThi();
                timThay = true;
            } else if (loai == 3 && taiLieu instanceof Bao) {
                taiLieu.hienThi();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy tài liệu nào thuộc loại này.");
        }
    }

    // Tạo sẵn dữ liệu mẫu cho thư viện (dùng constructor đầy đủ cho gọn)
    private static Tailieu[] taoDuLieuMau() {
        Sach sach1 = new Sach("S01", "NXB Trẻ", 1000, "Nguyễn Nhật Ánh", 320);
        Sach sach2 = new Sach("S02", "NXB Kim Đồng", 2500, "Tô Hoài", 180);

        Tapchi tapChi1 = new Tapchi("TC01", "NXB Thông Tin", 500, 12, 9);
        Tapchi tapChi2 = new Tapchi("TC02", "NXB Giáo Dục", 800, 5, 6);

        Bao bao1 = new Bao("B01", "Báo Tuổi Trẻ", 10000, LocalDate.of(2026, 9, 28));

        return new Tailieu[] { sach1, sach2, tapChi1, tapChi2, bao1 };
    }
}
