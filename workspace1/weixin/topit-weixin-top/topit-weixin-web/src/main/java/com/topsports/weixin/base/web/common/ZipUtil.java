package com.topsports.weixin.base.web.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

/**
 * @author liu.yf
 *文件打包下载功能工具包
 */
public class ZipUtil {

	/**
	 * 传进文件、文件夹，一次打包成.zip文件
	 * 传输到页面
	 * @param response
	 * @param files 文件
	 * @param zipName 压缩包名字
	 * @throws IOException
	 */
	public static void   downloadZip(HttpServletResponse response,List<File>files,String zipName) throws IOException{
		response.setContentType("application/octet-stream; charset=UTF-8");
		String fileName2 = new String(zipName.getBytes("gb2312"), "iso-8859-1");//设置文件中文名的字符编码
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName2 + ".zip");//定义文件的名字
		response.setHeader("Pragma", "no-cache");//设置属性
		 ZipOutputStream zipOut 
         = new ZipOutputStream(response.getOutputStream());//输出流定义为zip输出流
        zipFile(files, zipOut,"");
         zipOut.close();
	}
	 /**
	  * 测试用方法
	 * @param response
	 * @throws Exception
	 */
	public static void downLoadFiles(HttpServletResponse response)
	            throws Exception {
	        try {
	        	response.setContentType("application/octet-stream; charset=UTF-8");
	    		String fileName2 = new String("你好".getBytes("gb2312"), "iso-8859-1");
	    		response.setHeader("Content-Disposition", "attachment;filename=" + fileName2 + ".zip");
	    		response.setHeader("Pragma", "no-cache");
	            List files = new ArrayList();
	            files.add(new File("D:/你好0"));
	            files.add(new File("D:/text.pdf"));
	           ZipOutputStream zipOut 
	            = new ZipOutputStream(response.getOutputStream());
	           zipFile(files, zipOut,"");
	            zipOut.close();
	        }catch (Exception e) {
	                e.printStackTrace();
	            }
	    }
	    /**
	     * 压缩文件遍历方法
	     * @param files
	     * @param outputStream
	     * @param basePath
	     */
	    public static void zipFile
	            (List files,ZipOutputStream outputStream,String basePath) {
	    	if(files==null){
	    		return;
	    	}
	        int size = files.size();
	        basePath =( basePath.length() == 0 ? "" : basePath + "/" );
	        for(int i = 0; i < size; i++) {
	            File file = (File) files.get(i);
	            zipFile(file, outputStream,basePath+file.getName());
	        }
	    }
	    /**
	     * 测试用方法
	     * @param file
	     * @param response
	     * @return
	     */
	    public static HttpServletResponse downloadZip(File file,HttpServletResponse response) {
	        try {
	        // 以流的形式下载文件。
	        InputStream fis = new BufferedInputStream(new FileInputStream(file.getPath()));
	        byte[] buffer = new byte[fis.available()];
	        fis.read(buffer);
	        fis.close();
	        // 清空response
	        response.reset();
	        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
	        response.setContentType("application/octet-stream");
	        response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
	        toClient.write(buffer);
	        toClient.flush();
	        toClient.close();
	        } catch (IOException ex) {
	        ex.printStackTrace();
	        }finally{
	             try {
	                    File f = new File(file.getPath());
	                    f.delete();
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	        }
	        return response;
	    }
	    /**
	     * 文件、文件夹写入文件流
	     * 本方法是递归方法
	     * @param inputFile 文件
	     * @param ouputStream 输出流
	     * @param base 文件初始路径
	     */
	    public static void zipFile(File inputFile,
	            ZipOutputStream ouputStream,String base) {
	        try {
	            if(inputFile.exists()) {
	                if (inputFile.isFile()) {
	                    FileInputStream IN = new FileInputStream(inputFile);
	                    BufferedInputStream bins = new BufferedInputStream(IN, 512);
	                    //org.apache.tools.zip.ZipEntry
	                    ZipEntry entry = new ZipEntry(base);
	                    ouputStream.putNextEntry(entry);
	                    // 向压缩文件中输出数据   
	                    int nNumber;
	                    byte[] buffer = new byte[512];
	                    while ((nNumber = bins.read(buffer)) != -1) {
	                        ouputStream.write(buffer, 0, nNumber);
	                    }
	                    // 关闭创建的流对象   
	                    bins.close();
	                    IN.close();
	                } else {
	                    try {
	                        File[] files = inputFile.listFiles();
	                        ZipEntry entry = new ZipEntry(base+"/");
		                    ouputStream.putNextEntry(entry);
		                    base =( base.length() == 0 ? "" : base + "/" );
	                        for (int i = 0; i < files.length; i++) {
	                            zipFile(files[i], ouputStream,base+files[i].getName());
	                        }
	                    } catch (Exception e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    /**
	     * 指定文件目录，文件流写入方法
	     * @param list 指定文件目录的文件List
	     * @param response 
	     * @param zipName 压缩包的名字
	     * @throws IOException
	     */
	    public static void downloadZip(List<HashMap<String, Object>> list,HttpServletResponse response,String zipName) throws IOException{
	    	response.setContentType("application/octet-stream; charset=UTF-8");
			String fileName2 = new String(zipName.getBytes("gb2312"), "iso-8859-1");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName2 + ".zip");
			response.setHeader("Pragma", "no-cache");
			 ZipOutputStream zipOut 
	         = new ZipOutputStream(response.getOutputStream());//输出流定义为zip输出流
			 String basePath="";
			 for(HashMap<String, Object>fileList:list){
				 basePath=String.valueOf(fileList.get("basePath"));
				 List<File> files=(List<File>) fileList.get("files");
				 zipFile(files, zipOut,basePath);
			 }
			 zipOut.close();
	    }
}

