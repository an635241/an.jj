package com.qq.weixin.qy.common;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import com.qq.weixin.qy.pojo.response.message.Article;
import com.qq.weixin.qy.pojo.response.message.ImageMessage;
import com.qq.weixin.qy.pojo.response.message.NewsMessage;
import com.qq.weixin.qy.pojo.response.message.TextMessage;
import com.qq.weixin.qy.pojo.response.message.VideoMessage;
import com.qq.weixin.qy.pojo.response.message.VoiceMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.core.util.QuickWriter;



/**
 * 
 * @author zhangpeng
 * @version 1.0
 * @date 2014-7-23
 * @usage 消息处理工具此类
 *
 */
public class MessageUtil {

	
	/**
	 * 请求消息类型：文本
	 */
	public static final String REQ_MESSAGE_TYPE_TEXT="text";
	
	/**
	 * 请求消息类型：图片
	 */
	public static final String REQ_MESSAGE_TYPE_IMAGE="image";
	
	/**
	 * 请求消息类型：语音
	 */
	public static final String REQ_MESSAGE_TYPE_VOICE="voice";
	
	/**
	 * 请求消息类型：视频
	 */
	public static final String REQ_MESSAGE_TYPE_VIDEO="video";
	
	/**
	 * 请求消息类型：地理位置
	 */
	public static final String REQ_MESSAGE_TYPE_LOCATION="location";

	
	/**
	 * 请求消息类型：事件推送
	 */
	public static final String REQ_MESSAGE_TYPE_EVENT="event";
	
	/**
	 * 事件类型：subscribe（订阅）
	 */
	public static final String EVENT_TYPE_SUBSCRIBE="subscribe";
	
	/**
	 * 事件类型：unsubscribe（取消订阅）
	 */
	public static final String EVENT_TYPE_UNSUBSCRIBE="unsubscribe";
	
	/**
	 * 事件类型：scan（关注用户扫描带参数二维码）
	 */
	public static final String EVENT_TYPE_SCAN="scan";
	
	/**
	 * 事件类型：LOCATION(上报地理位置事件)
	 */
	public static final String EVENT_TYPE_LOCATION="LOCATION";
	
	/**
	 * 事件类型：CLICK（上报菜单事件）
	 */
	public static final String EVENT_TYPE_CLICK="click";
	
	/**
	 * 事件类型：VIEW（点击菜单跳转链接的事件推送）
	 */
	public static final String EVENT_TYPE_VIEW="VIEW";
	
	/**
	 * 事件类型：scancode_push（扫码推事件的事件推送）
	 */
	public static final String EVENT_TYPE_SCANCODE_PUSH="scancode_push";
	
	/**
	 * 事件类型：scancode_waitmsg(扫码推事件且弹出“消息接收中”提示框的事件推送)
	 */
	public static final String EVENT_TYPE_SCANCODE_WAITMSG="scancode_waitmsg";
	
	/**
	 * 事件类型：pic_sysphoto(弹出系统拍照发图的事件推送)
	 */
	public static final String EVENT_TYPE_PIC_SYSPHOTO="pic_sysphoto";
	
	/**
	 * 事件类型：pic_photo_or_album(弹出拍照或者相册发图的事件推送)
	 */
	public static final String EVENT_TYPE_PIC_PHOTO_OR_ALBUM="pic_photo_or_album";
	
	/**
	 * 事件类型：pic_weixin(弹出微信相册发图器的事件推送)
	 */
	public static final String EVENT_TYPE_PIC_WEIXIN="pic_weixin";
	
	/**
	 * 事件类型：location_select(弹出地理位置选择器的事件推送)
	 */
	public static final String EVENT_TYPE_LOCATION_SELECT="location_select";
	
	/**
	 * 事件类型：enter_agent(弹出地理位置选择器的事件推送)
	 */
	public static final String EVENT_TYPE_ENTER_AGENT="enter_agent";
	
	/**
	 * 事件类型：batch_job_result(异步任务完成事件推送)
	 */
	public static final String EVENT_TYPE_BATCH_JOB_RESULT="batch_job_result";

	
	/**
	 * 响应消息类型：文本
	 */
	public static final String RESP_MESSAGE_TYPE_TEXT="text";
	
	/**
	 * 响应消息类型：图片
	 */
	public static final String RESP_MESSAGE_TYPE_IMAGE="image";
	
	/**
	 * 响应消息类型：语音
	 */
	public static final String RESP_MESSAGE_TYPE_VOICE="voice";
	
	/**
	 * 响应消息类型：视频
	 */
	public static final String RESP_MESSAGE_TYPE_VIDEO="video";
	
	/**
	 * 响应消息类型：图文
	 */
	public static final String RESP_MESSAGE_TYPE_NEWS="news";
	
	/**
	 * 解析微信发来的请求（XML）
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,String> parseXml(HttpServletRequest request) throws Exception{
		//将解析结果存放在map里面
		Map<String,String> map=new HashMap<String,String>();
		//从request中取得输入流
		InputStream inputStream=request.getInputStream();
		//读取输入流
		SAXReader reader=new SAXReader();
		Document document=reader.read(inputStream);
		//得到XML根元素
		Element root=document.getRootElement();
		//得到根元素所有子节点
		List<Element> elementList=root.elements();
		
		//遍历所有子节点
		for(Element e:elementList){
			map.put(e.getName(), e.getText());
		}
		//释放资源
		inputStream.close();
		inputStream=null;
		
		return map;
	}

	/**
	 * 扩展xstream使其支持CDATA
	 */
	private static XStream xstream=new XStream(new XppDriver(){
		@Override
		public HierarchicalStreamWriter createWriter(Writer out){
			return new PrettyPrintWriter(out){
				//对所有XML节点都增加CDATA标记
				boolean cdata=true;
				
				@SuppressWarnings("rawtypes")
				@Override
				public void startNode(String name,Class clazz){
					if(name.equals("ArticleCount")){cdata=false;}else{cdata=true;}
					super.startNode(name, clazz);
				}
				@Override
				protected void writeText(QuickWriter writer,String text){
					if(cdata){
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					}else{
						writer.write(text);
					}
				}
			};
		}
	});
	@Test
	public void test(){
		TextMessage textMessage=new TextMessage();
		textMessage.setContent("aa");
		textMessage.setCreateTime(1111);
		textMessage.setFromUserName("asfas");
		xstream.alias("xml", textMessage.getClass());
		System.out.println(xstream.toXML(textMessage));
		
	}
	
	/**
	 * 文本消息对象转XML
	 */
	public static String messageToXml(TextMessage textMessage){
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}
	
	/**
	 * 图片消息对象转XML
	 */
	public static String messageToXml(ImageMessage imageMessage){
		xstream.alias("xml", imageMessage.getClass());
		return xstream.toXML(imageMessage);
	}
	
	/**
	 * 语音消息对象转XML
	 */
	public static String messageToXml(VoiceMessage voiceMessage){
		xstream.alias("xml", voiceMessage.getClass());
		return xstream.toXML(voiceMessage);
	}
	
	/**
	 * 视频消息对象转XML
	 */
	public static String messageToXml(VideoMessage videoMessage){
		xstream.alias("xml", videoMessage.getClass());
		return xstream.toXML(videoMessage);
	}
//	
//	/**
//	 * 音乐消息对象转XML
//	 */
//	public static String messageToXml(MusicMessage musicMessage){
//		xstream.alias("xml", musicMessage.getClass());
//		return xstream.toXML(musicMessage);
//	}
//	
	/**
	 * 图文消息对象转XML
	 */
	public static String messageToXml(NewsMessage newsMessage){
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", (new Article()).getClass());
		return xstream.toXML(newsMessage);
	}
}
