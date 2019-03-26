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
			<h1>修改用户密码</h1>
			<table>
				用户姓名：<input name="username" id="username" onblur="checkname(this)" onfocus="checkname1(this)"><span id="checkusername"></span><span id="checkusername1"></span><br>
					<span id="checkusername2"></span>
			</table>
		</div>
	</section>
	<footer class="footer"> 版权归XXXX </footer>
	<script src="../js/time.js"></script>
</body>
<script src="/js/jquery.js"></script>
<script>
	function checkPassword() {
		if($("#password1").val()!=$("#password2").val()){
		    alert("前后输入的密码不一致,请重新输入");
            $("#password2").val("");
		}
    }
    function register() {
	    if($("#username").val()==""||$("#password1").val()==""||$("#password2").val()==""){
	        alert("请填写完信息");
		}else {
            $.ajax({
                url:"/UserServlet.do",
                type:"post",
                dataType:"text",
                data:{
                    username:$("#username").val(),
                    password:$("#password1").val(),
                    choose:3
                },
                success:function (data) {
                    if(data==1){
                        alert("修改成功");
                        $("#password1").val("");
                        $("#password2").val("");
                    }else{
                        alert("修改失败");
                    }

                }
            })
		}
    }
    function checkname1(input) {
        $("#checkusername").html("");
        $("#checkusername2").html("");
        $("#checkusername1").html("注意：不要输入数据库中不存在的用户名！！！");
    }
	function checkname(input){
		username=$(input).val();
		if(username!=""){
		$.ajax({
			 url:"/checkUserServlet.do",
			 type:"post",
			 data:{
				 checkname:username,
			 },
			 dataType:"text",
			 success:function(data) {
			    if(data==1){
                    alert("未在数据库中找到该用户的信息！！，请重新输入用户名！");
                    $("#username").val("");
                    $("#username2").val("");
				}else{
                    //alert("该账号未被注册，可以使用");
                    $("#checkusername1").html("");
                    $("#checkusername").html("已找到该用户的信息，请在下方输入新的密码！！！");
                    $("#checkusername2").html("<br>用户密码：<input type=\"password\"\tid=\"password1\" name=\"password\"><br>\n" +
                        "\t\t\t\t\t<br>确认密码：<input type=\"password\" id=\"password2\" name=\"password1\" onblur=\"checkPassword()\"><br>\n" +
                        "\t\t\t\t\t<br><input type=\"button\" onclick=\"register()\" value=\"确定\">");
				}

				 //$("#checkusername").html(data);
			 }
		 });
        }
}
</script>
</html>