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
 * Servlet implementation class DeleteMultiCarInfo
 */
@WebServlet("/DeleteMultiCarInfo")
public class DeleteMultiCarInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMultiCarInfo() {
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
		System.out.println("触发批量删除车信息servlet");
		String[] cIds=request.getParameter("ids").split(",");
		String Cids=request.getParameter("ids");
		System.out.println("复选框长度为："+cIds.length+"Cids的值："+Cids);
		T_Ajax ajax = new T_Ajax();
		if(Cids.isEmpty()){
			System.out.println("添加失败,请选择您需要删除的记录");
			ajax.setStatusCode(300);
			ajax.setMessage("添加失败,请选择您需要删除的记录");	
			JSONObject json= new JSONObject(ajax);
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
			out.close();		
			
		}else{
			for(int i=0;i<cIds.length;i++){
				CarBiz cBiz = new CarBizImpl();
				T_Car tcar = new T_Car();
				System.out.println(Integer.parseInt(cIds[i]));
				tcar.setC_VIN(Integer.parseInt(cIds[i]));
				cBiz.DeleteCar(tcar);
				System.out.println("编号为"+cIds[i]+"已经删除");
			}
			System.out.println("删除成功！");
			ajax.setStatusCode(200);
			ajax.setMessage("您删除了"+cIds.length+"条记录！");	
			JSONObject json= new JSONObject(ajax);
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
			out.close();	
			
		}
	
	}
}
