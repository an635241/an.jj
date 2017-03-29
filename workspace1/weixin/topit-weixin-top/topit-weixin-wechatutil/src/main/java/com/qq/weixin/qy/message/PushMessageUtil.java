package com.qq.weixin.qy.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.qq.weixin.qy.common.CommonUtil;

public class PushMessageUtil {
	private static Logger log=LoggerFactory.getLogger(PushMessageUtil.class);

	private static final String pushMessageUrl="https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=ACCESS_TOKEN";
	
	public static <T>  int pushMessage(T message,String accessToken){
		int errcode=-2;
		
		String requestUrl=pushMessageUrl.replace("ACCESS_TOKEN", accessToken);
		
		try{	
			log.info(JSONObject.fromObject(message).toString());
			JSONObject jsonObject=CommonUtil.httpsRequest(requestUrl,"POST",JSONObject.fromObject(message).toString());
			errcode=jsonObject.getInt("errcode");
			log.info(jsonObject.toString());
		}catch(JSONException e){
			log.error("推送消息失败："+e.toString());
		}
		
		return errcode;
	}
}
