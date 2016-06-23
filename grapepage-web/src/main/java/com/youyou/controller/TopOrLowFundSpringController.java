package com.youyou.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.youyou.grapepage.buss.IFundInfoOperator;
import com.youyou.grapepage.model.DMFundInfo;

@Controller
@RequestMapping("fundquery")
public class TopOrLowFundSpringController {

	@Resource(name = "GetFundInfoLogic")
	private IFundInfoOperator operater;

	@RequestMapping("toporlow")
	public String getTopOrLowFundInfo(HttpServletRequest request, HttpServletResponse reponse, Model model) {

		try {
			// TODO Auto-generated method stub
			String dateTime = request.getParameter("datetime");
			String totalCount = request.getParameter("showtotal");
			String sortType = request.getParameter("sortType");

			SimpleDateFormat simFormat = new SimpleDateFormat("yyyy-MM-dd");

			Date date = simFormat.parse(dateTime);
			int count = Integer.parseInt(totalCount);
			int type = Integer.parseInt(sortType);
			//
			// ApplicationContext context = new
			// ClassPathXmlApplicationContext("beansconfig.xml");
			//
			// IFundInfoOperator operater = (IFundInfoOperator)
			// context.getBean("GetFundInfoLogic");

			List<DMFundInfo> lstFundInfo = this.operater.getTopOrLowFundInfo(date, count, type);

			request.setAttribute("fundInfo", lstFundInfo);
			request.setAttribute("datetime", simFormat.format(date));
			request.setAttribute("showtotal", count);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "toporlowfund";
	}
}
