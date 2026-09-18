import java.time.LocalDate;

public class Group {
    int id;
    String name;
    Account creator;
    LocalDate createDate;


    void in() {
        System.out.println("id: " + id);
        System.out.println("name: " + name);
        System.out.println("creator: " + creator.fullName);
        System.out.println("createDate: " + createDate);
    }
}