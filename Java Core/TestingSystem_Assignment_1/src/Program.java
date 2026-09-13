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

        // ===== Question 3: In gia tri =====
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
    }
}
