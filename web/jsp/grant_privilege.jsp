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

				<table border="1" style="text-align: center;">
					<tr>
						<td>角色名称</td>
						<td>${rolename}</td>
					</tr>
					<tr>
						<td>描述</td>
						<td>已具有权限： <c:forEach items="${privilegesesById}"
								var="privileges">
	 ${privileges.name}<input type="checkbox" disabled name="privilegedelete" value="${privileges.id}" checked="checked">&nbsp;
	</c:forEach>
						</td>
					</tr>

					<tr>
						<td>系统所有权限列表</td>
						<td>
							<c:forEach items="${privilegesesById}"
									   var="privileges">
								${privileges.name}<input type="checkbox" onchange="changestate(this,this.checked)" name="privilegeadd" value="${privileges.id}" checked="checked">&nbsp;
							</c:forEach>
							<c:forEach items="${privilegesesList}" var="privileges">
							 ${privileges.name}<input type="checkbox"  onchange="changestate(this,this.checked)" name="privilegeadd"	value="${privileges.id}">&nbsp;
							</c:forEach></td>
					</tr>
<tr>
<td colspan="2">
<input type="hidden" id="roleID" value="${roleid}">
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
		var privilegedeletes=$("input[name='privilegedelete']");
		//获取所有的元素对象
        var privilegeadds=$("input[name='privilegeadd']");
        var privildeles="";
        var priviladds="";
        //获取已经具备的权限id
        $(privilegedeletes).each(function (i) {
            privildeles+=this.value+",";
        });
        $(privilegeadds).each(function (i) {
            if(this.checked==true){
                priviladds+=this.value+",";
            }
        });

        //去逗号
        privildeles=privildeles.substring(0,privildeles.length-1);
        priviladds=priviladds.substring(0,priviladds.length-1);
		//发送请求
        $.ajax({
			url:"/PrivilegsServlet.do",
			type:"post",
			dataType:"json",
			data:{
			    roleid:$("#roleID").val(),
				privilegedeleteid:privildeles,
                privilegeaddid:priviladds,
				choose:1
			},
			success:function (data) {
				if(data==1){
				    window.location.href="/RolesServlet.do?roleid=${roleid}&rolename=${rolename}&choose=2";
				}
            }
		})
    }
</script>
</html>