package com.xfire.it.blog.server.article.dao;

import com.xfire.it.blog.server.vo.PostVO;

public interface PostDao {
	PostVO findPostById(Integer id);
}
