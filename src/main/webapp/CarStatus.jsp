
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="S" %>

<form id="pagerForm" method="post" action="CarStatus">
<%-- 	<input type="hidden" name="status" value="${param.status}">--%>
<%-- 	<input type="hidden" name="keywords" value="${param.keyword}" />  --%>
    <input type="hidden" id="C_VIN" name="C_VIN" value="${param.C_VIN}" />
	<input type="hidden" id="pageNum" name="pageNum" value="1" />
	<input type="hidden" id="numPerPage" name="numPerPage" value="${param.numPerPage}" />
    <input type="hidden" id="orderField" name="orderField" value="${param.orderField}" /> 
    <input type="hidden" id="orderDirection" name="orderDirection" value="${param.orderDirection}" />
</form>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="CarStatus" method="post" onreset="$(this).find('select.combox').comboxReset()">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td> 
					VIN码：<input type="text" name="C_VIN" />
				<input type="hidden" name="numPerPage" value="${param.numPerPage}" /> 
							
				</td>
			
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="button"><div class="buttonContent"><button type="reset">重置</button></div></div></li>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div id="pageContent" class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">	
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table id="content_table" class="list" width="98%" targetType="navTab" asc="asc" desc="desc" layoutH="116">
		<thead>
		      <tr>
				<th colspan="2">车主信息</th>
				<th colspan="7">车辆运行状态</th>
				<th colspan="1">数据上传时间</th>
				<th colspan="1">状态详情</th>
			</tr>
			<tr>
				<th width="50" class="desc" orderField="C_VIN">VIN码</th>
				<th width="50" class="asc" orderField="C_VIN">车辆编号</th>
			
				<th width="50">车辆运行状态</th>
				<th width="50">GPS定位状态</th>
				<th width="50">车辆电池状态</th>
				<th width="50">车辆电机状态</th>
				<th width="50">总电流状态</th>
				<th width="50">总电压状态</th>
				 <th width="50">曲轴转速r/min</th>
				<th width="80" class="asc" orderField="C_Time">最新数据上传时间</th>
				<th width="50">详情</th> 
			</tr>
		</thead>
		<tbody>
		    <S:forEach var="StatusList"   items="${StatusList}">
			<tr >
				<td>${StatusList.c_VIN}</td>
				<td>${StatusList.c_ID}</td>
			
				<td>
				         <S:if test="${StatusList.c_Status==0}"><font color="grey"><b>停止</b></font></S:if>
                         <S:if test="${StatusList.c_Status==1}"><font color="green"><b>运行</b></font></S:if>	
                           <S:if test="${StatusList.c_Status==2}"><font color="#efe39b"><b>熄火</b></font></S:if>
                           <S:if test="${StatusList.c_Status==3}"><font color="#25f3e6"><b>离线</b></font></S:if>
                         <S:if test="${StatusList.c_Status==0&&StatusList.charge_Status==1}"><font color="green"><b>充电</b></font></S:if>
				</td>
				<td>
				   
				         <S:if test="${StatusList.GPS_Status==0}"><font color="grey"><b>停止</b></font></S:if>
                         <S:if test="${StatusList.GPS_Status==1}"><font color="green"><b>运行</b></font></S:if>	
				</td>
				<td>
				        <S:if test="${StatusList.b_Status==0}"><font color="grey"><b>无</b></font></S:if>
                        <S:if test="${StatusList.b_Status==1}"><font color="green"><b>正常</b></font></S:if>
						<S:if test="${StatusList.b_Status==2}"><font color="orange"><b>警告</b></font></S:if>
						<S:if test="${StatusList.b_Status==3}"><font color="red"><b>危险</b></font></S:if> 
				</td>
				<td>
				        <S:if test="${StatusList.m_Status==0}"><font color="grey"><b>无</b></font></S:if>
                        <S:if test="${StatusList.m_Status==1}"><font color="green"><b>正常</b></font></S:if>
						<S:if test="${StatusList.m_Status==2}"><font color="orange"><b>警告</b></font></S:if>
						<S:if test="${StatusList.m_Status==3}"><font color="red"><b>危险</b></font></S:if> 
				</td>
				<td>
				        <S:if test="${StatusList.c_Electricity==0}"><font color="grey"><b>无</b></font></S:if>
                        <S:if test="${StatusList.c_Electricity==1}"><font color="green"><b>正常</b></font></S:if>
						<S:if test="${StatusList.c_Electricity==2}"><font color="orange"><b>警告</b></font></S:if>
						<S:if test="${StatusList.c_Electricity==3}"><font color="red"><b>危险</b></font></S:if> 
				</td>
				<td>
				        <S:if test="${StatusList.c_Voltage==0}"><font color="grey"><b>无</b></font></S:if>
                        <S:if test="${StatusList.c_Voltage==1}"><font color="green"><b>正常</b></font></S:if>
						<S:if test="${StatusList.c_Voltage==2}"><font color="orange"><b>警告</b></font></S:if>
						<S:if test="${StatusList.c_Voltage==3}"><font color="red"><b>危险</b></font></S:if> 
				</td>
				<td>
				        ${StatusList.cs_Speed}
				</td>
				<td>${StatusList.c_Time}</td>
					 <td>
					<a title="查看轨迹" target="dialog" href="CarPosition?C_VIN=${StatusList.c_VIN }" width="500" height="500" class="btnEdit">轨迹查看</a>
					<a title="车辆状态详情" target="dialog" href="ShowUpdateCarInfo?C_VIN=${StatusList.c_VIN }" width="800"  class="btnEdit" >状态详情</a>
				</td> 
			</tr>	
			</S:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
			
				<option value="5" ${pageInfo.getShowNumber() eq 5 ? 'selected="selected"' : ''}>5</option>
				<option value="10" ${pageInfo.getShowNumber() eq 10 ? 'selected="selected"' : ''}>10</option>
				<option value="20" ${pageInfo.getShowNumber() eq 20 ? 'selected="selected"' : ''}>20</option>
				<option value="50" ${pageInfo.getShowNumber() eq 50 ? 'selected="selected"' : ''}>50</option>
				<option value="100" ${pageInfo.getShowNumber() eq 100 ? 'selected="selected"' : ''}>100</option>
				<option value="200" ${pageInfo.getShowNumber() eq 200 ? 'selected="selected"' : ''}>200</option>
			</select>
			<span>条，共${pageInfo.getCount()}条</span>
		</div>

		<div class="pagination" targetType="navTab" totalCount="${pageInfo.getCount()}" numPerPage="${pageInfo.getShowNumber()}" pageNumShown="10" currentPage="${pageInfo.getCurPage()}"></div>

	</div>
</div>

 <S:if test="${amsg=='wordError' }">
  	<script>alert("查询关键字含有非法字符！");</script>
  </S:if>
<script type="text/javascript">


/*  var form = document.getElementById("pagerForm");
			//获取该表单下的所有input标签
var inputs = form.getElementsByTagName("input");
var d = {"inputs":[]};
for (var i = 0; i < inputs.length; i++) {
	
	d.inputs[i]="{"+inputs[i].name+":"+inputs[i].value+"}";

}
alert(JSON.stringify(d));
alert(JSON.parse(d)); */
         
         
     

/* var form = document.getElementById("pagerForm");
			//获取该表单下的所有input标签
var inputs = form.getElementsByTagName("input");
        var a =inputs[0].value;
        var b =inputs[1].value; */
        
        
/*       
        
 var C_VIN= $("input[name='C_VIN']").val();    
 var pageNum= $("input[name='pageNum']").val();  
var numPerPage= $("input[name='numPerPage']").val();  
var orderField= $("input[name='orderField']").val(); 
var orderDirection=  $("input[name='orderDirection']").val(); 
alert("c_VIN:--->"+C_VIN+"pageNum:-->"+pageNum+"numPerPage:-->"+numPerPage+"orderField:-->"+orderField+"orderDirection:-->"+orderDirection);

function startRequest(){

navTab.openTab("CarStatus", "http://localhost:8080/Car_Monitor_Platform/CarStatus", { title:"车辆状态查询", fresh:true, 
data:{"C_VIN":C_VIN,"pageNum":pageNum,"numPerPage":numPerPage,"orderField":orderField,"orderDirection":orderDirection}
});  
}    
setTimeout("startRequest()",30000);  */
  
  
  
  
  
  
/* 




 var _form = document.getElementById("pagerForm");
			//获取该表单下的所有input标签
			var _inputs = _form.getElementsByTagName("input");
			//定义一个收集input标签的name和值 
			var d = {"inputs":[]};
			
			//循环这个input数组取值  并将获取name和值拼接成对象赋值给d的对象的第I位
			for (var i = 0; i < _inputs.length; i++) {
				
				d.inputs[i]="{"+_inputs[i].name+":"+_inputs[i].value+"}";
			}
			var date =JSON.stringify(d)
			alert(date);

//setInterval("startRequest()",10000);
setTimeout("startRequest()",10000);

 */

</script>
