package com.qq.weixin.qy.user;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qq.weixin.qy.pojo.user.DepartmentInfo;

public class DepartmentUtilTest {
	private static Logger log=LoggerFactory.getLogger(DepartmentUtilTest.class);
	//@Test
	public void createDepartment(){
		DepartmentInfo dep=new DepartmentInfo();
		dep.setId(16);
		dep.setName("测试");
		dep.setParentid("1");
		int a= DepartmentUtil.createDepartment(dep, "KJF3QOiGfKLHdlqdFLtVOEM-PBnoa9CQYg6w_Q5RMgpGv2dmIgl9B6-7BVO45hoO");
		System.out.println(a);
	}
	//@Test
	public void updateDepartment(){
		
		// 
		DepartmentInfo depInfo=new DepartmentInfo();
		

		depInfo.setId(16);
		depInfo.setName("测试2");
		depInfo.setParentid("1");
		int errcode= DepartmentUtil.updateDepartment(depInfo, "KJF3QOiGfKLHdlqdFLtVOEM-PBnoa9CQYg6w_Q5RMgpGv2dmIgl9B6-7BVO45hoO");
		log.info(String.valueOf(errcode));
	}
	
	//@Test
	public void deleteDepartment(){
		int errcode= DepartmentUtil.deleteDepartment("16", "KJF3QOiGfKLHdlqdFLtVOEM-PBnoa9CQYg6w_Q5RMgpGv2dmIgl9B6-7BVO45hoO");
		log.info(String.valueOf(errcode));
	}
	
	@Test
	public void getDepartment(){
		List<DepartmentInfo> departments = DepartmentUtil.getDepartments("1", "KJF3QOiGfKLHdlqdFLtVOEM-PBnoa9CQYg6w_Q5RMgpGv2dmIgl9B6-7BVO45hoO");
		Iterator<DepartmentInfo> dep= departments.iterator();
		while(dep.hasNext()){
			System.out.println(dep.next().getId()+"   "+dep.next().getName());
		}
	}
}
