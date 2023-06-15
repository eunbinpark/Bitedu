package gisa.practice;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TestCenterByDB {
    public static void main(String[] args) throws IOException {
        TestCenterByDB tc = new TestCenterByDB();
        tc.startTest();
    }

    public void startTest() throws IOException {
        System.out.println("시험지를 배부합니다.");
        ArrayList<StudentDTO> data = null;
        System.out.println("시험을 시작합니다.");
        GisaQuiz quiz = new GisaQuiz(data);
        String answer = quiz.solveQuiz1();
        this.submitAnswer(1, answer);
        answer = quiz.solveQuiz2();
        this.submitAnswer(2, answer);
        answer = quiz.solveQuiz3();
        this.submitAnswer(3, answer);
        answer = quiz.solveQuiz4();
        this.submitAnswer(4, answer);
        System.out.println("답안지를 모두 제출합니다.");
        System.out.println("시험을 종료합니다.");
    }

    private void submitAnswer(int num, String answer) throws IOException {
        FileWriter output = new FileWriter("C:/Users/금정산2_PC07/Documents/bitedu-java/Ans"+num+".txt");
        output.write(answer);
        output.close();
    }
}
