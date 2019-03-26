<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>系统登录 - 权限管理系统管理系统</title>
    <link rel="stylesheet" href="../css/style.css"/>
</head>
<body class="login_bg" onload="showErr('${msg}')">
    <section class="loginBox">
        <header class="loginHeader">
            <h1>权限管理系统管理系统</h1>
        </header>
        <section class="loginCont">
            <form class="loginForm" method="post" action="/UserServlet.do?choose=1">
                <div class="inputbox">
                    <label for="user">用户名：</label>
                    <input id="user" type="text" name="username" placeholder="请输入用户名" required/>
                </div>
                <div class="inputbox">
                    <label for="mima">密码：</label>
                    <input id="mima" type="password" name="password" placeholder="请输入密码" required/>
                </div>
                <div class="subBtn">
                    <input type="submit" value="登录" />
                    <input type="reset" value="重置"/>
                </div>

            </form>
        </section>
    </section>

</body>
<script type="text/javascript">
    function showErr(msg){
        if(msg.length>0){
            alert(msg);
        }
    }
</script>
</html>