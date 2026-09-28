package Entity;

import java.time.LocalDate;

public class Bao extends Tailieu {

    private LocalDate ngayPhatHanh;

    public Bao() {
    }

    public Bao(String maTaiLieu, String tenNhaXuatBan, int soBanPhatHanh,
               LocalDate ngayPhatHanh) {
        super(maTaiLieu, tenNhaXuatBan, soBanPhatHanh);
        this.ngayPhatHanh = ngayPhatHanh;
    }

    // ===== GETTER & SETTER =====
    public LocalDate getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(LocalDate ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    @Override
    public void hienThi() {
        System.out.println("--- BÁO ---");
        super.hienThi();
        System.out.println("Ngày phát hành: " + ngayPhatHanh);
        System.out.println();
    }
}
