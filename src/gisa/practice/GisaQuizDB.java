package gisa.practice;

import java.sql.*;

public class GisaQuizDB {
    public String solveQuiz1() throws SQLException {
        Connection conn = null;
        String answer = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student",
                    "root",
                    "0000"
            );
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "" +
                "SELECT 학번, 국어점수, 영어점수, 지역" +
                "FROM studentinfo"+
                "WHERE 지역=?" +
                "ORDER BY (? + ?) ?" ;

        // PreparedStatement 얻기 및 값 지정
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "B");
        pstmt.setString(2, "국어점수");
        pstmt.setString(3, "영어점수");
        pstmt.setString(4, "DESC");

        // SQL문 실행 후, ResultSet을 통해 데이터 읽기
//        ResultSet rs = pstmt.executeQuery();
//        if(rs.next()){
//            StudentVO student = new StudentVO();
//        }

        return answer;
    }

    public String solveQuiz2(){
        String answer = null;

        return answer;
    }

    public String solveQuiz3(){
        String answer = null;

        return answer;
    }

    public String solveQuiz4(){
        String answer = null;

        return answer;
    }
}
