package bitedu.bipa.book.Sample.SimpleLibrarySample.src.bitedu.bipa.quiz.dao;

import bitedu.bipa.book.Sample.SimpleLibrarySample.src.bitedu.bipa.quiz.dto.BookDto;
import bitedu.bipa.book.Sample.SimpleLibrarySample.src.bitedu.bipa.quiz.util.ConnectionManager;
import bitedu.bipa.book.Sample.SimpleLibrarySample.src.bitedu.bipa.quiz.util.ConnectionManager2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


public class LibraryDAO {

	private Connection con;
	

	public LibraryDAO() throws IOException {
		this.con = ConnectionManager2.getConnection();
	}

	public void InsertBook(ArrayList<BookDto> books) throws IOException {

		Boolean flag = false;
		Connection con = ConnectionManager2.getConnection();

		String sql = "insert into book_info values(?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			for (BookDto book : books){
				pstmt.setString(1, book.getBookIsbn());
				pstmt.setString(2, book.getBookTitle());
				pstmt.setString(3, book.getBookAuthor());
				pstmt.setString(4, book.getBookPublishedDate());
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		flag = true;
		System.out.println("저장성공");

		ConnectionManager2.closeConnection(con, pstmt, null);
	}
	
		
	
	
	// 메소드 이름: selectBookInfoByUser 파라메터와 리턴타입은 분석에 의해 자유롭게
	
	
}
