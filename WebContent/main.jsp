<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主界面</title>
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/common.js"></script>
</head>
<body>
	<div id="all">
		<div id="search">
			用户姓名：<input id="yhxm"/>
			<!-- 如何在js中获取监听器中的值 -->
			用户部门：<select id="bmSelect"></select>
			
			<input type="button" value="查询" id="query"/>
			<input type="button" value="新增" id="add"/>
		</div>
		
		<div id="bmTree"></div>
		
		<div id="userInfo">
			<table id="user" border="1" cellspacing="0" bordercolor="#D0DFF3"></table>
		</div>
		
	</div>
</body>
</html>