package com.topsports.weixin.common.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qq.weixin.qy.oauth2.Oauth2InfoUtil;

import net.sf.json.JSONObject;

public class Position {
	private static Logger log = LoggerFactory.getLogger(Position.class);
	static String AK="O5HnvGQX2TbMdyVEDWmV061C";
	public static String getposition(String X,String Y){
		try{
		String urlString = "http://api.map.baidu.com/geocoder/v2/?ak="+AK+"&callback=renderReverse&location="+X+","+Y+"&output=json&pois=1&coordtype=wgs84ll";
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		connection.setConnectTimeout(60000);
		connection.setReadTimeout(60000);
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		//OutputStream out = connection.getOutputStream();
		/*if (StringUtils.isNotEmpty(jsonStr)) {
			out.write(jsonStr.getBytes("UTF-8"));
		}*/
		//out.flush();
		//out.close();
		InputStream in = connection.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
		StringBuffer sTotalString = new StringBuffer();
		String sCurrentLine = "";
		while ((sCurrentLine = bufferedReader.readLine()) != null) {
			sTotalString.append(sCurrentLine);
		}
		bufferedReader.close();
		connection.disconnect();
		String retu = sTotalString.substring(sTotalString.indexOf("{"), sTotalString.lastIndexOf("}")+1);
		JSONObject json = JSONObject.fromObject(retu);
		JSONObject result = JSONObject.fromObject(json.get("result"));
		String formatted_address = result.get("formatted_address").toString();
//		System.out.print(formatted_address.toString());
		log.error("formatted_address:" + formatted_address.toString());
		return formatted_address;
		}
		catch(Exception e){
			log.error("formatted_addresserr:" + e.toString());
			e.printStackTrace();
		}
		return null;
	}
    //经纬度计算距离
	public static double Distance(double long1, double lat1, double long2, double lat2) {
		double a, b, R;  
	    R = 6378137; // 地球半径  
	    lat1 = lat1 * Math.PI / 180.0;  
	    lat2 = lat2 * Math.PI / 180.0;  
	    a = lat1 - lat2;  
	    b = (long1 - long2) * Math.PI / 180.0;  
	    double d;  
	    double sa2, sb2;  
	    sa2 = Math.sin(a / 2.0);  
	    sb2 = Math.sin(b / 2.0);  
	    d = 2  
	            * R  
	            * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1)  
	                    * Math.cos(lat2) * sb2 * sb2));  
	    return d;
	}
	
}
