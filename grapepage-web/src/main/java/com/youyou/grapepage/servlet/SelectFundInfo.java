package com.youyou.grapepage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectFundInfo
 */
public class SelectFundInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectFundInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/jspfolder/MyFirst.jsp").forward(request, response);

		return;

		
		//cookie use
//		Cookie[] cookies = request.getCookies();
//
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//		out.println("<HTML>");
//		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//		out.println("  <BODY>");
//		out.print("    This is ");
//		out.print(this.getClass());
//		out.println(", using the Get method");
//		if (cookies != null && cookies.length > 0) {
//			for (Cookie cookie : cookies) {
//				out.println(cookie.getName() + cookie.getValue());
//			}
//		}
//
//		out.println("  </BODY>");
//		out.println("</HTML>");
//
//		SimpleDateFormat simformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
//		String time = simformat.format(new Date());
//		Cookie cookie = new Cookie("cookieTest", time);
//		cookie.setPath("/grapepage-web/SelectFundInfo");
//		response.addCookie(cookie);
//
//		out.flush();
//		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
