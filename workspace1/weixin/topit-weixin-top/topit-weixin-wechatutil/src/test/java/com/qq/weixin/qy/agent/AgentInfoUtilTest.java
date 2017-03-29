package com.qq.weixin.qy.agent;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qq.weixin.qy.pojo.agent.Agent;

public class AgentInfoUtilTest {
	private static Logger log=LoggerFactory.getLogger(AgentInfoUtilTest.class);

	
	private String accessToken="KJF3QOiGfKLHdlqdFLtVOEM-PBnoa9CQYg6w_Q5RMgpGv2dmIgl9B6-7BVO45hoO";
	//@Test
	public void test() {
				
	}
	
	@Test
	public void getAgentInfoByIdTest(){
		Agent agentinfo=AgentInfoUtil.getAgentInfoById("6",accessToken);
		int a=agentinfo.getAllow_userinfos().size();
		System.out.println("---");
		System.out.println(agentinfo.getDescription()+"\n"+agentinfo.getName()+"\n"+agentinfo.getSquare_logo_url()+"\n"+agentinfo.getRound_logo_url());
	}

	
}
