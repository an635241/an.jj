package com.topsports.weixin.base.web.common;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.Assert;
import org.apache.commons.lang.StringUtils;

/**
 * Cookie 辅助类
 * 
 * @author jin.jy
 * @date 2016年3月28日 下午6:14:46
 * @version 0.1.0 
 * @copyright yougou.com 
 */
public final class CookieUtils {

	private CookieUtils() {
	}

	/**
	 * 获得cookie
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param name
	 *            cookie name
	 * @return if exist return cookie, else return null.
	 */
	public static Cookie getCookie(HttpServletRequest request, String name) {
		Assert.notNull(request);
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie c : cookies) {
				if (c.getName().equals(name)) {
					return c;
				}
			}
		}
		return null;
	}

	public static String getCookieStr(HttpServletRequest request, String name){
		String cookie = "";
		Assert.notNull(request);
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie c : cookies) {
				if (c.getName().equals(name)) {
					cookie =c.getValue();
				}
			}
		}
		String strRet = "";
		try {
			strRet = java.net.URLDecoder.decode(cookie, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return strRet;
	}
	
	/**
	 * 根据部署路径，将cookie保存在根目录。
	 * 
	 * @param request 
	 * @param response 
	 * @param name 
	 * @param value 
	 * @param expiry 
	 * @return Cookie对象
	 */
	public static Cookie addCookie(HttpServletRequest request, HttpServletResponse response, String name, String value,
			Integer expiry) {
		Cookie cookie = new Cookie(name, value);
		if (expiry != null) {
			cookie.setMaxAge(expiry);
		}
		String ctx = request.getContextPath();
		cookie.setPath(StringUtils.isBlank(ctx) ? "/" : ctx);
		response.addCookie(cookie);
		return cookie;
	}

	/**
	 * 取消cookie
	 * 
	 * @param response 
	 * @param name 
	 * @param domain 
	 */
	public static void cancleCookie(HttpServletResponse response, String name, String domain) {
		Cookie cookie = new Cookie(name, null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		if (!StringUtils.isBlank(domain)) {
			cookie.setDomain(domain);
		}
		response.addCookie(cookie);
	}
}
