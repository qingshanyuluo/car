package com.car.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

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
 * Servlet implementation class UpdateCarInfo
 */
@WebServlet("/UpdateCarInfo")
public class UpdateCarInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCarInfo() {
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
		System.out.println("触发了更新车辆信息servlet");
		 request.setCharacterEncoding("UTF-8");
			String C_VIN=request.getParameter("C_VIN");
			String U_Name=request.getParameter("U_Name");
			String U_Tel=request.getParameter("U_Tel");
			String U_Email=request.getParameter("U_Email");
			String U_Address=request.getParameter("U_Address");
			String C_Type=request.getParameter("C_Type");
			System.out.println("-"+C_VIN+"-"+C_Type+"-"+U_Name+"-"+U_Tel+"-"+U_Email+"-"+U_Address);
			//将页面需要添加的参数放入实体类中
			T_Car tcar=new T_Car();
			tcar.setC_VIN(Integer.parseInt(C_VIN));
			tcar.setU_Name(U_Name);
			tcar.setU_Tel(U_Tel);
			tcar.setU_Email(U_Email);
			tcar.setC_Type(C_Type);
			tcar.setU_Address(U_Address);
			Date dt=new Date();
			Timestamp ts=new Timestamp(dt.getTime());
			tcar.setU_Time(ts);//最近一次更新时间
			CarBiz cBiz=new CarBizImpl();
			T_Ajax ajax =new T_Ajax();
			boolean flag=cBiz.UpdateCar(tcar);
			if(flag){
				System.out.println("更新车辆信息成功");
				ajax.setStatusCode(200);
				ajax.setMessage("更新车辆信息成功");
				ajax.setCallbackType("closeCurrent");
				JSONObject json= new JSONObject(ajax);
				response.setContentType("text/html; charset=utf-8");
				System.out.println(json);
				PrintWriter out = response.getWriter();
				out.println(json);
				out.flush();
				out.close();		
				
				//添加充电站成功
			}else{
				System.out.println("更新失败,未知错误，请联系管理员！");
				ajax.setStatusCode(300);
				ajax.setMessage("更新失败,未知错误，请联系管理员！");
				ajax.setCallbackType("closeCurrent");			
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
