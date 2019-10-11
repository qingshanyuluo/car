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

import org.json.JSONObject;

import com.car.biz.StatusBiz;
import com.car.bizimpl.StatusBizImpl;
import com.car.vo.T_Ajax;

/**
 * Servlet implementation class CarPathInfo
 */
@WebServlet("/CarPathInfo")
public class CarPathInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarPathInfo() {
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
		request.setCharacterEncoding("UTF-8");
		System.out.println("触发CarPathInfo----------");
		String dateStart = request.getParameter("dateStart");
		String dateEnd = request.getParameter("dateEnd");
		String C_VIN = request.getParameter("C_VIN");
		System.out.println("前端日期开始时间：" + dateStart);
		System.out.println("前端日期结束时间：" + dateEnd);
		System.out.println("前端C_VIN：" + C_VIN);
		T_Ajax ajax = new T_Ajax();
		StatusBiz sBiz = new StatusBizImpl();
	
		List lista = new ArrayList();
		lista.add(sBiz.GetRoute(C_VIN,dateStart,dateEnd));
		if(sBiz.GetRoute(C_VIN,dateStart,dateEnd)!=null){
			net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(lista);
			String str = jsonArray.toString();
			System.out.print(str);
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println(str);
			out.flush();
			out.close();
		}else{
			ajax.setStatusCode(300);
			ajax.setMessage("该车在此时间未存在轨迹路线！");
			JSONObject json= new JSONObject(ajax);
			response.setContentType("text/html; charset=utf-8");
			System.out.println(json);
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
			out.close();
			
		}   
	}

}
