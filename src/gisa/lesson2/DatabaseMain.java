package gisa.lesson2;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DatabaseMain main = new DatabaseMain();
//        main.makeTable();
        main.testStart();
    }

    public void testStart() throws SQLException, ClassNotFoundException {
        ArrayList<StudentDTO> data = this.readyData();
        System.out.println("시험을 시작합니다.");
        GisaQuiz quiz = new GisaQuiz(data);
        String answer1 = quiz.solveQuiz1();
        String answer2 = quiz.solveQuiz2();
        String answer3 = quiz.solveQuiz3();
        String answer4 = quiz.solveQuiz4();
        System.out.println("시험을 종료합니다.");
    }

    private ArrayList<StudentDTO> readyData() throws SQLException, ClassNotFoundException {
        ArrayList<StudentDTO> data = null;
        // file 처리 대신 DB 처리
        DatabaseWork work = new DatabaseWork();
        data = work.getStudentData();
        return data;
    }

    public void makeTable() {
        try {
            this.makeData();
        } catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    // DB에 데이터 넣기
    public void makeData() throws SQLException, ClassNotFoundException {

        ArrayList<StudentDTO> students = new ArrayList<>();
        File csv = new File("Abc1115.csv");
        BufferedReader reader;
        String line ;

        try {
            reader = new BufferedReader(new FileReader(csv));
            while ((line = reader.readLine()) != null) {
                StudentDTO student;
                String[] lineArr = line.split(",");
                List<String> aLine = Arrays.asList(lineArr);
                student = new StudentDTO(Integer.parseInt(aLine.get(0)), aLine.get(1), Integer.parseInt(aLine.get(2).trim()),
                        Integer.parseInt(aLine.get(3).trim()), Integer.parseInt(aLine.get(4).trim()), Integer.parseInt(aLine.get(5).trim()),
                        Integer.parseInt(aLine.get(6).trim()), Integer.parseInt(aLine.get(7).trim()), aLine.get(8).trim(), aLine.get(9), aLine.get(10));
                students.add(student);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        DatabaseWork work = new DatabaseWork();
        work.insertData(students);

    }
}
