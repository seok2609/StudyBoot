<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<c:import url="../temp/boot.jsp"></c:import>
<script defer src="/js/memberAdd.js"></script>
<script defer src="/js/util.js"></script>
</head>
<body>
<section class="container-fluid col-lg-10 mt-5">
	<h1>회원가입 페이지</h1>

	<form:form modelAttribute="memberVO" action="add" method="post">

			<sec:csrfInput/>
		  <div class="mb-3">
			  <label for="inputID" class="form-label">아이디</label>
		  <form:input path="id" cssClass="form-control" id="inputID"/>
		  <!--   <input type="text" class="form-control" id="inputID" name="id" placeholder="ID를 입력하세요"> -->
			<form:errors path="id"></form:errors>
			<span id="idHelp"></span>
		  </div>
		  
		  
		  <div class="mb-3">
		    <label for="inputPW" class="form-label">비밀번호</label>
		    <form:password path="pw" cssClass="form-control" id="inputPW1"/>
		    <!-- <input type="password" class="form-control" id="inputPW1" name="pw" placeholder="비밀번호를 입력하세요"> -->
		    <form:errors path="pw"></form:errors>
			<span id="pwHelp1"></span>
		  </div>

		  <div class="mb-3">
		    <label for="inputPW2" class="form-label">비밀번호 확인</label>
		    <form:password path="pwCheck" cssClass="form-control" id="inputPW2"/>
		    <!-- <input type="password" class="form-control" id="inputPW2" placeholder="비밀번호 확인"> -->
		    <form:errors path="pwCheck"></form:errors>
			<span id="pwHelp2"></span>
		  </div>
		  
		  
		  <div class="mb-3">
		    <label for="inputName" class="form-label">이름</label>
		    <form:input path="name" cssClass="form-control" id="inputName"/>
		    <!-- <input type="text" class="form-control" id="inputName" name="name" placeholder="이름을 입력하세요"> -->
		    <form:errors path="name"></form:errors>
			<span id="nameHelp">
				${name}
			</span>
		  </div>
		  
		  
		  <div class="mb-3">
		    <label for="inputEmail" class="form-label">이메일</label>
		    <form:input path="email" cssClass="form-control" id="inputEmail"/>
		    <!-- <input type="text" class="form-control" id="inputEmail" name="email" placeholder="이메일을 입력하세요"> -->
		    <form:errors path="email"></form:errors>
			<span id="emailHelp"></span>
		  </div>
		  
		  <div class="mb-3">
		    <label for="inputAge" class="form-label">나이</label>
		    <form:input path="age" cssClass="form-control" id="inputAge"/>
		    <!-- <input type="text" class="form-control" id="inputEmail" name="email" placeholder="이메일을 입력하세요"> -->
		    <form:errors path="age"></form:errors>
		  </div>
		  
		  
		  <div class="mb-3">
		    <label for="inputBirth" class="form-label">birth</label>
		    <form:input path="birth" cssClass="form-control" id="inputBirth"/>
		    <!-- <input type="text" class="form-control" id="inputEmail" name="email" placeholder="이메일을 입력하세요"> -->
		    <form:errors path="birth"></form:errors>
		  </div>
		
		  <button type="submit" id="joinBtn" class="btn btn-primary">회원가입</button>
		  

	</form:form>
	<!-- Post Button -->
	<div>
		<button type="button" id="test">Post Test</button>
		<button type="button" id="test2">Ajax Get Test</button>
		<button type="button" id="test3">Ajax Post Test</button>

	</div>

	<!-- 약관 TEST -->
	<div>
		<div>
			ALL <input type="checkbox" id="all">
		</div>

		<div>
			동의 1 <input type="checkbox" class="check">
			<div>
				약관1
			</div>
		</div>

		<div>
			동의 2 <input type="checkbox" class="check">
			<div>
				약관2
			</div>
		</div>

		<div>
			동의 3 <input type="checkbox" class="check">
			<div>
				약관3
			</div>
		</div>

	</div>

	<div>
		<select id="s1">
		   <option>1</option>
		   <option>2</option>
		</select>
		<button type="button" id="s1Add">Add</button>
	 </div>

<img src="../images/naeun111.jpg">


</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
			 integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
			  crossorigin="anonymous">
</script>    
</body>
</html>