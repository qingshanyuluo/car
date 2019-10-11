package com.car.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.car.biz.CarBiz;
import com.car.bizimpl.CarBizImpl;
import com.car.vo.Page;
import com.car.vo.T_Car;

public class CarManage extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
               doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
               System.out.println("触发CarManager.servlet");
               HttpSession session =  request.getSession();
               String pages=request.getParameter("pageNum");
               String keywords = request.getParameter("keyword");
               String orderBys=request.getParameter("orderField");
               String numPerPage=request.getParameter("numPerPage");
               String SCs=request.getParameter("orderDirection");
               String dateStart = request.getParameter("dateStart");
			   String dateEnd = request.getParameter("dateEnd");
               System.out.println("前端pagenum："+pages);
               System.out.println("前端orderfueld："+orderBys);
               System.out.println("前端numperpage："+numPerPage);
               System.out.println("前端排序条件："+SCs);
               System.out.println("前端关键字条件："+keywords);
               System.out.println("前端日期开始时间："+dateStart);
               System.out.println("前端日期结束时间："+dateEnd);
               int pageNum = 1;
				if (pages != null && !"".equals(pages)) {
					pageNum = Integer.parseInt(pages);
				}
				int NumPerPage = 5;
				if (numPerPage != null && !"".equals(numPerPage)) {
					NumPerPage = Integer.parseInt(numPerPage);
				}
				String SC="asc";
				if(SCs !=null && !"".equals(SCs)){
					SC=SCs;
				}
				String orderBy="C_Time";
				if(orderBys !=null && !"".equals(orderBys)){
					orderBy=orderBys;
				}
				String keyword="";
				if(keywords !=null && !"".equals(keywords)){
					keyword=keywords;
				}
				String DateStart="";
				if(dateStart !=null && !"".equals(dateStart)){
					DateStart=dateStart;
				}
				String DateEnd="";
				if(dateEnd !=null && !"".equals(dateEnd)){
					DateEnd=dateEnd;
				}
				if((keyword==null||"".equals(keyword))&&(DateStart==null||"".equals(DateStart))&&(DateEnd==null||"".equals(DateEnd))){
					CarBiz cBiz=new CarBizImpl();
					Page page = new Page(pageNum,NumPerPage,cBiz.AllCarCount());
					List<T_Car> cList=new ArrayList<T_Car>();
					cList=cBiz.AllCar(page,orderBy,SC);
					
					session.setAttribute("CarList", cList);
					request.setAttribute("pageInfo", page);
					request.setAttribute("orderByInfo", orderBy);
					request.setAttribute("SCInfo", SC);
					request.getRequestDispatcher("CarManage.jsp").forward(request, response);
					
					System.out.println("1111111111111111111111111111111111111");	
				}else{
					//System.out.print("keyword的值是"+keywords);
					if(keyword.replaceAll("[\u4e00-\u9fa5]*[a-z]*[A-Z]*\\d*-*_*\\s*","").length()>0){
						request.setAttribute("amsg","wordError");
						//关键字含有非法字符
						CarBiz cBiz=new CarBizImpl();
						Page page = new Page(pageNum,NumPerPage,cBiz.AllCarCount());
						List<T_Car> cList=new ArrayList<T_Car>();
						cList=cBiz.AllCar(page,orderBy,SC);
						
						session.setAttribute("CarList", cList);
						request.setAttribute("keywordInfo", keywords);
						request.setAttribute("dateStart", dateStart);
						request.setAttribute("dateEnd", dateEnd);
						request.setAttribute("pageInfo", page);
						request.setAttribute("orderByInfo", orderBy);
						request.setAttribute("SCInfo", SC);
						request.getRequestDispatcher("CarManage.jsp").forward(request, response);
						System.out.println("222222222222222222222222222222");	
					}else{
						CarBiz cBiz=new CarBizImpl();
						Page page = new Page(pageNum,NumPerPage,cBiz.CarKeywordCount(keyword,DateStart,DateEnd));
						List<T_Car> cList=new ArrayList<T_Car>();
						cList=cBiz.CarSelect(page, keyword,DateStart,DateEnd, orderBy, SC);
					 
						session.setAttribute("CarList", cList);
						request.setAttribute("keywordInfo", keyword);
						request.setAttribute("dateStart", DateStart);
						request.setAttribute("dateEnd", DateEnd);
						request.setAttribute("pageInfo", page);
						request.setAttribute("orderByInfo", orderBy);
						request.setAttribute("SCInfo", SC);
						request.getRequestDispatcher("CarManage.jsp").forward(request, response);
						System.out.println("33333333333333333333333333333333");	
					}
				}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
