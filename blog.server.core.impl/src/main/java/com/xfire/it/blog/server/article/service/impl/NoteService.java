package com.xfire.it.blog.server.article.service.impl;

import java.util.List;
import java.util.Map;

import com.xfire.it.blog.server.vo.NoteVO;

public interface NoteService {
	
	List<Map<String, Object>> listNotes(
		String notebookId)
		throws NotebookNotFoundException;
	
	NoteVO loadNote(String id);
	
	NoteVO createNote(String notebookId, 
			String userId, String title);
	
	NoteVO updateNote(String id, 
			String title, String body);
	
	boolean moveNote(String id, 
			String notebookId);
	// deleteNotes("1","2","3")
	// deleteNotes(new String[]{"1","2"})
	void deleteNotes(String... id);

	void deleteNotes2(String... id);
	
	/**
	 * 分页查询方法, num 是页面好: 0 1 2 3 
	 * @param num
	 * @param size 每页数据行数
	 * @return 页面中的数据
	 */
	List<Map<String, Object>> 
		findByPageNum(int num, int size);
}




