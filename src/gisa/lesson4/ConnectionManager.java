package gisa.lesson4;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionManager {
    public static void closeConnection(ResultSet rs, Statement stmt, Connection con){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
            rs = null;
        }

        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
            stmt = null;
        }

        if(con != null){
            try{
                con.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
            con = null;
        }
    }
    public static Connection getConnection() {
        Connection con = null;

        String jdbcURL = "";
        String driver = "";
        String id = "";
        String password = "";

        // Properties class 이용하기
        Properties p = new Properties();

        try {
            p.load(new FileReader("data/db/board.properties"));
            jdbcURL = p.getProperty("jdbcURL");
            driver = p.getProperty("driver");
            id = p.getProperty("id");
            password = p.getProperty("password");

        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            Class.forName(driver);
            con = DriverManager.getConnection(jdbcURL,id,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return con;
    }
}
