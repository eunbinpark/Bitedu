package bitedu.bipa.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bitedu.bipa.book.utils.ConnectionManager;
import bitedu.bipa.book.vo.BookCopy;

public class PagingDAO {
   private ConnectionManager manager;
   public PagingDAO() {
      manager = ConnectionManager.getInstance();
   }
   
   public ArrayList<BookCopy> selectBookAll(){
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
         
         while(rs.next()) {
            copy = new BookCopy();
            copy.setIsbn(rs.getString(1));
            copy.setTitle(rs.getString(2));
            copy.setAuthor(rs.getString(3));
            copy.setPublishDate(rs.getTimestamp(4));
            copy.setBookSeq(rs.getInt(5));
            copy.setBookPosition(rs.getString(6));
            copy.setBookStaus(rs.getString(7));
            list.add(copy);
         }
         con.close();
         pstmt.close();
         rs.close();
         //manager.closeConnection(rs, pstmt, con);
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return list;
   }
   

}