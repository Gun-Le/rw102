public class Answer {
    int id;
    String content;
    Question question;
    boolean isCorrect;

    void in() {
        System.out.println("id: " + id);
        System.out.println("content: " + content);
        System.out.println("question: " + question);
        System.out.println("isCorrect: " + isCorrect);
    }
}
