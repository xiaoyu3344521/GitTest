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
		//��ȡ�����RUi:ȥ��http:localhost:8080�ⲿ��ʣ�µ�
		 String uri = request.getRequestURI();
		 //UTL:����login.jsp�ǿ��Թ������ʵģ�������URL���������ؿ���
		 if (uri.indexOf("/Login") >= 0) {
		 return true;
		 }
		 //��ȡredis
		 String a = redisTrans.get("id");
		 //�ж�session���Ƿ����û����ݣ�����У��򷵻�true����������ִ��
		 if (a != null) {
		 //return true�������
		 return true;
		 }
		 //return false��������
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
