package com.qq.weixin.qy.pojo.user;


/**
 * 用户详细信息
 * @author zhang.p
 *
 */
public class UserInfoDetail {
	//返回码
	private int errcode;
	//返回码的文本描述内容
	private String errmsg;
	//员工UserID
	private String userid;
	//成员名称
	private String name;
	//性别(暂时没有用)
	private String gender;
	//部门id列表
	private int[] department;
	//职位信息
	private String position;
	//手机号码
	private String mobile;
	//邮箱
	private String email;
	//微信号
	private String weixinid;
	//头像url。注：如果要获取小图将url最后的"/0"改成"/64"即可
	private String avatar;
	//关注状态: 1=已关注，2=已冻结，4=未关注
	private String status;
	//扩展属性
	private ExtattrInfo extattr;
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
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
	public int[] getDepartment() {
		return department;
	}
	public void setDepartment(int[] department) {
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
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ExtattrInfo getExtattr() {
		return extattr;
	}
	public void setExtattr(ExtattrInfo extattr) {
		this.extattr = extattr;
	}
			
}
