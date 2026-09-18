import java.time.LocalDate;

public class GroupAccount {
    Group group;
    Account account;
    LocalDate joinDate;

    void in() {
        System.out.println("group: " + group);
        System.out.println("account: " + account.fullName);
        System.out.println("joinDate: " + joinDate);
    }
}
