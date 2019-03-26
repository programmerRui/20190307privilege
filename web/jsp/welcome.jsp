<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

</head>
<body>
	<!--头部-->
	<%@ include  file="top.jsp" %>
	<!--主体内容-->
	<section class="publicMian">
     <%@ include file="left.jsp" %>
		<div class="right">
			<img class="wColck" src="img/clock.jpg" alt="" />
			<div class="wFont">
				<h2> ${username}</h2>
				<p>欢迎来到权限管理系统!</p>
			</div>
		</div>
	</section>
	<footer class="footer"> 版权归XXXX </footer>
	<script src="../js/time.js"></script>
</body>
</html>