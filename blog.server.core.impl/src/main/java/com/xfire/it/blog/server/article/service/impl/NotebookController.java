package com.xfire.it.blog.server.article.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xfire.it.blog.server.util.JsonResult;


@Controller
@RequestMapping("/notebook")
public class NotebookController {
	
	@Autowired
	private NotebookService notebookService; 
	
	@RequestMapping("/list.do")
	@ResponseBody
	public JsonResult<List<Map<String, Object>>>
		listNotebooks(String userId){
		//try {
			List<Map<String, Object>> list=
				notebookService.listNotebooks(userId);
			return new JsonResult<List<Map<String,Object>>>(list);
		//} catch (Exception e) {
		//	e.printStackTrace();
		//	return new JsonResult<List<Map<String,Object>>>(e);
		//}
	}
}








