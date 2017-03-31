package com.yujiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yujiu.base.web.controller.BaseCurdController;
import com.yujiu.model.Test;
import com.yujiu.service.TestService;

@Controller
@RequestMapping(value="/test")
public class TestController extends BaseCurdController<Test> {
	@Autowired
	private TestService testService;

	@Override
	protected CrudInfo init() {
		// TODO Auto-generated method stub
		return new CrudInfo("test/", testService);
	}
	
	@RequestMapping(value="/test")
	public String test(Model model){
		return "test/list";
	}

}
