package com.xfire.it.blog.server.vo;

import java.io.Serializable;

/**
 * 用户表,有数据库中 cn_user 表对应
 */
public class UserVO implements Serializable{

	private static final long 
		serialVersionUID = -288301177049569372L;

	private String id;
	private String name;
	private String password;
	private String token;
	private String nick;
	private String createTime;
	private String lastupdateTime;
	
	public UserVO() {
	}

	public UserVO(String id, String name, String password, String token, String nick) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.token = token;
		this.nick = nick;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLastupdateTime() {
		return lastupdateTime;
	}

	public void setLastupdateTime(String lastupdateTime) {
		this.lastupdateTime = lastupdateTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastupdateTime == null) ? 0 : lastupdateTime.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nick == null) ? 0 : nick.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
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
		UserVO other = (UserVO) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastupdateTime == null) {
			if (other.lastupdateTime != null)
				return false;
		} else if (!lastupdateTime.equals(other.lastupdateTime))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nick == null) {
			if (other.nick != null)
				return false;
		} else if (!nick.equals(other.nick))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", password=" + password + ", token=" + token + ", nick=" + nick
				+ ", createTime=" + createTime + ", lastupdateTime=" + lastupdateTime + "]";
	}
	
}







