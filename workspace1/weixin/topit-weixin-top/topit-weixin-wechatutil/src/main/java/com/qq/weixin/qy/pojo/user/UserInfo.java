package com.qq.weixin.qy.pojo.user;

import java.util.List;

/**
 * 员工信息
 * @author zhang.p
 *
 */
public class UserInfo {
	
	/**
	 * 员工UserID。对应管理端的帐号，企业内必须唯一。长度为1~64个字符
	 */
	private String userid;
	
	/**
	 * 成员名称。长度为1~64个字符
	 */
	private String name;
	
	/**
	 * 成员所属部门id列表。注意，每个部门的直属员工上限为1000个
	 */
	private List<Integer> department;
	
	/**
	 * 职位信息。长度为0~64个字符
	 */
	private String position;
	
	/**
	 * 手机号码。企业内必须唯一，mobile/weixinid/email三者不能同时为空
	 */
	private String mobile;
	
	/**
	 * 邮箱。长度为0~64个字符。企业内必须唯一
	 */
	private String email;
	
	/**
	 * 微信号。企业内必须唯一。（注意：是微信号，不是微信的名字）
	 */
	private String weixinid;
	
	/**
	 * 扩展属性。扩展属性需要在WEB管理端创建后才生效，否则忽略未知属性的赋值
	 */
	private ExtattrInfo extattr;
		
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getDepartment() {
		return department;
	}
	public void setDepartment(List<Integer> department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWeixinid() {
		return weixinid;
	}
	public void setWeixinid(String weixinid) {
		this.weixinid = weixinid;
	}
	public ExtattrInfo getExtattr() {
		return extattr;
	}
	public void setExtattr(ExtattrInfo extattr) {
		this.extattr = extattr;
	}
	
}


