package com.qq.weixin.qy.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qq.weixin.qy.common.CommonUtil;
import com.qq.weixin.qy.pojo.user.UserInfo;
import com.qq.weixin.qy.pojo.user.UserInfoDetail;
import com.qq.weixin.qy.pojo.user.UserSimpleInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 * 用户信息工具类
 * @author zhang.p
 *
 */
public class UserInfoUtil {
	private static Logger log=LoggerFactory.getLogger(UserInfoUtil.class);
	
	//创建成员(POST)
	private final static String createUserUrl="https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=ACCESS_TOKEN";
	//更新成员(POST)
	private final static String updateUserUrl="https://qyapi.weixin.qq.com/cgi-bin/user/update?access_token=ACCESS_TOKEN";
	//删除成员(GET)
	private final static String deleteUserUrl="https://qyapi.weixin.qq.com/cgi-bin/user/delete?access_token=ACCESS_TOKEN&userid=USERID";
	//批量删除成员(POST)
	private final static String deleteUsersUrl="https://qyapi.weixin.qq.com/cgi-bin/user/batchdelete?access_token=ACCESS_TOKEN";
	//获取成员(GET)
	private final static String getUserUrl="https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&userid=USERID";
	//获取部门成员(GET)
	private final static String getDepartmentUsersUrl="https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?access_token=ACCESS_TOKEN&department_id=DEPARTMENT_ID&fetch_child=FETCH_CHILD&status=STATUS";
	//获取部门成员(详情)(GET)
	private final static String getDepartmentUsersDetailUrl="https://qyapi.weixin.qq.com/cgi-bin/user/list?access_token=ACCESS_TOKEN&department_id=DEPARTMENT_ID&fetch_child=FETCH_CHILD&status=STATUS";
	//邀请成员关注(POST)
	private final static String inviteUserAttentionUrl="https://qyapi.weixin.qq.com/cgi-bin/invite/send?access_token=ACCESS_TOKEN";
		
	/**
	 * 创建用户
	 * @param user	用户信息
	 * @param accessToken  调用凭证
	 * @return int  错误码(0为正常，其他参考错误列表)
	 */
	public static int createUser(UserInfo user,String accessToken){
		int errcode=-2;
		
		String requestUrl=createUserUrl.replace("ACCESS_TOKEN", accessToken);
		
		try{			
			JSONObject jsonObject=CommonUtil.httpsRequest(requestUrl,"POST",JSONObject.fromObject(user).toString());
			errcode=jsonObject.getInt("errcode");
		}catch(JSONException e){
			log.error("创建成员失败："+e.toString());
		}
		
		return errcode;
	}
	
	
	/**
	 * 更新用户
	 * @param user   用户信息
	 * @param accessToken   调用凭证
	 * @return  int  错误码(0为正常，其他参考错误列表)
	 */
	public static int updateUser(UserInfo user,String accessToken){
		int errcode=-2;
		
		String requestUrl=updateUserUrl.replace("ACCESS_TOKEN", accessToken);
		
		try{			
			JSONObject jsonObject=CommonUtil.httpsRequest(requestUrl,"POST",JSONObject.fromObject(user).toString());
			errcode=jsonObject.getInt("errcode");
		}catch(JSONException e){
			log.error("更新成员失败："+e.toString());
		}
		
		return errcode;
	}
	
	
	/**
	 * 删除指定用户
	 * @param userid    用户userid
	 * @param accessToken   调用凭证
	 * @return  int  错误码(0为正常，其他参考错误列表) 
	 */
	public static int deleteUser(String userid,String accessToken){
		int errcode=-2;
		
		String requestUrl=deleteUserUrl.replace("ACCESS_TOKEN", accessToken).replace("USERID", userid);
		
		try{			
			JSONObject jsonObject=CommonUtil.httpsRequest(requestUrl,"GET",null);
			errcode=jsonObject.getInt("errcode");
		}catch(JSONException e){
			log.error("删除成员失败："+e.toString());
		}
		
		return errcode;
	}
	
	
	/**
	 * 批量删除成员
	 * @param userIdList   批量删除的用户ID列表
	 * @param accessToken   调用凭证
	 * @return  int  错误码(0为正常，其他参考错误列表)  
	 */
	public static int deleteUsers(List<String> userIdList,String accessToken){
		int errcode=-2;
		
		String requestUrl=deleteUsersUrl.replace("ACCESS_TOKEN", accessToken);
		
		Map<String,List<String>> useridlistMap=new HashMap<String,List<String>>();
		useridlistMap.put("useridlist", userIdList);
		
		try{			
			JSONObject jsonObject=CommonUtil.httpsRequest(requestUrl,"POST",JSONObject.fromObject(useridlistMap).toString());
			errcode=jsonObject.getInt("errcode");
		}catch(JSONException e){
			log.error("批量删除成员失败："+e.toString());
		}
		
		return errcode;
	}
	
	
	/**
	 * 获取成员信息
	 * @param userid  用户userid
	 * @param accessToken   调用凭证
	 * @return UserInfoDetail  用户信息详细
	 */
	public static UserInfoDetail getUserById(String userid,String accessToken){
		UserInfoDetail userDetail=null;
		
		String requestUrl=getUserUrl.replace("ACCESS_TOKEN", accessToken).replace("USERID", userid);
		
		try{			
			JSONObject jsonObject=CommonUtil.httpsRequest(requestUrl,"GET",null);
			//log.info(jsonObject.toString());
			userDetail=(UserInfoDetail)JSONObject.toBean(jsonObject, UserInfoDetail.class);
		}catch(JSONException e){
			log.error("获取成员信息失败："+e.toString());
		}
		
		return userDetail;
	}
	
	
	/**
	 * 获取部门成员
	 * @param department_id  获取的部门id
	 * @param fetch_child  1/0：是否递归获取子部门下面的成员
	 * @param status  0获取全部员工，1获取已关注成员列表，2获取禁用成员列表，4获取未关注成员列表。status可叠加
	 * @param accessToken   调用接口凭证
	 * @return List<UserSimpleInfo> 用户信息列表
	 */
	public static List<UserSimpleInfo> getUsersByDepartmentId(String department_id,String fetch_child,String status,String accessToken){
		List<UserSimpleInfo> userSimpleInfoList=new ArrayList<UserSimpleInfo>();
		
		String requestUrl=getDepartmentUsersUrl.replace("ACCESS_TOKEN", accessToken).replace("DEPARTMENT_ID", department_id).replace("FETCH_CHILD", fetch_child).replace("STATUS", status);
		
		try{			
			JSONObject jsonObject=CommonUtil.httpsRequest(requestUrl,"GET",null);
			//log.info(jsonObject.toString());
			JSONArray userListJson=jsonObject.getJSONArray("userlist");
			
			
			for(int i=0;i<userListJson.size();i++){
				UserSimpleInfo userInfo=(UserSimpleInfo)JSONObject.toBean((JSONObject) userListJson.get(i),UserSimpleInfo.class);
				userSimpleInfoList.add(userInfo);
			}
			
		}catch(JSONException e){
			log.error("获取部门成员失败："+e.toString());
		}
		
		return userSimpleInfoList;
	}
	
	
	/**
	 * 获取部门成员(详情)
	 * @param department_id  获取的部门id
	 * @param fetch_child	1/0：是否递归获取子部门下面的成员
	 * @param status	0获取全部员工，1获取已关注成员列表，2获取禁用成员列表，4获取未关注成员列表。status可叠加
	 * @param accessToken  调用接口凭证
	 * @return  List<UserInfoDetail>用户详细信息列表
	 */
	public static List<UserInfoDetail> getUsersDetailByDepartmentId(String department_id,String fetch_child,String status,String accessToken){
		List<UserInfoDetail> userSimpleInfoList=new ArrayList<UserInfoDetail>();
		
		String requestUrl=getDepartmentUsersDetailUrl.replace("ACCESS_TOKEN", accessToken).replace("DEPARTMENT_ID", department_id).replace("FETCH_CHILD", fetch_child).replace("STATUS", status);
		
		try{			
			JSONObject jsonObject=CommonUtil.httpsRequest(requestUrl,"GET",null);
			log.info(jsonObject.toString());
			JSONArray userListJson=jsonObject.getJSONArray("userlist");
			
			
			for(int i=0;i<userListJson.size();i++){
				UserInfoDetail userInfo=(UserInfoDetail)JSONObject.toBean((JSONObject) userListJson.get(i),UserInfoDetail.class);
				userSimpleInfoList.add(userInfo);
			}
			
		}catch(JSONException e){
			log.error("获取部门成员失败："+e.toString());
		}
		
		return userSimpleInfoList;
	}
	
	
	/**
	 * 邀请成员关注
	 * @param userid  用户的userid
	 * @param invite_tips  推送到微信上的提示语（只有认证号可以使用）。当使用微信推送时，该字段默认为“请关注XXX企业号”，邮件邀请时，该字段无效。
	 * @param accessToken  调用接口凭证
	 * @return  int  错误码(0为正常，其他参考错误列表) 
	 */
	public static int inviteUserAttention(String userid,String invite_tips,String accessToken){
		int errcode=-2;
		String requestUrl=inviteUserAttentionUrl.replace("ACCESS_TOKEN", accessToken);
		Map<String,String> inviteInfo=new HashMap<String,String>();
		inviteInfo.put("userid", userid);
		inviteInfo.put("invite_tips", invite_tips);
		
		try{			
			JSONObject jsonObject=CommonUtil.httpsRequest(requestUrl,"POST",JSONObject.fromObject(inviteInfo).toString());
			errcode=jsonObject.getInt("errcode");
		}catch(JSONException e){
			log.error("邀请成员关注："+e.toString());
		}
		
		return errcode;
	}
}
