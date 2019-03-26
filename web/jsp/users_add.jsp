<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>权限管理系统-添加用户</title>
<style>
	#checkusername{
		color: #0c89de;
	}
	#checkusername1{
		color: red;
	}
</style>
</head>
<body>
	<!--头部-->
	<%@ include file="top.jsp"%>
	<!--主体内容-->
	<section class="publicMian">
		<%@ include file="left.jsp"%>
		<div class="right">
			<h1>添加用户</h1>
			<table>
					用户姓名：<input name="username" id="username" onblur="checkname(this)" onfocus="checkname1(this)"><span id="checkusername"></span><span id="checkusername1"></span><br>
					<br>用户密码：<input type="password"	id="password1" name="password"><br>
					<br>确认密码：<input type="password" id="password2" name="password1" onblur="checkPassword()"><br>
					<br>绰号：<input name="nickname" id="nickname"><br>
					<br><input type="button" onclick="register()" value="确定">
			</table>
		</div>
	</section>
	<footer class="footer"> 版权归XXXX </footer>
	<script src="../js/time.js"></script>
</body>
<script src="/js/jquery.js"></script>
<script>
	if($("#password2").val()!=null){
        function checkPassword() {
            if($("#nickname").val()!=$("#password2").val()){
                alert("前后输入的密码不一致,请重新输入");
                $("#password2").val("");
            }
        }
	}

    function register() {
	    if($("#username").val()==""||$("#password1").val()==""||$("#password1").val()==""&&$("#nickname").val()==""){
	        alert("请检查是否填写完了信息！！！");
		}else {
            $.ajax({
                url:"/UserServlet.do",
                type:"post",
                dataType:"text",
                data:{
                    username:$("#username").val(),
                    password:$("#password1").val(),
                    nickname:$("#nickname").val(),
                    choose:2
                },
                success:function (data) {
                    if(data==1){
                        alert("注册成功");
                        $("#password1").val("");
                        $("#password2").val("");
                        $("#nickname").val("");
                    }else{
                        alert("注册失败");
                    }

                }
            })
		}
    }
    function checkname1(input) {
        $("#checkusername").html("");
        $("#checkusername1").html("注意：不要输入已被注册的用户名！！！");
    }
	function checkname(input){
		username=$(input).val()
        if(username!="") {
            $.ajax({
                url: "/checkUserServlet.do",
                type: "post",
                data: {
                    checkname: username,
                },
                dataType: "text",
                success: function (data) {
                    if (data == 1) {
                        //alert("该账号未被注册，可以使用");
                        $("#checkusername1").html("");
                        $("#checkusername").html(" 该账号未被注册，可以使用");
                    } else {
                        alert("该账号已被注册，请更换注册名");
                        $("#username").val("");
                    }

                    //$("#checkusername").html(data);
                }
            });
        }
}
</script>
</html>