package com.qq.weixin.qy.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.util.Collection;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qq.weixin.qy.pojo.base.AccessToken;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;



/**
 * ͨ通用工具类
 * @author zhang.p
 * @date 2014.10.15
 *
 */
public class CommonUtil {

	private static Logger log=LoggerFactory.getLogger(CommonUtil.class);
	
	public final static String corpId="";
	public final static String corpSecret="";
	//凭证获取（GET）
	public final static String token_url="https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=CORPID&corpsecret=CORPSECRET";
	//获取获取微信服务器的ip段
	public final static String callbackip_url="https://qyapi.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN";
	//获取获取微信服务器的ip段
	public final static String jsapi_ticket="https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket?access_token=ACCESS_TOKEN";
	
	/**
	 * 发送https请求
	 */
	public static JSONObject httpsRequest(String requestUrl,String requestMethod,String outputStr){
		JSONObject jsonObject=null;
		HttpsURLConnection conn=null;
		try{
			//创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm={new MyX509TrustManager()};
			SSLContext sslContext=SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			//从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf=sslContext.getSocketFactory();
			
			URL url=new URL(requestUrl);
			 
			conn=(HttpsURLConnection)url.openConnection();
			conn.setSSLSocketFactory(ssf);
			
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			
			//设置请求方式（GET,POST）
			conn.setRequestMethod(requestMethod);
			
			//当outputStr不为null时，向输出流写数据
			if(null!=outputStr){
				OutputStream outputStream=conn.getOutputStream();
				//注意编码格式
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}
			//从输出流读取返回内容
			InputStream inputStream=conn.getInputStream();
			InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"utf-8");
			BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
			String str=null;
			StringBuffer buffer=new StringBuffer();
			while((str=bufferedReader.readLine())!=null){
				buffer.append(str);
			}
			//释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream=null;
			
			jsonObject=JSONObject.fromObject(buffer.toString());
			return jsonObject;
		}catch(ConnectException ce){
			log.error("连接超时:{}",ce);
		}catch(Exception e){
			log.error("https请求一次:{}",e);
		}finally{
			if(conn!=null){
				conn.disconnect();
			}
		}
		return jsonObject;
	}
	
	/**
	 * 获取接口访问凭证
	 */
	public static AccessToken getToken(String corpid,String corpsecret){
		AccessToken accessToken=null;
		String requestUrl=token_url.replace("CORPID", corpid).replace("CORPSECRET", corpsecret);
		//发起GET请求获取凭证
		JSONObject jsonObject=httpsRequest(requestUrl,"GET",null);
		
		if(null!=jsonObject){
			try{
				accessToken=new AccessToken();
				accessToken.setAccess_token(jsonObject.getString("access_token"));
				accessToken.setExpires_in(jsonObject.getInt("expires_in"));
			}catch(JSONException e){
				accessToken=null;
				log.error("获取token失败 errcode:{} errmsg:{}",jsonObject.getString("errorcode"),jsonObject.getString("errmsg"));
			}
		}
		return accessToken;
	}

	/**
	 * 获取微信服务器的ip段
	 */
	@SuppressWarnings("unchecked")
	public static Collection<String> getCallbackIp(String accessToken){
		Collection<String> 	callbackIpList=null;
		
		String requestUrl=callbackip_url.replace("ACCESS_TOKEN", accessToken);
		//发起GET请求获取凭证
		JSONObject jsonObject=httpsRequest(requestUrl,"GET",null);
		
		try{
			callbackIpList=JSONArray.toCollection(jsonObject.getJSONArray("ip_list"));
		}catch(JSONException e){
			log.error("获取微信服务器的IP段失败:"+e.toString());
		}
		return callbackIpList;
	}
	
	/**
	 * 获取jsapi_ticket
	 */
	@SuppressWarnings("unchecked")
	public static String getJsapiTicket(String accessToken){
		String 	ticket="";
		
		String requestUrl=jsapi_ticket.replace("ACCESS_TOKEN", accessToken);
		//发起GET请求获取凭证
		JSONObject jsonObject=httpsRequest(requestUrl,"GET",null);
		
		try{
			ticket=jsonObject.getString("ticket");
		}catch(JSONException e){
			log.error("获取jsapi_ticket失败:"+e.toString());
		}
		return ticket;
	}
}
