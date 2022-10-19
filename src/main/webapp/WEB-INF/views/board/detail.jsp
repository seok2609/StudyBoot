<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>detail</h1>
    <table border="1" class="table table-striped col-lg-16">
        <thead class="table-info">
            <tr>
                <th>글번호</th>
                <th>작성자</th>
                <th>제목</th>
                <th>내용</th>
                <th>작성날짜</th>
            </tr>
        </thead>
        
        <tbody>
                <tr>
                    <td>${dto.num}</td>
                    <td>${dto.writer}</td>
                    <td>${dto.title}</td>
                    <td>${dto.contents}</td>
                    <td>${dto.regDate}</td>
                </tr>
                
        </tbody>
    </table>

</body>
</html>