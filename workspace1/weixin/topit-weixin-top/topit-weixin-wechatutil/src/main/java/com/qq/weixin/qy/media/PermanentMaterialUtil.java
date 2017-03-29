package com.qq.weixin.qy.media;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.qq.weixin.qy.common.CommonUtil;
import com.qq.weixin.qy.menu.MenuUtil;
import com.qq.weixin.qy.pojo.media.PermanentMaterialInfo;

/**
 * 永久素材
 * @author zhang.p
 *
 */
public class PermanentMaterialUtil {
	private static Logger log=LoggerFactory.getLogger(PermanentMaterialUtil.class);
	
	//上传永久图文素材
	private static final String addMpnewsUrl="https://qyapi.weixin.qq.com/cgi-bin/material/add_mpnews?access_token=ACCESS_TOKEN";
	//上传其他类型永久素材
	private static final String addMaterialUrl="https://qyapi.weixin.qq.com/cgi-bin/material/add_material?agentid=AGENTID&type=TYPE&access_token=ACCESS_TOKEN";
	//通过media_id获取上传的图文消息、图片、语音、文件、视频素材
	private static final String getMaterialUrl="https://qyapi.weixin.qq.com/cgi-bin/material/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID&agentid=AGENTID";
	//通过media_id删除上传的图文消息、图片、语音、文件、视频素材
	private static final String delMaterialUrl="https://qyapi.weixin.qq.com/cgi-bin/material/del?access_token=ACCESS_TOKEN&agentid=AGENTID&media_id=MEDIA_ID";
	//获取永久素材列表
	private static final String batchgetMaterialUrl="https://qyapi.weixin.qq.com/cgi-bin/material/batchget?access_token=ACCESS_TOKEN";
	
	public static PermanentMaterialInfo addMpnews(){
		PermanentMaterialInfo info=new PermanentMaterialInfo();
		
		return info;
	}
	
	/**
	 * 根据media_id删除指定素材
	 * @param accessToken
	 * @param agentid
	 * @param media_id
	 * @return
	 */
	public static int delMaterial(String accessToken,String agentid,String media_id){
		String requestUrl=delMaterialUrl.replace("ACCESS_TOKEN", accessToken).replace("MEDIA_ID", media_id).replace("AGENTID", agentid);
		try{			
			JSONObject jsonObject=CommonUtil.httpsRequest(requestUrl,"GET",null);

			return (int)jsonObject.get("errcode");
		}catch(JSONException e){
			log.error("删除素材失败"+e.toString());
		}
		return -1;
	}
	
	/**
	 * 上传永久媒体文件
	 * @param fileType 媒体文件类型，分别有图片（image）、语音（voice）、视频（video），普通文件(file)
	 * @param filePath 上传文件路径
	 * @param accessToken 调用接口凭证
	 * @param agentid 应用ID
	 * @return
	 * @throws IOException 
	 * @care
	 * 所有文件size必须大于5个字节
	 * 图片（image）:5MB，支持JPG,PNG格式	
	 * 语音（voice）：2MB，播放长度不超过60s，支持AMR格式		
	 * 视频（video）：10MB，支持MP4格式	
	 * 普通文件（file）：10MB	
	 * 整个企业图文消息素材和图片素材数目的上限为5000，其他类型为1000	
	 * 超出素材数量限制返回错误码45028
	 */
	public static PermanentMaterialInfo AddMaterial(String fileType, String filePath,String accessToken,String agentid) throws IOException{
	    
	   String requestUrl = addMaterialUrl.replace("ACCESS_TOKEN", accessToken).replace("TYPE", fileType).replace("AGENTID", agentid);
	    
	   URL url = new URL(requestUrl);

       String result = null;

       File file = new File(filePath);
       
       if (!file.exists() || !file.isFile()) {
           throw new IOException("上传的文件不存在");
       }

       HttpURLConnection con = (HttpURLConnection) url.openConnection();
       con.setRequestMethod("POST"); // 以Post方式提交表单，默认get方式
       con.setDoInput(true);
       con.setDoOutput(true);
       con.setUseCaches(false); // post方式不能使用缓存

       // 设置请求头信息
       con.setRequestProperty("Connection", "Keep-Alive");
       con.setRequestProperty("Charset", "UTF-8");

       // 设置边界
       String BOUNDARY = "----------" + System.currentTimeMillis();

       con.setRequestProperty("Content-Type", "multipart/form-data; boundary="+ BOUNDARY);

       // 请求正文信息

       // 第一部分：
       StringBuilder sb = new StringBuilder();
       sb.append("--"); // 必须多两道线
       sb.append(BOUNDARY);
       sb.append("\r\n");
       sb.append("Content-Disposition: form-data;name=\"file\";filename=\""+ file.getName() + "\"\r\n");
       sb.append("Content-Type:application/octet-stream\r\n\r\n");
       byte[] head = sb.toString().getBytes("utf-8");
       // 获得输出流
       OutputStream out = new DataOutputStream(con.getOutputStream());
       // 输出表头
       out.write(head);
       // 文件正文部分

       // 把文件已流文件的方式 推入到url中
       DataInputStream in = new DataInputStream(new FileInputStream(file));
       int bytes = 0;
       byte[] bufferOut = new byte[1024];
       while ((bytes = in.read(bufferOut)) != -1) {
           out.write(bufferOut, 0, bytes);
       }
       in.close();
       // 结尾部分
       byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
       out.write(foot);
       out.flush();
       out.close();
       StringBuffer buffer = new StringBuffer();
       BufferedReader reader = null;
       try {
           // 定义BufferedReader输入流来读取URL的响应
           reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
           String line = null;
           while ((line = reader.readLine()) != null) {
               buffer.append(line);
           }
           if (result == null) {
               result = buffer.toString();
           }
       } catch (IOException e) {
           System.out.println("发送POST请求出现异常！" + e);
           e.printStackTrace();
           throw new IOException("数据读取异常");
       } finally {
           if (reader != null) {
               reader.close();
           }
       }	    
	    JSONObject jsonObj = JSONObject.fromObject(result);		
		return (PermanentMaterialInfo)JSONObject.toBean(jsonObj, PermanentMaterialInfo.class);
	}

	
	public static void getMaterialByMediaId(){
		
	}
	
	/**
	 * 获取应用素材素材列表
	 * @param accessToken
	 * @param type
	 * @param agentid
	 * @param offset
	 * @param count
	 * @return
	 */
	public static String batchgetMaterial(String accessToken,String type,int agentid,int offset,int count){
		String requestUrl=batchgetMaterialUrl.replace("ACCESS_TOKEN", accessToken);
		Map<String,Object> material=new HashMap<String,Object>();
		material.put("type", type);
		material.put("agentid", agentid);
		material.put("offset", offset);
		material.put("count", count);
		
		try{			
			JSONObject jsonObject=CommonUtil.httpsRequest(requestUrl,"POST",JSONObject.fromObject(material).toString());

			return jsonObject.toString();
		}catch(JSONException e){
			log.error("获取素材列表失败"+e.toString());
		}
		return "";
	}
}
