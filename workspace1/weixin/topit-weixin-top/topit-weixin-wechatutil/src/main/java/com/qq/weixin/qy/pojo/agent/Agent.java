package com.qq.weixin.qy.pojo.agent;

import java.util.List;

/**
 * 应用信息
 * @author zhang.p
 *
 */
public class Agent {
	/**
	 * 企业应用id
	 */
	private String agentid;
	
	/**
	 * 企业应用名称
	 */
	private String name;
	
	/**
	 * 企业应用方形头像
	 */
	private String square_logo_url;
	
	/**
	 * 企业应用圆形头像
	 */
	private String round_logo_url;
	
	/**
	 * 企业应用详情
	 */
	private String description;
	
	/**
	 * 企业应用是否被禁用
	 */
	private int close;
	
	/**
	 * 企业应用可信域名
	 */
	private String redirect_domain;
	
	/**
	 * 企业应用是否打开地理位置上报 0：不上报；1：进入会话上报；2：持续上报
	 */
	private int report_location_flag;
	
	/**
	 * 是否接收用户变更通知。0：不接收；1：接收
	 */
	private int isreportuser;
	
	/**
	 * 是否上报用户进入应用事件。0：不接收；1：接收
	 */
	private int isreportenter;
	
	/**
	 * 允许用户信息列表
	 */
	private List<Allow_userinfos> allow_userinfos;
	
    /**
     * 允许的部门ID类表
     */
    private int[] allow_partys;


	public List<Allow_userinfos> getAllow_userinfos() {
		return allow_userinfos;
	}

	public void setAllow_userinfos(List<Allow_userinfos> allow_userinfos) {
		this.allow_userinfos = allow_userinfos;
	}

	public int[] getAllow_partys() {
		return allow_partys;
	}

	public void setAllow_partys(int[] allow_partys) {
		this.allow_partys = allow_partys;
	}

	public String getAgentid() {
		return agentid;
	}

	public void setAgentid(String agentid) {
		this.agentid = agentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSquare_logo_url() {
		return square_logo_url;
	}

	public void setSquare_logo_url(String square_logo_url) {
		this.square_logo_url = square_logo_url;
	}

	public String getRound_logo_url() {
		return round_logo_url;
	}

	public void setRound_logo_url(String round_logo_url) {
		this.round_logo_url = round_logo_url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getClose() {
		return close;
	}

	public void setClose(int close) {
		this.close = close;
	}

	public String getRedirect_domain() {
		return redirect_domain;
	}

	public void setRedirect_domain(String redirect_domain) {
		this.redirect_domain = redirect_domain;
	}



	public int getReport_location_flag() {
		return report_location_flag;
	}

	public void setReport_location_flag(int report_location_flag) {
		this.report_location_flag = report_location_flag;
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
