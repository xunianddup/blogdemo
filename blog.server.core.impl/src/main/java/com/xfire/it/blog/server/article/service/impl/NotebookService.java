package com.xfire.it.blog.server.article.service.impl;

import java.util.List;
import java.util.Map;

public interface NotebookService {
	
	/**
	 * 查询全部的笔记本列表
	 * @param userId 用户ID
	 * @return 这个用户的笔记本列表信息
	 * @throws UserNotFoundException 
	 *   userId 对应的用户不存在!
	 */
	List<Map<String, Object>> 
		listNotebooks(String userId)
		throws UserNotFoundException;
	
	
	void deleteNotebook(String id);

}



