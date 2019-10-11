<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>新能源电动汽车数据监控展示平台</title>

		<link href="themes/default/style.css" rel="stylesheet" type="text/css" media="screen" />
		<link href="themes/css/core.css" rel="stylesheet" type="text/css" media="screen" />
		<link href="themes/css/print.css" rel="stylesheet" type="text/css" media="print" />
		
		<!--[if IE]>
<link href="themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->

		<!--[if lt IE 9]><script src="js/speedup.js" type="text/javascript"></script><script src="js/jquery-1.11.3.min.js" type="text/javascript"></script><![endif]-->
		<!--[if gte IE 9]><!-->
		<script src="js/jquery-2.1.4.min.js" type="text/javascript"></script>
		<!--<![endif]-->

		<script src="js/jquery.cookie.js" type="text/javascript"></script>
		<script src="js/jquery.validate.js" type="text/javascript"></script>
		<script src="js/jquery.bgiframe.js" type="text/javascript"></script>

		<!-- svg图表  supports Firefox 3.0+, Safari 3.0+, Chrome 5.0+, Opera 9.5+ and Internet Explorer 6.0+ -->
		<script type="text/javascript" src="chart/js/echarts.js"></script>

		 <script src="http://webapi.amap.com/maps?v=1.4.3&key=7ed9aa5ed0853a5c91c04bb6dcc5d2c6&plugin=AMap.Autocomplete,AMap.PlaceSearch"></script>
		 <script src="//webapi.amap.com/ui/1.0/main.js?v=1.0.11"></script>
         <script src="http://cache.amap.com/lbs/static/es5.min.js"></script>
         <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
	
		<script src="bin/dwz.min.js" type="text/javascript"></script>

		<script src="js/dwz.regional.zh.js" type="text/javascript"></script>

		<script type="text/javascript">
			$(function() {
				DWZ.init("dwz.frag.xml", {
					loginUrl: "login_dialog.html",
					loginTitle: "登录", // 弹出登录对话框
					//		loginUrl:"login.html",	// 跳到登录页面
					statusCode: {
						ok: 200,
						error: 300,
						timeout: 301
					}, //【可选】
					pageInfo: {
						pageNum: "pageNum",
						numPerPage: "numPerPage",
						orderField: "orderField",
						orderDirection: "orderDirection"
					}, //【可选】
					keys: {
						statusCode: "statusCode",
						message: "message"
					}, //【可选】
					ui: {
						hideMode: 'offsets'
					}, //【可选】hideMode:navTab组件切换的隐藏方式，支持的值有’display’，’offsets’负数偏移位置的值，默认值为’display’
					debug: false, // 调试模式 【true|false】
					callback: function() {
						initEnv();
						$("#themeList").theme({
							themeBase: "themes"
						}); // themeBase 相对于index页面的主题base路径
					}
				});
			});
		</script>

	</head>

	<body>
		<div id="layout">
			<div id="header">
				<div class="headerNav">

					<ul class="nav">
					    <li>
							<a width="600">用户${operator.o_ID }你好，今天是${MyTime}，欢迎登录系统！</a>
						</li>
						<li>
							<a href="changepwd.jsp" target="dialog" width="600">修改密码</a>
						</li>
						<li>
							<a href="OperatorLoginOut">注销</a>
						</li>
					</ul>
					<ul class="themeList" id="themeList">
						<li theme="default">
							<div class="selected">蓝色</div>
						</li>
						<li theme="green">
							<div>绿色</div>
						</li>
						<!--<li theme="red"><div>红色</div></li>-->
						<li theme="purple">
							<div>紫色</div>
						</li>
						<li theme="silver">
							<div>银色</div>
						</li>
						<li theme="azure">
							<div>天蓝</div>
						</li>
					</ul>
				</div>

				<!-- navMenu -->

			</div>

			<div id="leftside">
				<div id="sidebar_s">
					<div class="collapse">
						<div class="toggleCollapse">
							<div></div>
						</div>
					</div>
				</div>
				<div id="sidebar">
					<div class="toggleCollapse">
						<h2>主菜单</h2>
						<div>收缩</div>
					</div>

					<div class="accordion" fillSpace="sidebar">
						<div class="accordionHeader">
							<h2><span>Folder</span>车辆监控系统</h2>
						</div>
						<div class="accordionContent">
							<ul class="tree treeFolder">
								<li>
									<a>监控信息</a>
									<ul>
										<li>
											<a href="CarMonitor" target="navTab" rel="Amap">车辆监控</a>
										</li>
										<li>
											<a id="CarStatus" href="CarStatus" target="navTab" rel="CarStatus " fresh="true">车辆状态查询</a>
										</li>
									</ul>
								</li>

								<li>
									<a>图表分析</a>
									<ul>
										<li>
											<a href="chart/test/dataShow.jsp" target="navTab" rel="chart">数据概览统计</a>
										</li>

										
										<li>
											<a href="chart/test/Machine_Analysis.jsp" target="navTab" rel="chart">车辆数据分析统计</a>
										</li>
									</ul>
								</li>
							
							</ul>
						</div>

						<div class="accordionHeader">
							<h2><span>Folder</span>数据支持系统</h2>
						</div>
						<div class="accordionContent">
							<ul class="tree treeFolder">
							<li>
								<a href="CarManage" target="navTab" rel="CarManage " fresh="true">车辆管理</a>
							</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div id="container">
				<div id="navTab" class="tabsPage">
					<div class="tabsPageHeader">
						<div class="tabsPageHeaderContent">
							<!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
							<ul class="navTab-tab">
								<li tabid="main" class="main">
									<span><span class="home_icon">我的主页</span></span>
								</li>
							</ul>
						</div>
						
					</div>

					<div id="navTab-panel" class="navTab-panel tabsPageContent layoutBox">
						<div id="unitBox"class="page unitBox">
					
						</div>

					</div>
				</div>
			</div>

		</div>

		<div id="footer">Copyright &copy; 2018 GMH design</div>

	</body>

</html>