<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/css/public.css" />
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
<header class="publicHeader">
		<h1>权限管理系统</h1>

		<div class="publicHeaderR">
			<p>
				<span>下午好！</span><span style="color: #fff21b"> ${username}</span> , 欢迎你！
			</p>
			<a href="login.jsp">退出</a>
		</div>
	</header>
	<!--时间-->
	<section class="publicTime">
		<span id="time">2015年1月1日 11:11 星期一</span> <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
	</section>
</body>
</html>