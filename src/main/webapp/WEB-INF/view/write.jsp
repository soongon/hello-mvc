<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>글쓰기</h1>
<form action="/hello-mvc/bbs/write" method="post" name="frm">
	글번호: <input type="text" name="id"><br>
	제목: <input type="text" name="title"><br>
	작성자: <input type="text" name="author"><br>
	내용: <textarea name="content"></textarea><br>
	
	<input type="submit" value="글쓰기">
</form>
</body>
</html>