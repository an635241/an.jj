package com.qq.weixin.qy.pojo.base;
/**
 * 错误信息
 * @author zhang.p
 *
 */
public class ErrorMsg {
	/**
	 * 返回码
	 */
	private int errcode;
	
	/**
	 * 对返回码的文本描述内容
	 */
	private String errmsg;
	
	/**
	 * 部门管理(部门ID)
	 */
	private int id;
	
	public int getErrcode() {
		return errcode;
	}
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
