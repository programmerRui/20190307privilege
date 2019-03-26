<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>角色扮演</title>

</head>
<body>
	<!--头部-->
	<%@ include file="top.jsp"%>
	<!--主体内容-->
	<section class="publicMian">
		<%@ include file="left.jsp"%>
		<div class="right">

				<table border="1" style="text-align: center;">
					<tr>
						<td>用户名称</td>
						<td>${username}</td>
					</tr>
					<tr>
						<td>描述</td>
						<td>已扮演角色： <c:forEach items="${rolesList}"
								var="roles">
	 ${roles.name}<input type="checkbox" disabled name="rolesdeles" value="${roles.id}" checked="checked">&nbsp;
	</c:forEach>
						</td>
					</tr>

					<tr>
						<td>所有角色</td>
						<td>
							<c:forEach items="${rolesList}"
									   var="roles">
								${roles.name}<input type="checkbox" onchange="changestate(this,this.checked)" name="rolesadds" value="${roles.id}" checked="checked">&nbsp;
							</c:forEach>
							<c:forEach items="${roleList}" var="roles">
							 ${roles.name}<input type="checkbox"  onchange="changestate(this,this.checked)" name="rolesadds"	value="${roles.id}">&nbsp;
							</c:forEach></td>
					</tr>
<tr>
<td colspan="2">
<input type="hidden" id="userID" value="${userid}">
<input type="hidden" name="choose" value="3" >
<input type="button" value="授权" onclick="submit()"> </td>

</tr>
				</table>
		</div>
	</section>
	<footer class="footer"> 版权归XXXX </footer>
	<script src="../js/time.js"></script>
</body>
<script src="/js/jquery.js"></script>
<script>

	function changestate(th,checked) {
		if(checked){
		    $(th).attr("checked","checked");
		}else{
		    $(th).removeAttr("checked");
		}
    }
    function submit(){

	    //获取已经具备的权限元素对象
		var rolesList=$("input[name='rolesdeles']");
		//获取所有的元素对象
        var roleList=$("input[name='rolesadds']");
        var rolesdeles="";
        var rolesadds="";
        //获取已经具备的权限id
        $(rolesList).each(function (i) {
            rolesdeles+=this.value+",";
        });
        $(roleList).each(function (i) {
            if(this.checked==true){
                rolesadds+=this.value+",";
            }
        });
        //去逗号
        rolesdeles=rolesdeles.substring(0,rolesdeles.length-1);
        rolesadds=rolesadds.substring(0,rolesadds.length-1);
		//发送请求
        $.ajax({
			url:"/RolesServlet.do",
			type:"post",
			dataType:"json",
			data:{
                userid:$("#userID").val(),
                rolesdeles:rolesdeles,
                rolesadds:rolesadds,
				choose:5
			},
			success:function (data) {
				if(data==1){

				   // window.location.href="/RolesServlet.do?roleid=${roleid}&rolename=${rolename}&choose=2";
				    window.location.href="/RolesServlet.do?userid=${userid}&username=${username}&choose=4";
				}
            }
		})
    }
</script>
</html>