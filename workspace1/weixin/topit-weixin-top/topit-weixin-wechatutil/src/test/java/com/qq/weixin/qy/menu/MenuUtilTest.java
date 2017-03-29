package com.qq.weixin.qy.menu;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qq.weixin.qy.pojo.menu.Button;
import com.qq.weixin.qy.pojo.menu.Menu;
import com.qq.weixin.qy.pojo.menu.ViewButton;


public class MenuUtilTest {
	private static Logger log=LoggerFactory.getLogger(MenuUtilTest.class);
	
	//@Test
	public void test() {
		//fail("Not yet implemented");
	}
	@Test
	public void getMenuTest(){
		JSONObject menuStr= MenuUtil.getMenu( "faOQqqUA6VxNDcBrY2A1WuqaVsSYOZC8GT92decfQ14-ou1hRK_s_FEZvDnlcNcO", "1");
		//Menu menu=(Menu)JSONObject.toBean(menuStr.getJSONObject("menu"), Menu.class);
		//log.info(String.valueOf(menu.getButton().length));
		log.info(menuStr.toString());
	}
	
	//@Test
//	public void createMenuTest(){
//		Menu menu=new Menu();
//		ViewButton btn1=new ViewButton();
//		btn1.setName("hello2");
//		btn1.setType("view");
//		btn1.setUrl("http://www.baidu.com/");
//		
//		menu.setButton(new Button[]{btn1});
//		
//		Applicationmenu menuA=new Applicationmenu();
//		menuA.setName("world2");
//		menuA.setType("view");
//		menuA.setUrl("http://www.baidu.com/");
//		Map<String,Object> map=new HashMap<String,Object>();
//		map.put("button", new Applicationmenu[]{menuA});
//		log.info(JSONObject.fromObject(map).toString());
//		log.info("----------");
//		
//		MenuUtil.createMenu("faOQqqUA6VxNDcBrY2A1WuqaVsSYOZC8GT92decfQ14-ou1hRK_s_FEZvDnlcNcO","1",JSONObject.fromObject(map).toString());
//	}
	
	//@Test
	public void deleteMenuTest(){
		int errcode=MenuUtil.deleteMenu("KJF3QOiGfKLHdlqdFLtVOEM-PBnoa9CQYg6w_Q5RMgpGv2dmIgl9B6-7BVO45hoO", "6");
		log.debug(String.valueOf(errcode));
	}
}
