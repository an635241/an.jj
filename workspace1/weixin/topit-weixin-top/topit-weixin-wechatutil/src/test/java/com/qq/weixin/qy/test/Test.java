package com.qq.weixin.qy.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

public class Test {
	String AK="O5HnvGQX2TbMdyVEDWmV061C";
	String X="31.187986";
	String Y="121.415932";
	String jsonStr = "{\"expire_seconds\": 604800, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": 25}}}";
	
	//@org.junit.Test
	public void getcode(){
		try{
		String urlString = "http://api.map.baidu.com/geocoder/v2/?ak="+AK+"&callback=renderReverse&location="+X+","+Y+"&output=json&pois=0&coordtype=wgs84ll";
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		connection.setConnectTimeout(2000);
		connection.setReadTimeout(2000);
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
		System.out.print(json.toString());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	@org.junit.Test
	public void test(){
		Convert_BD09_To_GCJ02(31.186087,121.44873);
	}
	public  HashMap<String, Object> Convert_BD09_To_GCJ02( double lat, double lng)
	{
		HashMap<String, Object> hash = new HashMap<String, Object>();
		double x_pi = 3.14159265358979324 * 3000.0 / 180.0;
		double x = lng - 0.0065, y = lat - 0.006;
		double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
		double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
		lng = z * Math.cos(theta);
		lat = z * Math.sin(theta);
		hash.put("lat", lat);
		hash.put("lng", lng);
		return hash;
	} 

}
