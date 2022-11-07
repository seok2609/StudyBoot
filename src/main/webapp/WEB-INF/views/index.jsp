<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./temp/boot.jsp"></c:import>
<link href="./css/test.css" rel="styleSheet">
<script defer src="/js/test.js"></script>
</head>
<body>
	<h1>이나은 팬클럽</h1>
	<h1><spring:message code="hi" var="h"></spring:message></h1>
	<h1><spring:message code="test" text="code가 없을때 출력되는 메세지"></spring:message></h1>
	
	<div>
		<!-- 로그인 성공 -->
		<sec:authorize access="isAuthenticated()">	<!-- 인증(Authenticated)이 되었냐 안되었냐 is로 시작하면 true/false -->
													<!-- isAuthenticated() : 인증(로그인)이 되었다 -->
			<sec:authentication property="Principal" var="member"/>
			<h3><spring:message code="welcome" arguments="${member.name}"></spring:message></h3>
			<h3><spring:message code="welcome2" arguments="${member.id},${member.name}" argumentSeparator=","></spring:message></h3>
			
			<form action="./member/logout" method="post" id="outForm">
				<sec:csrfInput/>
				<a href="./member/logout">로그아웃</a>
				<!-- <button>로그아웃</button> -->
			</form>
			<!-- 로그인한 회원 등급이 ADMIN이면 admin 태그가 뜨고 회원등급이 admin이 아니거나 비회원이면 안보임 -->
			<sec:authorize access="hasRole('ADMIN')">
				<a href="/admin">admin</a>
			</sec:authorize>
			
			<sec:authorize access="hasAnyRole('ADMIN', 'MANAGER')">
				<a href="/manager">manager</a>
			</sec:authorize>
			
			<sec:authorize access="hasAnyRole('ADMIN', 'MANAGER', 'MEMBER')">
				<a href="/member/myPage">myPage</a>
			</sec:authorize>
		</sec:authorize>
		
		<!-- 로그인 전 -->
		<sec:authorize access="!isAuthenticated()">	<!-- !를 써서 로그인이 안됐을떄로 표현 -->
			<a href="./member/login">로그인</a>
			<a href="/oauth2/authorization/kakao">KaKao Login</a>
			<a href="./member/add">회원가입</a>
		</sec:authorize>
		
	
	</div>
	
	<%-- <c:if test="${empty sessionScope.member}">
		<a href="./member/login">로그인</a>
		<a href="./member/add">회원가입</a>
	</c:if>
	
	<c:if test ="${not empty sessionScope.member}">
		<h3><spring:message code="welcome" arguments="${member.name}"></spring:message></h3>
		<h3><spring:message code="welcome2" arguments="${member.id},${member.name}" argumentSeparator=","></spring:message></h3>
		argumentSeparator="," => arguments="${member.id},${member.name}"에서 ","를 구분점으로 삼아서 id,name따로 따로 출력시킴
		<a href="./member/logout">로그아웃</a>
	
	</c:if> --%>



	<img src="./images/naeun.jpg">
	<a href="./qna/list">QnA</a>
	<!-- <a href="./member/logout">로그아웃</a> -->
	
	<!-- <div>
		<img alt="" src="/file/qna/6399170c-1b61-4759-89d3-0a8631e74f0e_naeun.jpg">
	</div> -->
	
	
	<div>
		<img alt="" src="/file/qna/6fd44e23-2976-49f9-b09c-0075362c35a5_.jpg">
		<a href="/fileDown/qna?fileNum=2">QnaDown</a>
		<img alt="" src="/file/notice/1111.jpg">
		<a href="/fileDown/notice?fileNum=2">NoticeDown</a>
	</div>

	<button id="btn" class="btn btn-primary" type="button">클릭</button>

	<button class="buttons">btn1</button>
	<button class="buttons">btn2</button>
	<button class="buttons">btn3</button>

	<div class="test">

	</div>
	
	<h1>${h}</h1>
	<h1>${h}</h1>
	<h1>${h}</h1>
	<h1>${h}</h1>
	<h1>${h}</h1>
	
	<script type="text/javascript">
		$("#logout").click(function(){
			$("outForm").submit();
		});
	</script>

</body>
</html>