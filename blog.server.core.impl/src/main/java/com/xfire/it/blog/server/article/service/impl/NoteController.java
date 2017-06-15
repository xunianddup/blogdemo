package com.xfire.it.blog.server.article.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xfire.it.blog.server.util.JsonResult;
import com.xfire.it.blog.server.vo.NoteVO;

@Controller
@RequestMapping("/note")
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	
	@RequestMapping("/list.do")
	@ResponseBody
	public JsonResult<List<Map<String, Object>>>
		listNotes(String notebookId){
		//try {
			List<Map<String, Object>> list=
				noteService.listNotes(notebookId);
			return new JsonResult<List<Map<String,Object>>>(list);
		//} catch (Exception e) {
		//	e.printStackTrace();
		//	return new JsonResult<List<Map<String,Object>>>(e);
		//}
	}
	
	/*
	 * NoteController.java
	 */
	@RequestMapping("/load.do")
	@ResponseBody
	public JsonResult<NoteVO> loadNote(
			String noteId){
		//try {
			NoteVO note=noteService.loadNote(noteId);
			return new JsonResult<NoteVO>(note);
		//} catch (Exception e) {
		//	e.printStackTrace();
		//	return new JsonResult<Note>(e);
		//}
	}
	
	@RequestMapping("/add.do")
	@ResponseBody
	public JsonResult<NoteVO> addNote(
			String notebookId, 
			String userId, String title){
		//try {
			NoteVO note = noteService.createNote(
				notebookId, userId, title);
			return new JsonResult<NoteVO>(note);
		//} catch (Exception e) {
		//	e.printStackTrace();
		//	return new JsonResult<Note>(e);
		//}
	}
	
	@RequestMapping("/save.do")
	@ResponseBody
	public JsonResult<NoteVO> saveNote(
			String id, String title, 
			String body){
		//try {
			NoteVO note = noteService
				.updateNote(id, title, body);
			return new JsonResult<NoteVO>(note);
		//} catch (Exception e) {
		//	e.printStackTrace();
		//	return new JsonResult<Note>(e);
		//}
	}
	
	@RequestMapping("/move.do")
	@ResponseBody
	public JsonResult<Boolean> moveNote(
		String id, String notebookId){
		//try {
			boolean b=noteService.moveNote(
				id, notebookId);
			return new JsonResult<Boolean>(b);
		//} catch (Exception e) {
		//	e.printStackTrace();
		//	return new JsonResult<Boolean>(e);
		//}
	}
}















