package com.qq.weixin.qy.pojo.response.message;
/**
 * 
 * @author zhangpeng
 * @version 1.0
 * @date 2014-12-20
 * @usage 微信响应文本消息
 *
 */
public class TextMessage extends BaseMessage{
	//回复的消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
	
	
}
