<%@page import="vo.BookVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 목록</title>
<style>
   table, th, td {
      border: 1px solid black;
      font-size: 20px;
      border-collapse:collapse;
      padding:20px;
   }
   th {
      font-size:32px;
   }
</style>
</head>
<body>
<% 
	ArrayList<BookVO> list = (ArrayList<BookVO>)request.getAttribute("bookList");
%>
   
   <table>
      <tr>
         <th colspan="5">도서리스트</th>
      </tr>
      <tr>
         <td>순번</td>
         <td>타이틀</td>
         <td>저자</td>
         <td>출판일</td>
         <td></td>
      </tr>
      <% for(BookVO booklist:list) {%>
      <tr>
         <td><%= booklist.getBook_seq() %></td>
         <td><a href="/book/BookRegistController?book_isbn=<%= booklist.getBook_isbn() %>&toggle=1"><%= booklist.getBook_title() %></a></td>
         <td><%= booklist.getBook_author() %></td>
         <td><%= booklist.getBook_published_date() %></td>
         <td><a href="/book/BookRegistController?book_isbn=<%= booklist.getBook_isbn() %>&toggle=2">삭제</a></td>
      </tr>
      <%} %>
      
      <tr>
         <td colspan='5'><input type="button" value="도서등록"></td>
      </tr>
   </table>
   
</body>
</html>