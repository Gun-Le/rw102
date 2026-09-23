import java.time.LocalDate;

public class Exam {
    int id;
    String code;
    String title;
    CategoryQuestion category;
    int duration;
    Account creator;
    LocalDate createDate;

    void in() {
        System.out.println("id: " + id);
        System.out.println("code: " + code);
        System.out.println("title: " + title);
        System.out.println("category: " + category.name);
        System.out.println("duration: " + duration);
        System.out.println("creator: " + creator.fullName);
        System.out.println("createDate: " + createDate);
    }
}
