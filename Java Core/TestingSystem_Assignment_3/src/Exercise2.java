import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Exercise2 {

    // Question 1: In ra số nguyên 5
    public static void question1() {
        System.out.println("===== Exercise 2 - Question 1 =====");
        int a = 5;
        System.out.printf("%d%n", a);
    }

    // Question 2: In số 100000000 thành 100,000,000
    public static void question2() {
        System.out.println("===== Exercise 2 - Question 2 =====");
        int b = 100000000;
        System.out.printf(Locale.US, "%,d%n", b);
    }

    // Question 3: In số thực 5.567098, chỉ lấy 4 số sau dấu phẩy
    public static void question3() {
        System.out.println("===== Exercise 2 - Question 3 =====");
        double c = 5.567098;
        System.out.printf(Locale.US, "%.4f%n", c);
    }

    // Question 4: In họ tên học sinh theo định dạng
    public static void question4() {
        System.out.println("===== Exercise 2 - Question 4 =====");
        String hoTen = "Nguyễn Văn A";
        System.out.printf("Tên tôi là \"%s\" và tôi đang độc thân.%n", hoTen);
    }

    // Question 5: In thời gian hiện tại dạng 24/04/2020 11h:16p:20s
    public static void question5() {
        System.out.println("===== Exercise 2 - Question 5 =====");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH'h':mm'p':ss's'");
        System.out.printf("%s%n", now.format(format));
    }

    // Question 6: In thông tin account (như Question 8 phần FOREACH) dạng bảng
    public static void question6() {
        System.out.println("===== Exercise 2 - Question 6 =====");
        String duongKe = "+-----+--------------------------+--------------------+-------------+";
        System.out.println(duongKe);
        System.out.printf("| %-3s | %-24s | %-18s | %-11s |%n", "ID", "Email", "Full name", "Phòng ban");
        System.out.println(duongKe);
        for (Account account : Exercise1.accounts) {
            String tenPhongBan = (account.department == null) ? "" : account.department.name;
            System.out.printf("| %-3d | %-24s | %-18s | %-11s |%n",
                    account.id, account.email, account.fullName, tenPhongBan);
        }
        System.out.println(duongKe);
    }
}
