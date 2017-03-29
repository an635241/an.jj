package com.qq.weixin.qy.agent;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qq.weixin.qy.common.CommonUtil;
import com.qq.weixin.qy.pojo.agent.Agent;
import com.qq.weixin.qy.pojo.agent.AgentForUpdate;
import com.qq.weixin.qy.pojo.agent.Allow_userinfos;


/**
 * 应用信息工具类
 * @AUTHOR ZHANG.P
 *
 */
public class AgentInfoUtil {
	private static Logger log=LoggerFactory.getLogger(AgentInfoUtil.class);
	
	//获取应用信息列表(GET)
	private final static String getAgentInfoUrl="https://qyapi.weixin.qq.com/cgi-bin/agent/get?access_token=ACCESS_TOKEN&agentid=AGENTID";
	//设置应用信息地址(POST)
	private final static String updateAgentInfoUrl="https://qyapi.weixin.qq.com/cgi-bin/agent/set?access_token=ACCESS_TOKEN";
	
	/**
	 * @param agentid  应用ID
	 * @param accessToken  调用凭证
	 * @return
	 */
	public static Agent getAgentInfoById(String agentid,String accessToken){
		int errcode=-2;
		Agent agentInfo=new Agent();
		
		String requestUrl=getAgentInfoUrl.replace("ACCESS_TOKEN", accessToken).replace("AGENTID", agentid);
		
		try{			
			JSONObject jsonObject=CommonUtil.httpsRequest(requestUrl,"GET",null);
			log.debug(jsonObject.toString());
			//转化JSON
			agentInfo.setAgentid(jsonObject.getString("agentid"));
			agentInfo.setName(jsonObject.getString("name"));
			agentInfo.setSquare_logo_url(jsonObject.getString("square_logo_url"));
			agentInfo.setRound_logo_url(jsonObject.getString("round_logo_url"));
			agentInfo.setDescription(jsonObject.get("description").toString());
			
			//获取可见用户信息列表
			JSONArray userinfoJsonArray= ((JSONObject)jsonObject.get("allow_userinfos")).getJSONArray("user");
			List<Allow_userinfos> userinfos=new ArrayList<Allow_userinfos>();
			for(int i=0;i<userinfoJsonArray.size();i++){
				Allow_userinfos userinfo=new Allow_userinfos();
				userinfo.setUserid(userinfoJsonArray.getJSONObject(i).getString("userid"));
				userinfo.setStatus(userinfoJsonArray.getJSONObject(i).getInt("status"));
				userinfos.add(userinfo);
			}
			agentInfo.setAllow_userinfos(userinfos);
			
			//获取可见部门列表
			JSONArray departInfoJsonArray=jsonObject.getJSONObject("allow_partys").getJSONArray("partyid");
			int[] departinfos=new int[departInfoJsonArray.size()];
			for(int i=0;i<departInfoJsonArray.size();i++){
				departinfos[i]=departInfoJsonArray.getInt(i);
			}
			
			agentInfo.setAllow_partys(departinfos);
	
			agentInfo.setClose(jsonObject.getInt("close"));
			agentInfo.setRedirect_domain(jsonObject.getString("redirect_domain"));
			agentInfo.setIsreportuser(jsonObject.getInt("isreportuser"));
			agentInfo.setIsreportenter(jsonObject.getInt("isreportenter"));
			
			
			errcode=jsonObject.getInt("errcode");
			
			return agentInfo;
		}catch(JSONException e){
			log.error("获取应用失败："+e.toString()+"errorcode"+errcode);
			
		}
		return null;
	}

	/**
	 * @param agent  应用信息
	 * @param accessToken  调用凭证
	 * @return errorcode 返回错误码
	 */
	public static int updateAgentInf(AgentForUpdate agent,String accessToken){
		int errcode=-2;
		String requestUrl=updateAgentInfoUrl.replace("ACCESS_TOKEN", accessToken);
		try{
			JSONObject jsonObject=CommonUtil.httpsRequest(requestUrl,"POST",JSONObject.fromObject(agent).toString());
			errcode=jsonObject.getInt("errorcode");
		}catch(JSONException e){
			log.error("更新应用信息失败"+e.getMessage());
		}
		return errcode;
	}
}
