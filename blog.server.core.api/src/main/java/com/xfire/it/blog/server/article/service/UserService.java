package com.xfire.it.blog.server.article.service;

import com.xfire.it.blog.server.vo.UserVO;;

/**
 * 服务接口
 */
public interface UserService {
	/**
	 * 封装登录逻辑
	 * 如果登录成功就返回登录的成功的用户信息
	 * 否则登录失败就抛出异常
	 * @param name 用户名
	 * @param password 密码
	 * @return 登录成功的用户信息
	 * @throws NameOrPasswordException 登录失败
	 */
	UserVO login(String name, String password)
		throws NameOrPasswordException;
	
	UserVO regist(String name, String nick, 
			String password, String confirm);

	void saveUser(UserVO user);

	boolean checkToken(
			String userId, String token);

}






