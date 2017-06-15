package com.xfire.it.blog.server.article.dao;

import java.util.List;
import java.util.Map;

import com.xfire.it.blog.server.vo.NoteVO;

public interface NoteDao {
	/**
	 * 根据笔记本id查询笔记列表 
	 * @param notebookId 笔记本ID
	 * @return 笔记列表数据
	 */
	List<Map<String, Object>> 
		findNotesByNotebookId(
		String notebookId);
	
	NoteVO findNoteById(String noteId);
	
	void saveNote(NoteVO note);
	
	//void updateNote(Note note);
	void updateNote(Map<String, Object> note);
	
	void deleteNote(String id);
	
	void deleteNotes(String... id);
	
	int countNotes(List<String> idList);
	
	/**
	 * 多参数统计
	 * params中可以接受: {userId:"12ad2121",
	 * statusId:0}
	 * @param params 传递的参数
	 * @return
	 */
	int countNotesByParams(Map<String, Object> params);

	List<Map<String, Object>> 
		findNoteByParams(
		Map<String, Object> params);
	
	/**
	 * params 包含参数 start 开始行,
	 * 		 size 每页行数
	 * params 参数 notebookId 
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> findNoteByPage(
		Map<String, Object> params);
}








