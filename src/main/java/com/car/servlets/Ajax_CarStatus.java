package com.car.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.car.biz.StatusBiz;
import com.car.bizimpl.StatusBizImpl;
import com.car.vo.Page;
import com.car.vo.T_C_Status;

/**
 * Servlet implementation class Ajax_CarStatus
 */
@WebServlet("/Ajax_CarStatus")
public class Ajax_CarStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajax_CarStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("触发AJAX车辆状态显示servlet-----");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session =  request.getSession();
        String pages=request.getParameter("pageNum");
        String C_VIN = request.getParameter("C_VIN");
        String orderBys=request.getParameter("orderField");
        String numPerPage=request.getParameter("numPerPage");
        String SCs=request.getParameter("orderDirection");
        System.out.println("前端pagenum："+pages);
        System.out.println("前端orderfueld："+orderBys);
        System.out.println("前端numperpage："+numPerPage);
        System.out.println("前端排序条件："+SCs);
        System.out.println("前端关键字条件："+C_VIN);
        
        int pageNum = 1;
		if (pages != null && !"".equals(pages)) {
			pageNum = Integer.parseInt(pages);
		}
		int NumPerPage = 15;
		if (numPerPage != null && !"".equals(numPerPage)) {
			NumPerPage = Integer.parseInt(numPerPage);
		}
		String SC="asc";
		if(SCs !=null && !"".equals(SCs)){
			SC=SCs;
		}
		String orderBy="C_VIN";
		if(orderBys !=null && !"".equals(orderBys)){
			orderBy=orderBys;
		}
		
		if((C_VIN==null||"".equals(C_VIN))){
			StatusBiz sBiz=new StatusBizImpl();
			Page page = new Page(pageNum,NumPerPage,sBiz.AllStatusCount());
			List<T_C_Status> mList=new ArrayList<T_C_Status>();
			mList=sBiz.AllStatus(page,orderBy,SC);
			System.out.println(mList.size());
			
			request.setAttribute("StatusList", mList);
			request.setAttribute("pageInfo", page);
			request.setAttribute("orderByInfo", orderBy);
			request.setAttribute("SCInfo", SC);
			
			PrintWriter out = response.getWriter();
			
			out.println("<table id=\"content_table\" class=\"list\" width=\"98%\" targetType=\"navTab\" asc=\"asc\" desc=\"desc\" layoutH=\"116\">"+
					"		<thead>"+
					"		      <tr>"+
					"				<th colspan=\"2\">车主信息</th>"+
					"				<th colspan=\"7\">车辆运行状态</th>"+
					"				<th colspan=\"1\">数据上传时间</th>"+
					"				<th colspan=\"1\">状态详情</th>"+
					"			</tr>"+
					"			<tr>"+
					"				<th width=\"50\" class=\"asc\" orderField=\"C_VIN\">VIN码</th>"+
					"				<th width=\"50\" class=\"desc\" orderField=\"C_VIN\">车辆编号</th>"+
					"				"+
					"				<th width=\"50\">车辆运行状态</th>"+
					"				<th width=\"50\">GPS定位状态</th>"+
					"				<th width=\"50\">车辆电池状态</th>"+
					"				<th width=\"50\">车辆电机状态</th>"+
					"				<th width=\"50\">总电流状态</th>"+
					"				<th width=\"50\">总电压状态</th>"+
					"				<th width=\"50\">曲轴转速r/min</th>"+
					"				<th width=\"80\" class=\"asc\" orderField=\"C_Time\">最新数据上传时间</th>"+
					"				<th width=\"50\">详情</th>"+
					"			</tr>"+
					"		</thead>"+
					"		<tbody>"+
					"		    <S:forEach var=\"StatusList\"   items=\"${StatusList}\">"+
					"			<tr >"+
					"				<td>${StatusList.c_VIN}</td>"+
					"				<td>${StatusList.c_ID}</td>"+
					"				"+
					"				<td>"+
					"				         <S:if test=\"${StatusList.c_Status==0}\"><font color=\"grey\"><b>停止</b></font></S:if>"+
					"                         <S:if test=\"${StatusList.c_Status==1}\"><font color=\"green\"><b>运行</b></font></S:if>	"+
					"                         <S:if test=\"${StatusList.c_Status==0&&StatusList.charge_Status==1}\"><font color=\"green\"><b>充电</b></font></S:if>"+
					"				</td>"+
					"				<td>"+
					"				   "+
					"				         <S:if test=\"${StatusList.GPS_Status==0}\"><font color=\"grey\"><b>停止</b></font></S:if>"+
					"                         <S:if test=\"${StatusList.GPS_Status==1}\"><font color=\"green\"><b>运行</b></font></S:if>	"+
					"				</td>"+
					"				<td>"+
					"				        <S:if test=\"${StatusList.b_Status==0}\"><font color=\"grey\"><b>无</b></font></S:if>"+
					"                        <S:if test=\"${StatusList.b_Status==1}\"><font color=\"green\"><b>正常</b></font></S:if>"+
					"						<S:if test=\"${StatusList.b_Status==2}\"><font color=\"orange\"><b>警告</b></font></S:if>"+
					"						<S:if test=\"${StatusList.b_Status==3}\"><font color=\"red\"><b>危险</b></font></S:if> "+
					"				</td>"+
					"				<td>"+
					"				        <S:if test=\"${StatusList.m_Status==0}\"><font color=\"grey\"><b>无</b></font></S:if>"+
					"                        <S:if test=\"${StatusList.m_Status==1}\"><font color=\"green\"><b>正常</b></font></S:if>"+
					"						<S:if test=\"${StatusList.m_Status==2}\"><font color=\"orange\"><b>警告</b></font></S:if>"+
					"						<S:if test=\"${StatusList.m_Status==3}\"><font color=\"red\"><b>危险</b></font></S:if> "+
					"				</td>"+
					"				<td>"+
					"				        <S:if test=\"${StatusList.c_Electricity==0}\"><font color=\"grey\"><b>无</b></font></S:if>"+
					"                        <S:if test=\"${StatusList.c_Electricity==1}\"><font color=\"green\"><b>正常</b></font></S:if>"+
					"						<S:if test=\"${StatusList.c_Electricity==2}\"><font color=\"orange\"><b>警告</b></font></S:if>"+
					"						<S:if test=\"${StatusList.c_Electricity==3}\"><font color=\"red\"><b>危险</b></font></S:if> "+
					"				</td>"+
					"				<td>"+
					"				        <S:if test=\"${StatusList.c_Voltage==0}\"><font color=\"grey\"><b>无</b></font></S:if>"+
					"                        <S:if test=\"${StatusList.c_Voltage==1}\"><font color=\"green\"><b>正常</b></font></S:if>"+
					"						<S:if test=\"${StatusList.c_Voltage==2}\"><font color=\"orange\"><b>警告</b></font></S:if>"+
					"						<S:if test=\"${StatusList.c_Voltage==3}\"><font color=\"red\"><b>危险</b></font></S:if> "+
					"				</td>"+
					"				<td>"+
					"				        ${StatusList.cs_Speed}"+
					"				</td>"+
					"				<td>${StatusList.c_Time}</td>"+
					"				<td>"+
					"					<a title=\"查看轨迹\" target=\"dialog\" href=\"CarMonitor(test).jsp\" width=\"500\" height=\"500\" class=\"btnEdit\">轨迹查看</a>"+
					"					<a title=\"车辆状态详情\" target=\"dialog\" href=\"ShowUpdateCarInfo?C_VIN=${StatusList.c_VIN }\" width=\"800\"  class=\"btnEdit\">状态详情</a>"+
					"				</td>"+
					"			</tr>	"+
					"			</S:forEach>"+
					"		</tbody>"+
					"	</table>");
			out.flush();
			out.close();
			System.out.println("1111111111111111111111111111111111111");	
		}
		
	}

}
