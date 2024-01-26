package hexlet.code;

public class GenerateQAA {
    private String question;
    private String answer;

    public GenerateQAA(String q, String a) {
        question = q;
        answer = a;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String toString() {
        return getAnswer() + " " + getQuestion();
    }
}
