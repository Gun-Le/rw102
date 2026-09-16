import java.time.LocalDate;

public class Question {
    int id;
    String content;
    CategoryQuestion category;
    TypeQuestion type;
    Account creator;
    LocalDate createDate;

    void in (){
        System.out.println("id: " + id);
        System.out.println("content: " + content);
        System.out.println("category: " + category.name);
        System.out.println("type: " + type.name);
        System.out.println("creator: " + creator.fullName);
        System.out.println("createDate: " + createDate);
    }
}
