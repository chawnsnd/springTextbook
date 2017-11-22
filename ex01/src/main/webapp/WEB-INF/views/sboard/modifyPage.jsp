<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@include file="../include/header.jsp" %>

<script>
$(document).ready(function(){
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	
	$(".btn-warning").on("click", function(){
		self.location = "/sboard/list?page=${cri.page}&perPageNum=${cri.perPageNum}"
				+"&searchType=${cri.searchType}&keyword=${cri.keyword}";
	});
	
	$(".btn-primary").on("click", function(){
		formObj.submit();
	});
})
</script>

<form role="form" action="modifyPage" method="post">

	<input type='hidden' name='page' value="${cri.page }">
	<input type='hidden' name='perPageNum' value="${cri.perPageNum }">
	<input type='hidden' name='searchType' value="${cri.searchType }">
	<input type='hidden' name='keyword' value="${cri.keyword }">

	
	<div class="box-body">
	
		<div class="form-group">
			<label for="exampleInputEmail1">BNO</label>
			<input type="text"
			name='bno' class="form-control" value="${boardVO.bno }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Title</label>
			<input type="text"
			name='title' class="form-control" value="${boardVO.title }">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Content</label>
			<textarea class="form-control" name="content" rows="3">${boardVO.content }</textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Writer</label>
			<input type="text"
			name='writer' class="form-control" value="${boardVO.writer }" readonly="readonly">
		</div>
	</div>
	<!-- /.box-body -->
	
	<div class="box-footer">
		<button type="submit" class="btn btn-primary">SAVE</button>
		<button type="button" class="btn btn-warning">CANCEL</button>
	</div>
</form>

<%@include file="../include/footer.jsp" %>

</body>
</html>