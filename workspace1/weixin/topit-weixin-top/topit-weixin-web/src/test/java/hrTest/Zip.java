//package hrTest;
//
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Enumeration;
//import java.util.zip.Deflater;
//  
//
//
//
//import org.apache.tools.zip.ZipEntry;
//import org.apache.tools.zip.ZipFile;
//import org.apache.tools.zip.ZipOutputStream;
//import org.junit.Test;
//
//
//public class Zip {
//	 private ZipFile         zipFile;
//	    private ZipOutputStream zipOut;     //压缩Zip
//	    private  int            bufSize;    //size of bytes
//	    private byte[]          buf;
//	  
//	    public Zip(){
//	        //要构造函数中去初始化我们的缓冲区  
//	        this.bufSize = 1024*4;
//	        this.buf = new byte[this.bufSize];
//	    }  
//	    
//	 public void unZip(String unZipfile, String destFile) {
//		 System.setProperty("sun.zip.encoding", System.getProperty("sun.jnu.encoding"));// unZipfileName需要解压的zip文件名
//	        FileOutputStream fileOut;
//	        File file;
//	        InputStream inputStream;
//	  
//	        try {
//	            //生成一个zip的文件
//	            this.zipFile = new ZipFile(unZipfile, "GBK");
//	            //遍历zipFile中所有的实体，并把他们解压出来
//	            for (@SuppressWarnings("unchecked")
//	            Enumeration<ZipEntry> entries = this.zipFile.getEntries(); entries
//	                    .hasMoreElements();) {
//	                ZipEntry entry =  entries.nextElement();
//	                //生成他们解压后的一个文件  
//	                file = new File(destFile+File.separator+entry.getName());
//	  
//	                if (entry.isDirectory()) {
//	                    file.mkdirs();
//	                } else {
//	                    // 如果指定文件的目录不存在,则创建之.
//	                    File parent = file.getParentFile();
//	                    if (!parent.exists()) {
//	                        parent.mkdirs();
//	                    }  
//	                    //获取出该压缩实体的输入流 
//	                    inputStream = zipFile.getInputStream(entry);
//	  
//	                    fileOut = new FileOutputStream(file);
//	                    int length = 0;
//	                    //将实体写到本地文件中去
//	                    while ((length = inputStream.read(this.buf)) > 0) {
//	                        fileOut.write(this.buf, 0, length);
//	                    }
//	                    fileOut.close();
//	                    inputStream.close();
//	                }
//	            }
//	            this.zipFile.close();
//	        } catch (IOException ioe) {
//	            ioe.printStackTrace();
//	        }
//	    }
//
//	 @Test
//	  public void main()
//	  {
//	    String zipFilePath = "f:\\ssi.rar";
//
//	    String destDir = "f:\\ssi";
//
//	    new Zip().unZip(zipFilePath,destDir);
//	   // unRarFile(zipFilePath,destDir);
//	  }
//
//}
