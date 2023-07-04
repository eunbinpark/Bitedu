<%@page import="bitedu.bipa.member.vo.BookCopy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록</title>
<style>
        table, td, th {
            border : 1px solid black;
            border-collapse: collapse;
            margin: 20px auto;
        }
        td {
            width: 150px;
            height: 50px;
            padding: 5px;
            font-size: 20px;
            /* text-align: center; */
        }

        input , select {
            font-size: 20px;
        }
        .data_ui {
            /* width: 250px; */
            height: 50px;
        }

        button {
            font-size: 15px;
            margin: 5px;
        }
        
        
        #sending {
        	text-align: center;
        }
        
        input.poster :disabled {
        	background: gray;
        }
        
        #form {
        	font-size: 30px;
        }
        
        #message {
        	color: red;
        }
    </style>
    <script type="text/javascript" src="https://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$('#go_book_update').on('click',function(){
			let form = $('#frm');
			form.attr('action','/MemberSample0629/BlmController?cmd=update');
			form.submit();
			
		});
		$('#go_book_list').on('click',function(){
			let form = $('#frm');
			form.attr('action','/MemberSample0629/BlmController?cmd=list')
			form.submit();
			
		});
	});
	</script>
</head>
<body>

<form action="" method="post" id="frm">
    <table>
        <tr><th colspan="4" id="form">도서 상세</th></tr>
        <tr><th>구분</th><th class="data_ui" colspan="2">데이터입력</th><th>비고</th></tr>
        <tr>
            <td>도서번호</td>
            <td colspan="2">
            	<input type="text" id="book_seq" name="book_seq" value="${book.bookSeq}" readonly>
            </td>
            <td id="message"></td></tr>
        <tr>
        	<td>ISBN</td>
        	<td colspan="2">
        		<input type="text" id="isbn" name="isbn" value ="${book.isbn}" readonly>
        	</td>
        	<td>
        		<input type="hidden" id="flag" value="false">
        	</td>
        </tr>
        <tr>
        	<td>도서명</td>
        	<td colspan="2">
        		<input type="text" id="book_title" name="book_title" value ="${book.title}">
        	</td><td></td>
        </tr>
        <tr>
        	<td>저자/역자</td>
        	<td colspan="2">
        		<input type="text" id="author" name="author" value ="${book.author}">
        	</td><td></td>
        </tr>
        <tr>
        	<td>출판사</td>
        	<td colspan="2">
        		<input type="text" id="publisher" size="35" name="publisher" value ="${book.publisher}">
        	</td><td></td>
        </tr>
        <tr>
        	<td>출판일</td>
        	<td colspan="2">
        		<input type="text" id="publish_date" size="35" name="publish_date" value="<fmt:formatDate value="${book.publishDate}" pattern="yyyy-MM-dd" />">
        	</td>
        	<td></td>
        <tr>
        <tr>
        	<td>도서위치</td>
        	<td colspan="2">
        		<select name="book_position">
        			<option value='BS'>--도서 위치--
        			<option value='BS-001' selected>일반서가
        			<option value='BS-002'>예약서가
        			<option value='BS-'>회원
        		</select>
        	</td>
        	<td></td>
        <tr>
        <tr>
        	<td>도서상태</td>
        	<td colspan="2">
        		<select name="book_status">
        			<option value='BM'>--도서 상태--
        			<option value='BM-001' selected>도서대출서비스
        			<option value='BM-002'>도서수선
        			<option value='BM-003'>도서저장고
        		</select>
        	</td>
        	<td></td>
        <tr>
        <tr>
        	<td colspan="4" id="sending">
        		<input type="submit" value="도서수정" id="go_book_update"> 
        		<input type="reset">
        		<input type="submit" value="도서리스트" id="go_book_list">
        	</td>
        </tr>
    </table>
</form>
</body>
</html>