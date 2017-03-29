package com.qq.weixin.qy.pojo.menu;

/**
 * View类型按钮
 * @author zhang.p
 *
 */
public class ViewButton extends Button{
	//菜单的响应动作类型
	private String type;
	//网页链接
	private String url;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
