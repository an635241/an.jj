package com.qq.weixin.qy.media;

import static org.junit.Assert.*;

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

import net.sf.json.JSONObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qq.weixin.qy.pojo.media.MediaUploadInfo;
import com.qq.weixin.qy.user.DepartmentUtilTest;

public class MediaUtilTest {
	private static Logger log=LoggerFactory.getLogger(MediaUtilTest.class);
	
	@Before
	public void begin(){
		log.info("-----------------------测试开始------------------------------");
	}

	
	@Test
	public void uploadMediaTest(){
		log.info("上传媒体文件");
		try {
			String mediaInfo=uploadMedia("icon", "D:\\a.jpg","3awMUByBc8xVUkdxP0ntbeCzJLYljEKQlCED5R0Rym6PkOzEcnyh29E_DWl_HImOEbPWDp8UanVM2wG6nUPA_13gvFnZd_pXPqLoJ89cZ14");
//			log.info("文件类型："+mediaInfo.getType());
//			log.info("media_id："+mediaInfo.getMedia_id());
//			log.info("时间戳："+mediaInfo.getCreated_at());
			log.info("结果："+mediaInfo);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	//@Test
	public void downloadFile(){
		log.info("下载媒体文件");
		MediaUtil.downloadMedia("10xo1scNdo5U54a2ALj-oBbVZMrrZIbX_ypdVKDK6ZOfoWqJd3sq1gZvBOPM0ke2K466hXH68K7nx6_iounoxZw", "C:\\Users\\15mins\\Pictures\\3.jpg", "KJF3QOiGfKLHdlqdFLtVOEM-PBnoa9CQYg6w_Q5RMgpGv2dmIgl9B6-7BVO45hoO");
	}
	
	@After
	public void end(){
		log.info("-----------------------测试结束------------------------------");
	}

	public  String uploadMedia(String fileType, String filePath,String accessToken)throws Exception{
		   // 上传文件请求路径
	       String requestUrl = "https://api.weixin.qq.com/shakearound/material/add?access_token=ACCESS_TOKEN&type=TYPE".replace("ACCESS_TOKEN", accessToken).replace("TYPE", fileType);

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

	       con.setRequestProperty("Content-Type", "multipart/form-data; boundary="

	               + BOUNDARY);

	       // 请求正文信息

	       // 第一部分：
	       StringBuilder sb = new StringBuilder();

	       sb.append("--"); // 必须多两道线

	       sb.append(BOUNDARY);

	       sb.append("\r\n");

	       sb.append("Content-Disposition: form-data;name=\"file\";filename=\""

	               + file.getName() + "\"\r\n");

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
	           reader = new BufferedReader(new InputStreamReader(con

	                   .getInputStream()));

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

			return result;
		}
}
