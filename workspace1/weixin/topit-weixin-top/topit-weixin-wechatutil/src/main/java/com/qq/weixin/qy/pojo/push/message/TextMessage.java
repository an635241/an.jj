package com.qq.weixin.qy.pojo.push.message;

/**
 * 推送文本消息
 * @author zhang.p
 *
 */
public class TextMessage extends BaseMessage{
	//文本消息内容
	private Content text;
		
	public Content getText() {
		return text;
	}
	public void setText(String textStr) {
		Content content=new Content();
		content.setContent(textStr);
		this.text = content;
	}



	public class Content{
		private String content;

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
		
	}
}
