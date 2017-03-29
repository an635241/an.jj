package com.qq.weixin.qy.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 标签管理
 * @author zhang.p
 *
 */
public class TagInfoUtil {
	
	private static Logger log=LoggerFactory.getLogger(TagInfoUtil.class);
	
	//创建标签(POST)
	private static final String createTagUrl="https://qyapi.weixin.qq.com/cgi-bin/tag/create?access_token=ACCESS_TOKEN";
	//更新标签名字(POST)
	private static final String updateTagUrl="https://qyapi.weixin.qq.com/cgi-bin/tag/update?access_token=ACCESS_TOKEN";
	//删除标签(GET)
	private static final String deleteTagUrl="https://qyapi.weixin.qq.com/cgi-bin/tag/delete?access_token=ACCESS_TOKEN&tagid=1";
	//获取标签成员(GET)
	private static final String getTagUserUrl="https://qyapi.weixin.qq.com/cgi-bin/tag/get?access_token=ACCESS_TOKEN&tagid=1";
	//增加标签成员(POST)
	private static final String addTagUserUrl="https://qyapi.weixin.qq.com/cgi-bin/tag/addtagusers?access_token=ACCESS_TOKEN";
	//删除标签成员(POST)
	private static final String deleteTagUserUrl="https://qyapi.weixin.qq.com/cgi-bin/tag/deltagusers?access_token=ACCESS_TOKEN";
	//获取标签列表(GET)
	private static final String getTagListUrl="https://qyapi.weixin.qq.com/cgi-bin/tag/list?access_token=ACCESS_TOKEN";
}
