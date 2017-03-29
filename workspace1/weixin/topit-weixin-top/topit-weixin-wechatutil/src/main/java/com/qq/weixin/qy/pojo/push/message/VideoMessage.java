package com.qq.weixin.qy.pojo.push.message;

/**
 * 推送视频消息
 * @author zhang.p
 *
 */
public class VideoMessage extends BaseMessage{
	public Video video;
	
	
	public Video getVideo() {
		return video;
	}


	public void setVideo(String media_id,String title,String description) {		
		Video video=new Video();
		video.setMedia_id(media_id);
		video.setTitle(title);
		video.setDescription(description);
		
		this.video = video;
	}


	public class Video{
		//视频媒体文件id，可以调用上传媒体文件接口获取
		private String media_id;
		//视频消息的标题(可空)
		private String title;
		//视频消息的描述(可空)
		private String description;
		
		public String getMedia_id() {
			return media_id;
		}
		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
	}
}
