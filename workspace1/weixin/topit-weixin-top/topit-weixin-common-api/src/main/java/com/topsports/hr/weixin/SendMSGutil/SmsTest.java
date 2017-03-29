package com.topsports.hr.weixin.SendMSGutil;

import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import net.sf.json.JSONObject;

import org.apache.axis.client.Call;
import org.apache.axis.encoding.XMLType;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.topsports.hr.weixin.util.DatahubHelper;

public class SmsTest {
	private static Logger logger=LoggerFactory.getLogger(SmsTest.class);
	private static final String	POST					= "POST";
	private static final String	UTF_8					= "UTF-8";

	private static final String	RETURN_TYPE_NAMESPACE	= "http://www.w3.org/2001/XMLSchema";
	private static final String	RETURN_TYPE_STRING		= "string";
	private static final String	NAMESPACE				= "http://tempuri.org/";
	private static final String	PARAMETER_NAME			= "Json";

	/**
	 * 创建所需要的Call对象
	 * @return
	 * @throws Exception
	 */
	public static Call crateCallPart() throws Exception {
		org.apache.axis.client.Service service = new org.apache.axis.client.Service();
		Call call = (Call) service.createCall();
		call.setTargetEndpointAddress(new java.net.URL("http://192.168.4.233:801/YDCService.asmx?wsdl"));
		call.setUseSOAPAction(true);
		return call;
	}
	
	public static String getJsonStringByAxis(String method, String jsonStr) throws Exception {
		Call call = crateCallPart();
		call.setReturnType(new QName(RETURN_TYPE_NAMESPACE, RETURN_TYPE_STRING));
		// 第二种设置返回值类型为String的方法  
		call.setOperationName(new QName(NAMESPACE, method));
		System.out.println("Request Remote Address【" + NAMESPACE + method + "】");
		call.setSOAPActionURI(NAMESPACE + method);
		call.addParameter(new QName(NAMESPACE, PARAMETER_NAME), XMLType.XSD_STRING, ParameterMode.IN);
		return (String) call.invoke(new Object[] { jsonStr });

	}
	public static String sMSendServiceByAxis(String jsonStr) {
		String method= "HttpSendSM";
		try {
			//String jsonStr = "{\"sends\":[{\"type\":1,\"content\":\"您的验证码是：11，请在5分钟内完成输入!\",\"mobile\":\"13301710201\",\"remark\":null,\"accNo\":\"D775C31F2FD09847\"}]}";
			logger.error("Request jsonStr【" + jsonStr + "】");
			//特殊处理后的结果
			jsonStr = jsonStr.substring(9, jsonStr.length() - 1);
			logger.error("Request jsonStr特殊处理【" + jsonStr + "】");
			long startTime = System.currentTimeMillis();
			String sTotalString = getJsonStringByAxis(method, jsonStr);
			long totalTime = System.currentTimeMillis() - startTime;
			logger.error("本次请求【" + method + "】共【" + totalTime + "】Response jsonStr【" + sTotalString.toString() + "】");
			//sTotalString = sTotalString.replace("[", "").replace("]", "");//先做特殊处理
			JSONObject jsonObject = JSONObject.fromObject(sTotalString);
			Map<String, Class> classMap = new HashMap<String, Class>();
			classMap.put("DATA", SMSSendResponse.Data.class);
			SMSSendResponse mapping = (SMSSendResponse) JSONObject.toBean(jsonObject, SMSSendResponse.class, classMap);
			if (!ResponseMessageMapping.SUCCESS_FLAG.equals(mapping.getFirstData().getERROR())) {
				String errorMessage = ResponseMessageMapping.ERROR_MAPPING.get(mapping.getFirstData().getERROR());
				if (StringUtils.isBlank(errorMessage)) {
					errorMessage = "远程请求出错啦!";
					return errorMessage;
				}
			}
//			return mapping;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return e.getMessage();
		}
		return "发送成功！";
	}
}
