<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1>회원가입 페이지</h1>


	<form action="add" method="post">
	
		  <div class="mb-3">
		    <label for="exampleInputEmail1" class="form-label">아이디</label>
		    <input type="text" class="form-control" id="exampleInputEmail1" name="id" placeholder="ID를 입력하세요">
		  </div>
		  
		  
		  <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">비밀번호</label>
		    <input type="password" class="form-control" id="exampleInputPassword1" name="pw" placeholder="비밀번호를 입력하세요">
		  </div>
		  
		  
		  <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">이름</label>
		    <input type="text" class="form-control" id="exampleInputPassword1" name="name" placeholder="이름을 입력하세요">
		  </div>
		  
		  
		  <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">이메일</label>
		    <input type="text" class="form-control" id="exampleInputPassword1" name="email" placeholder="이메일을 입력하세요">
		  </div>
		
		  <button type="submit" class="btn btn-primary">회원가입</button>
		  
	</form>


<img src="../images/naeun111.jpg">


</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
			 integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
			  crossorigin="anonymous">
</script>    
</body>
</html>