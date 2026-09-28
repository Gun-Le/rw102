package Entity;

public class Tailieu {
    private String maTaiLieu;        // mã tài liệu (duy nhất)
    private String tenNhaXuatBan;
    private int soBanPhatHanh;

    // Constructor rỗng
    public Tailieu() {
    }

    // Constructor đầy đủ: tạo object và gán luôn 3 thuộc tính
    public Tailieu(String maTaiLieu, String tenNhaXuatBan, int soBanPhatHanh) {
        this.maTaiLieu = maTaiLieu;
        this.tenNhaXuatBan = tenNhaXuatBan;
        this.soBanPhatHanh = soBanPhatHanh;
    }

    // ===== GETTER & SETTER =====
    public String getMaTaiLieu() {
        return maTaiLieu;
    }

    public void setMaTaiLieu(String maTaiLieu) {
        this.maTaiLieu = maTaiLieu;
    }

    public String getTenNhaXuatBan() {
        return tenNhaXuatBan;
    }

    public void setTenNhaXuatBan(String tenNhaXuatBan) {
        this.tenNhaXuatBan = tenNhaXuatBan;
    }

    public int getSoBanPhatHanh() {
        return soBanPhatHanh;
    }

    public void setSoBanPhatHanh(int soBanPhatHanh) {
        this.soBanPhatHanh = soBanPhatHanh;
    }

    // In thông tin chung của mọi tài liệu
    // Các lớp con sẽ ghi đè (override) method này để in thêm thông tin riêng
    public void hienThi() {
        System.out.println("Mã tài liệu: " + maTaiLieu);
        System.out.println("Nhà xuất bản: " + tenNhaXuatBan);
        System.out.println("Số bản phát hành: " + soBanPhatHanh);
    }
}
