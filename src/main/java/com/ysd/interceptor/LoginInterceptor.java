package com.ysd.interceptor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import com.ysd.redis.RedisTrans;

public class LoginInterceptor implements HandlerInterceptor{
	@Resource(name = "redis")
	RedisTrans redisTrans;
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//获取请求的RUi:去除http:localhost:8080这部分剩下的
		 String uri = request.getRequestURI();
		 //UTL:除了login.jsp是可以公开访问的，其他的URL都进行拦截控制
		 if (uri.indexOf("/Login") >= 0) {
		 return true;
		 }
		 //获取redis
		 String a = redisTrans.get("id");
		 //判断session中是否有用户数据，如果有，则返回true，继续向下执行
		 if (a != null) {
		 //return true代表放行
		 return true;
		 }
		 //return false代表拦截
		return false;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
   
}
