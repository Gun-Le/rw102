import java.time.LocalDate;

public class Account {
    int id;
    String email;
    String username;
    String fullName;
    Department department;
    Position position;
    LocalDate createDate;


    void in() {
        System.out.println("id: " + id);
        System.out.println("username: " + username);
        System.out.println("fullName: " + fullName);
        System.out.println("email: " + email);
        System.out.println("department: " + department.name);
        System.out.println("position: " + position.name);
        System.out.println("createDate: " + createDate);
    }
}
