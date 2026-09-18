import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Exercise3 {

    // ================== DỮ LIỆU EXAM (lấy từ bài 1) ==================
    static CategoryQuestion cat1;
    static Exam exam1;

    static {
        cat1 = new CategoryQuestion();
        cat1.id = 1;
        cat1.name = "Java";

        exam1 = new Exam();
        exam1.id = 1;
        exam1.code = "JAVA01";
        exam1.title = "Java Core Basic";
        exam1.category = cat1;
        exam1.duration = 60;
        exam1.creator = Exercise1.acc1; // dùng lại acc1 bên Exercise1
        exam1.createDate = LocalDate.of(2024, 8, 1);
    }

    // Question 1: In thông tin Exam thứ 1, createDate theo định dạng Việt Nam
    public static void question1() {
        System.out.println("===== Exercise 3 - Question 1 =====");
        DateTimeFormatter dinhDangVN = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Id: " + exam1.id);
        System.out.println("Code: " + exam1.code);
        System.out.println("Title: " + exam1.title);
        System.out.println("Category: " + exam1.category.name);
        System.out.println("Duration: " + exam1.duration + " phút");
        System.out.println("Creator: " + exam1.creator.fullName);
        System.out.println("Create date: " + exam1.createDate.format(dinhDangVN));
    }

    // Question 2: Exam đã tạo ngày nào theo định dạng Năm-tháng-ngày-giờ-phút-giây
    public static void question2() {
        System.out.println("===== Exercise 3 - Question 2 =====");
        // createDate ở bài 1 là LocalDate (chỉ có ngày, không có giờ)
        // → chuyển sang LocalDateTime, giờ phút giây sẽ là 00
        LocalDateTime ngayGioTao = exam1.createDate.atStartOfDay();
        DateTimeFormatter dinhDang = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        System.out.println("Exam được tạo ngày: " + ngayGioTao.format(dinhDang));
    }

    // Question 3: Chỉ in ra năm của createDate
    public static void question3() {
        System.out.println("===== Exercise 3 - Question 3 =====");
        DateTimeFormatter dinhDang = DateTimeFormatter.ofPattern("yyyy");
        System.out.println("Năm tạo: " + exam1.createDate.format(dinhDang));
    }

    // Question 4: Chỉ in ra tháng và năm của createDate
    public static void question4() {
        System.out.println("===== Exercise 3 - Question 4 =====");
        DateTimeFormatter dinhDang = DateTimeFormatter.ofPattern("MM-yyyy");
        System.out.println("Tháng và năm tạo: " + exam1.createDate.format(dinhDang));
    }

    // Question 5: Chỉ in ra "MM-DD" của createDate
    public static void question5() {
        System.out.println("===== Exercise 3 - Question 5 =====");
        // Chú ý: trong Java, "dd" là ngày trong tháng, "DD" là ngày trong năm
        DateTimeFormatter dinhDang = DateTimeFormatter.ofPattern("MM-dd");
        System.out.println("Tháng-ngày tạo: " + exam1.createDate.format(dinhDang));
    }
}
