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

<title>接口调用列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="/QiyiyunClient/js/jquery-1.11.3.js"></script>
	<style type="text/css">
		.inputjson{
			width:1024px;
		}
		
	</style>

</head>

<body>
	
	 <form action="servlet/checkUser" method="post">
		<table>
			<tr>
				<td><label for="checkresult">CheckUserIsExist</label></td>
			</tr>
			<tr>
				<td colspan="2"><input name="username" type="text"
					id="username" />
				</td>
			</tr>
			<tr>
				<td>
					<button class="check">检测</button>
				</td>
			</tr>
		</table>
	</form>
    <form action="servlet/getUserMessageList" method="post">
		<table>
			<tr>
				<td><label>GetUserMessageList</label></td>
			</tr>
			<tr>
				<td>
					<button class="check">获取</button></td>
			</tr>
		</table>
	</form>
	<!--  
	<form action="servlet/newUserMessage" method="post">
		<table>
			<tr>
				<td>NewUserMessage</td>
			</tr>
			<tr>
				<td>receiverId</td>
				<td><input type="text" name="receiverId"></td>
			</tr>
			<tr>
				<td>messageTitle</td>
				<td><input type="text" name="messageTitle"></td>
			</tr>
			<tr>
				<td>messageContent</td>
				<td><input type="text" name="messageContent"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
	<form action="servlet/addMessageType" method="post">
		<table>
			<tr>
				<td>AddMessageType</td>
			</tr>
			<tr>
				<td>messageTypeName</td>
				<td><input type="text" name="messageTypeName"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
	<form action="servlet/delMessageType" method="post">
		<table>
			<tr>
				<td>DelMessageType</td>
			</tr>
			<tr>
				<td>messageTypeId</td>
				<td><input type="text" name="messageTypeId"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
	<form action="servlet/modifyMessageType" method="post">
		<table>
			<tr>
				<td>ModifyMessageType</td>
			</tr>
			<tr>
				<td>messageTypeId</td>
				<td><input type="text" name="messageTypeId"></td>
			</tr>
			<tr>
				<td>messageTypeName</td>
				<td><input type="text" name="messageTypeName"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
	<form action="servlet/getMessageTypeList" method="post">
		<table>
			<tr>
				<td>GetMessageTypeList</td>
			</tr>
			
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
	
	<form action="servlet/modUserPsd" method="post">
		<table>
			<tr>
				<td>ModUserPsd</td>
			</tr>
			<tr>
				<td>oldPsd</td>
				<td><input type="text" name="oldPsd"></td>
			</tr>
			<tr>
				<td>newPsd</td>
				<td><input type="text" name="newPsd"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
	<form action="servlet/addNewRegisteredSpace" method="post">
		<table>
			<tr>
				<td>addNewRegisteredSpace</td>
			</tr>
			<tr>
				<td>registeredSpaceName</td>
				<td><input type="text" name="registeredSpaceName"></td>
			</tr>
			<tr>
				<td>registeredSpaceAddress</td>
				<td><input type="text" name="registeredSpaceAddress"></td>
			</tr>
			<tr>
				<td>registeredSpaceX</td>
				<td><input type="text" name="registeredSpaceX"></td>
			</tr>
			<tr>
				<td>registeredSpaceY</td>
				<td><input type="text" name="registeredSpaceY"></td>
			</tr>
			<tr>
				<td>registeredSpaceDescription</td>
				<td><input type="text" name="registeredSpaceDescription"></td>
			</tr>
			<tr>
				<td>registeredSpaceImg</td>
				<td><input type="text" name="registeredSpaceImg"></td>
			</tr>
			<tr>
				<td>registeredSpaceLeaderId</td>
				<td><input type="text" name="registeredSpaceLeaderId"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
	<form action="servlet/getRegisteredSpaceList" method="post">
		<table>
			<tr>
				<td>getRegisteredSpaceList</td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
	<form action="servlet/queryRegisteredSpaceDetail" method="post">
		<table>
			<tr>
				<td>queryRegisteredSpaceDetail</td>
			</tr>
			<tr>
				<td>registeredSpaceId</td>
				<td><input type="text" name="registeredSpaceId"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
	<form action="servlet/delRegisteredSpace" method="post">
		<table>
			<tr>
				<td>delRegisteredSpace</td>
			</tr>
			<tr>
				<td>registeredSpaceId</td>
				<td><input type="text" name="registeredSpaceId"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
	<form action="servlet/updateRegisteredSpaceInfo" method="post">
		<table>
			<tr>
				<td>updateRegisteredSpace</td>
			</tr>
			<tr>
				<td>registeredSpaceId</td>
				<td><input type="text" name="registeredSpaceId"></td>
			</tr>
			<tr>
				<td>registeredSpaceName</td>
				<td><input type="text" name="registeredSpaceName"></td>
			</tr>
			<tr>
				<td>registeredSpaceAddress</td>
				<td><input type="text" name="registeredSpaceAddress"></td>
			</tr>
			<tr>
				<td>registeredSpaceX</td>
				<td><input type="text" name="registeredSpaceX"></td>
			</tr>
			<tr>
				<td>registeredSpaceY</td>
				<td><input type="text" name="registeredSpaceY"></td>
			</tr>
			<tr>
				<td>registeredSpaceDescription</td>
				<td><input type="text" name="registeredSpaceDescription"></td>
			</tr>
			<tr>
				<td>registeredSpaceImg</td>
				<td><input type="text" name="registeredSpaceImg"></td>
			</tr>
			<tr>
				<td>registeredSpaceLeaderId</td>
				<td><input type="text" name="registeredSpaceLeaderId"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>-->
	<form action="servlet/test" method="post">
	<br>
		<table>
			<tr>
				<td>test</td>
			</tr>
			<tr>
				<td>fn</td>
				<td><input type="text" name="fn" class="inputjson"></td>
			</tr>
			<tr>
				<td>input</td>
				<td><input type="text" name="input" class="inputjson"></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit" ></td>
			</tr>
		</table>
	</form>
	
</body>
</html>