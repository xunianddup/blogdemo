package com.xfire.it.blog.server.article.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xfire.it.blog.server.article.dao.NotebookDao;
import com.xfire.it.blog.server.article.dao.UserDao;
import com.xfire.it.blog.server.vo.UserVO;

@Service("notebookService")
public class NotebookServiceImpl 
	implements NotebookService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private NotebookDao notebookDao;
	
	@Autowired 
	private NoteService noteService;
	
	public List<Map<String, Object>> 
		listNotebooks(String userId) 
		throws UserNotFoundException {
		if(userId==null||userId.trim().isEmpty()){
			throw new UserNotFoundException("ID不能空");
		}
		UserVO user = 
			userDao.findUserById(userId);
		if(user==null){
			throw new UserNotFoundException("不存在!");
		}
		return notebookDao.findNotebooksByUserId(userId);
	}
	
	@Transactional
	public void deleteNotebook(String id) {
		//找到这个笔记本的全部笔记
		//逐一删除每个笔记, 然后再删除笔记本
		
		//调用其他的 业务方法实现这个功能
		// 目的是为了研究事务传播
		
		List<Map<String, Object>> notes=
			noteService.listNotes(id);
		//[{id:1, title:"abd"},
		// {id:2, title:"def"}]
		String[] ary=new String[notes.size()];
		for (int i = 0; i < ary.length; i++) {
			ary[i]=(String)
				notes.get(i).get("id");
		}
		//获得全部笔记的ID
		noteService.deleteNotes(ary); 
		//有异常
		notebookDao.deleteNotebook(id);
		//String s = null;
		//s.charAt(0);
	}
}





