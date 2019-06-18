package com.gg.www.client.backUser.vo;

import java.util.ArrayList;
import java.util.List;

public class BackUserVo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userId; // 用户ID
	private String token; // 用户ID
	private String username; // 用户名
	private String nickname; // 昵称
	private String headPortrait; // 正常' COMMENT '状态：正常，正常；删除，删除；
	private String birthday; // 正常' COMMENT '状态：正常，正常；删除，删除；
	private String sex; // 正常' COMMENT '状态：正常，正常；删除，删除；
	private String tbStatus; // 状态：正常，正常；删除，删除；
	private String roleName; // 角色名称
	public List<String> urlPowerList = new ArrayList<>(); // 用户可以访问的URL，用于权限验证

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTbStatus() {
		return tbStatus;
	}

	public void setTbStatus(String tbStatus) {
		this.tbStatus = tbStatus;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}

