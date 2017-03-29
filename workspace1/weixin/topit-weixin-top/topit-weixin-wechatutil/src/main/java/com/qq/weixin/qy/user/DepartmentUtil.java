package com.qq.weixin.qy.user;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.qq.weixin.qy.common.CommonUtil;
import com.qq.weixin.qy.pojo.user.DepartmentInfo;

/**
 * 通讯录部门管理
 * @author zhang.p
 *
 */
public class DepartmentUtil {
	
	private static Logger log=LoggerFactory.getLogger(DepartmentUtil.class);
	
	//创建部门(POST)
	private final static String createDepUrl="https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=ACCESS_TOKEN";
	//更新部门(POST)
	private final static String updateDepUrl="https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token=ACCESS_TOKEN";
	//删除部门(GET)
	private final static String deleteDepUrl="https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token=ACCESS_TOKEN&id=ID";
	//获取部门列表(GET)
	private final static String getDepsUrl="https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=ACCESS_TOKEN&id=ID";
	
	/**
	 * 创建部门
	 * @param depInfo   部门信息
	 * @param accessToken  调用凭证
	 * @return  int  错误码(0为正常，其他参考错误列表)
	 */
	public static int createDepartment(DepartmentInfo depInfo,String accessToken){
		int errcode=-2;
		String requestUrl=createDepUrl.replace("ACCESS_TOKEN", accessToken);
		
		try{			
			JSONObject jsonObject=CommonUtil.httpsRequest(requestUrl,"POST",JSONObject.fromObject(depInfo).toString());
			errcode=jsonObject.getInt("errcode");
		}catch(JSONException e){
			log.error("创建部门失败："+e.toString());
		}
		
		return errcode;
	}
	
	/**
	 * 创建部门返回部门ID
	 * @param depInfo   部门信息
	 * @param accessToken  调用凭证
	 * @return  int  错误码(0为正常，其他参考错误列表)
	 */
	public static JSONObject createDepartmentReturnID(DepartmentInfo depInfo,String accessToken){
		int errcode=-2;
		String requestUrl=createDepUrl.replace("ACCESS_TOKEN", accessToken);
		
		try{			
			JSONObject jsonObject=CommonUtil.httpsRequest(requestUrl,"POST",JSONObject.fromObject(depInfo).toString());
			
			return jsonObject;
		}catch(JSONException e){
			log.error("创建部门失败："+e.toString());
		}
		
		
		return null;
	}
		
	/**
	 * 更新部门
	 * @param depInfo     部门信息(如果非必须的字段未指定，则不更新该字段之前的设置值)
	 * @param accessToken    调用凭证
	 * @return int 错误码(0为正常，其他参考错误列表)
	 */
	public static int updateDepartment(DepartmentInfo depInfo,String accessToken){
		int errcode=-2;
		String requestUrl=updateDepUrl.replace("ACCESS_TOKEN", accessToken);
		
		try{			
			JSONObject jsonObject=CommonUtil.httpsRequest(requestUrl,"POST",JSONObject.fromObject(depInfo).toString());
			errcode=jsonObject.getInt("errcode");
		}catch(JSONException e){
			log.error("创建部门失败："+e.toString());
		}
		
		return errcode;
	}
	
	/**
	 * 删除部门
	 * @param id	部门ID
	 * @param accessToken   调用凭证
	 * @return  int  错误码(0为正常，其他参考错误列表)
	 */
	public static int deleteDepartment(String id,String accessToken){
		int errcode=-2;
		String requestUrl=deleteDepUrl.replace("ACCESS_TOKEN", accessToken).replace("ID", id);
		try{			
			JSONObject jsonObject=CommonUtil.httpsRequest(requestUrl,"GET",null);
			errcode=jsonObject.getInt("errcode");
		}catch(JSONException e){
			log.error("删除部门失败："+e.toString());
		}
		return errcode;
	}
	
	/**
	 * 获取部门列表
	 * @param id   父部门ID
	 * @param accessToken    调用凭证
	 * @return List<DepartmentInfo>部门信息列表
	 */
	public static List<DepartmentInfo> getDepartments(String id,String accessToken){
		int errcode=-2;
		
		List<DepartmentInfo> departments=null;
		String requestUrl=getDepsUrl.replace("ACCESS_TOKEN", accessToken).replace("ID", id);
		try{			
			JSONObject jsonObject=CommonUtil.httpsRequest(requestUrl,"GET",null);
			errcode=jsonObject.getInt("errcode");
			JSONArray deps=jsonObject.getJSONArray("department");
			departments=new ArrayList<DepartmentInfo>();
			for(int i=0;i<deps.size();i++){
				JSONObject depJson=(JSONObject)deps.get(i);
				DepartmentInfo dep=(DepartmentInfo) JSONObject.toBean(depJson, DepartmentInfo.class);
				departments.add(dep);
			}
			
		}catch(JSONException e){
			log.error("删除部门失败："+e.toString());
		}catch(Exception e){
			log.error("删除部门失败："+e.toString());
			log.error(String.valueOf(errcode));
		}
		
		return departments;
	}
}
