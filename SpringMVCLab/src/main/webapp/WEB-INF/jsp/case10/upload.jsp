<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 파라미터는 없고 part 형식으로 보낸다.  -->
<form method="post" enctype="multipart/form-data">
	<input type="text" name="uploader"/>
	<input type="file" name="uploadFile"/>
	<button type="submit">업로드</button>
</form>
</body>
</html>