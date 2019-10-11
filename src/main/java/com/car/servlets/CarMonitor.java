package com.car.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarMonitor
 */
@WebServlet("/CarMonitor")
public class CarMonitor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarMonitor() {
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
		System.out.print("触发Carmonitor=++++++++++++");
		
	/*	[{
            name: '路线0',
            path: [
                [117.114150,39.065520],
                [117.114565,39.075372],
                [117.114709,39.075856],
                [117.118634,39.075834],
                [117.121662,39.076073],
                [117.118302,39.078887],
                [116.405289,39.904987],
                [116.406265,39.905015],
                [116.406441,39.905018],
                [116.406647,39.905018],
                [116.406647,39.905018],
                [116.40667,39.904457]
                
            ]
        }]*/
		
       /* List list = new ArrayList();
      
        float[] obj1 = new float[]{(float) 117.114150,(float) 39.065520};
        float[] obj2 = new float[]{(float) 117.121662,(float) 39.075834};
        float[] obj3 = new float[]{(float) 117.118302,(float) 39.078887};
        float[] obj4 = new float[]{(float) 116.406441,(float) 39.905018};
        float[] obj5 = new float[]{(float) 116.40667,(float) 39.904457};
		list.add(obj1);
		list.add(obj2);
		list.add(obj3);
		list.add(obj4);
		list.add(obj5);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("name", "路线0");
		data.put("path", list);
		List lista= new ArrayList();
		lista.add(data);*/
	/*	StatusBiz sBiz = new StatusBizImpl();
		
		List lista = new ArrayList();
	   lista.add(sBiz.GetRoute());
     net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(lista);
	    String str = jsonArray.toString();
		 System.out.print(str);
		 request.setAttribute("str", str);*/
		request.getRequestDispatcher("CarMonitor.jsp").forward(request, response);		
	}

}
