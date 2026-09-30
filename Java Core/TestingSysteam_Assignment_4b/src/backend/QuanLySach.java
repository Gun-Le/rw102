package backend;

import entity.Bao;
import entity.Sach;
import entity.TaiLieu;
import entity.TapChi;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLySach {
    private ArrayList<TaiLieu> danhSach = new ArrayList<>();

    private boolean tonTai(String ma) {
        for (TaiLieu tl : danhSach) {
            if (tl.getMaTaiLieu().equalsIgnoreCase(ma)) {
                return true;
            }
        }
        return false;
    }

    // 1. Thêm mới tài liệu: Sách, Tạp chí, Báo
    public void themTaiLieu(Scanner sc) {
        System.out.println("Chọn loại: 1. Sách | 2. Tạp chí | 3. Báo");
        System.out.print("Lựa chọn: ");
        int loai = Integer.parseInt(sc.nextLine());

        if (loai < 1 || loai > 3) {
            System.out.println("Loại tài liệu không hợp lệ!");
            return;
        }

        System.out.print("Mã tài liệu: ");
        String ma = sc.nextLine();
        if (tonTai(ma)) {
            System.out.println("Mã tài liệu đã tồn tại!");
            return;
        }

        System.out.print("Tên nhà xuất bản: ");
        String nxb = sc.nextLine();
        System.out.print("Số bản phát hành: ");
        int soBan = Integer.parseInt(sc.nextLine());

        switch (loai) {
            case 1:
                System.out.print("Tác giả: ");
                String tacGia = sc.nextLine();
                System.out.print("Số trang: ");
                int soTrang = Integer.parseInt(sc.nextLine());
                danhSach.add(new Sach(ma, nxb, soBan, tacGia, soTrang));
                break;
            case 2:
                System.out.print("Số phát hành: ");
                int soPhatHanh = Integer.parseInt(sc.nextLine());
                System.out.print("Tháng phát hành: ");
                int thang = Integer.parseInt(sc.nextLine());
                danhSach.add(new TapChi(ma, nxb, soBan, soPhatHanh, thang));
                break;
            case 3:
                System.out.print("Ngày phát hành (dd/MM/yyyy): ");
                String ngay = sc.nextLine();
                danhSach.add(new Bao(ma, nxb, soBan, ngay));
                break;
        }
        System.out.println("Thêm thành công!");
    }

    // 2. Xoá tài liệu theo mã tài liệu
    public void xoaTaiLieu(String ma) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaTaiLieu().equalsIgnoreCase(ma)) {
                danhSach.remove(i);
                System.out.println("Đã xoá tài liệu có mã: " + ma);
                return;
            }
        }
        System.out.println("Không tìm thấy tài liệu có mã: " + ma);
    }


    private void inBang(ArrayList<TaiLieu> ds) {
        String line = "+----------+----------+--------------------+----------+------------------------------------------+";
        System.out.println(line);
        System.out.printf("| %-8s | %-8s | %-18s | %-8s | %-40s |%n",
                "Mã TL", "Loại", "Nhà xuất bản", "Số bản", "Thông tin thêm");
        System.out.println(line);

        for (TaiLieu tl : ds) {
            String loai;
            String thongTinThem;

            if (tl instanceof Sach) {
                Sach s = (Sach) tl;
                loai = "Sách";
                thongTinThem = "Tác giả: " + s.getTacGia() + ", " + s.getSoTrang() + " trang";
            } else if (tl instanceof TapChi) {
                TapChi t = (TapChi) tl;
                loai = "Tạp chí";
                thongTinThem = "Số " + t.getSoPhatHanh() + ", tháng " + t.getThangPhatHanh();
            } else if (tl instanceof Bao) {
                Bao b = (Bao) tl;
                loai = "Báo";
                thongTinThem = "Ngày phát hành: " + b.getNgayPhatHanh();
            } else {
                loai = "Khác";
                thongTinThem = "";
            }

            System.out.printf("| %-8s | %-8s | %-18s | %-8d | %-40s |%n",
                    tl.getMaTaiLieu(), loai, tl.getTenNhaXuatBan(), tl.getSoBanPhatHanh(), thongTinThem);
        }
        System.out.println(line);
    }

    // 3. Hiển thị thông tin về tài liệu (dùng instanceof)
    public void hienThi() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        inBang(danhSach);
    }

    // 4. Tìm kiếm gần đúng theo mã tài liệu
    public void timKiem(String keyword) {
        ArrayList<TaiLieu> ketQua = new ArrayList<>();
        for (TaiLieu tl : danhSach) {
            if (tl.getMaTaiLieu().toLowerCase().contains(keyword.toLowerCase())) {
                ketQua.add(tl);
            }
        }
        if (ketQua.isEmpty()) {
            System.out.println("Không tìm thấy tài liệu nào gần đúng với: " + keyword);
        } else {
            inBang(ketQua);
        }
    }
}
