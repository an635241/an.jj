package com.qq.weixin.qy.message;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.qq.weixin.qy.pojo.push.message.*;

public class PushMessageUtilTest {

//	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	//@Test
	public void jsonMessageText(){
		//文本消息测试
		TextMessage textMessage=new TextMessage();
		textMessage.setTouser("zhang.p");
		textMessage.setMsgtype("text");
		textMessage.setText("hello world");
		JSONObject textJson=JSONObject.fromObject(textMessage);
		System.out.println(textJson.toString());
		//图片消息测试
		ImageMessage imageMessage=new ImageMessage();
		imageMessage.setTouser("zhang.p");
		imageMessage.setMsgtype("text");
		imageMessage.setImage("hello world");
		JSONObject imageJson=JSONObject.fromObject(imageMessage);
		System.out.println(imageJson.toString());
	}
	
	@Test
	public void pushMessageTest(){
		//推送文本消息测试
		TextMessage textMessage=new TextMessage();
		textMessage.setTouser("zhou.s");
		textMessage.setAgentid("20");
		textMessage.setMsgtype("text");
		textMessage.setText("<a href='http://www.w3school.com.cn'>W3School</a>");
		int errcode=PushMessageUtil.pushMessage(textMessage, "VadGSdgzJnePlM5X6MSwRXuGD_S9MDSU23bsMNuiln1TWztyRGSAsh3pCeJa-dsk");
	
		//推送图片
//		ImageMessage imageMessage=new ImageMessage();
//		imageMessage.setTouser("zhang.p|zhou.s|jin.jy|yu.q");
//		imageMessage.setAgentid("6");
//		imageMessage.setMsgtype("image");
//		imageMessage.setImage("1CNUCMXCjTWsQKjlonfKH6UFWmfz-r-RNQPeYwYfkEzRKw8-Z1U2qK3gblQZ4sSnQ6q_9hS4ooHW-x91K6BBA7A");
//		PushMessageUtil.pushMessage(imageMessage, "KJF3QOiGfKLHdlqdFLtVOEM-PBnoa9CQYg6w_Q5RMgpGv2dmIgl9B6-7BVO45hoO");

		//推送图文消息
//		NewsMessage newsMessage=new NewsMessage();
//		newsMessage.setTouser("zhang.p|zhou.s|jin.jy|yu.q");
//		newsMessage.setAgentid("6");
//		newsMessage.setMsgtype("news");
//		Article article=new Article();
//		article.setTitle("测试");
//		article.setDescription("test");
//		article.setPicurl("http://192.168.6.41/apache_pb.png");
//		article.setUrl("http://qydev.weixin.qq.com/wiki/index.php?title=%E6%B6%88%E6%81%AF%E7%B1%BB%E5%9E%8B%E5%8F%8A%E6%95%B0%E6%8D%AE%E6%A0%BC%E5%BC%8F");
//		newsMessage.setNews(new Article[]{article});
//		PushMessageUtil.pushMessage(newsMessage, "KJF3QOiGfKLHdlqdFLtVOEM-PBnoa9CQYg6w_Q5RMgpGv2dmIgl9B6-7BVO45hoO");
//		
		//推送多图文消息
//		MPNewsMessage mpNewsMessage=new MPNewsMessage();
//		mpNewsMessage.setTouser("zhang.p|zhou.s|jin.jy|yu.q");
//		mpNewsMessage.setAgentid("6");
//		mpNewsMessage.setMsgtype("mpnews");
//		MPArticle mpArticle=new MPArticle();
//		mpArticle.setTitle("test");
//		mpArticle.setAuthor("张鹏");
//		mpArticle.setContent("hello world/微笑");
//		mpArticle.setDigest("测试");
//		mpArticle.setContent_source_url("https://www.baidu.com/");
//		mpArticle.setThumb_media_id("1FYRrEljsXE9dd0Tcbdh0fLTAU7uWeaCyRVyKexTqwfkOpHVhOC75gXjOy0iY57v0h6VYo8j_WBlTTHd2jlm5qA");
//
//		
//		MPArticle mpArticle2=new MPArticle();
//		mpArticle2.setTitle("test2");
//		mpArticle2.setAuthor("张鹏");
//		mpArticle2.setContent("hello world<br/><img src=\"http://192.168.6.41/apache_pb.png\"/>");
//		mpArticle2.setDigest("测试");
//		mpArticle2.setContent_source_url("https://www.baidu.com/");
//		mpArticle2.setThumb_media_id("1FYRrEljsXE9dd0Tcbdh0fLTAU7uWeaCyRVyKexTqwfkOpHVhOC75gXjOy0iY57v0h6VYo8j_WBlTTHd2jlm5qA");
//
//		mpNewsMessage.setMpnews(new MPArticle[]{mpArticle,mpArticle2});
//		PushMessageUtil.pushMessage(mpNewsMessage, "KJF3QOiGfKLHdlqdFLtVOEM-PBnoa9CQYg6w_Q5RMgpGv2dmIgl9B6-7BVO45hoO");
	}
}
