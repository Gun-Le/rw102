import java.util.Scanner;

public static void questionDemo() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhập tuổi: ");
    int tuoi = scanner.nextInt();
    System.out.println("Nhập tên: ");
    String ten = scanner.nextLine();
    System.out.println("Nhập điểm: ");
    int diem  = scanner.nextInt();

    System.out.println("Tuổi: " + tuoi);
    System.out.println("Tên: " + ten);
    System.out.println("Điểm: " + diem);
}
