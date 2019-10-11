<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'echartsDemo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <style>
  .fontCSS2 {
    font-family: "黑体";
	font-size: 20px;
	color:#000000;
	vertical-align:middle;
	text-align:center;
}
  </style>
  <body>
  <form >
<br>
<div class="fontCSS2">电机数据统计</div><br>
<center>
<table  width="100%"  border="0"   cellpadding="0" cellspacing="0" valign="top">
  <tr>
    <td width="2%" height="1">&nbsp;</td>
    <td width="97%">&nbsp;</td>
    <td width="1%" >&nbsp;</td>
  </tr>

  <tr>
    <td height="30">&nbsp;</td>
    <td  valign="top"  bgcolor="#FFFFFF" class="fontCSS3"><font color="#004471">&nbsp;用户年度统计</font></td>
    <td>&nbsp;</td>
  </tr>
    <tr>
    <td height="16">&nbsp;</td>
    <td  valign="top" bgcolor="#FFFFFF">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="25">&nbsp;</td>
    <td  align="right"  bgcolor="#FFFFFF"><div id="yearChart" style="width:100%;height:200px; "></div></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="30">&nbsp;</td>
    <td  valign="top"  bgcolor="#FFFFFF" class="fontCSS3"><font color="#004471">&nbsp;用户月度统计</font></td>
    <td>&nbsp;</td>
  </tr>
    <tr>
    <td height="16">&nbsp;</td>
    <td  valign="top" bgcolor="#FFFFFF">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="25">&nbsp;</td>
    <td  align="right"  bgcolor="#FFFFFF"><div id="monthChart" style="width:100%;height:200px;"></div></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="30">&nbsp;</td>
    <td  valign="top"  bgcolor="#FFFFFF" class="fontCSS3"><font color="#004471">&nbsp;用户周统计</font></td>
    <td>&nbsp;</td>
  </tr>
    <tr>
    <td height="16">&nbsp;</td>
    <td  valign="top" bgcolor="#FFFFFF">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="25">&nbsp;</td>
    <td  align="right"  bgcolor="#FFFFFF"><div id="weekChart" style="width:100%;height:200px;"></div></td>
    <td>&nbsp;</td>
  </tr>
</table>
</center>
<script type="text/javascript">
	  setTimeout("showyearchart()",500);
	  setTimeout("showmonthchart()",500);
	  setTimeout("showweekchart()",500);
	  function showyearchart(){
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('yearChart'));


        // 指定图表的配置项和数据
        var option = {
          
            tooltip: {},
            legend: {
                data:['用户增长量']
            },
            xAxis: {
                data: ["2015","2016","2017","2018","2019","2020"]
            },
            yAxis: {},
            series: [{
                name: '用户增长量',
                type: 'pie',
                data: [5, 20, 36, 10, 10, 20]
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        }
		function showmonthchart(){
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('monthChart'));


        // 指定图表的配置项和数据
        var option = {
          
            tooltip: {},
            legend: {
                data:['用户增长量']
            },
            xAxis: {
                data: ["1","2","3","4","5","6","7","8","9","10","11","12"]
            },
            yAxis: {},
            series: [{
                name: '用户增长量',
                type: 'line',
                data: [5, 20, 36, 10, 10, 20, 20, 36, 10, 10, 20, 20]
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        }
		function showweekchart(){
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('monthChart'));


        // 指定图表的配置项和数据
        var option = {
          
            tooltip: {},
            legend: {
                data:['用户增长量']
            },
            xAxis: {
                data: ["7.1","7.2","7.3","7.4","7.5","7.6","7.7"]
            },
            yAxis: {},
            series: [{
                name: '用户增长量',
                type: 'bar',
                data: [5, 20, 36, 10, 10, 20, 20]
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        }
    </script>
                <br>
             
</form>
  </body>
</html>
