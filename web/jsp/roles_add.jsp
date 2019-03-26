<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<h1>添加角色</h1>
			<table>
				<form method="post" action="/RolesServlet.do?choose=3">
					角色名称：<input name="name"><br>
					<br>权限描述：<input name="description"><br>
					<br><input type="submit" value="确定">
				</form>
			</table>
		</div>
	</section>
	<footer class="footer"> 版权归XXXX </footer>
	<script src="../js/time.js"></script>
</body>
</html>