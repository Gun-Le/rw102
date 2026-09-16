import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {

        // ===== Department =====
        Department dep1 = new Department();
        dep1.id = 1;
        dep1.name = "Sale";

        Department dep2 = new Department();
        dep2.id = 2;
        dep2.name = "Marketing";

        Department dep3 = new Department();
        dep3.id = 3;
        dep3.name = "Technical";

        // ===== Position =====
        Position pos1 = new Position();
        pos1.id = 1;
        pos1.name = PositionName.DEV;

        Position pos2 = new Position();
        pos2.id = 2;
        pos2.name = PositionName.TEST;

        Position pos3 = new Position();
        pos3.id = 3;
        pos3.name = PositionName.PM;

        // ===== CategoryQuestion =====
        CategoryQuestion cat1 = new CategoryQuestion();
        cat1.id = 1;
        cat1.name = "Java";

        CategoryQuestion cat2 = new CategoryQuestion();
        cat2.id = 2;
        cat2.name = "SQL";

        CategoryQuestion cat3 = new CategoryQuestion();
        cat3.id = 3;
        cat3.name = "Postman";

        // ===== TypeQuestion =====
        TypeQuestion type1 = new TypeQuestion();
        type1.id = 1;
        type1.name = TypeName.ESSAY;

        TypeQuestion type2 = new TypeQuestion();
        type2.id = 2;
        type2.name = TypeName.MULTIPLE_CHOICE;

        TypeQuestion type3 = new TypeQuestion();
        type3.id = 3;
        type3.name = TypeName.ESSAY;

        // ===== Account =====
        Account acc1 = new Account();
        acc1.id = 1;
        acc1.email = "tin.le@vti.com.vn";
        acc1.username = "tinle";
        acc1.fullName = "Le Trung Tin";
        acc1.department = dep3;
        acc1.position = pos1;
        acc1.createDate = LocalDate.of(2024, 1, 15);

        Account acc2 = new Account();
        acc2.id = 2;
        acc2.email = "an.nguyen@vti.com.vn";
        acc2.username = "annguyen";
        acc2.fullName = "Nguyen Van An";
        acc2.department = dep1;
        acc2.position = pos2;
        acc2.createDate = LocalDate.of(2024, 3, 20);

        Account acc3 = new Account();
        acc3.id = 3;
        acc3.email = "binh.tran@vti.com.vn";
        acc3.username = "binhtran";
        acc3.fullName = "Tran Thi Binh";
        acc3.department = dep2;
        acc3.position = pos3;
        acc3.createDate = LocalDate.of(2024, 5, 10);

        // ===== Group =====
        Group group1 = new Group();
        group1.id = 1;
        group1.name = "Backend Team";
        group1.creator = acc1;
        group1.createDate = LocalDate.of(2024, 2, 1);

        Group group2 = new Group();
        group2.id = 2;
        group2.name = "Testing Team";
        group2.creator = acc2;
        group2.createDate = LocalDate.of(2024, 4, 1);

        Group group3 = new Group();
        group3.id = 3;
        group3.name = "Marketing Team";
        group3.creator = acc3;
        group3.createDate = LocalDate.of(2024, 6, 1);

        // ===== GroupAccount =====
        GroupAccount ga1 = new GroupAccount();
        ga1.group = group1;
        ga1.account = acc1;
        ga1.joinDate = LocalDate.of(2024, 2, 5);

        GroupAccount ga2 = new GroupAccount();
        ga2.group = group1;
        ga2.account = acc2;
        ga2.joinDate = LocalDate.of(2024, 2, 10);

        GroupAccount ga3 = new GroupAccount();
        ga3.group = group2;
        ga3.account = acc3;
        ga3.joinDate = LocalDate.of(2024, 4, 15);

        // ===== Question =====
        Question q1 = new Question();
        q1.id = 1;
        q1.content = "OOP la gi?";
        q1.category = cat1;
        q1.type = type1;
        q1.creator = acc1;
        q1.createDate = LocalDate.of(2024, 7, 1);

        Question q2 = new Question();
        q2.id = 2;
        q2.content = "JOIN trong SQL co may loai?";
        q2.category = cat2;
        q2.type = type2;
        q2.creator = acc2;
        q2.createDate = LocalDate.of(2024, 7, 5);

        Question q3 = new Question();
        q3.id = 3;
        q3.content = "Postman dung de lam gi?";
        q3.category = cat3;
        q3.type = type1;
        q3.creator = acc3;
        q3.createDate = LocalDate.of(2024, 7, 10);

        // ===== Answer =====
        Answer ans1 = new Answer();
        ans1.id = 1;
        ans1.content = "Lap trinh huong doi tuong";
        ans1.question = q1;
        ans1.isCorrect = true;

        Answer ans2 = new Answer();
        ans2.id = 2;
        ans2.content = "Co 4 loai JOIN chinh";
        ans2.question = q2;
        ans2.isCorrect = true;

        Answer ans3 = new Answer();
        ans3.id = 3;
        ans3.content = "Dung de viet code Java";
        ans3.question = q3;
        ans3.isCorrect = false;

        // ===== Exam =====
        Exam exam1 = new Exam();
        exam1.id = 1;
        exam1.code = "JAVA01";
        exam1.title = "Java Core Basic";
        exam1.category = cat1;
        exam1.duration = 60;
        exam1.creator = acc1;
        exam1.createDate = LocalDate.of(2024, 8, 1);

        Exam exam2 = new Exam();
        exam2.id = 2;
        exam2.code = "SQL01";
        exam2.title = "SQL Fundamentals";
        exam2.category = cat2;
        exam2.duration = 45;
        exam2.creator = acc2;
        exam2.createDate = LocalDate.of(2024, 8, 5);

        Exam exam3 = new Exam();
        exam3.id= 3;
        exam3.code = "API01";
        exam3.title = "API Testing";
        exam3.category = cat3;
        exam3.duration = 90;
        exam3.creator = acc3;
        exam3.createDate = LocalDate.of(2024, 8, 10);

        // ===== ExamQuestion =====
        ExamQuestion eq1 = new ExamQuestion();
        eq1.exam = exam1;
        eq1.question = q1;

        ExamQuestion eq2 = new ExamQuestion();
        eq2.exam = exam2;
        eq2.question = q2;

        ExamQuestion eq3 = new ExamQuestion();
        eq3.exam = exam3;
        eq3.question = q3;

        dep1.in();
        pos1.in();
        cat1.in();
        type1.in();
        acc1.in();
        group1.in();
        ga1.in();
        q1.in();
        ans1.in();
        exam1.in();
        eq1.in();

        Department[] departments = { dep1, dep2, dep3 };
        Account[] accounts = { acc1, acc2, acc3 };
        GroupAccount[] groupAccounts = { ga1, ga2, ga3 };

        // Question 1: Kiểm tra phòng ban của account thứ 2
        System.out.println("===== Question 1 =====");
        if (acc2.department == null) {
            System.out.println("Nhân viên này chưa có phòng ban");
        } else {
            System.out.println("Phòng ban của nhân viên này là " + acc2.department.name);
        }

        // Question 2: Kiểm tra group của account thứ 2
        System.out.println("===== Question 2 =====");
        // Đếm xem account thứ 2 có mặt trong bao nhiêu group
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

        // Question 3: Làm lại Question 1 bằng ternary
        System.out.println("===== Question 3 =====");
        System.out.println(acc2.department == null
                ? "Nhân viên này chưa có phòng ban"
                : "Phòng ban của nhân viên này là " + acc2.department.name);

        // Question 4: Kiểm tra Position của account thứ 1 bằng ternary
        System.out.println("===== Question 4 =====");
        System.out.println(acc1.position.name == PositionName.DEV
                ? "Đây là Developer"
                : "Người này không phải là Developer");

        // ================== BÀI 2 - SWITCH CASE ==================

        // Question 5: Số thành viên trong group thứ 1
        System.out.println("===== Question 5 =====");
        // Đếm xem group thứ 1 có bao nhiêu account
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

        // Question 6: Làm lại Question 2 bằng switch case
        // (dùng lại biến groupCountAcc2 đã đếm ở Question 2)
        System.out.println("===== Question 6 =====");
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

        // Question 7: Làm lại Question 4 bằng switch case
        System.out.println("===== Question 7 =====");
        switch (acc1.position.name) {
            case DEV:
                System.out.println("Đây là Developer");
                break;
            default:
                System.out.println("Người này không phải là Developer");
        }

        // ================== BÀI 2 - FOREACH ==================

        // Question 8: In Email, FullName, phòng ban của các account
        System.out.println("===== Question 8 =====");
        for (Account account : accounts) {
            System.out.println("Email: " + account.email);
            System.out.println("Full name: " + account.fullName);
            System.out.println("Phòng ban: " + account.department.name);
            System.out.println();
        }

        // Question 9: In id và name các phòng ban
        System.out.println("===== Question 9 =====");
        for (Department department : departments) {
            System.out.println("Id: " + department.id);
            System.out.println("Name: " + department.name);
            System.out.println();
        }

        // ================== BÀI 2 - FOR ==================

        // Question 10: In thông tin account theo định dạng
        System.out.println("===== Question 10 =====");
        for (int i = 0; i < accounts.length; i++) {
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.println("Email: " + accounts[i].email);
            System.out.println("Full name: " + accounts[i].fullName);
            System.out.println("Phòng ban: " + accounts[i].department.name);
            System.out.println();
        }

        // Question 11: In thông tin department theo định dạng
        System.out.println("===== Question 11 =====");
        for (int i = 0; i < departments.length; i++) {
            System.out.println("Thông tin department thứ " + (i + 1) + " là:");
            System.out.println("\t\t\tId: " + departments[i].id);
            System.out.println("\t\t\tName: " + departments[i].name);
        }

        // Question 12: Chỉ in 2 department đầu tiên
        System.out.println("===== Question 12 =====");
        for (int i = 0; i < 2; i++) {
            System.out.println("Thông tin department thứ " + (i + 1) + " là:");
            System.out.println("\t\t\tId: " + departments[i].id);
            System.out.println("\t\t\tName: " + departments[i].name);
        }

        // Question 13: In tất cả account trừ account thứ 2
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

        // Question 14: In các account có id < 4
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

        // Question 15: In các số chẵn nhỏ hơn hoặc bằng 20
        System.out.println("===== Question 15 =====");
        for (int i = 0; i <= 20; i = i + 2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
