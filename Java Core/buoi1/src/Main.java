import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public enum GioiTinh {
        NAM, NU, KHAC
    }
    public static void main(String[] args) {
        System.out.println("Hello World");
        String fullname = "Lê Trung Tín";
        int age = 27;
        float point = 7.5f;
        LocalDate birthday = LocalDate.of(2005,4,15);
        Date date = new Date();
        LocalDateTime date1 = LocalDateTime.now();
        Gender gender1 = Gender.MALE;

        System.out.println("Fullname: " + fullname);
        System.out.println("Age: " + age);
        System.out.println("Point: " + point);
        System.out.println("Birthday " + birthday);
        System.out.println("Date: " + date);
        System.out.println("DateTime" + date1);
        System.out.println("Gender: " + gender1);
        System.out.println("Giới tính: " + GioiTinh.NAM);
    }
}
