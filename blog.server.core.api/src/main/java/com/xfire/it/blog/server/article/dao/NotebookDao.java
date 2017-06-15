package com.xfire.it.blog.server.article.dao;

import java.util.List;
import java.util.Map;

import com.xfire.it.blog.server.vo.NotebookVO;

/**
 * 笔记本的数据访问接口 
 */
public interface NotebookDao {

	/**
	 * 根据用户ID查询笔记本列表信息
	 * @param userId
	 * @return 笔记本列表信息
	 */
	List<Map<String, Object>> 
		findNotebooksByUserId(String userId);

	NotebookVO findNotebookById(String notebookId);
	
	void deleteNotebook(String id);

}






