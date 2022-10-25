<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<section class="container-fluid col-lg-10 mt-5">
	<h1>이나은 팬 목록</h1>
	
	<img src="../images/naeun.jpg">
	
	<div>
		<button class="btn btn-primary" type="button" onclick="location='/'">홈</button>
	</div>
	
	<div>
		<!-- <button class="btn btn-primary">Write</button> -->
		<div style="display: inline-block; margin: 0 5px;  float: right;">
			<a href="./add" class="btn btn-secondary">write</a>
		</div>
<!-- 		<button type="submit" class="btn btn-secondary">write</button> -->
	</div>
	
	<table border="1" class="table table-striped table-hover">
		<thead>
			<tr>
				<th>NUM</th>
				<th>WRITER</th>
				<th>TITLE</th>
				<th>CONTENTS</th>
				<th>HITS</th>
				<th>REGDATE</th>
<!-- 				<th>REF</th>
				<th>STEP</th>
				<th>DEPTH</th> -->
			</tr>
		</thead>
		
			<tbody>
				<c:forEach items="${requestScope.list}" var="qnaVO">
					
					<tr>
						<td>${qnaVO.num}</td>
						<td>${qnaVO.writer}</td>
						<td><a href="./detail?num=${qnaVO.num}">${qnaVO.title}</a></td>
						<!-- <td>${dto.title}</td> -->
				 		<td>${qnaVO.contents}</td>
						<td>${qnaVO.hits}</td>
						<td>${qnaVO.regDate}</td>
					</tr>
					
				</c:forEach>
				
			</tbody>
	</table>
	
	<script type="text/javascript">
		let result = '${param.result}';
		if(result != ""){
			if(result == '1'){
				alert('등록 성공');
			}else{
				alert('등록 실패');
			}
		}
	</script>

</section>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
			 integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
			  crossorigin="anonymous">
</script>    
</body>
</html>