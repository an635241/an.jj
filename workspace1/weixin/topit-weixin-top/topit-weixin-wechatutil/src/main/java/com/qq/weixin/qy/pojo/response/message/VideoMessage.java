package com.qq.weixin.qy.pojo.response.message;
/**
 * 
 * @author zhangpeng
 * @version 1.0
 * @date 2014-7-19
 * @usage 微信响应视频消息
 *
 */
public class VideoMessage extends BaseMessage{
	//视频
	private Video Video;

	public Video getVideo() {
		return Video;
	}

	public void setVideo(String mediaId,String title,String description) {
		Video video=new Video();
		video.setMediaId(mediaId);
		video.setTitle(title);
		video.setDescription(description);
		Video = video;
	}
	public class Video {
		//视频文件id
		private String MediaId;
		//视频消息的标题
		private String Title;
		//视频消息的描述
		private String Description;
		
		public String getMediaId() {
			return MediaId;
		}
		public void setMediaId(String mediaId) {
			MediaId = mediaId;
		}
		public String getTitle() {
			return Title;
		}
		public void setTitle(String title) {
			Title = title;
		}
		public String getDescription() {
			return Description;
		}
		public void setDescription(String description) {
			Description = description;
		}

		
		
	}
	
}
