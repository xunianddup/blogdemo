package com.xfire.it.blog.server.article.dao;

import com.xfire.it.blog.server.vo.UserVO;

/**
 * 封装用户User对象的CRUD方法 MapperScanner 会扫描这个接口,自动为接口创建 实现类, 并且实例化接口的子类Bean对象
 */
public interface UserDao {
	/**
	 * 将用户对象保存到数据库
	 * 
	 * @param user
	 */
	void saveUser(UserVO user);

	void updateUser(UserVO user);

	UserVO findUserByName(String name);

	UserVO findUserById(String userId);

}
