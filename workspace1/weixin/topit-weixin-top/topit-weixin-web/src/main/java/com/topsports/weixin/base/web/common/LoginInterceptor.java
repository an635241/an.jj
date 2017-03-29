package com.topsports.weixin.base.web.common;

import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object obj, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub	
		String url=req.getRequestURI();
		String []urls={"/mobile","/login","/resources/","/echoServlet","/serviceechoServlet"};
		for(String urlVaild:urls){
			if(url.contains(urlVaild)){
				return;
			}
		}			
		if(req.getSession().getAttribute("currentPage")!=null&&!req.getSession().getAttribute("currentPage").toString().trim().equals("")){
			String currentPage=req.getSession().getAttribute("currentPage").toString();
			currentPage= new String(currentPage.getBytes("utf-8"),"iso8859-1");
			res.sendRedirect(currentPage);
			req.getSession().removeAttribute("currentPage");
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		String path=req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath();
		String pathurl=req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getRequestURI();
		String url=req.getRequestURI();
		
		String []urls={"/mobile","/login","/resources/","/echoServlet","/serviceechoServlet","libs.baidu.com"};
		for(String urlVaild:urls){
			if(url.contains(urlVaild)){
				return true;
			}
		}		
		if(req.getSession().getAttribute("userIDFromUC")!=null&&!"".equals(req.getSession().getAttribute("userIDFromUC").toString().trim())){
			return true;
		}
		//保存当前页至session
		String param="";
		Map<String, String[]> map = req.getParameterMap();  
		    Set<Entry<String, String[]>> set = map.entrySet();  
		    Iterator<Entry<String, String[]>> it = set.iterator();  
		    while (it.hasNext()) {  
		        Entry<String, String[]> entry = it.next();   
		        for (String value : entry.getValue()) {
		        	param+=entry.getKey()+"="+value+"&";
		        }
		    }
		if(!param.equals("")){
			pathurl=pathurl+"?"+ param.substring(0,param.length()-1);
			
		}
		req.getSession().setAttribute("currentPage", pathurl);	
		res.sendRedirect(path+"/login");
		return false;
	}  
}
