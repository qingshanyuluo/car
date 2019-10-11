package com.car.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminFilter
 */
public class OperatorFilter implements Filter {

    /**
     * Default constructor. 
     */
    public OperatorFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		//Admin
		HttpServletRequest HttpRequest=(HttpServletRequest)request;
		HttpServletResponse HttpResponse=(HttpServletResponse)response;
		HttpSession se=HttpRequest.getSession();
	
		if("".equals(se.getAttribute("operator")) || se.getAttribute("operator")==null){
			HttpResponse.sendRedirect("OperatorLogin.jsp?omsg=502");
		}else{
			chain.doFilter(request, response);
		}
	}


		// pass the request along the filter chain
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
