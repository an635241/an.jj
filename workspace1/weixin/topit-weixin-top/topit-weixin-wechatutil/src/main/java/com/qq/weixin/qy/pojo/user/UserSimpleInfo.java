package com.qq.weixin.qy.pojo.user;

/**
 * 获取部门用户信息
 * @author zhang.p
 *
 */
public class UserSimpleInfo {
	//用户ID
	private String userid;		
	//用户姓名
	private String name;
	//部门ID(暂时为空)
	private int[] department;	      
	
	public int[] getDepartment() {
		return department;
	}
	public void setDepartment(int[] department) {
		this.department = department;
	}
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
}
