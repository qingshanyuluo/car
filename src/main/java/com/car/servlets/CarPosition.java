package com.car.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.car.biz.StatusBiz;
import com.car.bizimpl.StatusBizImpl;
import com.car.vo.T_C_Status;

/**
 * Servlet implementation class CarPosition
 */
@WebServlet("/CarPosition")
public class CarPosition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarPosition() {
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
	System.out.println("触发CarPosition----servet------");
		
		String C_VIN = request.getParameter("C_VIN");
        System.out.println("前端C_VIN："+C_VIN);    
        
        StatusBiz sBiz = new StatusBizImpl();
        T_C_Status tsc = sBiz.CarLonlat(C_VIN);
        float lng= tsc.getC_longitude();
        float lat= tsc.getC_latitude();
        System.out.println("lng:"+lng+"lat:"+lat);
        request.setAttribute("lng", lng);
        request.setAttribute("lat", lat);
		request.getRequestDispatcher("CarPath.jsp").forward(request, response);		
        
		
		
		
		
	}

}
