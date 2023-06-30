<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INDEX</title>
</head>
<body>
<h1>INDEX</h1>
<jsp:forward page="./BlmController"></jsp:forward>		// 액션 태그 , RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response); 이걸로 바뀜 (BlmController)
	
</body>
</html>