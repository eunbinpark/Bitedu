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
	margin: 20px auto; /* 테이블을 수평으로 중앙 정렬합니다. */
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
			<!-- <caption> 태그는 HTML 테이블의 캡션(제목)을 정의하는 데 사용됩니다. <caption> 태그는 <table> 요소의 첫 번째 자식 요소로 위치해야 합니다. -->
			<colgroup>
				<!-- HTML 테이블의 열 그룹을 정의하는 데 사용 -->
				<col width="10%" />
				<col width="*" />
				<col width="20%" />
				<col width="10%" />
			</colgroup>
			<thead>
				<!-- 테이블의 헤더 -->
				<tr>
					<!-- 가로줄 -->
					<th>순번</th>
					<!-- 셀 -->
					<th>타이틀</th>
					<th>저자</th>
					<th>출판일</th>
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
			<!-- Icon은 fontawesome에서 가져왔습니다. -->
			<i class="fa-solid fa-angles-left" id="first_page"></i>
			<!-- i 태그는 단순히 텍스트를 이탤릭체로 표시하는 역할만 함-->
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