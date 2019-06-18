package com.gg.www.client.configCenter.vo;

import java.math.BigDecimal;
import java.util.Date;
/** 
* 
* @author 吴彬 的  autoWeb 自动代码 网址  www.wubin9.com 
* @data 2019年06月12日 14:54:57  
* 此文件由 www.wubin9.com 网站的自动代码 autoWeb 自动生成。 
* 可以根据需求随意修改，如果需要帮助，请联系 吴彬 
* 联系方式：QQ 810978593  微信  wubin0830bingo 邮箱 wubin5922@dingtalk.com 
*/  

public class ServerVo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer serverId; // 服务ID
	private String serverName; // 服务名称
	private String waiwangIp; // 外网ip
	private String neiwangIp; // 内网ip
	private String basePath; // 服务基础路径
	private Integer serverPort; // 服务的端口号
	private String serverGroup; // 服务分组
	private String serverStatus; // 服务状态：打开，打开；关闭，关闭；
	private String createTime; // 创建时间
	private String updateTime; // 更新时间
	private String tbStatus; // 状态：正常，正常；删除，删除；

	public Integer getServerId() {
		return serverId;
	}
	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}

	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getWaiwangIp() {
		return waiwangIp;
	}
	public void setWaiwangIp(String waiwangIp) {
		this.waiwangIp = waiwangIp;
	}

	public String getNeiwangIp() {
		return neiwangIp;
	}
	public void setNeiwangIp(String neiwangIp) {
		this.neiwangIp = neiwangIp;
	}

	public String getBasePath() {
		return basePath;
	}
	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public Integer getServerPort() {
		return serverPort;
	}
	public void setServerPort(Integer serverPort) {
		this.serverPort = serverPort;
	}

	public String getServerGroup() {
		return serverGroup;
	}
	public void setServerGroup(String serverGroup) {
		this.serverGroup = serverGroup;
	}

	public String getServerStatus() {
		return serverStatus;
	}
	public void setServerStatus(String serverStatus) {
		this.serverStatus = serverStatus;
	}

	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getTbStatus() {
		return tbStatus;
	}
	public void setTbStatus(String tbStatus) {
		this.tbStatus = tbStatus;
	}

}

