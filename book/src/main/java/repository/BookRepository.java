package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionManager;
import vo.BookVO;

public class BookRepository {
	
	public boolean regist_book_info(BookVO book) {
		
		boolean flag = false;
        Connection con = ConnectionManager.getConnect();
        String sql = new StringBuilder().append("INSERT INTO book_info(book_isbn, book_title, book_author, book_published_date, book_publisher) ")
        								.append("values (?,?,?,?,?); ")
        								.toString();
        
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, book.getBook_isbn());
            pstmt.setString(2, book.getBook_title());
            pstmt.setString(3, book.getBook_author());
            pstmt.setString(4, book.getBook_published_date());
            pstmt.setString(5, book.getPublisher());
            
            
            int affected = pstmt.executeUpdate();

            if(affected > 0){
                flag = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
		
		return flag;
	}
	public boolean regist_book_copy(BookVO book) {
		boolean flag = false;
        Connection con = ConnectionManager.getConnect();
		String sql = new StringBuilder().append("INSERT INTO book_copy(book_isbn) ")
										.append("values (?);")
										.toString();
		PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, book.getBook_isbn());
            
            int affected = pstmt.executeUpdate();

            if(affected > 0){
                flag = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
		
		return flag;
	}
	public ArrayList<BookVO> getBookList(){
		Connection con = ConnectionManager.getConnect();
		ArrayList<BookVO> list;
		String sql = new StringBuilder().append("SELECT * ")
										.append("FROM BOOK_COPY a ")
										.append("JOIN BOOK_INFO b ")
										.append("on a.book_isbn = b.book_isbn")
										.toString();
		
		PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(sql);
            
            ResultSet rs = pstmt.executeQuery();
            list = new ArrayList<BookVO>();

            while(rs.next()){
                BookVO item = new BookVO();
                item.setBook_seq(rs.getString("book_seq"));
                item.setBook_author(rs.getString("book_author"));
                item.setBook_isbn(rs.getString("book_isbn"));
                item.setBook_position(rs.getString("book_position"));
                item.setBook_published_date(rs.getString("book_published_date"));
                item.setBook_status(rs.getString("book_status"));
                item.setBook_title(rs.getString("book_title"));
                item.setPublisher(rs.getString("book_publisher"));
                list.add(item);
            }
            //System.out.println(list);
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
		
	}
	
	public BookVO selectGetBookList(String book_isbn){
		Connection con = ConnectionManager.getConnect();
		BookVO selectbook = new BookVO();
		String sql = new StringBuilder().append("SELECT * ")
										.append("FROM BOOK_COPY a ")
										.append("JOIN BOOK_INFO b ")
										.append("on a.book_isbn = b.book_isbn ")
										.append("where b.book_isbn = ?")
										.toString();
		
		PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, book_isbn);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
            	selectbook.setBook_seq(rs.getString("book_seq"));
            	selectbook.setBook_author(rs.getString("book_author"));
            	selectbook.setBook_isbn(rs.getString("book_isbn"));
                selectbook.setBook_position(rs.getString("book_position"));
                selectbook.setBook_published_date(rs.getString("book_published_date"));
                selectbook.setBook_status(rs.getString("book_status"));
                selectbook.setBook_title(rs.getString("book_title"));
                selectbook.setPublisher(rs.getString("book_publisher"));
            }
            //System.out.println(list);
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return selectbook;
		
	}
	
//	public update 

}
