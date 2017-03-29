package com.qq.weixin.qy.pojo.response.message;
/**
 * 
 * @author zhangpeng
 * @version 1.0
 * @date 2014-7-19
 * @usage 微信响应音频消息
 *
 */
public class VoiceMessage extends BaseMessage{
	//音频
	private Voice Voice;

	public Voice getVoice() {
		return Voice;
	}

	public void setVoice(String mediaId) {
		Voice voice=new Voice();
		voice.setMediaId(mediaId);
		
		Voice = voice;
	}
	public class Voice {
		//视频文件id
		private String MediaId;

		public String getMediaId() {
			return MediaId;
		}

		public void setMediaId(String mediaId) {
			MediaId = mediaId;
		}
		
		
	}
	
	
}
