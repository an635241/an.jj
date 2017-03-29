package com.qq.weixin.qy.pojo.user;

/**
 * 部门信息
 * @author zhang.p
 */
public class DepartmentInfo {
	/**
	 * 部门ID。用指定部门ID新建部门，不指定此参数时，则自动生成
	 */
	private int id;
	
	/**
	 * 部门名称。长度限制为1~64个字符
	 */
	private String name;
	
	/**
	 * 父亲部门id。根部门id为1
	 */
	private String parentid;
	
	/**
	 * 在父部门中的次序。从1开始，数字越大排序越靠后
	 */
	private String order;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}

}
