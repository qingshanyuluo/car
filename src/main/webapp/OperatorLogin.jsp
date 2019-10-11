<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="S" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新能源电动汽车数据监控展示平台</title>
<link href="themes/css/login.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div id="login">
		<div id="login_header">
			<h1 class="login_logo">
				<img src="themes/default/images/login_logo.gif" />
			</h1>
			<div class="login_headerContent">
				<div class="navList">
					
				</div>
				<h2 class="login_title"><img src="themes/default/images/login_title.png" /></h2>
			</div>
		</div>
		<div id="login_content">
			<div class="loginForm">
				<form name="login_form" id="login_form" action="OperatorLogin" method="post">
					<p>
						<label>用户名：</label>
						<input type="text" name="username" size="20" class="login_input" />
					</p>
					<p>
						<label>密码：</label>
						<input type="password" name="password" size="20" class="login_input" />
					</p>
					
					<div class="login_bar">
						<input class="sub" type="submit" value=" " />
						<input class="res" type="reset" value=" " />
					</div>
				</form>
			</div>
			<div class="login_banner"><img src="themes/default/images/login_banner.jpg" /></div>
			<div class="login_main">		
			</div>
		</div>
		<div id="login_footer">
			Copyright &copy; 2009 www.dwzjs.com Inc. All Rights Reserved.
		</div>
	</div>
</body>
<S:if test="${omsg==141 }">
  	<script>alert("登录失败，账号不可为空！");</script>
  </S:if>
  <S:if test="${omsg==142 }">
  	<script>alert("登录失败，密码不可为空！");</script>
  </S:if>
  <S:if test="${omsg==143 }">
  	<script>alert("登录失败，账号长度超出限制！");</script>
  </S:if>
  <S:if test="${omsg==144 }">
  	<script>alert("登录失败，密码长度超出限制！");</script>
  </S:if>
  <S:if test="${omsg==145 }">
  	<script>alert("登录失败，账号错误(非法字符)！");</script>
  </S:if>
  <S:if test="${omsg==146 }">
  	<script>alert("登录失败，密码错误(非法字符)！");</script>
  </S:if>
  <S:if test="${omsg==147 }">
  	<script>alert("登录失败，账号或密码错误！");</script>
  </S:if>
  <S:if test="${param.omsg==502 }">
  	<script>alert("请登录系统！");</script>
  </S:if>
</html>