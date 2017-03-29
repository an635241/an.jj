package com.topsports.weixin.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.topsports.weixin.base.common.exception.ServiceException;

@Controller
@RequestMapping(value = "/mobile/test")
public class TestControl {
//	@Autowired
//	private StoreSalSummaryService storeSalSummaryService;

	Logger log = Logger.getLogger(TestControl.class);
	
	String ticketTimestamp;
	String ticketNonceStr;
	String url;
	
	@RequestMapping(value="/list")
	public String identificationUpload(HttpServletRequest request,Model model) throws JSONException, IOException{
		HashMap<String, Object> param = new HashMap<String, Object>();
		model.addAttribute("aa", "11"); 
		return "test/list";
	}

}
