package com.xfire.it.blog.server.article.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xfire.it.blog.server.article.dao.NoteDao;
import com.xfire.it.blog.server.article.dao.NotebookDao;
import com.xfire.it.blog.server.article.dao.UserDao;
import com.xfire.it.blog.server.vo.NoteVO;
import com.xfire.it.blog.server.vo.NotebookVO;
import com.xfire.it.blog.server.vo.UserVO;


@Service("noteService")
public class NoteServiceImpl 
	implements NoteService{
	
	@Autowired
	private NoteDao noteDao;
	
	@Autowired
	private NotebookDao notebookDao;
	
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public List<Map<String, Object>> 
		listNotes(String notebookId) 
		throws NotebookNotFoundException{
		if(notebookId==null ||
			notebookId.trim().isEmpty()){
			throw new NotebookNotFoundException("笔记本ID空");
		}
		NotebookVO notebook = notebookDao
			.findNotebookById(notebookId);
		if(notebook==null){
			throw new NotebookNotFoundException("没有笔记本");
		}
		return noteDao.findNotesByNotebookId(notebookId);
	}
	
	@Transactional(readOnly=true,
			isolation=Isolation.READ_COMMITTED,
			propagation=Propagation.REQUIRED)
	public NoteVO loadNote(String noteId) {
		if(noteId==null || noteId.trim().isEmpty()){
			throw new IllegalArgumentException("noteId不能空");
		}
		return noteDao.findNoteById(noteId);
	}
	
	@Transactional
	public NoteVO createNote(String notebookId,
			String userId, String title) {
		if(notebookId==null || 
				notebookId.trim().isEmpty()){
			throw new IllegalArgumentException("笔记本ID不能空");
		}
		if(userId==null||userId.trim().isEmpty()){
			throw new IllegalArgumentException("用户ID不能空");
		}
		NotebookVO notebook = notebookDao.findNotebookById(notebookId);
		if(notebook==null){
			throw new NotebookNotFoundException("没有笔记本");
		}
		UserVO user = userDao.findUserById(userId);
		if(user==null){
			throw new UserNotFoundException("没有用户");
		}
		if(title==null || title.trim().isEmpty()){
			title="新建笔记";
		}
		//String s = null;
		//s.charAt(0);
		title = title.trim();
		String id = UUID.randomUUID().toString();
		long time=System.currentTimeMillis();
		NoteVO note=new NoteVO(id, notebookId, userId,
				"1", "1", title, "", time, time);
		noteDao.saveNote(note);
		return note;
	}
	
	@Transactional
	public NoteVO updateNote(String id, 
			String title, String body) {
		if(id==null || id.trim().isEmpty()){
			throw new IllegalArgumentException("id空");
		}
		NoteVO note = noteDao.findNoteById(id);
		if(note==null){
			throw new NoteNotFoundExceprion("没有笔记");
		}
		Map<String, Object> noteInfo =
				new HashMap<String, Object>();
		if(title!=null && 
				!title.trim().isEmpty()){
			title = title.trim();
			if(! note.getTitle().equals(title)){
				note.setTitle(title); 
				noteInfo.put("title", title);
			}
		}
		if(body!=null){
			body = body.trim();
			if(! note.getBody().equals(body)){
				note.setBody(body);
				noteInfo.put("body", body);
			}
		}
		
		if(noteInfo.isEmpty()){
			return note;
		}
		noteInfo.put("id", id);
		noteInfo.put("lastModifyTime", 
				System.currentTimeMillis());
		
		noteDao.updateNote(noteInfo);
		return note;
	}
	
	@Transactional
	public boolean moveNote(
			String id, String notebookId) {
		if(id==null||id.trim().isEmpty()){
			throw new IllegalArgumentException("ID空");
		}
		NoteVO note=noteDao.findNoteById(id);
		if(note==null){
			throw new NoteNotFoundExceprion("没有笔记");
		}
		if(notebookId==null||
			notebookId.trim().isEmpty()){
			throw new IllegalArgumentException("NotebookId null");
		}
		NotebookVO notebook=notebookDao.findNotebookById(notebookId);
		if(notebook==null){
			throw new NotebookNotFoundException("没有笔记本");
		}
		if(notebookId.equals(note.getNotebookId())){
			//没有更改笔记位置,无需更新
			return false;
		}
		Map<String, Object> map = 
			new HashMap<String, Object>(); 
		map.put("id", id);
		map.put("notebookId", notebookId);
		map.put("lastModifyTime", 
			System.currentTimeMillis());
		noteDao.updateNote(map); 
		return true;
	}
	
	@Transactional(
		propagation=Propagation.REQUIRED)
	public void deleteNotes(String... ary) {
		for(String id:ary){
			NoteVO n=noteDao.findNoteById(id);
			if(n==null){
				throw new NoteNotFoundExceprion("Note 没有找到");
			}
			noteDao.deleteNote(id); 
		}
	}
	
	@Transactional
	public void deleteNotes2(String... id) {
		int count = noteDao.countNotes(
				Arrays.asList(id));
		if(count != id.length){
			throw new NoteNotFoundExceprion("笔记ID错误");
		}
		noteDao.deleteNotes(id); 
	}

	public List<Map<String, Object>> 
		findByPageNum(int num, int size) {
		
		int start = num*size;
		Map<String, Object> params =
			new HashMap<String, Object>();
		params.put("start", start);
		params.put("size", size);
		return noteDao.findNoteByPage(params);
	}
}





