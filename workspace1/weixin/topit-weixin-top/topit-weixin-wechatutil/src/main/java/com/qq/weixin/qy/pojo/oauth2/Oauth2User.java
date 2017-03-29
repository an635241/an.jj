package com.qq.weixin.qy.pojo.oauth2;

/**
 * Oauth2获取成员信息
 * @author zhang.p
 *
 */
public class Oauth2User {
	
	/**
	 * 成员UserID
	 */
	private String UserId;
	/**
	 * 手机设备号(由微信在安装时随机生成)
	 */
	private String DeviceId;
	
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getDeviceId() {
		return DeviceId;
	}
	public void setDeviceId(String deviceId) {
		DeviceId = deviceId;
	}	
}
