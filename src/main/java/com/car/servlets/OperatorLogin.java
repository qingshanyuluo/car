package com.car.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.car.biz.OperatorBiz;
import com.car.bizimpl.OperatorBizImpl;
import com.car.vo.T_Operator;

public class OperatorLogin extends HttpServlet {

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
      //System.out.println("111111111111112222222222222222222233333333333333333");
		//客服人员登录
		String operatorname = request.getParameter("username");
		String opassword = request.getParameter("password");
	
		if(operatorname==null||"".equals(operatorname)){
			request.setAttribute("omsg", 141);//登录失败，账号不可为空
			request.getRequestDispatcher("OperatorLogin.jsp").forward(request, response);
		}else{
			if(opassword==null||"".equals(opassword)){
				request.setAttribute("omsg", 142);//登录失败，密码不可为空
				request.getRequestDispatcher("OperatorLogin.jsp").forward(request, response);
			}else{
				if(operatorname.length()>20){
					request.setAttribute("omsg", 143);//登录失败，账号长度超出限制
					request.getRequestDispatcher("OperatorLogin.jsp").forward(request, response);
				}else{
					if(opassword.length()>30){
						request.setAttribute("omsg", 144);//登录失败，密码长度超出限制
						request.getRequestDispatcher("OperatorLogin.jsp").forward(request, response);
					}else{
						if(operatorname.replaceAll("[a-z]*[A-Z]*\\d*-*_*\\s*","").length()>0){
							//判断字符串是否由a-z,A-Z,两个下划线，空格组成
							request.setAttribute("omsg", 145);//登录失败，账号错误(非法字符)
							request.getRequestDispatcher("OperatorLogin.jsp").forward(request, response);
						}else{
							if(opassword.replaceAll("[a-z]*[A-Z]*\\d*","").length()>0){
								request.setAttribute("omsg", 146);//登录失败，密码错误(非法字符),字母或数字组成
								request.getRequestDispatcher("OperatorLogin.jsp").forward(request, response);
							}else{
								OperatorBiz biz=new OperatorBizImpl();
								
								HttpSession session=request.getSession();
								//System.out.println("该会话的sessionID是"+session.getId());
								T_Operator operator=new T_Operator();
								operator = biz.Login(operatorname, opassword);
								if(operator.getO_ID()==null || "".equals(operator.getO_ID())){
									//response.sendRedirect("OperatorLogin.jsp");
									request.setAttribute("omsg", 147);//登录失败，账号或密码错误
									request.getRequestDispatcher("OperatorLogin.jsp").forward(request, response);
								}else{
									
									Date dt=new Date();
									SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
									String now=sdf.format(dt);
									session.setAttribute("operator" , operator);
									session.setAttribute("MyTime" , now);
									response.sendRedirect("OperatorIndex.jsp");
									
								}
							}
						}
					}
				}
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
