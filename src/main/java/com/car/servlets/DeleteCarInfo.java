package com.car.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.car.biz.CarBiz;
import com.car.bizimpl.CarBizImpl;
import com.car.vo.T_Ajax;
import com.car.vo.T_Car;

/**
 * Servlet implementation class DeleteCarInfo
 */
@WebServlet("/DeleteCarInfo")
public class DeleteCarInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCarInfo() {
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
		System.out.println("触发单个删除车辆信息servlet");
		String C_VIN=request.getParameter("C_VIN");
		T_Car tCar =new T_Car();
		tCar.setC_VIN(Integer.parseInt(C_VIN));
		CarBiz cBiz=new CarBizImpl();
	     boolean  flag=cBiz.DeleteCar(tCar);
	     T_Ajax ajax =new T_Ajax();
	     if(flag){
				System.out.println("删除车辆信息成功");
				ajax.setStatusCode(200);
				ajax.setMessage("删除车辆信息成功！");
				
				JSONObject json= new JSONObject(ajax);
				response.setContentType("text/html; charset=utf-8");
				System.out.println(json);
				PrintWriter out = response.getWriter();
				out.println(json);
				out.flush();
				out.close();		
				
				//添加充电站成功
			}else{
				System.out.println("删除失败,已存在数据无法插入");
				ajax.setStatusCode(300);
				ajax.setMessage("删除失败,未知错误，请联系技术人员！");	
		
				JSONObject json= new JSONObject(ajax);
				response.setContentType("text/html; charset=utf-8");
				System.out.println(json);
				PrintWriter out = response.getWriter();
				out.println(json);
				out.flush();
				out.close();		
				
				//添加失败,未知错误
			}
	}

}
