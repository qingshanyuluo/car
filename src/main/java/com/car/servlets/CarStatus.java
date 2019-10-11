package com.car.servlets;

import java.io.IOException;
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
 * Servlet implementation class CarStatus
 */
@WebServlet("/CarStatus")
public class CarStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarStatus() {
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
		System.out.println("触发车辆状态显示servlet-----");
		HttpSession session =  request.getSession();
        String pages=request.getParameter("pageNum");
        String C_VIN1 = request.getParameter("C_VIN");
        String orderBys=request.getParameter("orderField");
        String numPerPage1=request.getParameter("numPerPage");
        String SCs=request.getParameter("orderDirection");
        System.out.println("前端pagenum："+pages);
        System.out.println("前端orderfueld："+orderBys);
        System.out.println("前端numperpage："+numPerPage1);
        System.out.println("前端排序条件："+SCs);
        System.out.println("前端关键字条件："+C_VIN1);
        
        int pageNum = 1;
		if (pages != null && !"".equals(pages)) {
			pageNum = Integer.parseInt(pages);
		}
		int NumPerPage = 5;
		if (numPerPage1 != null && !"".equals(numPerPage1)) {
			NumPerPage = Integer.parseInt(numPerPage1);
		}
		String SC="asc";
		if(SCs !=null && !"".equals(SCs)){
			SC=SCs;
		}
		
		System.out.println("SC是--->"+SC);
		String orderBy="C_VIN";
		if(orderBys !=null && !"".equals(orderBys)){
			orderBy=orderBys;
		}
		String C_VIN="";
		if(C_VIN1 !=null && !"".equals(C_VIN1)){
			C_VIN=C_VIN1;
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
			
			request.setAttribute("C_VIN", C_VIN);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("NumPerPage", NumPerPage);
			request.setAttribute("orderBy", orderBy);
			request.setAttribute("SC", SC);

			request.getRequestDispatcher("CarStatus.jsp").forward(request, response);
				
			
			System.out.println("1111111111111111111111111111111111111");	
		}else{
		
			if(C_VIN.replaceAll("[\u4e00-\u9fa5]*[a-z]*[A-Z]*\\d*-*_*\\s*","").length()>0){
				request.setAttribute("amsg","wordError");
				//关键字含有非法字符
				StatusBiz sBiz=new StatusBizImpl();
				Page page = new Page(pageNum,NumPerPage,sBiz.AllStatusCount());
				List<T_C_Status> mList=new ArrayList<T_C_Status>();
				mList=sBiz.AllStatus(page,orderBy,SC);
				request.setAttribute("StatusList", mList);
				request.setAttribute("pageInfo", page);
				request.setAttribute("orderByInfo", orderBy);
				request.setAttribute("SCInfo", SC);
				request.getRequestDispatcher("CarStatus.jsp").forward(request, response);
								
				System.out.println("222222222222222222222222222222");	
			}else{
				StatusBiz sBiz=new StatusBizImpl();
				Page page = new Page(pageNum,NumPerPage,sBiz.CarKeywordCount(C_VIN));
				int sum =sBiz.CarKeywordCount(C_VIN);
				System.out.println("共有多少条记录："+ sum);
				
				List<T_C_Status> mList=new ArrayList<T_C_Status>();
				mList=sBiz.CarSelect(page, C_VIN, orderBy, SC);
				
                session.setAttribute("StatusList", mList);

				request.setAttribute("pageInfo", page);
				request.setAttribute("orderByInfo", orderBy);
				request.setAttribute("SCInfo", SC);
				request.getRequestDispatcher("CarStatus.jsp").forward(request, response);			
				
				System.out.println("33333333333333333333333333333333");	
			}
		
		}
	}

}
