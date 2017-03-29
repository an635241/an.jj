package com.qq.weixin.qy.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

import com.qq.weixin.qy.pojo.user.*;

public class UserInfoUtilTest {
	private static Logger log=LoggerFactory.getLogger(UserInfoUtilTest.class);
	//@Test
	public void testUserIdList(){
		List<String> userids=new ArrayList<String>();
		userids.add("111");
		userids.add("222");
		Map<String,List<String>> map=new HashMap<String,List<String>>();
		map.put("useridlist",userids);
		JSONObject b=JSONObject.fromObject(map);
		System.out.println(b);
	}
	//@Test
	public void testUserJson(){
		UserInfo user=new UserInfo();
		user.setName("张鹏");
		ArrayList<Integer> a=new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		user.setDepartment(a);
		
		ExtattrInfo c=new ExtattrInfo();
		Attr a1=new Attr("11","22");
		Attr a2=new Attr("11","22");
		List<Attr> cc=new ArrayList<Attr>();
		cc.add(a1);
		cc.add(a2);
		
		c.setAttrs(cc);
		user.setExtattr(c);
		JSONObject b=JSONObject.fromObject(user);
		System.out.println(b);
	}
	
	//@Test
	public void createUserTest(){
		UserInfo userInfo=new UserInfo();
		userInfo.setName("test");
		userInfo.setUserid("zp2");
		userInfo.setMobile("1234");
		List<Integer> departments=new ArrayList<Integer>();
		departments.add(15);
		userInfo.setDepartment(departments);
		int errcode=UserInfoUtil.createUser(userInfo, "KJF3QOiGfKLHdlqdFLtVOEM-PBnoa9CQYg6w_Q5RMgpGv2dmIgl9B6-7BVO45hoO");
		log.info(String.valueOf(errcode));
	}
	
	//@Test
	public void getUserInfoDetailTest(){
		UserInfoDetail userDetail=UserInfoUtil.getUserById("zhang.p", "KJF3QOiGfKLHdlqdFLtVOEM-PBnoa9CQYg6w_Q5RMgpGv2dmIgl9B6-7BVO45hoO");
		
		log.info("错误码："+userDetail.getErrcode());
		log.info("错误信息："+userDetail.getErrmsg());
		log.info("用户姓名："+userDetail.getName());
		log.info("用户代号："+userDetail.getUserid());
		log.info("性别："+userDetail.getGender());
		log.info("部门："+userDetail.getDepartment()[0]);
		log.info("职位："+userDetail.getPosition());
		log.info("电话："+userDetail.getMobile());
		log.info("邮箱："+userDetail.getEmail());
		log.info("微信号："+userDetail.getWeixinid());
		log.info("状态："+userDetail.getStatus());
	}
	
	@Test
	public void getUsersByDepartmentIdTest(){
		log.info("-----------------------获取部门成员信息开始------------------------------");
		
		List<UserInfoDetail> userSimpleInfoList=UserInfoUtil.getUsersDetailByDepartmentId("1", "1", "0", "VadGSdgzJnePlM5X6MSwRXuGD_S9MDSU23bsMNuiln1TWztyRGSAsh3pCeJa-dsk");
		for(int i=0;i<userSimpleInfoList.size();i++){
			System.out.println(userSimpleInfoList.get(i).getName()+"\t"+userSimpleInfoList.get(i).getUserid()+"\t"+userSimpleInfoList.get(i).getStatus());
		}
		
		log.info("-----------------------获取部门成员信息结束------------------------------");
	}
	
	//@Test
	public void getUsersDetailByDepartmentIdTest(){
		log.info("-----------------------获取部门成员详情开始------------------------------");
		
		List<UserInfoDetail> userInfoList=UserInfoUtil.getUsersDetailByDepartmentId("1", "1", "0", "KJF3QOiGfKLHdlqdFLtVOEM-PBnoa9CQYg6w_Q5RMgpGv2dmIgl9B6-7BVO45hoO");
		for(int i=0;i<userInfoList.size();i++){
			log.info("姓名："+userInfoList.get(i).getName()+"  代号："+userInfoList.get(i).getUserid()+" 头像URL："+userInfoList.get(i).getAvatar());
		}
		
		log.info("-----------------------获取部门成员详情结束------------------------------");
	}
	
	//@Test
	public void deleteUsersTest(){
		List<String> useridList=new ArrayList<String>();
		useridList.add("zp");
		useridList.add("zp2");
		int errcode= UserInfoUtil.deleteUsers(useridList,  "KJF3QOiGfKLHdlqdFLtVOEM-PBnoa9CQYg6w_Q5RMgpGv2dmIgl9B6-7BVO45hoO");
		log.info(String.valueOf(errcode));
	}
	
}
