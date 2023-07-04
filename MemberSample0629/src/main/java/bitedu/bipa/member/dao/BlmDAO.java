package bitedu.bipa.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bitedu.bipa.member.utils.ConnectionManager;
import bitedu.bipa.member.vo.BookCopy;

public class BlmDAO {
	private ConnectionManager manager;

	public BlmDAO() {
		manager = ConnectionManager.getInstance();
	}

	public boolean insertBook(BookCopy copy) {
		boolean flag = false;
		String sql1 = "insert into book_info(book_isbn, book_title, book_author, book_publisher, book_published_date) values (?,?,?,?,?)";
		String sql2 = "insert into book_copy(book_isbn) values (?)";
		Connection con = manager.getConnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, copy.getIsbn());
			pstmt.setString(2, copy.getTitle());
			pstmt.setString(3, copy.getAuthor());
			pstmt.setString(4, copy.getPublisher());
			pstmt.setTimestamp(5, copy.getPublishDate());
			int affectedCount = pstmt.executeUpdate();
			System.out.println("1");
			if (affectedCount > 0) {
				System.out.println("2");
				pstmt = con.prepareStatement(sql2);
				pstmt.setString(1, copy.getIsbn());
				affectedCount = pstmt.executeUpdate();
				if (affectedCount > 0) {
					flag = true;
					con.commit();
					System.out.println("commit");
				}
			} else {
				con.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
				System.out.println("rollback");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				con.setAutoCommit(true);
				manager.closeConnection(null, null, con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return flag;
	}

	public ArrayList<BookCopy> selectBookAll() {
		ArrayList<BookCopy> list = null;
		list = new ArrayList<BookCopy>();
		BookCopy copy = null;
		StringBuilder sb = new StringBuilder("select a.*, b.* from book_info a ");
		sb.append("inner join book_copy b on a.book_isbn=b.book_isbn");
		String sql = sb.toString();
		Connection con = manager.getConnection();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				copy = new BookCopy();
				copy.setBookSeq(rs.getInt(1));
				copy.setIsbn(rs.getString(2));
				copy.setTitle(rs.getString(3));
				copy.setAuthor(rs.getString(4));
				copy.setPublisher(rs.getString(5));
				copy.setPublishDate(rs.getTimestamp(6));
				copy.setBookPosition(rs.getString(7));
				copy.setBookStaus(rs.getString(8));
				list.add(copy);
			}
			con.close();
			pstmt.close();
			rs.close();
			// manager.closeConnection(rs, pstmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public boolean deleteBook(int parseInt) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "delete from book_info where book_seq = ?";
		Connection con = manager.getConnection();
		PreparedStatement pstmt = null;
		System.out.println(parseInt);
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, parseInt);
			System.out.println(pstmt);
			int affectedCount = pstmt.executeUpdate();
			System.out.println(affectedCount);
			if (affectedCount > 0) {
				flag = true;
			}
			manager.closeConnection(null, pstmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	public boolean updateBook(BookCopy book) {
		boolean flag = false;
		String sql = "update book_info \r\n"
				+ "set book_title = ?, book_author = ?, book_publisher = ?, book_published_date = ? \r\n"
				+ "where book_seq = ?;";
		Connection con = manager.getConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getPublisher());
			pstmt.setTimestamp(4, book.getPublishDate());
			pstmt.setInt(5, book.getBookSeq());
			int affectedCount = pstmt.executeUpdate();
			if (affectedCount > 0) {
				flag = true;
			}
			System.out.println(pstmt);
			manager.closeConnection(null, pstmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}
}