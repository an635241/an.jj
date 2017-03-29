package com.qq.weixin.qy.oauth2;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qq.weixin.qy.common.CommonUtil;
import com.qq.weixin.qy.pojo.oauth2.Oauth2User;

/**
 * Oauth2验证接口工具
 * @author zhang.p
 *
 */
public class Oauth2InfoUtil {
	private static Logger log = LoggerFactory.getLogger(Oauth2InfoUtil.class);

	private final static String getOauth2UserUrl = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=ACCESS_TOKEN&code=CODE&agentid=AGENTID";
	
	private final static String getOpenIdUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=wxcc5fa47321e8e49c&secret=52c52f2300822ce8aad6ab0439983fc0&js_code=JSCODE&grant_type=authorization_code";


//	private final static String getOauth2UserUrl="https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=ACCESS_TOKEN&code=CODE";
	/**
	 * @param agentid  应用ID 
	 * @param accessToken  调用凭证
	 * @param code	通过成员授权获取到的code，每次成员授权带上的code将不一样，code只能使用一次，5分钟未被使用自动过期
	 * @return
	 */
	public static Oauth2User getOauth2UserInfo(String agentid, String accessToken, String code) {
		Oauth2User oauth2User = new Oauth2User();

		String requestUrl = getOauth2UserUrl.replace("ACCESS_TOKEN", accessToken).replace("AGENTID", agentid)
				.replace("CODE", code);
		try {
			JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
			log.error("获取OAuth2用户信息jsonObject:" + jsonObject.toString());
			oauth2User.setUserId(jsonObject.getString("UserId"));
			oauth2User.setDeviceId(jsonObject.getString("DeviceId"));
		} catch (JSONException e) {
			log.error("获取OAuth2用户信息:" + e.getMessage());
		}
		return oauth2User;
	}
	public static String getOpenIdInfo(String code) {
		Oauth2User oauth2User = new Oauth2User();

		String requestUrl = getOpenIdUrl.replace("JSCODE", code);
		try {
			JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
			log.error("获取小程序openid:" + jsonObject.toString());
			return jsonObject.get("openid").toString();
		} catch (JSONException e) {
			log.error("获取OAuth2用户信息:" + e.getMessage());
		}
		return null;
	}
}
