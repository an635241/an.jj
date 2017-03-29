package com.topsports.weixin.service.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qq.weixin.mp.common.MessageUtil;
import com.qq.weixin.mp.pojo.response.message.TextMessage;

/**
 * 格式化返回的内容
 * @author zhang.p
 *
 */
@Service
public class ServiceReturnMessageService {

	/**
	 * 返回文本消息
	 * @param fromUserName
	 * @param toUserName
	 * @param respContent
	 * @return
	 */
	public String  returnTextMessage(String fromUserName,String toUserName,String respContent){
		TextMessage textMessage=new TextMessage();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
		textMessage.setContent(respContent);
		
		return MessageUtil.messageToXml(textMessage);
	}
	
	/**
	 * 返回图片消息
	 * @param fromUserName
	 * @param toUserName
	 * @param mediaId
	 * @return
	 */
//	public String returnImageMessage(String fromUserName,String toUserName,String mediaId){
//		ImageMessage imageMessage=new ImageMessage();
//		imageMessage.setToUserName(fromUserName);
//		imageMessage.setFromUserName(toUserName);
//		imageMessage.setCreateTime(new Date().getTime());
//		imageMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_IMAGE);
//		imageMessage.setImage(mediaId);
//		
//		return MessageUtil.messageToXml(imageMessage);
//	}
	
	/**
	 * 返回音频消息
	 * @param fromUserName
	 * @param toUserName
	 * @param mediaId
	 * @return
	 */
//	public String returnVoiceMessage(String fromUserName,String toUserName,String mediaId){
//		VoiceMessage voiceMessage=new VoiceMessage();
//		voiceMessage.setToUserName(fromUserName);
//		voiceMessage.setFromUserName(toUserName);
//		voiceMessage.setCreateTime(new Date().getTime());
//		voiceMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_VOICE);
//		voiceMessage.setVoice(mediaId);
//		
//		return MessageUtil.messageToXml(voiceMessage);
//	}
	
	/**
	 * 返回视频消息
	 * @param fromUserName
	 * @param toUserName
	 * @param mediaId
	 * @param title
	 * @param description
	 * @return
	 */
//	public String returnVideoMessage(String fromUserName,String toUserName,String mediaId,String title,String description){
//		VideoMessage videoMessage=new VideoMessage();
//		videoMessage.setToUserName(fromUserName);
//		videoMessage.setFromUserName(toUserName);
//		videoMessage.setCreateTime(new Date().getTime());
//		videoMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_VIDEO);
//		videoMessage.setVideo(mediaId,title,description);
//		
//		return MessageUtil.messageToXml(videoMessage);
//	}
	
	/**
	 * 返回单图文消息
	 * @param fromUserName
	 * @param toUserName
	 * @param article
	 * @return
	 */
//	public String returnSingleNewsMessage(String fromUserName,String toUserName,Article article){
//		NewsMessage newsMessage=new NewsMessage();
//		newsMessage.setFromUserName(toUserName);
//		newsMessage.setToUserName(fromUserName);
//		newsMessage.setArticleCount(1);
//		Article[] articles=new Article[1];
//		articles[0]=article;
//		newsMessage.setArticles(articles);
//		newsMessage.setMsgType("news");
//		return MessageUtil.messageToXml(newsMessage);
//	}
	
	/**
	 * 返回多图文消息
	 * @param fromUserName
	 * @param toUserName
	 * @param articles
	 * @return
	 */
//	public String returnMultiNewsMessage(String fromUserName,String toUserName,Article[] articles){
//		NewsMessage newsMessage=new NewsMessage();
//		newsMessage.setFromUserName(toUserName);
//		newsMessage.setToUserName(fromUserName);
//		if(articles==null||articles.length==0){return "";}
//		newsMessage.setArticleCount(articles.length);
//		newsMessage.setMsgType("news");
//		newsMessage.setArticles(articles);
//		return MessageUtil.messageToXml(newsMessage);
//	}
}
