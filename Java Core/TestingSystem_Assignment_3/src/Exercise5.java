import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Exercise5 {

    static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    static Random random = new Random();

    // Question 1: Nhập 3 số nguyên
    public static void question1() {
        System.out.println("===== Exercise 5 - Question 1 =====");
        System.out.println("Nhập số nguyên thứ 1:");
        int so1 = scanner.nextInt();
        System.out.println("Nhập số nguyên thứ 2:");
        int so2 = scanner.nextInt();
        System.out.println("Nhập số nguyên thứ 3:");
        int so3 = scanner.nextInt();
        scanner.nextLine(); // bỏ dấu Enter còn sót lại sau nextInt()

        System.out.println("Bạn đã nhập: " + so1 + ", " + so2 + ", " + so3);
    }

    // Question 2: Nhập 2 số thực
    public static void question2() {
        System.out.println("===== Exercise 5 - Question 2 =====");
        System.out.println("Nhập số thực thứ 1 (dùng dấu chấm, ví dụ 5.5):");
        double so1 = scanner.nextDouble();
        System.out.println("Nhập số thực thứ 2:");
        double so2 = scanner.nextDouble();
        scanner.nextLine(); // bỏ dấu Enter còn sót

        System.out.println("Bạn đã nhập: " + so1 + " và " + so2);
    }

    // Question 3: Nhập họ và tên
    public static void question3() {
        System.out.println("===== Exercise 5 - Question 3 =====");
        System.out.println("Nhập họ và tên:");
        String hoTen = scanner.nextLine();

        System.out.println("Họ và tên của bạn là: " + hoTen);
    }

    // Question 4: Nhập ngày sinh nhật
    public static void question4() {
        System.out.println("===== Exercise 5 - Question 4 =====");
        System.out.println("Nhập ngày sinh nhật theo định dạng dd/MM/yyyy (ví dụ 15/01/2004):");
        String chuoiNgay = scanner.nextLine();

        DateTimeFormatter dinhDang = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ngaySinh = LocalDate.parse(chuoiNgay, dinhDang);

        System.out.println("Ngày sinh nhật của bạn là: " + ngaySinh.format(dinhDang));
    }

    // Question 5: Tạo account
    public static void question5() {
        System.out.println("===== Exercise 5 - Question 5 =====");
        Account account = new Account();
        account.id = Exercise1.accounts.length + 1;

        System.out.println("Nhập username:");
        account.username = scanner.nextLine();

        System.out.println("Nhập email:");
        account.email = scanner.nextLine();

        System.out.println("Nhập full name:");
        account.fullName = scanner.nextLine();

        Position position = new Position();
        while (true) {
            System.out.println("Nhập position (1: Dev, 2: Test, 3: Scrum Master, 4: PM):");
            int chon = scanner.nextInt();
            scanner.nextLine();

            if (chon == 1) {
                position.id = 1;
                position.name = PositionName.DEV;
                break;
            } else if (chon == 2) {
                position.id = 2;
                position.name = PositionName.TEST;
                break;
            } else if (chon == 3) {
                position.id = 3;
                position.name = PositionName.SCRUM_MASTER;
                break;
            } else if (chon == 4) {
                position.id = 4;
                position.name = PositionName.PM;
                break;
            } else {
                System.out.println("Không có position này, mời bạn nhập lại");
            }
        }
        account.position = position;
        account.createDate = LocalDate.now();

        Account[] mangMoi = new Account[Exercise1.accounts.length + 1];
        for (int i = 0; i < Exercise1.accounts.length; i++) {
            mangMoi[i] = Exercise1.accounts[i];
        }
        mangMoi[mangMoi.length - 1] = account;
        Exercise1.accounts = mangMoi;

        System.out.println("Tạo account thành công:");
        System.out.println("Id: " + account.id);
        System.out.println("Username: " + account.username);
        System.out.println("Email: " + account.email);
        System.out.println("Full name: " + account.fullName);
        System.out.println("Position: " + account.position.name);
        System.out.println("Create date: " + account.createDate);
    }

    // Question 6: Tạo department
    public static void question6() {
        System.out.println("===== Exercise 5 - Question 6 =====");
        Department department = new Department();
        department.id = Exercise1.departments.length + 1;

        System.out.println("Nhập tên department:");
        department.name = scanner.nextLine();

        Department[] mangMoi = new Department[Exercise1.departments.length + 1];
        for (int i = 0; i < Exercise1.departments.length; i++) {
            mangMoi[i] = Exercise1.departments[i];
        }
        mangMoi[mangMoi.length - 1] = department;
        Exercise1.departments = mangMoi;

        System.out.println("Tạo department thành công:");
        System.out.println("Id: " + department.id);
        System.out.println("Name: " + department.name);
    }

    // Question 7: Nhập số chẵn từ console
    public static void question7() {
        System.out.println("===== Exercise 5 - Question 7 =====");
        while (true) {
            System.out.println("Nhập 1 số chẵn:");
            int so = scanner.nextInt();
            scanner.nextLine();

            if (so % 2 == 0) {
                System.out.println("Bạn đã nhập số chẵn: " + so);
                break;
            }
            System.out.println("Đây không phải số chẵn, mời bạn nhập lại");
        }
    }

    // Question 8: Menu chọn chức năng (1: tạo account, 2: tạo department)
    public static void question8() {
        System.out.println("===== Exercise 5 - Question 8 =====");
        while (true) {

            System.out.println("Mời bạn nhập vào chức năng muốn sử dụng:");
            System.out.println("1. Tạo account");
            System.out.println("2. Tạo department");
            int chucNang = scanner.nextInt();
            scanner.nextLine();

            if (chucNang == 1) {
                question5();
                return;
            } else if (chucNang == 2) {
                question6();
                return;
            } else {
                System.out.println("Mời bạn nhập lại");
            }
        }
    }

    // Question 9: Thêm group vào account
    public static void question9() {
        System.out.println("===== Exercise 5 - Question 9 =====");

        Account account = chonAccount();

        System.out.println("Danh sách group:");
        for (Group group : Exercise1.groups) {
            System.out.println("- " + group.name);
        }

        Group groupDuocChon = null;
        while (groupDuocChon == null) {
            System.out.println("Nhập tên group:");
            String tenGroup = scanner.nextLine();

            for (Group group : Exercise1.groups) {
                if (group.name.equals(tenGroup)) {
                    groupDuocChon = group;
                    break;
                }
            }
            if (groupDuocChon == null) {
                System.out.println("Không tìm thấy group này, mời bạn nhập lại");
            }
        }

        themAccountVaoGroup(account, groupDuocChon);
    }

    // Question 10: Menu có thêm chức năng 3 và hỏi có muốn tiếp tục không
    public static void question10() {
        System.out.println("===== Exercise 5 - Question 10 =====");
        while (true) {
            System.out.println("Mời bạn nhập vào chức năng muốn sử dụng:");
            System.out.println("1. Tạo account");
            System.out.println("2. Tạo department");
            System.out.println("3. Thêm group vào account");
            int chucNang = scanner.nextInt();
            scanner.nextLine();

            if (chucNang == 1) {
                question5();
            } else if (chucNang == 2) {
                question6();
            } else if (chucNang == 3) {
                question9();
            } else {
                System.out.println("Mời bạn nhập lại");
                continue; // quay lại bước 1
            }

            if (!hoiTiepTuc()) {
                System.out.println("Kết thúc chương trình");
                return;
            }
        }
    }

    // Question 11: Menu có thêm chức năng 4 (thêm account vào group ngẫu nhiên)
    public static void question11() {
        System.out.println("===== Exercise 5 - Question 11 =====");
        while (true) {

            System.out.println("Mời bạn nhập vào chức năng muốn sử dụng:");
            System.out.println("1. Tạo account");
            System.out.println("2. Tạo department");
            System.out.println("3. Thêm group vào account");
            System.out.println("4. Thêm account vào 1 group ngẫu nhiên");
            int chucNang = scanner.nextInt();
            scanner.nextLine();

            if (chucNang == 1) {
                question5();
            } else if (chucNang == 2) {
                question6();
            } else if (chucNang == 3) {
                question9();
            } else if (chucNang == 4) {
                Account account = chonAccount();
                Group groupNgauNhien = Exercise1.groups[random.nextInt(Exercise1.groups.length)];
                System.out.println("Chương trình đã chọn ngẫu nhiên group: " + groupNgauNhien.name);
                // Bước 4: thêm account vào group
                themAccountVaoGroup(account, groupNgauNhien);
            } else {
                System.out.println("Mời bạn nhập lại");
                continue;
            }

            if (!hoiTiepTuc()) {
                System.out.println("Kết thúc chương trình");
                return;
            }
        }
    }

    // ================== CÁC METHOD HỖ TRỢ ==================

    // In danh sách username và cho người dùng chọn 1 account
    static Account chonAccount() {
        System.out.println("Danh sách username:");
        for (Account account : Exercise1.accounts) {
            System.out.println("- " + account.username);
        }

        while (true) {
            System.out.println("Nhập username của account:");
            String username = scanner.nextLine();

            for (Account account : Exercise1.accounts) {
                if (account.username.equals(username)) {
                    return account;
                }
            }
            System.out.println("Không tìm thấy username này, mời bạn nhập lại");
        }
    }

    // Thêm 1 account vào 1 group (tạo thêm 1 GroupAccount)
    static void themAccountVaoGroup(Account account, Group group) {
        // Kiểm tra account đã có trong group chưa
        for (GroupAccount ga : Exercise1.groupAccounts) {
            if (ga.account.id == account.id && ga.group.id == group.id) {
                System.out.println("Account " + account.username + " đã có trong group " + group.name + " rồi");
                return;
            }
        }

        GroupAccount gaMoi = new GroupAccount();
        gaMoi.account = account;
        gaMoi.group = group;
        gaMoi.joinDate = LocalDate.now();

        // Thêm vào cuối mảng groupAccounts
        GroupAccount[] mangMoi = new GroupAccount[Exercise1.groupAccounts.length + 1];
        for (int i = 0; i < Exercise1.groupAccounts.length; i++) {
            mangMoi[i] = Exercise1.groupAccounts[i];
        }
        mangMoi[mangMoi.length - 1] = gaMoi;
        Exercise1.groupAccounts = mangMoi;

        System.out.println("Đã thêm account " + account.username + " vào group " + group.name);
    }

    // Hỏi "Bạn có muốn thực hiện chức năng khác không?"
    // Trả về true nếu chọn Có, false nếu chọn Không
    static boolean hoiTiepTuc() {
        while (true) {
            System.out.println("Bạn có muốn thực hiện chức năng khác không? (Có/Không)");
            String traLoi = scanner.nextLine();

            if (traLoi.equalsIgnoreCase("Có") || traLoi.equalsIgnoreCase("co")) {
                return true;
            } else if (traLoi.equalsIgnoreCase("Không") || traLoi.equalsIgnoreCase("khong")) {
                return false;
            }
            System.out.println("Vui lòng nhập Có hoặc Không");
        }
    }

    public static void questionDemo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tuổi: ");
        int tuoi = scanner.nextInt();
        System.out.println("Nhập tên: ");
        String ten = scanner.nextLine();
        System.out.println("Nhập điểm: ");
        int diem = scanner.nextInt();

        System.out.println("Tuổi: " + tuoi);
        System.out.println("Tên: " + ten);
        System.out.println("Điểm: " + diem);
    }
}
