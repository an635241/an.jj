package com.qq.weixin.qy.pojo.response.message;
/**
 * 
 * @author zhangpeng
 * @version 1.0
 * @date 2014-7-19
 * @usage 响应图片消息
 *
 */
public class ImageMessage extends BaseMessage{
	//图片
	private Image Image;

	public Image getImage() {
		return Image;
	}

	public void setImage(String mediaId) {
		Image image=new Image();
		image.setMediaId(mediaId);
		Image = image;
	}
	
	public class Image {
		//图片ID
		private String MediaId;

		public String getMediaId() {
			return MediaId;
		}

		public void setMediaId(String mediaId) {
			MediaId = mediaId;
		}
		
		
	}
	
}
