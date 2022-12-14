<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous"
>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
    <section class="container-fluid col-lg-10 mt-5">
	<h1>detail</h1>
    <h3>제목 : ${qnaVO.title}</h3>
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
                    <td>${qnaVO.num}</td>
                    <td>${qnaVO.writer}</td>
                    <td>${qnaVO.title}</td>
                    <td>${qnaVO.contents}</td>
                    <td>${qnaVO.regDate}</td>
                </tr>


                
            </tbody>
        </table>

        <div class="row border border-top-2 border-danger bg-light"  style="min-height: 60vh" >
            <div class="col">아니 왜 안나와
                <c:forEach items="${qnaVO.qnaFileVOs}" var="qnaFileVO">
                    <!-- <a href="../../../static/upload/qna/${fileVO.fileName}">${fileVO.oriName}</a> -->
                    <!-- <img src="./result/upload/qna/${qnaFileVO.fileName}" width="300px" height="300px"> -->
                    <img src="/file/qna/${qnaFileVO.fileName}" alt="">
                    <%-- <a href="/file/qna/${qnaFileVO.fileName}"></a> --%>
                    <a href="/fileDown/qna?fileNum=${qnaFileVO.fileNum}">${qnaFileVO.oriName}</a>
                </c:forEach>
            </div>
        </div>

        <div>
            <a href="update?num=${qnaVO.num}">수정</a>
        </div>

        <button class="btn btn-primary" type="button" onclick="location='./list'">목록</button>
</section>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
			 integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
			  crossorigin="anonymous">
</script>    
</body>
</html>