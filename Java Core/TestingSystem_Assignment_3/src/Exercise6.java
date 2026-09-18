public class Exercise6 {

    // Question 1: In ra các số chẵn nguyên dương nhỏ hơn 10
    public static void question1() {
        System.out.println("===== Exercise 6 - Question 1 =====");
        for (int i = 2; i < 10; i = i + 2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Question 2: In thông tin các account
    public static void question2() {
        System.out.println("===== Exercise 6 - Question 2 =====");
        for (Account account : Exercise1.accounts) {
            String tenPhongBan = (account.department == null) ? "Chưa có phòng ban" : account.department.name;
            System.out.println("Id: " + account.id);
            System.out.println("Username: " + account.username);
            System.out.println("Email: " + account.email);
            System.out.println("Full name: " + account.fullName);
            System.out.println("Phòng ban: " + tenPhongBan);
            System.out.println();
        }
    }

    // Question 3: In ra các số nguyên dương nhỏ hơn 10
    public static void question3() {
        System.out.println("===== Exercise 6 - Question 3 =====");
        for (int i = 1; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
