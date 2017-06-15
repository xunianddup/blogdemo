package com.xfire.it.blog.server.article.service.impl;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xfire.it.blog.server.util.JsonResult;
import com.xfire.it.blog.server.vo.UserVO;

/**
 * 组件扫描 
 */
@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login.do")
	@ResponseBody
	public JsonResult<UserVO> login(
		String name, String password, 
		HttpServletResponse response){
		//try{
		UserVO user=userService.login(
					name, password);
			String token = 
				UUID.randomUUID().toString();
			user.setToken(token);
			//保存Token到数据库
			userService.saveUser(user);
			//下发Token到客户端浏览器
			Cookie cookie = 
				new Cookie("token",
				user.getId() + ","+token);
			cookie.setPath("/"); 
			response.addCookie(cookie);
			
			Thread t = Thread.currentThread();
			System.out.println( "login.do:"+
					t.getName()+","+t.getId());
			
			return new JsonResult<UserVO>(user);
		//}catch(NameOrPasswordException e){
		///	e.printStackTrace();
		//	return new JsonResult<User>(
		//		e.getField(), e.getMessage(), 
		//		null);
		//}catch(Exception e){
		//	e.printStackTrace();
		//	return new JsonResult<User>(e);
		//}
	}

}





