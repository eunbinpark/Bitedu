package bitedu.bipa.book.Sample.SimpleLibrarySample.src.bitedu.bipa.quiz.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.util.Properties;

public class ConnectionManager2 {
	// 싱글톤으로 작성
	// data폴더의 db.properties를 이용하여 컨넥션 생성
    private static final String PROPERTIES_PATH = "Sample/SimpleLibrarySample/data/db.properties";
    public static Connection getConnection() throws IOException {
    Properties properties = new Properties();
    Connection con;

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(PROPERTIES_PATH);
            properties.load(fileReader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    String jdbcURL = properties.getProperty("jdbcURL");
    String driver = properties.getProperty("driver");
    String id = properties.getProperty("id");
    String pwd = properties.getProperty("pwd");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(jdbcURL,id,pwd);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    public static void closeConnection(Connection con, PreparedStatement pstmt, ResultSet rs){
        if(con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(pstmt != null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
