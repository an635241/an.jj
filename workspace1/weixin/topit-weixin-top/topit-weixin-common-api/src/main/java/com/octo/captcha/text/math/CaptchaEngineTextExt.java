package com.octo.captcha.text.math;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;

import com.octo.captcha.text.TextCaptcha;
import com.octo.captcha.text.math.MathCaptcha;
import com.octo.captcha.text.math.MathCaptchaFactory;

public class CaptchaEngineTextExt extends MathCaptchaFactory {

	/**
	 * 扩展jcaptcha验证
	 * 用来生成四位随机数
	 */
	@Override
	public TextCaptcha getTextCaptcha(Locale locale) {
		//build the challenge;
		//get 2 int
		Random myRamdom = new SecureRandom();
		int one = myRamdom.nextInt(10);
		int two = myRamdom.nextInt(10);
		int three = myRamdom.nextInt(10);
		int four = myRamdom.nextInt(10);
		String code = "" + one + two + three + four;
		TextCaptcha captcha = new  MathCaptcha(code, code, code);
		return captcha;
	}
}

