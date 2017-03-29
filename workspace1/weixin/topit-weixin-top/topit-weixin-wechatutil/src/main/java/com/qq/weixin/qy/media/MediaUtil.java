package com.qq.weixin.qy.media;

import java.io.*;
import java.net.*;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qq.weixin.qy.pojo.media.MediaUploadInfo;

/**
 * 多媒体文件管理
 * @author zhang.p
 *
 */
public class MediaUtil {

	private static Logger log=LoggerFactory.getLogger(MediaUtil.class);
	
	//上传媒体文件地址(POST)
	private static final String uploadMediaUrl="https://qyapi.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	//获取媒体文件地址(GET)
	private static final String getMediaUrl="https://qyapi.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
	
	
	/**
	 * 上传媒体文件
	 * @param fileType  文件类型
	 * @param filePath  文件路径
	 * @param accessToken 调用接口凭证
	 * @return MediaUploadInfo 上传媒体文件返回信息（文件类型，media_id，时间戳）
	 * @care
	 * 上传的媒体文件限制
	 * 图片（image）:1MB，支持JPG格式 
	 * 语音（voice）：2MB，播放长度不超过60s，支持AMR格式
	 * 视频（video）：10MB，支持MP4格式
	 * 普通文件（file）：10MB
	 * 
	 */
	public static MediaUploadInfo uploadMedia(String fileType, String filePath,String accessToken)throws Exception{
	   // 上传文件请求路径
       String requestUrl = uploadMediaUrl.replace("ACCESS_TOKEN", accessToken).replace("TYPE", fileType);

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

		return (MediaUploadInfo)JSONObject.toBean(jsonObj, MediaUploadInfo.class);
	}
	
	
	/**
	 * 下载媒体文件,保存至指定文件路径
	 * @param mediaId    媒体ID
	 * @param filePath	  文件路径	
	 * @param accessToken 调用接口凭证
	 */
	public static void downloadMedia(String mediaId,String filePath,String accessToken){
	   InputStream inputStream = getInputStream(mediaId,accessToken);
	   log.info("结束获取图片！");
       byte[] data = new byte[1024];

       int len = 0;

       FileOutputStream fileOutputStream = null;

       try {

           fileOutputStream = new FileOutputStream(filePath);

           while ((len = inputStream.read(data)) != -1) {

               fileOutputStream.write(data, 0, len);
               log.info(data+"下载图片！");

           }

       } catch (IOException e) {

           e.printStackTrace();

       } finally {

           if (inputStream != null) {

               try {

                   inputStream.close();

               } catch (IOException e) {

                   e.printStackTrace();

               }

           }

           if (fileOutputStream != null) {

               try {

                   fileOutputStream.close();
                   log.info("结束下载图片！");

               } catch (IOException e) {

                   e.printStackTrace();

               }

           }

       }
	}
	
	public static boolean downloadMediaretu(String mediaId,String filePath,String accessToken){
		   InputStream inputStream = getInputStream(mediaId,accessToken);
		   log.info("结束获取图片！");
	       byte[] data = new byte[1024];

	       int len = 0;

	       FileOutputStream fileOutputStream = null;

	       try {

	           fileOutputStream = new FileOutputStream(filePath);

	           while ((len = inputStream.read(data)) != -1) {

	               fileOutputStream.write(data, 0, len);
	               log.info(data+"下载图片！");

	           }

	       } catch (IOException e) {

	           e.printStackTrace();
	           return false;

	       } finally {

	           if (inputStream != null) {

	               try {

	                   inputStream.close();

	               } catch (IOException e) {

	                   e.printStackTrace();
	                   return false;

	               }

	           }

	           if (fileOutputStream != null) {

	               try {

	                   fileOutputStream.close();
	                   log.info("结束下载图片！");

	               } catch (IOException e) {

	                   e.printStackTrace();
	                   return false;

	               }

	           }
	       }
	       return true;
		}
	
	/**
	 * 获取媒体文件流
	 * @param mediaId     媒体ID
	 * @param accessToken 调用接口凭证
	 * @return 文件流
	 */
	public static InputStream getInputStream(String mediaId, String accessToken) {

		log.info("开始获取图片！");
		InputStream is = null;

		String requestUrl = getMediaUrl.replace("ACCESS_TOKEN", accessToken).replace("MEDIA_ID", mediaId);

		try {

			URL urlGet = new URL(requestUrl);

			HttpURLConnection http = (HttpURLConnection) urlGet

			.openConnection();

			http.setRequestMethod("GET"); // 必须是get方式请求

			http.setRequestProperty("Content-Type",

			"application/x-www-form-urlencoded");

			http.setDoOutput(true);

			http.setDoInput(true);

			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒

			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒

			http.connect();

			// 获取文件转化为byte流

			is = http.getInputStream();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return is;

	}
}
