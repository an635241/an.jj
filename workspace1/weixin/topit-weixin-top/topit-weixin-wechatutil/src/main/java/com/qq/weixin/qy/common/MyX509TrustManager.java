package com.qq.weixin.qy.common;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * 
 * @author zhang.p
 * @date 2014.10.17
 *
 */
public class MyX509TrustManager implements X509TrustManager{

	public void checkClientTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		
		
	}

	
	public void checkServerTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		
		
	}

	
	public X509Certificate[] getAcceptedIssuers() {
		
		return null;
	}

}
