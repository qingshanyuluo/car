package com.car.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.car.biz.CarBiz;
import com.car.bizimpl.CarBizImpl;

/**
 * Servlet implementation class CarStatusStatistic
 */
@WebServlet("/CarStatusStatistic")
public class CarStatusStatistic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarStatusStatistic() {
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
		System.out.println("==================触发车辆状态数据显示servlet=================");
		CarBiz cBiz = new CarBizImpl();
	      List cList =cBiz.CarStatusCount();
		net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(cList);
		String str = jsonArray.toString();
		System.out.print(str+"\n");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(str);
		out.flush();
		out.close();
	}

}
