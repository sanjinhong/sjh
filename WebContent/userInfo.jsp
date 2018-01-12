<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dao.interfaces.IDepartDAO" %>
<%@ page import="com.dao.impl.DepartDAOImpl" %>
<%@ page import="com.beans.Depart" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.dao.impl.BzdmDAOImpl" %>
<%@ page import="com.dao.interfaces.IBzdmDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增删改查界面</title>

<link rel="stylesheet" type="text/css" href="css/userInfo.css" />

<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/userInfo.js"></script>
<script type="text/javascript" src="js/common.js"></script>
</head>
<body>
	<%
		String type = request.getParameter("type");
		String yhdm = request.getParameter("yhdm");
		IDepartDAO departDAO = new DepartDAOImpl();
		IBzdmDAO bzdmDAO = new BzdmDAOImpl();
		System.out.print(type);
	%>
	<div id="all">
		<table	id="userInfo" border="1" bordercolor="#D0DFF3" cellspacing="0">
			<caption><h3>用户信息</h3></caption>
			<tr>
				<td class="tdshow"><span>*用户ID</span></td>
				<td class="tdinput">
					<input type="text" id="yhid"/>
				</td>
				<td class="tdshow"><span>*用户姓名</span></td>
				<td class="tdinput">
					<input type="text" id="yhxm"/>
				</td>
			</tr>		
			<tr>
				<td class="tdshow"><span>*用户口令</span></td>
				<td class="tdinput">
					<input type="password" id="yhkl"/>
				</td>
				<td class="tdshow"><span>*确认口令</span></td>
				<td class="tdinput">
					<input type="password" id="qrkl"/>
				</td>
			</tr>		
			<tr>
				<td class="tdshow">用户性别</td>
				<td>
					<select id="yhxb">
						<option value="">请选择</option>
						<%
							Map<String,String> xbs = bzdmDAO.getXbmc();
							for(Map.Entry<String,String> xb : xbs.entrySet()) {
						%>
							<option value="<%=xb.getKey() %>"><%=xb.getValue() %></option>
						<%
							}
						%>
					</select>
				</td>
				<td class="tdshow">用户部门</td>
				<td>
					<select id="yhbm">
						<option value="">请选择</option>
					<%
						List<Depart> departs = departDAO.select();
						for(Depart depart : departs){
					%>
						<option value="<%=depart.getBmdm() %>"><%=depart.getBmmc() %></option>
					<%
						}
					%>
					</select>	
				</td>
			</tr>		
			<tr>
				<td class="tdshow">出生日期</td>
				<td>
					<input type="date" id="crsq"/>
				</td>
				<td class="tdshow">排序号</td>
				<td>
					<input type="text" id="pxh"/>
				</td>
			</tr>		
			<tr>
				<td colspan="4">
					<input type="checkbox" id="sfjy"/>禁用
				</td>
			</tr>		
			<tr>
				<td colspan="4">
					<input type="button" value="保存" onclick="save('<%=type %>','<%=yhdm %>');" id="save"/>
					<input type="button" value="返回" id="back"/>
				</td>
			</tr>		
		</table>
	</div>
</body>
</html>