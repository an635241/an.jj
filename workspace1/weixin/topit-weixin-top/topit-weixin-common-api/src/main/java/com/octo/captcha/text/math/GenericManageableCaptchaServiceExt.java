package com.octo.captcha.text.math;

import com.octo.captcha.Captcha;
import com.octo.captcha.engine.CaptchaEngine;
import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.multitype.GenericManageableCaptchaService;

public class GenericManageableCaptchaServiceExt extends GenericManageableCaptchaService {

	public GenericManageableCaptchaServiceExt(CaptchaEngine captchaEngine, int minGuarantedStorageDelayInSeconds,
			int maxCaptchaStoreSize) {
		super(captchaEngine, minGuarantedStorageDelayInSeconds, maxCaptchaStoreSize);
	}

	@Override
	public Boolean validateResponseForID(String ID, Object response) throws CaptchaServiceException {
		//logger.debug("validateResponseForID:id=" + ID + "开始验证!");
		this.garbageCollectCaptchaStore();
		if (!store.hasCaptcha(ID)) {
			throw new CaptchaServiceException("验证超时,信息丢失!");
		} else {
			Captcha captcha = store.getCaptcha(ID);
			Boolean valid = store.getCaptcha(ID).validateResponse(response);
			if (valid) {
				store.removeCaptcha(ID);
			}
			return valid;
		}
	}

	/** 
	* 移除session绑定的验证码信息. 
	* Method Name：removeCaptcha . 
	* @param sessionId 
	* the return type：void 
	*/
	public void removeCaptcha(String sessionId) {
		if (sessionId != null && this.store.hasCaptcha(sessionId)) {
			this.store.removeCaptcha(sessionId);
		}
	}
}

