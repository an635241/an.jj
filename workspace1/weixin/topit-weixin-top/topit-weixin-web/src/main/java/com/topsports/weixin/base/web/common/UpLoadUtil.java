package com.topsports.weixin.base.web.common;

import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.swing.ImageIcon;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.qq.weixin.qy.media.MediaUtil;

@Service
public class UpLoadUtil implements ImageObserver {

	@Value("#{configProperties['taskdebug']}")
	private String taskdebug;

	@Value("#{configProperties['picService']}")
	private String picService;

	/**
	 * 
	 * @param iconPath 图片路径
	 * @param markwords 图片上添加的文字
	 */
	public void markImageByIcon(String iconpath, String srcImgPath, String markwords) {
		markImageByIcon(iconpath, srcImgPath, srcImgPath, markwords, 0);
	}

	//	public void markImageByIcon(){
	//		markImageByIcon("","C:/apache-tomcat-8.0.24/webapps/attached/image/20150827/20150827114749_132.jpg","C:/apache-tomcat-8.0.24/webapps/attached/image/20150827/20150827114749_132.jpg","流沙不腐",0);
	//	}

	//图片加水印方法
	/**  
	   * 给图片添加水印、可设置水印图片旋转角度  
	   * @param iconPath 水印图片路径  
	   * @param srcImgPath 源图片路径  
	   * @param targerPath 目标图片路径  
	   * @param degree 水印图片旋转角度  
	   */
	public void markImageByIcon(String iconPath, String srcImgPath, String targerPath, String markwords, Integer degree) {
		OutputStream os = null;
		try {
			Image srcImg = ImageIO.read(new File(srcImgPath));
			BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null),
					BufferedImage.TYPE_INT_RGB);
			int width = srcImg.getWidth(null);
			int height = srcImg.getHeight(null);

			// 得到画笔对象   
			// Graphics g= buffImg.getGraphics();   
			Graphics2D g = buffImg.createGraphics();

			// 设置对线段的锯齿状边缘处理   
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

			g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null), Image.SCALE_SMOOTH), 0,
					0, null);

			if (null != degree) {
				// 设置水印旋转   
				g.rotate(Math.toRadians(degree), (double) buffImg.getWidth() / 2, (double) buffImg.getHeight() / 2);
			}

			// 水印图象的路径 水印一般为gif或者png的，这样可设置透明度  
			// iconPath="C:/apache-tomcat-8.0.24/webapps/topit-weixin-web/resources/assets/images/icon64_wx_logo.png";
			ImageIcon imgIcon = new ImageIcon(iconPath);
			int perwordwid = (int) (width * 0.030);

			// 得到Image对象。   
			Image img = imgIcon.getImage();
			float alpha = 1.0f; // 透明度   
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));

			// 表示水印图片的位置   
			//水印图片位置

			//g.drawImage(img, width-markwords.length()*perwordwid-2*perwordwid, (int) (height-perwordwid*1.5), null);
			g.drawImage(img, width - markwords.length() * perwordwid - 3 * perwordwid,
					(int) (height - perwordwid * 2.5), 2 * perwordwid, 2 * perwordwid, this);
			//水印文字大小和位置
			g.setFont(new Font("华文细黑", 0, perwordwid));
			g.drawString(markwords, width - markwords.length() * perwordwid - perwordwid, height - perwordwid);

			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));

			g.dispose();

			os = new FileOutputStream(targerPath);

			// 生成图片   
			ImageIO.write(buffImg, "JPG", os);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != os)
					os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		return false;
	}

	/**
	 * PC端上传单个文件
	 * @param img_upload 文件
	 * @return 单个图片的相对路径
	 * @throws IOException
	 */
	public String uploadImg(MultipartFile img_upload) throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String ymd = sdf.format(new Date());
		String url = "attached/image/" + ymd + "/";
		//区分生产环境和测试环境图片存放路径
		if ("1".equals(taskdebug)) {
			url = "attached/testImage/" + ymd + "/";
		}
		String savePath = picService + url;
		String saveUrl = "/" + url;
		//检查目录 如果不存在 创建目录
		File uploadDir = new File(savePath);
		if (!uploadDir.isDirectory()) {
			uploadDir.mkdirs();
		}
		if (!img_upload.isEmpty()) {
			String fileExt = img_upload.getOriginalFilename()
					.substring(img_upload.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
			sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			int x=(int)(Math.random()*1000);
			String newFileName = sdf.format(new Date()) + "_" + x + "." + fileExt;
			sdf = new SimpleDateFormat("yyyyMMdd");
			saveUrl += newFileName;
			FileUtils.copyInputStreamToFile(img_upload.getInputStream(), new File(savePath, newFileName));
		}
		return saveUrl;
	}

	/**
	 * 微信端上传单个图片
	 * @param mediaId media图片的ID
	 * @param token 本企业号的toke
	 * @return 单个图片的相对路径
	 */
	public String uploadImg(String mediaId, String token) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String ymd = sdf.format(new Date());
		int x=(int)(Math.random()*1000);
		String newFileName = sdf.format(new Date()) + "_" + x + ".png";
		String url = "attached/image/" + ymd + "/";
		//区分生产环境和测试环境图片存放路径
		if ("1".equals(taskdebug)) {
			url = "attached/testImage/" + ymd + "/";
		}
		String savePath = picService + url;
		sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String savePUrl = "/" + url + newFileName;
		File dirFile = new File(savePath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}else{
			File filePic = new File(savePUrl);
			int j=0;
			while(filePic.exists()){		
				savePUrl="/"+url+newFileName+"_"+j;
				filePic = new File(savePUrl);
				j++;
			}
				
		}
		MediaUtil.downloadMedia(mediaId, savePath + newFileName, token);
		return savePUrl;
	}
}
