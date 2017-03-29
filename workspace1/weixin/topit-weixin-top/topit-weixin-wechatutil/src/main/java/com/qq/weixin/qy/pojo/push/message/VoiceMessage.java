package com.qq.weixin.qy.pojo.push.message;


/**
 * 推送音频信息
 * @author zhang.p
 *
 */
public class VoiceMessage extends BaseMessage{
	private Voice voice;

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(String media_id) {
		Voice voice=new Voice();
		voice.setMedia_id(media_id);
		this.voice = voice;
	}
	
	public class Voice{
		private String media_id;

		public String getMedia_id() {
			return media_id;
		}

		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}
		
	}
}
