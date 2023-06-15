package gisa.lesson4;

import java.sql.*;

public class GisaDAO {
    // DB 관련 작업 전용 클래스

    public int selectQuiz(String sql) throws SQLException {
        int num = 0;
        Connection con = ConnectionManager.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            num = rs.getInt(1);
        }
        ConnectionManager.closeConnection(rs, stmt, con);

       return num;
    }

}
