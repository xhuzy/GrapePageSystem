package com.youyou.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CharacterEncodingRequest extends HttpServletRequestWrapper {

	private HttpServletRequest request;

	public CharacterEncodingRequest(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
		this.request = request;
	}

	@Override
	public String getParameter(String name) {
		String value = this.request.getParameter(name);
		try {

			if (this.request.getMethod().equalsIgnoreCase("get")) {
				value = new String(value.getBytes("ISO8859-1"), this.request.getCharacterEncoding());
				return value;
			} else {
				return value;
			}
		} catch (Exception ex) {
			RuntimeException exception = new RuntimeException(ex);
			throw exception;
		}

	}

}
