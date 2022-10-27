<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:import url="../temp/boot.jsp"></c:import>
<c:import url="../temp/summer.jsp"></c:import>
<script defer type="text/javascript" src="/js/fileManager.js"></script>
<body>
	
	<div class="container-fluid">
	<div class="row justify-content-center">

		<div class="col-6">

		<h1>수정 페이지</h1>

		<form action="update" method="post" enctype="multipart/form-data">

			<input type="hidden" name="num" value="${qnaVO.num}">

			<div class="mb-3">
			  <label for="title" class="form-label">Title</label>
			  	<input type="text" value="${qnaVO.title}" name="title" class="form-control" id="title" placeholder="제목">
			</div>

			<div class="mb-3">
			  <label for="writer" class="form-label">Writer</label>
			  	<input type="text" value="${qnaVO.writer}" name="writer" class="form-control" id="writer" placeholder="작성자">
			</div>

			<div class="mb-3">
			  <label for="contents" class="form-label">Contents</label>
			  <textarea class="form-control" name="contents" id="contents"></textarea>
			</div>
			
			<div class="mb-3" id="fileAddResult">

				<c:forEach items="${qnaVO.qnaFileVOs}" var="qnaFileVO">

					<p>
						${qnaFileVO.oriName}
						<button type="button" class="deleteFile" data-file-num="${qnaFileVO.fileNum}">X</button>
					</p>

				</c:forEach>
				
			</div>

			<div class="mb-3">
				<button type="button" id="fileAdd">파일추가</button>
			</div>

			
			<div>
				<button class="btn btn-danger">Update</button>
			</div>

			<div>
				<button class="btn btn-primary" onclick="location='/'">홈으로</button>
			</div>

			<div>
				<button class="btn btn-primary" onclick="location='./list'">리스트</button>
			</div>
		</form>
		</div>
	</div>
	</div>
	
	<script type="text/javascript">
    $('#contents').summernote({
        tabsize: 4,
        height: 250
      });
    
    $('#contents').summernote('code', '${vo.contents}')
    
	</script>

</body>
</html>