<%@page import="bitedu.bipa.book.vo.BookCopy"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<style>
* {
	margin: 0;
	padding: 0;
}

div.app {
	justify-content: center;
	align-items: center;
}

table, td {
	border: 1px solid #333;
	border-collapse: collapse;
}

table {
	width: 70%;
	margin: 20px auto; /* ���̺��� �������� �߾� �����մϴ�. */
}

td, th {
	padding: 3px;
}

thead, tfoot {
	background-color: #333;
	color: #fff;
}

td.center {
	text-align: center;
}

div.paging {
	width: 100%;
	display: inline-flex;
	align-items: center;
	margin-top: 20px;
	justify-content: center;
}

div.paging>i, div.paging>div.pages {
	margin: 0 10px;
}

div.paging>i, div.paging>div.pages>span {
	margin: 0 3px;
	cursor: pointer;
}

span.active {
	color: orangered;
	font-weight: bold;
}
</style>

</head>
<body>
	<div class="app">
		<table id="tblTodo">
			<caption></caption>
			<!-- <caption> �±״� HTML ���̺��� ĸ��(����)�� �����ϴ� �� ���˴ϴ�. <caption> �±״� <table> ����� ù ��° �ڽ� ��ҷ� ��ġ�ؾ� �մϴ�. -->
			<colgroup>
				<!-- HTML ���̺��� �� �׷��� �����ϴ� �� ��� -->
				<col width="10%" />
				<col width="*" />
				<col width="20%" />
				<col width="10%" />
			</colgroup>
			<thead>
				<!-- ���̺��� ��� -->
				<tr>
					<!-- ������ -->
					<th>����</th>
					<!-- �� -->
					<th>Ÿ��Ʋ</th>
					<th>����</th>
					<th>������</th>
				</tr>


			</thead>
			<tbody>
				<c:forEach var="list" items="${list}">
					<tr>
						<td>${list.bookSeq}</td>
						<td>${list.title}</td>
						<td>${list.author}</td>
						<td><fmt:formatDate value="${list.publishDate}"
								pattern="yyyy-MM-dd" /></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="paging">
			<!-- Icon�� fontawesome���� �����Խ��ϴ�. -->
			<i class="fa-solid fa-angles-left" id="first_page"></i>
			<!-- i �±״� �ܼ��� �ؽ�Ʈ�� ���Ÿ�ü�� ǥ���ϴ� ���Ҹ� ��-->
			<i class="fa-solid fa-angle-left" id="prev_page"></i>
			<div class="pages">
				<span class="active">1</span> <span>2</span> <span>3</span> <span>4</span>
				<span>5</span>
			</div>
			<i class="fa-solid fa-angle-right" id="next_page"></i> <i
				class="fa-solid fa-angles-right" id="last_page"></i>
		</div>
	</div>

</body>


</html>