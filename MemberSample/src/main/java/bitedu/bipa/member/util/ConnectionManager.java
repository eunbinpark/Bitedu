package bitedu.bipa.member.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//커넥션 매니저 singleton으로 작성 --> 외부에서 객체를 생성하지 않고 내부에서 생성해서 보내준다.
public class ConnectionManager {
	private static ConnectionManager manager;

	private ConnectionManager() {  // private <-- 객체생성 불가
		
	}
	public static ConnectionManager getInstance() { //static 객체 생성 전 실행 
		if(manager==null) {
			manager = new ConnectionManager();
		}
		
		return manager;
	}
	public Connection getConncetion() {
		Connection con =null;
		return con;
	}
	
	public void closeConnection(ResultSet rs, Statement stmt, Connection con) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;
		}
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stmt = null;
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = null;
		}
	}

}
