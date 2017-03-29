package com.qq.weixin.qy.pojo.agent;

/**
 * 应用允许用户列表
 * @author zhang.p
 *
 */
public class Allow_userinfos {
	/**
	 * 链接Employee表的PersonID
	 */
	private String userid;
	/**
	 * 参照接口，1：启动，0：未启用
	 */
	private int status;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
