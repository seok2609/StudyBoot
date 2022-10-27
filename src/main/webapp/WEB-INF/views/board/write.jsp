<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- summernote JQUERY -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<!-- summernote bootstrap -->
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
 
<!-- include summernote css/js -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
<section class="container-fluid col-lg-6 mt-5">
	<h1>글쓰기</h1>
	
	<div>
		<form action="add" method="post" enctype="multipart/form-data">
			
			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label">작성자</label>
				<input type="text" class="form-control" name="writer" placeholder="작성자를 입력하세요.">
			</div>
	
			<div class="mb-3">
			  <label for="formGroupExampleInput" class="form-label">제목</label>
			  <input type="text" class="form-control" name="title" placeholder="제목을 입력하세요.">
			</div>
			
			<div class="mb-3">
			  <label for="formGroupExampleInput2" class="form-label">글내용</label>
			  <textarea class="form-control" name="contents" id="contents" rows="5" placeholder="내용을 입력하세요."></textarea>
			  <!-- <input type="text" name="contents" placeholder="내용을 입력하세요." id="contents"> -->
			</div>
			
<!-- 			<div class="mb-3">
			
			</div>
			<div class="mb-3">
				<button type="button">FileAdd</button>
			</div> -->
			
 			<div class="mb-3">
			  <label for="formGroupExampleInput" class="form-label">file</label>
			  <input type="file" name="files">
			</div>	
			
			<div class="mb-3">
			  <label for="formGroupExampleInput" class="form-label">file</label>
			  <input type="file" name="files">
			</div>
				
			<div>
				<button type="submit" class="btn btn-primary">write</button>
			</div>	
		
		</form>
	</div>
	
	<div style="margin-top: 10px;">
		<button class="btn btn-primary" type="button" onclick="location='./list'">list</button>
	</div>
	<div style="display: inline-block; margin: 0 5px;  float: right;">
		<button class="btn btn-secondary" type="button" onclick="location='/'">홈</button>
	</div>
</section>
<!-- 부트스트랩 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script type="text/javascript">
	$('#contents').summernote({
		height : 350,
		toolbar: [
		    ['style', ['style']],
		    ['font', ['bold', 'italic', 'underline', 'clear']],
		    ['fontname', ['fontname']],
		    ['color', ['color']],
		    ['para', ['ul', 'ol', 'paragraph']],
		    ['height', ['height']],
		    ['table', ['table']],
		    ['insert', ['link', 'picture', 'hr']],
		    ['view', ['fullscreen', 'codeview']],
		    ['help', ['help']]
		  ]
	});
</script>
</body>
</html>