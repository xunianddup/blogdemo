package com.xfire.it.blog.server.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class AccessFilter 
	implements Filter{
	
	ServletContext servletContext;

	public void init(FilterConfig cfg)
			throws ServletException {
		servletContext = 
				cfg.getServletContext();
	}
	public void destroy() {
		
	}
	public void doFilter(ServletRequest req,
			ServletResponse res, 
			FilterChain chain)
		throws IOException, ServletException {
		HttpServletRequest request=
			(HttpServletRequest)req;
		HttpServletResponse response=
			(HttpServletResponse)res;
		//获取请求的路径
		String path = 
				request.getRequestURI();
		String reg = ".*edit\\.html$";
		//如果是edit.html就检查是否登录
		if(path.matches(reg)){
			checkLogin(request, response, chain);
			return;
		}
		reg = ".*\\.do";
		String account = ".*account.*\\.do";
		//检查 *.do 是否登录 排除 /account路径
		if(path.matches(reg) && 
			! path.matches(account)){
			checkdo(request, response, chain);
			return;
		}
		chain.doFilter(request, response);
	}
	private void checkdo(
			HttpServletRequest request, 
			HttpServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String name = "token";
		String value = null;
		value = getCookie(request, name, value);
		if(! checkToken(value)){
			//返回json字符串
			String json = "{\"state\":1, "
				+ "\"message\":\"必须登录!\"}";
			response.setContentType(
				"application/json;charset=UTF-8");
			response.getWriter().println(json);
			return;
		}
		chain.doFilter(request, response); 
	}
	private void checkLogin(
		HttpServletRequest request, 
		HttpServletResponse response,
		FilterChain chain) 
		throws IOException, ServletException {
		//读取cookie 检查是否登录了
		String name = "token";
		String value = null;
		value = getCookie(request, name, value);
		if(! checkToken(value)){//没有cookie没有登录
			//重定向到 登录页面
			String path="log_in.html";
			response.sendRedirect(path);
			return;
		}
		//有cookie就通过
		chain.doFilter(request, response);
	}
	private boolean checkToken(String value) {
		
		if(value==null){
			return false;
		}
		String[] data=value.split(",");
		if(data.length!=2){
			return false;
		}
		String userId=data[0];
		String token = data[1];
		
		//获取业务层Bean, 检查token
		WebApplicationContext ctx=
			WebApplicationContextUtils
			.getWebApplicationContext(
					servletContext);
		System.out.println("ctx:"+ctx); 
//		UserService service = 
//			ctx.getBean("userService",
//			UserService.class);
//		boolean pass = service.checkToken(
//			userId, token);
//		return pass;
		return true;
	}
	//获取Cookie值
	private String getCookie(HttpServletRequest request, String name, String value) {
		Cookie[] cookies=request.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals(name)){
				value=cookie.getValue();
			}
		}
		return value;
	}
}




