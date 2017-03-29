package com.qq.weixin.qy.pojo.push.message;

/**
 * 推送图片消息
 * @author zhang.p
 *
 */
public class ImageMessage extends BaseMessage {
	private Image image;
	
	
	public Image getImage() {
		return image;
	}


	public void setImage(String media_id) {
		Image image=new Image();
		image.setMedia_id(media_id);
		this.image = image;
	}


	public class Image{
		private String media_id;

		public String getMedia_id() {
			return media_id;
		}

		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}
		
	}
}
