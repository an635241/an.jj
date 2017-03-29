package com.qq.weixin.qy.pojo.agent;

public class AgentForUpdate {

	/**
	 * 企业应用的id
	 */
	private String agentid;
	/**
	 * 企业应用是否打开地理位置上报 0：不上报；1：进入会话上报；2：持续上报
	 */
	private String report_location_flag;
	/**
	 * 企业应用头像的mediaid，通过多媒体接口上传图片获得mediaid，上传后会自动裁剪成方形和圆形两个头像
	 */
	private String logo_mediaid;
	/**
	 * 企业应用名称
	 */
	private String name;
	/**
	 * 企业应用详情
	 */
	private String description;
	/**
	 * 企业应用可信域名
	 */
	private String redirect_domain;
	
	/**
	 * 是否接收用户变更通知。0：不接收；1：接收
	 */
	private int isreportuser;
	
	/**
	 * 是否上报用户进入应用事件。0：不接收；1：接收
	 */
	private int isreportenter;

	public String getAgentid() {
		return agentid;
	}
	public void setAgentid(String agentid) {
		this.agentid = agentid;
	}
	public String getReport_location_flag() {
		return report_location_flag;
	}
	public void setReport_location_flag(String report_location_flag) {
		this.report_location_flag = report_location_flag;
	}
	public String getLogo_mediaid() {
		return logo_mediaid;
	}
	public void setLogo_mediaid(String logo_mediaid) {
		this.logo_mediaid = logo_mediaid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRedirect_domain() {
		return redirect_domain;
	}
	public void setRedirect_domain(String redirect_domain) {
		this.redirect_domain = redirect_domain;
	}
	public int getIsreportuser() {
		return isreportuser;
	}
	public void setIsreportuser(int isreportuser) {
		this.isreportuser = isreportuser;
	}
	public int getIsreportenter() {
		return isreportenter;
	}
	public void setIsreportenter(int isreportenter) {
		this.isreportenter = isreportenter;
	}
	
	
}
