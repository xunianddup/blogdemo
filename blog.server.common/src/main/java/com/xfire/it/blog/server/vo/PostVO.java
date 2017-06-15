package com.xfire.it.blog.server.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PostVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5690351892752953017L;
	private Integer id;
	private String content;
	private String postTime;

	private UserVO user;
	private List<CommentVO> comments = new ArrayList<CommentVO>();

	public PostVO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPostTime() {
		return postTime;
	}

	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	public List<CommentVO> getComments() {
		return comments;
	}

	public void setComments(List<CommentVO> comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostVO other = (PostVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", content=" + content + ", postTime=" + postTime + ", user=" + user + ", comments="
				+ comments + "]";
	}

}
