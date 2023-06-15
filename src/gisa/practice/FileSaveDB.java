package gisa.practice;

import java.io.*;
import java.sql.*;

public class FileSaveDB {
    public static void main(String[] args) {
        Connection conn = null;
        File csv = new File("Abc1115.csv");
        BufferedReader reader;
        String line ;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student",
                    "root",
                    "0000"
            );

            conn.setAutoCommit(false);

            System.out.println("연결 성공");

            String sql = "" +
                    "INSERT INTO studentinfo (id, email, kor, eng, math, sci, hist, total, teacher, acc, reg) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            int rows= 0;
            reader = new BufferedReader(new FileReader(csv));
            while ((line = reader.readLine()) != null) {
                String[] lineArr = line.split(",");
                pstmt.setString(1, lineArr[0]);
                pstmt.setString(2, lineArr[1]);
                pstmt.setString(3, lineArr[2]);
                pstmt.setString(4, lineArr[3]);
                pstmt.setString(5, lineArr[4]);
                pstmt.setString(6, lineArr[5]);
                pstmt.setString(7, lineArr[6]);
                pstmt.setString(8, lineArr[7]);
                pstmt.setString(9, lineArr[8]);
                pstmt.setString(10, lineArr[9]);
                pstmt.setString(11, lineArr[10]);
                rows = pstmt.executeUpdate();
            }
            System.out.println("저장된 행 수 : " + rows);

            if (rows == 0) throw new Exception("저장 실패");
            pstmt.close();

            conn.commit();
            System.out.println("저장 성공");
        } catch (Exception e) {
            try {
                assert conn != null;
                conn.rollback();
            } catch (SQLException e1) {e1.printStackTrace();}

        } finally {
            if(conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                    System.out.println("연결 끊기");
                } catch (SQLException ignored) {
                }
            }
    }
}

}
