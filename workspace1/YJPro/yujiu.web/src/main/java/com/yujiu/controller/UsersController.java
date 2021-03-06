package com.yujiu.controller;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yujiu.base.common.exception.ServiceException;
import com.yujiu.base.web.controller.BaseCurdController;
import com.yujiu.model.Users;
import com.yujiu.service.UsersService;

@Controller
@RequestMapping(value="/users")
public class UsersController extends BaseCurdController<Users> {
	
	@Autowired
	private UsersService usersService;
	@Autowired
	private HttpServletResponse response;

	@Override
	protected BaseCurdController<Users>.CrudInfo init() {
		// TODO Auto-generated method stub
		return new CrudInfo("users/", usersService);
	}
	
//	@RequestMapping(value="/add")
//	@ResponseBody
//	public String add(Users user){
//		response.setHeader("Access-Control-Allow-Origin", "*");
//		user.setInsertTime(new Date());
//		user.setUpdateTime(new Date());
//		try {
//			return usersService.add(user)+"";
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "0";
//	}
//	@RequestMapping(value="/update")
//	@ResponseBody
//	public String update(Users user){
//		response.setHeader("Access-Control-Allow-Origin", "*");
//		user.setUpdateTime(new Date());
//		try {
//			return usersService.modifyById(user)+"";
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "0";
//	}
//	@RequestMapping(value="/remove")
//	@ResponseBody
//	public String remove(Users user){
//		response.setHeader("Access-Control-Allow-Origin", "*");
//		try {
//			return usersService.deleteById(user)+"";
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "0";
//	}

}
