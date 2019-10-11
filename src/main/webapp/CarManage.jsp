
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="S" %>
<form id="pagerForm" method="post" action="CarManage">
<%-- 	<input type="hidden" name="status" value="${param.status}">--%>
 <input type="hidden" name="dateEnd" value="${param.dateEnd}" /> 
     <input type="hidden" name="dateStart" value="${param.dateStart}" />  
	<input type="hidden" name="keyword" value="${param.keyword}" />  
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${param.numPerPage}" />
    <input type="hidden" name="orderField" value="${param.orderField}" /> 
    <input type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="CarManage" method="post" onreset="$(this).find('select.combox').comboxReset()">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td> 
					关键字：<input type="text" name="keyword" />
					 <input type="hidden" name="numPerPage" value="${param.numPerPage}" /> 
				</td>
				<td>
					日期：<input name=dateStart type="text" class="date"  readonly="true" />
				    --    <input name=dateEnd type="text" class="date"  readonly="true" />
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
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="addCarInfo.jsp" target="dialog" width="800"><span>添加</span></a></li>
			<li><a id="delBtn" title="确实要删除这些记录吗?" target="ajaxTodo" rel="ids" href="DeleteMultiCarInfo?ids=1" class="delete"><span>批量删除</span></a></li>
			<input id="ids" type="hidden">			
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
			    <th width="22"><input type="checkbox" group="cids" class="checkboxCtrl"></th>
				<th width="40" class="desc" orderField="C_VIN">VIN码</th>
				<th width="40" class="asc" orderField="C_VIN">车辆编号</th>
				<th width="50">车主姓名</th>
				<th width="30">所属类型</th>
				<th width="80">车主地址</th>
				<th width="80">车主Email</th>
				<th width="80">创建时间</th>
				<th width="80">最近一次更新时间</th>
				<th width="50">操作</th>
				
			</tr>
		</thead>
		<tbody>
		    <S:forEach var="CarList"   items="${CarList}">
			<tr >
				<td><input name="cids" value="${CarList.c_VIN }" type="checkbox"></td>
				<td>${CarList.c_VIN }</td>
				<td>${CarList.c_VIN  }</td>
				<td>${CarList.u_Name}</td>	
				<td>${CarList.c_Type }</td>
				<td>${CarList.u_Address}</td>
				<td>${CarList.u_Email}</td>
				<td>${CarList.c_Time}<</td>
				<td>${CarList.u_Time}<</td>
				<td>
					<a title="删除" target="ajaxTodo" href="DeleteCarInfo?C_VIN=${CarList.c_VIN }" class="btnDel">删除</a>
					<a title="编辑" target="dialog" href="ShowUpdateCarInfo?C_VIN=${CarList.c_VIN }" width="800"  class="btnEdit">编辑</a>
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

 <S:if test="${omsg==251 }">
  	<script>alert("删除失败，未选择删除项！");</script>
  </S:if>
   <S:if test="${omsg==252 }">
  	<script>alert("删除成功！您删除了"+${CarCount}+"个车辆信息");</script>
  </S:if>
 <script>
	$("#delBtn", navTab.getCurrentPanel()).bind('click', function() {
			 var chk_value =[];
		      $('input[name="cids"]:checked').each(function(){
		     	 chk_value.push($(this).val());
		      });
			$("#ids").val(chk_value);
			$("#delBtn").attr("href","DeleteMultiCarInfo?ids="+$("#ids").val());
		});



</script>
 