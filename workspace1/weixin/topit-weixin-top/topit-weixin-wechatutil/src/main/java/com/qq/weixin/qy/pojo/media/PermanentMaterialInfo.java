package com.qq.weixin.qy.pojo.media;

/**
 * 上传永久素材返回信息
 * @author zhang.p
 *
 */
public class PermanentMaterialInfo {

	/**
	 * 错误返回码，0正常
	 */
	private String errcode;
	
	/**
	 * 错误信息
	 */
	private String errmsg;
	
	/**
	 * 素材资源标识ID
	 */
	private String media_id;

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	
}
