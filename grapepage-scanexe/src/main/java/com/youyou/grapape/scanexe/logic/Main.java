package com.youyou.grapape.scanexe.logic;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		try {

			ApplicationContext context = new ClassPathXmlApplicationContext("beansconfig.xml");

			EachFundDealLogic dealLogic = (EachFundDealLogic) context.getBean("eachfunddeallogic");

			String[] fundCode = null;

			Properties pops = new Properties();
			pops.load(Main.class.getClassLoader().getResourceAsStream("FundList.properties"));
			String fundList = pops.getProperty("fundcode");
			fundCode = fundList.split("/");

			while (true) {
				try {
					for (String fund : fundCode) {
						if (null == fund || fund.isEmpty()) {
							continue;
						}

						Thread thread = new Thread(new Runnable() {

							@Override
							public void run() {
								dealLogic.dealEachFund(fund);

							}
						});

						thread.start();

					}

					Thread.sleep(5*60 * 1000);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
