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
			<table>
				<tr>
					<td>编号</td>
					<td>用户名称</td>
					<td>绰号</td>
				</tr>
				<c:forEach items="${usersList}" var="user">
					<tr>
						<td>${user.id}</td>
						<td>${user.username}</td>
						<td>${user.nickname}</td>
						<td><a href="/RolesServlet.do?userid=${user.id}&username=${user.username}&choose=4">授权角色</a></td>
					</tr>


				</c:forEach>

			</table>
		</div>
	</section>
	<footer class="footer"> 版权归XXXX </footer>
	<script src="../js/time.js"></script>
</body>
</html>