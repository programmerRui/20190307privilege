<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

</head>
<body>
	<!--头部-->
	<%@ include file="top.jsp"%>
	<!--主体内容-->
	<section class="publicMian">
		<%@ include file="left.jsp"%>
		<div class="right">
			<h1>添加权限</h1>
			<form method="post" action="/PrivilegsServlet.do?choose=2">
				名称：<input name="p_name"><br>
				<br> url:<input name="p_url"><br>
				<br> 描述:
				<textarea rows="5" cols="50" name="p_description"></textarea>
				<br>
				<br> <input type="submit" value="提交">
			</form>
		</div>
	</section>
	<footer class="footer"> 版权归XXXX </footer>
	<script src="../js/time.js"></script>
</body>
</html>