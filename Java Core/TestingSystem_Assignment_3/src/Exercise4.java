import java.time.LocalDate;
import java.util.Random;

public class Exercise4 {

    static Random random = new Random();

    // Question 1: In ngẫu nhiên ra 1 số nguyên
    public static void question1() {
        System.out.println("===== Exercise 4 - Question 1 =====");
        int soNguyen = random.nextInt();
        System.out.println("Số nguyên ngẫu nhiên: " + soNguyen);
    }

    // Question 2: In ngẫu nhiên ra 1 số thực
    public static void question2() {
        System.out.println("===== Exercise 4 - Question 2 =====");
        double soThuc = random.nextDouble();
        System.out.println("Số thực ngẫu nhiên: " + soThuc);
    }

    // Question 3: In ngẫu nhiên tên 1 bạn trong lớp
    public static void question3() {
        System.out.println("===== Exercise 4 - Question 3 =====");
        String[] tenCacBan = { "Tin", "An", "Binh", "Hieu", "Nhan" };
        int viTri = random.nextInt(tenCacBan.length); // số từ 0 đến length - 1
        System.out.println("Bạn được chọn: " + tenCacBan[viTri]);
    }

    // Question 4: Ngày ngẫu nhiên từ 24-07-1995 đến 20-12-1995
    public static void question4() {
        System.out.println("===== Exercise 4 - Question 4 =====");
        // toEpochDay(): đổi ngày thành "số ngày tính từ 01/01/1970" để dễ random
        long ngayBatDau = LocalDate.of(1995, 7, 24).toEpochDay();
        long ngayKetThuc = LocalDate.of(1995, 12, 20).toEpochDay();

        long soNgay = ngayKetThuc - ngayBatDau + 1;
        long ngayNgauNhien = ngayBatDau + random.nextInt((int) soNgay);

        System.out.println("Ngày ngẫu nhiên: " + LocalDate.ofEpochDay(ngayNgauNhien));
    }

    // Question 5: Ngày ngẫu nhiên trong 1 năm trở lại đây
    public static void question5() {
        System.out.println("===== Exercise 4 - Question 5 =====");
        long ngayBatDau = LocalDate.now().minusYears(1).toEpochDay();
        long ngayKetThuc = LocalDate.now().toEpochDay();

        long soNgay = ngayKetThuc - ngayBatDau + 1;
        long ngayNgauNhien = ngayBatDau + random.nextInt((int) soNgay);

        System.out.println("Ngày ngẫu nhiên: " + LocalDate.ofEpochDay(ngayNgauNhien));
    }

    // Question 6: Ngày ngẫu nhiên trong quá khứ (từ 01/01/1970 đến hôm qua)
    public static void question6() {
        System.out.println("===== Exercise 4 - Question 6 =====");
        int homNay = (int) LocalDate.now().toEpochDay();
        int ngayNgauNhien = random.nextInt(homNay); // từ 0 đến homNay - 1

        System.out.println("Ngày ngẫu nhiên trong quá khứ: " + LocalDate.ofEpochDay(ngayNgauNhien));
    }

    // Question 7: Số ngẫu nhiên có 3 chữ số (100 -> 999)
    public static void question7() {
        System.out.println("===== Exercise 4 - Question 7 =====");
        int so = random.nextInt(900) + 100; // nextInt(900) cho 0 -> 899, cộng 100 thành 100 -> 999
        System.out.println("Số có 3 chữ số: " + so);
    }
}
