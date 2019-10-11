<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="S" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="pageContent">
	<form method="post" action="UpdateCarInfo" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>VIN码：</label>
				<input name="C_VIN" type="text" size="30" value="${tCar.getC_VIN() }" class="required" alt="请输入VIN号码"/>
			</p>
			<p>
				<label>车主姓名：</label>
				<input name="U_Name" class="required" value="${tCar.getU_Name() }" type="text" size="30" alt="请输入客户名称"/>
			</p>
			 <p>
				<label>车主电话：</label>
				<input name="U_Tel" type="text" size="30" value="${tCar.getU_Tel() }" class="required" alt="请输入车主电话"/>
			</p> 
			<p>
				<label>车主Email：</label>
				<input name="U_Email" type="text" size="30" value="${tCar.getU_Email() }" class="required" alt="请输入车主邮箱"/>
			</p> 
		
		  
			<p>
				<label>车辆品牌：</label>
				<%-- <input name="C_Type" type="text" size="20" value="${tCar.getC_Type() }" class="required" alt="请输入车辆品牌"/> --%>
				<select name="C_Type"  class="required combox">
					<option value="">请选择</option>
					<option value="奔驰" ${tCar.getC_Type() eq '奔驰' ? 'selected="selected"' : ''} >奔驰</option>
					<option value="宝马" ${tCar.getC_Type() eq '宝马' ? 'selected="selected"' : ''}  >宝马</option>
					<option value="大众" ${tCar.getC_Type() eq '大众' ? 'selected="selected"' : ''} >大众</option>
					<option value="奥迪" ${tCar.getC_Type() eq '奥迪' ? 'selected="selected"' : ''} >奥迪</option>
					<option value="法拉利" ${tCar.getC_Type() eq '法拉利' ? 'selected="selected"' : ''}>法拉利</option>
				</select>
			</p>
			 <p>
				<label>车主地址：</label>
				<input name="U_Address" type="text" size="30" value="${tCar.getU_Address() }" class="required" alt="请输入车主所在地址"/>
			</p> 
			
		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
