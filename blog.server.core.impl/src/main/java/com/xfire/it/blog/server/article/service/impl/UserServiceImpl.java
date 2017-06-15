package com.xfire.it.blog.server.article.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xfire.it.blog.server.article.dao.UserDao;
import com.xfire.it.blog.server.util.Utils;
import com.xfire.it.blog.server.vo.UserVO;


/**
 * 业务层实现类
 * @Service 与组件扫描配合, 扫描到
 *   cn.tedu.note.service
 */
@Service("userService")
public class UserServiceImpl
	implements UserService{

	@Autowired //注入的组件ID是 userDao
	private UserDao userDao;
	
	@Transactional
	public UserVO login(String name, 
			String password) 
		throws NameOrPasswordException {
		
		Thread t = Thread.currentThread();
		System.out.println( "UserService:"+
				t.getName()+","+t.getId());
	
		
		System.out.println("Login"); 
		//检查入口参数!!!
		//String s = null;
		//s.charAt(0);
		if(name==null||name.trim().isEmpty()){
			throw new NameOrPasswordException(1, "用户为空");
		}
		if(password==null||password.trim().isEmpty()){
			throw new NameOrPasswordException(2, "密码空");
		}
		name=name.trim();
		password.trim();
		UserVO user=userDao.findUserByName(name);
		if(user==null){
			throw new NameOrPasswordException(1, "木有人");
		}
		
		if(! name.equals(user.getName())){
			throw new NameOrPasswordException(1,"名字错误");
		}
		
		//计算加盐的密码
		//String pwd = DigestUtils.md5Hex(
		//	password+"今天你吃了么?");
		String pwd=Utils.md5salt(password);
		if(pwd.equals(user.getPassword())){
			//登录成功!!
			return user;
		}
		throw new NameOrPasswordException(2, "错误密码");
	}
	
	public UserVO regist(String name, String nick, String password, String confirm) {
		if(name==null){
			throw new IllegalArgumentException("用户名空");
		}
		name = name.trim();
		String reg = "^\\w{3,10}$";
		if(! name.matches(reg)){
			throw new IllegalArgumentException("密码不合适");
		}
		UserVO user = userDao.findUserByName(name);
		if(user!=null){
			throw new NameOrPasswordException(1,"用户已经存在");
		}
		if(password==null){
			throw new IllegalArgumentException("密码空");
		}
		if(confirm==null){
			throw new IllegalArgumentException("确认密码空");
		}
		if(nick==null){
			throw new IllegalArgumentException("昵称空");
		}
		
		return null;
	}
	
	public void saveUser(UserVO user) {
		userDao.updateUser(user); 
	}
	
	public boolean checkToken(
			String userId, String token) {
		UserVO user = userDao.findUserById(userId);
		return token.equals(user.getToken());
	}
}



