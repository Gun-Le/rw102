package Entity;

public class Sach extends Tailieu {

        private String tenTacGia;
        private int soTrang;

        public Sach() {
        }

        public Sach(String maTaiLieu, String tenNhaXuatBan, int soBanPhatHanh,
                    String tenTacGia, int soTrang) {
            super(maTaiLieu, tenNhaXuatBan, soBanPhatHanh);   // gọi constructor lớp cha
            this.tenTacGia = tenTacGia;
            this.soTrang = soTrang;
        }

        // ===== GETTER & SETTER =====
        public String getTenTacGia() {
            return tenTacGia;
        }

        public void setTenTacGia(String tenTacGia) {
            this.tenTacGia = tenTacGia;
        }

        public int getSoTrang() {
            return soTrang;
        }

        public void setSoTrang(int soTrang) {
            this.soTrang = soTrang;
        }

        @Override
        public void hienThi() {
            System.out.println("--- SÁCH ---");
            super.hienThi();                 // gọi lại phần in chung của lớp cha
            System.out.println("Tên tác giả: " + tenTacGia);
            System.out.println("Số trang: " + soTrang);
            System.out.println();
        }
    }

