public class Exercise5 {

    // Question 5: So sánh 2 phòng ban xem tên có bằng nhau không
    public static void question5() {
        System.out.println("===== Exercise 5 - Question 5 =====");
        Department dep1 = new Department();
        dep1.id = 1;
        dep1.name = "Sale";

        Department dep2 = new Department();
        dep2.id = 2;
        dep2.name = "Marketing";

        System.out.println("Phòng ban 1: " + dep1.name);
        System.out.println("Phòng ban 2: " + dep2.name);

        // So sánh chuỗi phải dùng equals, không dùng dấu ==
        if (dep1.name.equals(dep2.name)) {
            System.out.println("2 phòng ban bằng nhau");
        } else {
            System.out.println("2 phòng ban không bằng nhau");
        }
    }

    // Question 6: Sắp xếp 5 phòng ban tăng dần theo tên (vần ABCD)
    public static void question6() {
        System.out.println("===== Exercise 5 - Question 6 =====");
        Department[] departments = taoDanhSachPhongBan(
                "Sale", "Marketing", "Accounting", "waiting room", "Boss of director");

        // Sắp xếp nổi bọt: so từng cặp cạnh nhau, sai thứ tự thì đổi chỗ
        for (int i = 0; i < departments.length - 1; i++) {
            for (int j = 0; j < departments.length - 1 - i; j++) {
                // compareToIgnoreCase: so sánh theo vần ABCD, KHÔNG phân biệt hoa thường
                // trả về số dương nghĩa là tên đứng trước lớn hơn -> phải đổi chỗ
                if (departments[j].name.compareToIgnoreCase(departments[j + 1].name) > 0) {
                    Department tam = departments[j];
                    departments[j] = departments[j + 1];
                    departments[j + 1] = tam;
                }
            }
        }

        for (Department department : departments) {
            System.out.println(department.name);
        }
    }

    // Question 7: Sắp xếp theo tên, có phân biệt chữ hoa chữ thường
    public static void question7() {
        System.out.println("===== Exercise 5 - Question 7 =====");
        Department[] departments = taoDanhSachPhongBan(
                "sale", "Marketing", "Accounting", "Waiting room", "Boss of director");

        for (int i = 0; i < departments.length - 1; i++) {
            for (int j = 0; j < departments.length - 1 - i; j++) {
                // compareTo: có phân biệt hoa thường, chữ HOA luôn đứng trước chữ thường
                if (departments[j].name.compareTo(departments[j + 1].name) > 0) {
                    Department tam = departments[j];
                    departments[j] = departments[j + 1];
                    departments[j + 1] = tam;
                }
            }
        }

        for (Department department : departments) {
            System.out.println(department.name);
        }
    }

    // Method hỗ trợ: tạo mảng Department từ danh sách tên
    static Department[] taoDanhSachPhongBan(String... tenCacPhongBan) {
        Department[] departments = new Department[tenCacPhongBan.length];
        for (int i = 0; i < tenCacPhongBan.length; i++) {
            Department department = new Department();
            department.id = i + 1;
            department.name = tenCacPhongBan[i];
            departments[i] = department;
        }
        return departments;
    }
}
