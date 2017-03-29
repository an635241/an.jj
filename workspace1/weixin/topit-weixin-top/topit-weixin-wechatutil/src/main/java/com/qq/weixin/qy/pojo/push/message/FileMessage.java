package com.qq.weixin.qy.pojo.push.message;

/**
 * 推送普通文件
 * @author zhang.p
 *
 */
public class FileMessage extends BaseMessage{
	private File file;	
	
	public File getFile() {
		return file;
	}

	public void setFile(String media_id) {
		File file=new File();
		file.setMedia_id(media_id);
		this.file = file;
	}



	public class File{
		//媒体文件id，可以调用上传媒体文件接口获取
		private String media_id;

		public String getMedia_id() {
			return media_id;
		}

		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}
		
	}
}
