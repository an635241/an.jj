package com.qq.weixin.qy.media;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qq.weixin.qy.pojo.media.MediaUploadInfo;
import com.qq.weixin.qy.pojo.media.PermanentMaterialInfo;

public class PermanentMaterialUtilTest {
	private static Logger log=LoggerFactory.getLogger(PermanentMaterialUtilTest.class);

	
	//@Test
	public void uploadMediaTest(){
		log.info("上传媒体文件");
		try {
			PermanentMaterialInfo mediaInfo=PermanentMaterialUtil.AddMaterial("image", "C:\\Users\\Public\\Pictures\\Sample Pictures\\1.jpg","VadGSdgzJnePlM5X6MSwRXuGD_S9MDSU23bsMNuiln1TWztyRGSAsh3pCeJa-dsk","9");
			log.info("错误码："+mediaInfo.getErrcode());
			log.info("media_id："+mediaInfo.getMedia_id());
			log.info("时间戳："+mediaInfo.getErrmsg());
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}
	//27uRJ5pOMM42Ckd-nK-8R6JEMtIUXro56sStNzh37NTrnlUAhAuuy8oT3-mAKw1WhcyA3llcYWn-e4gX3bZm4OuF8l3Jpo8YFYNpqNTkk0eA
	//@Test
	public void delMaterialTest(){
		int errcode=PermanentMaterialUtil.delMaterial("VadGSdgzJnePlM5X6MSwRXuGD_S9MDSU23bsMNuiln1TWztyRGSAsh3pCeJa-dsk", "9", "27uRJ5pOMM42Ckd-nK-8R6JEMtIUXro56sStNzh37NTqg9E_qiI3sG1D0uRud567gG9Q_G3vX6LQjNm4OcgvoGIaMc1NsHe91QQxs7ABsCgU");
		log.info(String.valueOf(errcode) );
	}
	
	//@Test
	public void batchgetMaterial(){
		String result=PermanentMaterialUtil.batchgetMaterial("VadGSdgzJnePlM5X6MSwRXuGD_S9MDSU23bsMNuiln1TWztyRGSAsh3pCeJa-dsk", "image", 9, 0, 50);
		log.info(result);
	}
}
