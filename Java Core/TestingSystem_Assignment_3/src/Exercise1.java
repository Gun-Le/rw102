import java.time.LocalDate;

public class Exercise1 {

    // ================== DỮ LIỆU (lấy từ bài 1) ==================
    // Khai báo ở đầu class để tất cả các question đều dùng được
    static Department dep1, dep2, dep3;
    static Position pos1, pos2, pos3;
    static Account acc1, acc2, acc3;
    static Group group1, group2, group3;
    static GroupAccount ga1, ga2, ga3;

    static Department[] departments;
    static Account[] accounts;
    static Group[] groups;
    static GroupAccount[] groupAccounts;

    // Khối static tự chạy 1 lần khi Program gọi Exercise1 lần đầu
    // → dữ liệu được tạo sẵn trước khi các question chạy
    static {
        // ===== Department =====
        dep1 = new Department();
        dep1.id = 1;
        dep1.name = "Sale";

        dep2 = new Department();
        dep2.id = 2;
        dep2.name = "Marketing";

        dep3 = new Department();
        dep3.id = 3;
        dep3.name = "Technical";

        // ===== Position =====
        pos1 = new Position();
        pos1.id = 1;
        pos1.name = PositionName.DEV;

        pos2 = new Position();
        pos2.id = 2;
        pos2.name = PositionName.TEST;

        pos3 = new Position();
        pos3.id = 3;
        pos3.name = PositionName.PM;

        // ===== Account =====
        acc1 = new Account();
        acc1.id = 1;
        acc1.email = "tin.le@vti.com.vn";
        acc1.username = "tinle";
        acc1.fullName = "Le Trung Tin";
        acc1.department = dep3;
        acc1.position = pos1;
        acc1.createDate = LocalDate.of(2024, 1, 15);

        acc2 = new Account();
        acc2.id = 2;
        acc2.email = "an.nguyen@vti.com.vn";
        acc2.username = "annguyen";
        acc2.fullName = "Nguyen Van An";
        acc2.department = dep1;
        acc2.position = pos2;
        acc2.createDate = LocalDate.of(2024, 3, 20);

        acc3 = new Account();
        acc3.id = 3;
        acc3.email = "binh.tran@vti.com.vn";
        acc3.username = "binhtran";
        acc3.fullName = "Tran Thi Binh";
        acc3.department = dep2;
        acc3.position = pos3;
        acc3.createDate = LocalDate.of(2024, 5, 10);

        // ===== Group =====
        group1 = new Group();
        group1.id = 1;
        group1.name = "Backend Team";
        group1.creator = acc1;
        group1.createDate = LocalDate.of(2024, 2, 1);

        group2 = new Group();
        group2.id = 2;
        group2.name = "Testing Team";
        group2.creator = acc2;
        group2.createDate = LocalDate.of(2024, 4, 1);

        group3 = new Group();
        group3.id = 3;
        group3.name = "Marketing Team";
        group3.creator = acc3;
        group3.createDate = LocalDate.of(2024, 6, 1);

        // ===== GroupAccount =====
        ga1 = new GroupAccount();
        ga1.group = group1;
        ga1.account = acc1;
        ga1.joinDate = LocalDate.of(2024, 2, 5);

        ga2 = new GroupAccount();
        ga2.group = group1;
        ga2.account = acc2;
        ga2.joinDate = LocalDate.of(2024, 2, 10);

        ga3 = new GroupAccount();
        ga3.group = group2;
        ga3.account = acc3;
        ga3.joinDate = LocalDate.of(2024, 4, 15);

        // ===== Gom vào mảng để dùng vòng lặp =====
        departments = new Department[] { dep1, dep2, dep3 };
        accounts = new Account[] { acc1, acc2, acc3 };
        groups = new Group[] { group1, group2, group3 };
        groupAccounts = new GroupAccount[] { ga1, ga2, ga3 };
    }

    // ======================== IF ========================

    // Question 1: Kiểm tra phòng ban của account thứ 2
    public static void question1() {
        System.out.println("===== Question 1 =====");
        if (acc2.department == null) {
            System.out.println("Nhân viên này chưa có phòng ban");
        } else {
            System.out.println("Phòng ban của nhân viên này là " + acc2.department.name);
        }
    }

    // Question 2: Kiểm tra group của account thứ 2
    public static void question2() {
        System.out.println("===== Question 2 =====");
        int groupCountAcc2 = 0;
        for (GroupAccount ga : groupAccounts) {
            if (ga.account.id == acc2.id) {
                groupCountAcc2++;
            }
        }

        if (groupCountAcc2 == 0) {
            System.out.println("Nhân viên này chưa có group");
        } else if (groupCountAcc2 == 1 || groupCountAcc2 == 2) {
            System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
        } else if (groupCountAcc2 == 3) {
            System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
        } else {
            System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }
    }

    // Question 3: Làm lại Question 1 bằng ternary
    public static void question3() {
        System.out.println("===== Question 3 =====");
        System.out.println(acc2.department == null
                ? "Nhân viên này chưa có phòng ban"
                : "Phòng ban của nhân viên này là " + acc2.department.name);
    }

    // Question 4: Kiểm tra Position của account thứ 1 bằng ternary
    public static void question4() {
        System.out.println("===== Question 4 =====");
        System.out.println(acc1.position != null && acc1.position.name == PositionName.DEV
                ? "Đây là Developer"
                : "Người này không phải là Developer");
    }

    // ======================== SWITCH CASE ========================

    // Question 5: Số thành viên trong group thứ 1
    public static void question5() {
        System.out.println("===== Question 5 =====");
        int accountCountGroup1 = 0;
        for (GroupAccount ga : groupAccounts) {
            if (ga.group.id == group1.id) {
                accountCountGroup1++;
            }
        }

        switch (accountCountGroup1) {
            case 1:
                System.out.println("Nhóm có một thành viên");
                break;
            case 2:
                System.out.println("Nhóm có hai thành viên");
                break;
            case 3:
                System.out.println("Nhóm có ba thành viên");
                break;
            default:
                System.out.println("Nhóm có nhiều thành viên");
        }
    }

    // Question 6: Làm lại Question 2 bằng switch case
    public static void question6() {
        System.out.println("===== Question 6 =====");
        // Mỗi method là riêng biệt nên phải đếm lại
        int groupCountAcc2 = 0;
        for (GroupAccount ga : groupAccounts) {
            if (ga.account.id == acc2.id) {
                groupCountAcc2++;
            }
        }

        switch (groupCountAcc2) {
            case 0:
                System.out.println("Nhân viên này chưa có group");
                break;
            case 1:
            case 2:
                System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
                break;
            case 3:
                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
                break;
            default:
                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }
    }

    // Question 7: Làm lại Question 4 bằng switch case
    public static void question7() {
        System.out.println("===== Question 7 =====");
        if (acc1.position == null) {
            System.out.println("Người này không phải là Developer");
            return;
        }
        switch (acc1.position.name) {
            case DEV:
                System.out.println("Đây là Developer");
                break;
            default:
                System.out.println("Người này không phải là Developer");
        }
    }

    // ======================== FOREACH ========================

    // Question 8: In Email, FullName, phòng ban của các account
    public static void question8() {
        System.out.println("===== Question 8 =====");
        for (Account account : accounts) {
            System.out.println("Email: " + account.email);
            System.out.println("Full name: " + account.fullName);
            System.out.println("Phòng ban: " + account.department.name);
            System.out.println();
        }
    }

    // Question 9: In id và name các phòng ban
    public static void question9() {
        System.out.println("===== Question 9 =====");
        for (Department department : departments) {
            System.out.println("Id: " + department.id);
            System.out.println("Name: " + department.name);
            System.out.println();
        }
    }

    // ======================== FOR ========================

    // Question 10: In thông tin account theo định dạng
    public static void question10() {
        System.out.println("===== Question 10 =====");
        for (int i = 0; i < accounts.length; i++) {
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.println("Email: " + accounts[i].email);
            System.out.println("Full name: " + accounts[i].fullName);
            System.out.println("Phòng ban: " + accounts[i].department.name);
            System.out.println();
        }
    }

    // Question 11: In thông tin department theo định dạng
    public static void question11() {
        System.out.println("===== Question 11 =====");
        for (int i = 0; i < departments.length; i++) {
            System.out.println("Thông tin department thứ " + (i + 1) + " là:");
            System.out.println("\t\t\tId: " + departments[i].id);
            System.out.println("\t\t\tName: " + departments[i].name);
        }
    }

    // Question 12: Chỉ in 2 department đầu tiên
    public static void question12() {
        System.out.println("===== Question 12 =====");
        for (int i = 0; i < 2; i++) {
            System.out.println("Thông tin department thứ " + (i + 1) + " là:");
            System.out.println("\t\t\tId: " + departments[i].id);
            System.out.println("\t\t\tName: " + departments[i].name);
        }
    }

    // Question 13: In tất cả account trừ account thứ 2
    public static void question13() {
        System.out.println("===== Question 13 =====");
        for (int i = 0; i < accounts.length; i++) {
            if (i == 1) {
                continue; // bỏ qua account thứ 2
            }
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.println("Email: " + accounts[i].email);
            System.out.println("Full name: " + accounts[i].fullName);
            System.out.println("Phòng ban: " + accounts[i].department.name);
            System.out.println();
        }
    }

    // Question 14: In các account có id < 4
    public static void question14() {
        System.out.println("===== Question 14 =====");
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].id < 4) {
                System.out.println("Thông tin account thứ " + (i + 1) + " là:");
                System.out.println("Email: " + accounts[i].email);
                System.out.println("Full name: " + accounts[i].fullName);
                System.out.println("Phòng ban: " + accounts[i].department.name);
                System.out.println();
            }
        }
    }

    // Question 15: In các số chẵn nhỏ hơn hoặc bằng 20
    public static void question15() {
        System.out.println("===== Question 15 =====");
        for (int i = 0; i <= 20; i = i + 2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // ======================== WHILE ========================

    // Question 16: Làm lại các Question phần FOR bằng WHILE + break, continue
    public static void question16() {
        System.out.println("===== Question 16 =====");

        // --- Làm lại Question 10 ---
        System.out.println("--- Q16 - làm lại Question 10 ---");
        int i = 0;
        while (i < accounts.length) {
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.println("Email: " + accounts[i].email);
            System.out.println("Full name: " + accounts[i].fullName);
            System.out.println("Phòng ban: " + accounts[i].department.name);
            System.out.println();
            i++;
        }

        // --- Làm lại Question 11 ---
        System.out.println("--- Q16 - làm lại Question 11 ---");
        i = 0;
        while (i < departments.length) {
            System.out.println("Thông tin department thứ " + (i + 1) + " là:");
            System.out.println("\t\t\tId: " + departments[i].id);
            System.out.println("\t\t\tName: " + departments[i].name);
            i++;
        }

        // --- Làm lại Question 12: dùng BREAK ---
        System.out.println("--- Q16 - làm lại Question 12 ---");
        i = 0;
        while (i < departments.length) {
            if (i == 2) {
                break; // in đủ 2 department thì dừng hẳn vòng lặp
            }
            System.out.println("Thông tin department thứ " + (i + 1) + " là:");
            System.out.println("\t\t\tId: " + departments[i].id);
            System.out.println("\t\t\tName: " + departments[i].name);
            i++;
        }

        // --- Làm lại Question 13: dùng CONTINUE ---
        System.out.println("--- Q16 - làm lại Question 13 ---");
        i = 0;
        while (i < accounts.length) {
            if (i == 1) {
                i++;      // PHẢI tăng i trước khi continue, nếu không sẽ lặp vô tận
                continue; // bỏ qua account thứ 2
            }
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.println("Email: " + accounts[i].email);
            System.out.println("Full name: " + accounts[i].fullName);
            System.out.println("Phòng ban: " + accounts[i].department.name);
            System.out.println();
            i++;
        }

        // --- Làm lại Question 14: dùng CONTINUE ---
        System.out.println("--- Q16 - làm lại Question 14 ---");
        i = 0;
        while (i < accounts.length) {
            if (accounts[i].id >= 4) {
                i++;
                continue; // bỏ qua account có id >= 4
            }
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.println("Email: " + accounts[i].email);
            System.out.println("Full name: " + accounts[i].fullName);
            System.out.println("Phòng ban: " + accounts[i].department.name);
            System.out.println();
            i++;
        }

        // --- Làm lại Question 15: dùng CONTINUE ---
        System.out.println("--- Q16 - làm lại Question 15 ---");
        i = 0;
        while (i <= 20) {
            if (i % 2 != 0) {
                i++;
                continue; // bỏ qua số lẻ
            }
            System.out.print(i + " ");
            i++;
        }
        System.out.println();
    }

    // ======================== DO-WHILE ========================

    // Question 17: Làm lại các Question phần FOR bằng DO-WHILE + break, continue
    public static void question17() {
        System.out.println("===== Question 17 =====");

        // --- Làm lại Question 10 ---
        System.out.println("--- Q17 - làm lại Question 10 ---");
        int i = 0;
        do {
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.println("Email: " + accounts[i].email);
            System.out.println("Full name: " + accounts[i].fullName);
            System.out.println("Phòng ban: " + accounts[i].department.name);
            System.out.println();
            i++;
        } while (i < accounts.length);

        // --- Làm lại Question 11 ---
        System.out.println("--- Q17 - làm lại Question 11 ---");
        i = 0;
        do {
            System.out.println("Thông tin department thứ " + (i + 1) + " là:");
            System.out.println("\t\t\tId: " + departments[i].id);
            System.out.println("\t\t\tName: " + departments[i].name);
            i++;
        } while (i < departments.length);

        // --- Làm lại Question 12: dùng BREAK ---
        System.out.println("--- Q17 - làm lại Question 12 ---");
        i = 0;
        do {
            if (i == 2) {
                break; // in đủ 2 department thì dừng
            }
            System.out.println("Thông tin department thứ " + (i + 1) + " là:");
            System.out.println("\t\t\tId: " + departments[i].id);
            System.out.println("\t\t\tName: " + departments[i].name);
            i++;
        } while (i < departments.length);

        // --- Làm lại Question 13: dùng CONTINUE ---
        System.out.println("--- Q17 - làm lại Question 13 ---");
        i = 0;
        do {
            if (i == 1) {
                i++;
                continue; // bỏ qua account thứ 2
            }
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.println("Email: " + accounts[i].email);
            System.out.println("Full name: " + accounts[i].fullName);
            System.out.println("Phòng ban: " + accounts[i].department.name);
            System.out.println();
            i++;
        } while (i < accounts.length);

        // --- Làm lại Question 14: dùng CONTINUE ---
        System.out.println("--- Q17 - làm lại Question 14 ---");
        i = 0;
        do {
            if (accounts[i].id >= 4) {
                i++;
                continue; // bỏ qua account có id >= 4
            }
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.println("Email: " + accounts[i].email);
            System.out.println("Full name: " + accounts[i].fullName);
            System.out.println("Phòng ban: " + accounts[i].department.name);
            System.out.println();
            i++;
        } while (i < accounts.length);

        // --- Làm lại Question 15: dùng CONTINUE ---
        System.out.println("--- Q17 - làm lại Question 15 ---");
        i = 0;
        do {
            if (i % 2 != 0) {
                i++;
                continue; // bỏ qua số lẻ
            }
            System.out.print(i + " ");
            i++;
        } while (i <= 20);
        System.out.println();
    }
}