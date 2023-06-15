package bitedu.bipa.lesson2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseWork {
	
	public void insertData(ArrayList<StudentDTO> data) {
		// DB에 1000개의 DTO를 저장
		System.out.println(data.size());
		System.out.println(data.get(0));
		//this.testConnection();
		/*
		try {
			this.insert(data);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		this.insertWithBatchAndTransaction(data);
	}
	
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;
		String jdbcURL = "jdbc:mysql://localhost:3306/bitedu";
		String driver = "com.mysql.cj.jdbc.Driver";
		String id = "root";
		String password = "1234";
		
		Class.forName(driver);
		con = DriverManager.getConnection(jdbcURL,id,password);
		return con;
	}
	
	private void insertWithBatchAndTransaction(ArrayList<StudentDTO> list) {
		//batch 와 transaction을 적용하는 코드 작성
		Connection con = null;
		try {
			con = this.getConnection();
			con.setAutoCommit(false);
			//SQL 작성
			String sql = "insert into gisaTBL values (?,?,?,?,?,?,?,?,?,?,?)";
			//쿼리 (전용)전송 통로 생성
			PreparedStatement pstmt = con.prepareStatement(sql);
			int count = 0;
			for(StudentDTO dto : list) {
				//전송할 객체 자료
				//StudentDTO dto = list.get(0);		
				//통로를 통해서 쿼리 실행
				pstmt.setInt(1, dto.getStdNo());
				pstmt.setString(2, dto.getEmail());
				pstmt.setInt(3, dto.getKor());
				pstmt.setInt(4, dto.getEng());
				pstmt.setInt(5, dto.getMath());
				pstmt.setInt(6, dto.getSci());
				pstmt.setInt(7, dto.getHist());
				pstmt.setInt(8, dto.getTotal());
				pstmt.setString(9, dto.getMgrCode());
				pstmt.setString(10, dto.getAccCode());
				pstmt.setString(11, dto.getLocCode());
				pstmt.addBatch();
				count++;
				if(count%100==0) {
					pstmt.executeBatch();
					count = 0;
					System.out.println("100개 입력");
				}
			}
			if(count>0) {
				pstmt.executeBatch();
				System.out.println("final "+count+"개 입력");
			}
			con.commit();
			con.setAutoCommit(true);
			//통로 정리
			pstmt.close();
			//커넥션 정리
			con.close();
			System.out.println(list.size()+"개 자료 입력완료");
		} catch(SQLException se) {
			try {
				con.rollback();
				System.out.println(se.getMessage()+"\n위의 이유로 작업이 취소되었습니다.");
				con.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void insert(ArrayList<StudentDTO> list) throws ClassNotFoundException, SQLException {
		Connection con = this.getConnection();
		//SQL 작성
		String sql = "insert into gisaTBL values (?,?,?,?,?,?,?,?,?,?,?)";
		//쿼리 (전용)전송 통로 생성
		PreparedStatement pstmt = con.prepareStatement(sql);
		for(StudentDTO dto : list) {
			//전송할 객체 자료
			//StudentDTO dto = list.get(0);		
			//통로를 통해서 쿼리 실행
			pstmt.setInt(1, dto.getStdNo());
			pstmt.setString(2, dto.getEmail());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMath());
			pstmt.setInt(6, dto.getSci());
			pstmt.setInt(7, dto.getHist());
			pstmt.setInt(8, dto.getTotal());
			pstmt.setString(9, dto.getMgrCode());
			pstmt.setString(10, dto.getAccCode());
			pstmt.setString(11, dto.getLocCode());
			pstmt.executeUpdate();
		}
		//통로 정리
		pstmt.close();
		//커넥션 정리
		con.close();
		System.out.println("1000개 자료 입력완료");
	}
	
	private void testConnection() {
		Connection con = null;
		try {
			con = this.getConnection();
			if(con!=null) {
				System.out.println("connected");
				con.close();
			} else {
				System.out.println("fails");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public ArrayList<StudentDTO> getStudentData() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<StudentDTO> data = null;
		//DB의 데이터를 가져와서 List로 변경
		
		//컨넥션 생성
		Connection con = this.getConnection();
		//쿼리 생성
		String sql = "select * from gisaTBL";
		//쿼리 통로 생성
		Statement stmt = con.createStatement();
		//쿼리 실행
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			//쿼리 결과 받고 처리하기(List로 변경작업)
			
		}
		//통로 정리
		stmt.close();
		//컨넥션 정리
		con.close();
		return data;
	}
}






