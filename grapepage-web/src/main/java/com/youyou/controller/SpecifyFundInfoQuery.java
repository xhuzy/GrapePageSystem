package com.youyou.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.youyou.grapepage.buss.IFundInfoOperator;
import com.youyou.grapepage.model.DMFundInfo;

/**
 * Servlet implementation class SpecifyFundInfoQuery
 */
public class SpecifyFundInfoQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SpecifyFundInfoQuery() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String fundcode = request.getParameter("fundCode");
			String fundName = request.getParameter("fundName");
			String date = request.getParameter("date");
			SimpleDateFormat simpformat=new SimpleDateFormat("yyyy-MM-dd");
			Date realDate=simpformat.parse(date);
			ApplicationContext context=new ClassPathXmlApplicationContext("beansconfig.xml");
			IFundInfoOperator operater = (IFundInfoOperator) context.getBean("GetFundInfoLogic");
			
			List<DMFundInfo> lstFundInfo=operater.getFundinfoByCodeAndName(realDate, fundcode, fundName);
			
			request.setAttribute("fundCode",fundcode );
			request.setAttribute("fundName", fundName);
			request.setAttribute("date",date );
			request.setAttribute("lstFundInfo",lstFundInfo );
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/specifyfundquery.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception ex) {
			RuntimeException runex = new RuntimeException(ex);
			throw runex;
		}

	}

}
