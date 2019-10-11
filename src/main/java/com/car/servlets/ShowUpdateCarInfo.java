package com.car.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.car.biz.CarBiz;
import com.car.bizimpl.CarBizImpl;
import com.car.vo.T_Car;

/**
 * Servlet implementation class ShowUpdateCarInfo
 */
@WebServlet("/ShowUpdateCarInfo")
public class ShowUpdateCarInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUpdateCarInfo() {
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
		System.out.println("触发了显示更新车辆信息servlet");
		String C_VIN = request.getParameter("C_VIN");
		System.out.println("页面获取的VIN："+C_VIN);
	
		CarBiz cBiz =new CarBizImpl();
	      T_Car tCar =new T_Car();
	      tCar=cBiz.CarInfo(C_VIN);
	      //System.out.println("汽车的ID"+tCar.getC_ID());
	      request.setAttribute("tCar", tCar);
	      request.getRequestDispatcher("UpdateCarInfo.jsp").forward(request, response);	
	}

}
