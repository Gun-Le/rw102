import java.util.Scanner;

public class Exercise4 {

    static Scanner scanner = new Scanner(System.in);

    // Danh sách group dùng cho Question 8 và Question 9
    static String[] tenCacGroup = {
            "Java Fresher", "Java Advanced", "Java", "C# Fresher", "Testing System", "Java"
    };

    // Question 1: Đếm số từ trong xâu (các từ có thể cách nhau nhiều khoảng trắng)
    public static void question1() {
        System.out.println("===== Exercise 4 - Question 1 =====");

        String chuoi;
        while (true) {
            System.out.print("Nhập chuỗi: ");
            chuoi = scanner.nextLine().trim();   // trim: bỏ khoảng trắng ở đầu và cuối
            if (!chuoi.isEmpty()) {
                break;
            }
            System.out.println("Hãy nhập một chuỗi");
        }

        // \\s+ nghĩa là "một hoặc nhiều khoảng trắng" -> cắt chuỗi tại các chỗ đó
        String[] cacTu = chuoi.split("\\s+");
        System.out.println("Số từ: " + cacTu.length);
    }

    // Question 2: Nối xâu s2 vào sau xâu s1
    public static void question2() {
        System.out.println("===== Exercise 4 - Question 2 =====");

        String s1;
        while (true) {
            System.out.print("Nhập chuỗi 1: ");
            s1 = scanner.nextLine().trim();
            if (!s1.isEmpty()) {
                break;
            }
            System.out.println("Hãy nhập một chuỗi");
        }

        String s2;
        while (true) {
            System.out.print("Nhập chuỗi 2: ");
            s2 = scanner.nextLine().trim();
            if (!s2.isEmpty()) {
                break;
            }
            System.out.println("Hãy nhập một chuỗi");
        }

        // Nối s2 vào ngay sau s1 (không có dấu cách, đúng như đề)
        System.out.println("Sau khi nối: " + s1.concat(s2));
    }

    // Question 3: Viết hoa chữ cái đầu của tên nếu chưa viết hoa
    public static void question3() {
        System.out.println("===== Exercise 4 - Question 3 =====");

        String ten;
        while (true) {
            System.out.print("Nhập tên: ");
            ten = scanner.nextLine().trim();
            if (!ten.isEmpty()) {
                break;
            }
            System.out.println("Hãy nhập tên của mình");
        }

        String[] cacTu = ten.split("\\s+");
        StringBuilder ketQua = new StringBuilder();

        for (String tu : cacTu) {
            if (!tu.isEmpty()) {
                // Viết hoa ký tự đầu, phần còn lại viết thường
                String tuVietHoa = tu.substring(0, 1).toUpperCase()
                        + tu.substring(1).toLowerCase();
                ketQua.append(tuVietHoa).append(" ");
            }
        }

        String tenDaVietHoa = ketQua.toString().trim();

        // Kiểm tra xem tên nhập vào đã viết hoa đúng sẵn chưa
        if (tenDaVietHoa.equals(ten)) {
            System.out.println("Tên đã viết hoa chữ cái đầu: " + tenDaVietHoa);
        } else {
            System.out.println("Sau khi viết hoa chữ cái đầu: " + tenDaVietHoa);
        }
    }

    // Question 4: In từng ký tự trong tên
    public static void question4() {
        System.out.println("===== Exercise 4 - Question 4 =====");
        System.out.println("Nhập tên:");
        String ten = scanner.nextLine();

        for (int i = 0; i < ten.length(); i++) {
            System.out.println("Ký tự thứ " + (i + 1) + " là: " + ten.charAt(i));
        }
    }

    // Question 5: Nhập họ, nhập tên rồi in ra họ và tên đầy đủ
    public static void question5() {
        System.out.println("===== Exercise 4 - Question 5 =====");
        System.out.println("Nhập họ:");
        String ho = scanner.nextLine().trim();
        System.out.println("Nhập tên:");
        String ten = scanner.nextLine().trim();

        System.out.println("Họ và tên đầy đủ: " + ho + " " + ten);
    }

    // Question 6: Tách họ, tên đệm, tên từ họ tên đầy đủ
    public static void question6() {
        System.out.println("===== Exercise 4 - Question 6 =====");
        System.out.println("Nhập họ và tên đầy đủ:");
        String hoTen = scanner.nextLine().trim().replaceAll("\\s+", " ");

        String[] cacTu = hoTen.split(" ");
        if (cacTu.length < 2) {
            System.out.println("Bạn phải nhập ít nhất họ và tên");
            return;
        }

        System.out.println("Họ là: " + cacTu[0]);

        // Tên đệm là tất cả các từ ở giữa
        String tenDem = "";
        for (int i = 1; i < cacTu.length - 1; i++) {
            if (!tenDem.isEmpty()) {
                tenDem = tenDem + " ";
            }
            tenDem = tenDem + cacTu[i];
        }
        System.out.println("Tên đệm là: " + (tenDem.isEmpty() ? "(không có)" : tenDem));

        System.out.println("Tên là: " + cacTu[cacTu.length - 1]);
    }

    // Question 7: Chuẩn hóa họ và tên
    public static void question7() {
        System.out.println("===== Exercise 4 - Question 7 =====");
        System.out.println("Nhập họ và tên đầy đủ:");
        String hoTen = scanner.nextLine();

        // a) Xóa khoảng trắng thừa ở đầu, cuối và ở giữa
        String buocA = hoTen.trim().replaceAll("\\s+", " ");
        System.out.println("a) Sau khi xóa khoảng trắng thừa: \"" + buocA + "\"");

        // b) Viết hoa chữ cái đầu mỗi từ
        String[] cacTu = buocA.split(" ");
        String buocB = "";
        for (int i = 0; i < cacTu.length; i++) {
            String tu = cacTu[i];
            if (tu.isEmpty()) {
                continue;
            }
            String tuVietHoa = Character.toUpperCase(tu.charAt(0)) + tu.substring(1).toLowerCase();
            if (i > 0) {
                buocB = buocB + " ";
            }
            buocB = buocB + tuVietHoa;
        }
        System.out.println("b) Sau khi viết hoa chữ cái mỗi từ: \"" + buocB + "\"");
    }

    // Question 8: In ra tất cả các group có chứa chữ "Java"
    public static void question8() {
        System.out.println("===== Exercise 4 - Question 8 =====");
        for (String tenGroup : tenCacGroup) {
            if (tenGroup.contains("Java")) {     // contains: có chứa hay không
                System.out.println(tenGroup);
            }
        }
    }

    // Question 9: In ra tất cả các group tên đúng là "Java"
    public static void question9() {
        System.out.println("===== Exercise 4 - Question 9 =====");
        for (String tenGroup : tenCacGroup) {
            if (tenGroup.equals("Java")) {       // equals: giống hệt hay không
                System.out.println(tenGroup);
            }
        }
    }

    // Question 10: Kiểm tra 2 chuỗi có đảo ngược của nhau không
    public static void question10() {
        System.out.println("===== Exercise 4 - Question 10 =====");
        System.out.println("Nhập chuỗi thứ 1:");
        String chuoi1 = scanner.nextLine();
        System.out.println("Nhập chuỗi thứ 2:");
        String chuoi2 = scanner.nextLine();

        // Đảo ngược chuỗi 1 bằng vòng lặp
        String chuoi1DaoNguoc = "";
        for (int i = chuoi1.length() - 1; i >= 0; i--) {
            chuoi1DaoNguoc = chuoi1DaoNguoc + chuoi1.charAt(i);
        }

        if (chuoi1DaoNguoc.equals(chuoi2)) {
            System.out.println("OK");
        } else {
            System.out.println("KO");
        }
    }

    // Question 11: Đếm số lần xuất hiện ký tự "a" trong chuỗi
    public static void question11() {
        System.out.println("===== Exercise 4 - Question 11 =====");
        System.out.println("Nhập chuỗi:");
        String chuoi = scanner.nextLine();

        int demSoLan = 0;
        for (int i = 0; i < chuoi.length(); i++) {
            if (chuoi.charAt(i) == 'a') {
                demSoLan++;
            }
        }
        System.out.println("Ký tự 'a' xuất hiện " + demSoLan + " lần");
    }

    // Question 12: Đảo ngược chuỗi bằng vòng lặp
    public static void question12() {
        System.out.println("===== Exercise 4 - Question 12 =====");
        System.out.println("Nhập chuỗi:");
        String chuoi = scanner.nextLine();

        String ketQua = "";
        for (int i = chuoi.length() - 1; i >= 0; i--) {   // chạy từ cuối về đầu
            ketQua = ketQua + chuoi.charAt(i);
        }
        System.out.println("Chuỗi đảo ngược: " + ketQua);
    }

    // Question 13: Kiểm tra chuỗi có chứa chữ số hay không
    public static void question13() {
        System.out.println("===== Exercise 4 - Question 13 =====");
        System.out.println("Nhập chuỗi:");
        String chuoi = scanner.nextLine();

        System.out.println("Kết quả: " + khongChuaChuSo(chuoi));
    }

    // Trả về true nếu chuỗi KHÔNG chứa chữ số, false nếu có chữ số hoặc null
    static boolean khongChuaChuSo(String chuoi) {
        if (chuoi == null) {
            return false;
        }
        for (int i = 0; i < chuoi.length(); i++) {
            if (Character.isDigit(chuoi.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Question 14: Thay 1 ký tự trong chuỗi bằng ký tự khác
    public static void question14() {
        System.out.println("===== Exercise 4 - Question 14 =====");
        System.out.println("Nhập chuỗi:");
        String chuoi = scanner.nextLine();
        System.out.println("Nhập ký tự muốn thay:");
        char kyTuCu = scanner.nextLine().charAt(0);
        System.out.println("Nhập ký tự mới:");
        char kyTuMoi = scanner.nextLine().charAt(0);

        System.out.println("Kết quả: " + chuoi.replace(kyTuCu, kyTuMoi));
    }

    // Question 15: Đảo ngược thứ tự các từ trong chuỗi
    public static void question15() {
        System.out.println("===== Exercise 4 - Question 15 =====");
        System.out.println("Nhập chuỗi:");
        String chuoi = scanner.nextLine();

        String ketQua = "";
        String tuHienTai = "";
        for (int i = 0; i < chuoi.length(); i++) {
            char kyTu = chuoi.charAt(i);

            if (kyTu != ' ') {
                tuHienTai = tuHienTai + kyTu;      // đang gom 1 từ
            } else if (!tuHienTai.isEmpty()) {
                // gặp dấu cách và đã gom xong 1 từ -> đưa từ đó lên đầu kết quả
                ketQua = ketQua.isEmpty() ? tuHienTai : tuHienTai + " " + ketQua;
                tuHienTai = "";
            }
        }
        // từ cuối cùng (sau vòng lặp vẫn còn trong tuHienTai)
        if (!tuHienTai.isEmpty()) {
            ketQua = ketQua.isEmpty() ? tuHienTai : tuHienTai + " " + ketQua;
        }

        System.out.println("Kết quả: \"" + ketQua + "\"");
    }

    // Question 16: Chia chuỗi thành các phần bằng nhau, mỗi phần n ký tự
    public static void question16() {
        System.out.println("===== Exercise 4 - Question 16 =====");
        System.out.println("Nhập chuỗi:");
        String chuoi = scanner.nextLine();
        System.out.println("Nhập số nguyên n:");
        int n = scanner.nextInt();
        scanner.nextLine();   // dọn dấu Enter còn sót

        // n = 0 hoặc chuỗi không chia hết cho n thì không chia được
        if (n <= 0 || chuoi.length() % n != 0) {
            System.out.println("KO");
            return;
        }

        for (int i = 0; i < chuoi.length(); i = i + n) {
            System.out.println(chuoi.substring(i, i + n));
        }
    }
}

