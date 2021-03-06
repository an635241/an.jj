package com.yujiu.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yujiu.base.web.controller.BaseCurdController;
import com.yujiu.model.Logs;
import com.yujiu.service.LogsService;

@Controller
@RequestMapping(value="/logs")
public class LogsController extends BaseCurdController<Logs> {
	@Autowired
	private LogsService logsService;
	@Autowired
	private HttpServletResponse response;

	@Override
	protected BaseCurdController<Logs>.CrudInfo init() {
		// TODO Auto-generated method stub
		return new CrudInfo("logs/", logsService);
	}
	
	@RequestMapping(value="/search")
	@ResponseBody
	public List<HashMap<String,Object>> search(Date date0,Date date1,String type,String name,String keyword){
		response.setHeader("Access-Control-Allow-Origin", "*");
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("date0", date0);
		param.put("date1", date1);
		param.put("type", type);
		param.put("name", name);
		param.put("keyword", keyword);
		return logsService.search(param);
	}

}
