package com.qq.weixin.qy.common;

import java.util.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.qq.weixin.qy.pojo.base.AccessToken;

public class CommonUtilTest {

	public final static String corpId="wx26bcf78631e93cb4";
	public final static String corpSecret="Wj68ywfMqwwL2o0xagH-8gh6gy4IstTue7ueorkN3wA-YkYRB3nyfbME9eYg5OPA";
	
	@Test
	public void getAccessToken(){
		AccessToken accessToken=CommonUtil.getToken(corpId, corpSecret);
		System.out.println(accessToken.getAccess_token());
	}
 
	//@Test
	public void getCallbackip(){
		Collection<String> callbackIpList=CommonUtil.getCallbackIp("KJF3QOiGfKLHdlqdFLtVOEM-PBnoa9CQYg6w_Q5RMgpGv2dmIgl9B6-7BVO45hoO");
		for(String callbackIp:callbackIpList){
			System.out.println(callbackIp);
		}
	}
}
