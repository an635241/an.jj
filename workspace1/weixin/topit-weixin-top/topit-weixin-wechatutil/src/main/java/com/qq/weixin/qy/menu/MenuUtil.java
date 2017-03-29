package com.qq.weixin.qy.menu;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qq.weixin.qy.common.CommonUtil;
import com.qq.weixin.qy.pojo.menu.Button;
import com.qq.weixin.qy.pojo.menu.Menu;
import com.qq.weixin.qy.pojo.menu.ViewButton;

public class MenuUtil {
	private static Logger log=LoggerFactory.getLogger(MenuUtil.class);
	
	//创建菜单(POST)
	private static final String createMenuUrl="https://qyapi.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN&agentid=AGENTID";
	//删除菜单(GET)
	private static final String deleteMenuUrl="https://qyapi.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN&agentid=AGENTID";
	//获取菜单(GET)
	private static final String getMenuUrl="https://qyapi.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN&agentid=AGENTID";
	
	
	/**
	 * @param accessToken  接口调用凭证
	 * @param agentId	        应用ID
	 * @return	菜单JSON
	 */
	public static JSONObject getMenu(String accessToken,String agentId){
		String menuStr="";
		String requestUrl=getMenuUrl.replace("ACCESS_TOKEN", accessToken).replace("AGENTID", agentId);
		try{			
			JSONObject jsonObject=CommonUtil.httpsRequest(requestUrl,"GET",null);
			menuStr=jsonObject.toString();
			return jsonObject;
		}catch(JSONException e){
			log.error("获取菜单失败"+e.toString());
		}
		return null;
	}
	
	/**
	 * 创建菜单
	 * @param accessToken  接口调用凭证
	 * @param agentId	   应用ID
	 * @param menuJsonStr   
	 * @return  返回码
	 */
	public static int createMenu(String accessToken,String agentId,String menuJsonStr){
		int errcode=-2;
		String requestUrl=createMenuUrl.replace("ACCESS_TOKEN", accessToken).replace("AGENTID", agentId);
		try{			
			JSONObject jsonObject=CommonUtil.httpsRequest(requestUrl,"POST",menuJsonStr);
			errcode=jsonObject.getInt("errcode");
			log.info(jsonObject.toString());
		}catch(JSONException e){
			log.error("创建菜单失败"+e.toString());
		}
		return errcode;
	}
	
	/**
	 * 删除菜单
	 * @param accessToken  调用凭证
	 * @param agentId	应用ID
	 * @return	返回码
	 */
	public static int deleteMenu(String accessToken,String agentId){
		int errcode=-2;
		String requestUrl=deleteMenuUrl.replace("ACCESS_TOKEN", accessToken).replace("AGENTID", agentId);
		try{			
			JSONObject jsonObject=CommonUtil.httpsRequest(requestUrl,"GET",null);
			errcode=jsonObject.getInt("errcode");
		}catch(JSONException e){
			log.error("删除菜单失败"+e.toString());
		}
		return errcode;
	}
	
	
}
