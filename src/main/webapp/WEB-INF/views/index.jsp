<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./temp/boot.jsp"></c:import>
<link href="./css/test.css" rel="styleSheet">
</head>
<body>
	<h1>이나은 페이지</h1>

	<img src="./images/naeun.jpg">
	<a href="./qna/list">QnA</a>
	
	<!-- <div>
		<img alt="" src="/file/qna/6399170c-1b61-4759-89d3-0a8631e74f0e_naeun.jpg">
	</div> -->
	
	<div>
		<img alt="" src="/file/qna/6fd44e23-2976-49f9-b09c-0075362c35a5_.jpg">
		<a href="/fileDown/qna?fileNum=23">QnaDown</a>
		<img alt="" src="/file/notice/1111.jpg">
		<a href="/fileDown/notice?fileNum=31">NoticeDown</a>
	</div>
</body>
</html>