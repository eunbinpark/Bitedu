package gisa.practice;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCenter {

    public static void main(String[] args) throws IOException {
        TestCenter tc = new TestCenter();
        tc.startTest();
    }

    public ArrayList<StudentDTO> readFile() {

        ArrayList<StudentDTO> students = new ArrayList<>();
        File csv = new File("Abc1115.csv");
        BufferedReader reader;
        String line;

        try {
            reader = new BufferedReader(new FileReader(csv));
            while ((line = reader.readLine()) != null) {
                StudentDTO student;
                String[] lineArr = line.split(",");
                List<String> aLine = Arrays.asList(lineArr);
                student = new StudentDTO(Integer.parseInt(aLine.get(0)), aLine.get(1), Integer.parseInt(aLine.get(2).trim()), Integer.parseInt(aLine.get(3).trim()), Integer.parseInt(aLine.get(4).trim()), Integer.parseInt(aLine.get(5).trim()), Integer.parseInt(aLine.get(6).trim()), Integer.parseInt(aLine.get(7).trim()), aLine.get(8).trim(), aLine.get(9), aLine.get(10));
                students.add(student);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
}

    public void startTest() throws IOException {
        System.out.println("시험지를 배부합니다.");
        ArrayList<StudentDTO> data = null;
        data = this.readFile();
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