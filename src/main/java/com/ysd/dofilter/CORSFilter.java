package com.ysd.dofilter;

import javax.servlet.*;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CORSFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
		httpResponse.addHeader("Access-Control-Allow-Origin", "*");
		httpResponse.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		// 允许跨域的Http方法
		httpResponse.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE");
		filterChain.doFilter(servletRequest, servletResponse);
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
