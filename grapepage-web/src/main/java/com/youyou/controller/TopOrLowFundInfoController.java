package com.youyou.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.youyou.grapepage.buss.IFundInfoOperator;
import com.youyou.grapepage.model.DMFundInfo;

/**
 * Servlet implementation class TopOrLowFundInfoController
 */
@Controller("GetTopFundController")
public class TopOrLowFundInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TopOrLowFundInfoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// TODO Auto-generated method stub
			String dateTime = request.getParameter("datetime");
			String totalCount = request.getParameter("showtotal");
			String sortType = request.getParameter("sortType");

			SimpleDateFormat simFormat = new SimpleDateFormat("yyyy-MM-dd");

			Date date = simFormat.parse(dateTime);
			int count = Integer.parseInt(totalCount);
			int type = Integer.parseInt(sortType);

			ApplicationContext context = new ClassPathXmlApplicationContext("beansconfig.xml");

			IFundInfoOperator operater = (IFundInfoOperator) context.getBean("GetFundInfoLogic");

			List<DMFundInfo> lstFundInfo = operater.getTopOrLowFundInfo(date, count, type);

			request.setAttribute("fundInfo", lstFundInfo);
			request.setAttribute("datetime", simFormat.format(date));
			request.setAttribute("showtotal", count);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/toporlowfund.jsp");
			dispatcher.forward(request, response);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
