package Entity;

public class Tapchi extends Tailieu {

    private int soPhatHanh;
    private int thangPhatHanh;

    public Tapchi() {
    }

    public Tapchi(String maTaiLieu, String tenNhaXuatBan, int soBanPhatHanh,
                  int soPhatHanh, int thangPhatHanh) {
        super(maTaiLieu, tenNhaXuatBan, soBanPhatHanh);
        this.soPhatHanh = soPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
    }

    // ===== GETTER & SETTER =====
    public int getSoPhatHanh() {
        return soPhatHanh;
    }

    public void setSoPhatHanh(int soPhatHanh) {
        this.soPhatHanh = soPhatHanh;
    }

    public int getThangPhatHanh() {
        return thangPhatHanh;
    }

    public void setThangPhatHanh(int thangPhatHanh) {
        this.thangPhatHanh = thangPhatHanh;
    }

    @Override
    public void hienThi() {
        System.out.println("--- TẠP CHÍ ---");
        super.hienThi();
        System.out.println("Số phát hành: " + soPhatHanh);
        System.out.println("Tháng phát hành: " + thangPhatHanh);
        System.out.println();
    }
}
