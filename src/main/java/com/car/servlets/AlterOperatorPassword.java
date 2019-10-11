package com.car.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.car.biz.PasswordBiz;
import com.car.bizimpl.PasswordBizImpl;
import com.car.vo.T_Ajax;
import com.car.vo.T_Operator;

public class AlterOperatorPassword extends HttpServlet {

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

	  System.out.println("--------触发了修改操作员密码servlet-------");
	  String tOPassword_old = request.getParameter("oldPassword");
		String tOPassword_new = request.getParameter("newPassword");
		String tOPassword_check = request.getParameter("rnewPassword");
		System.out.println("旧密码："+tOPassword_old+"新密码："+tOPassword_new+"重复新密码："+tOPassword_check);
		HttpSession session = request.getSession();
	    T_Operator tOperator = (T_Operator) session.getAttribute("operator");
	    System.out.println("我是session中的密码："+tOperator.getO_Password());
	    System.out.println("我是页面中的密码："+tOPassword_old);
	    T_Ajax ajax =new T_Ajax();
	    if (tOPassword_old.equals(tOperator.getO_Password())){
	        PasswordBiz pwBiz=new PasswordBizImpl();
			Boolean flag=pwBiz.AlterOperatorPW(tOperator.getO_ID(), tOPassword_new);
			if(flag){		
				ajax.setStatusCode(200);
				ajax.setMessage("修改密码成功");
				ajax.setCallbackType("closeCurrent");
				JSONObject json= new JSONObject(ajax);
				tOperator.setO_Password(tOPassword_new);
				session.setAttribute("operator" , tOperator);
				response.setContentType("text/html; charset=utf-8");
				System.out.println(json);
				PrintWriter out = response.getWriter();
				out.println(json);
				out.flush();
				out.close();		
				System.out.println("密码修改成功!");
		    }
			}else{
				ajax.setStatusCode(300);
				ajax.setMessage("修改密码失败,原密码错误！");
				JSONObject json= new JSONObject(ajax);
				response.setContentType("text/html; charset=utf-8");
				System.out.println(json);
				PrintWriter out = response.getWriter();
				out.println(json);
				out.flush();
				out.close();
				System.out.println("密码修改失败");
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
