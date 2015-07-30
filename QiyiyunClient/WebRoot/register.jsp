<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style type="text/css">
.showcode {
	visibility: hidden;
}

#getCode {
	visibility: hidden;
}
</style>
<script type="text/javascript" src="/QiyiyunClient/js/jquery-1.11.3.js">
	
	
	</script>
</head>

<body>
	<form action="servlet/registerServlet" method="post">
		<table>
			<tr>
				<td><input type="radio" name="identity" value="用户名"
					checked="checked" />用户名 <input type="radio" name="identity"
					value="手机" />手机 <input type="radio" name="identity" value="邮箱" />邮箱
				</td>
				<td><input id="username" name="username" type="text" /></td>
				<td><input type="button" value="获取验证码" id="getCode" /></td>
			</tr>
			<tr>
				<td><label for="password">密码</label></td>
				<td><input id="password" name="password" type="password" /></td>
			</tr>
			<tr>
				<td><label for="surepassword">确认密码</label></td>
				<td><input id="surepassword" type="password" /></td>
			</tr>
			<tr class="showcode">
				<td><label for="code">动态验证码</label></td>
				<td><input id="code" name="code" type="text" /></td>
			</tr>
			<tr>
				<td>
					<button type="submit" class="btn btn-primary" id="submit1">提交</button>
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
 						$(document).ready(function(){
 								$("#getCode").click(function(){
 									 var value = $("#username").val();
 									 if(value==""){
 									 	alert("手机号码不能为空");
 									 	 $("#username").focus();
 									 }else{
 									 	$.ajax({   
     											url:'http://127.0.0.1:8080/QiyiyunServer/Entry',
												type : 'post',
												data : 'params=[{\"fn\":\"GetRegCodeByPhone\",\"input\":{\"phoneNumb\":\"'+value+'\"}}]',
												async : false, //默认为true 异步   
												error : function() {
													alert('error');
												},
												success : function(data) {
													alert(data);
												}
												});
											}
										});
							$("input[name=identity]").click(
									function() {
										var value = $(this).val();
										if (value == "手机") {
											$(".showcode").css("visibility",
													"visible");
											$("#getCode").css("visibility",
													"visible");
										} else {
											$(".showcode").css("visibility",
													"hidden");
											$("#getCode").css("visibility",
													"hidden");
										}
									});
							$("#submit1").click(
									function() {
										var username = $("#username").val();
										var password = $("#password").val();
										var surepassword = $("#surepassword")
												.val();
										if (username == '') {
											alert("用户名不能为空");
											$("#username").focus();
											return false;
										}
										if (password == '') {
											alert("密码不能空");
											$("#password").focus();
											return false;
										}
										if (surepassword == ''
												|| password != surepassword) {
											alert("两次输入的密码不同！");
											$("#password").focus();
											return false;
										}
									});
						});
	</script>
</body>
</html>
