package com.topsports.hr.weixin.util;

import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.encoding.XMLType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DatahubHelper {
	private static Logger logger=LoggerFactory.getLogger(DatahubHelper.class);
	@Value("#{configProperties['dataHubUrl']}")
	private String dataHubUrl;//="http://172.24.241.79:7001/frdif/n_frdif.asmx";
	@Value("#{configProperties['userId']}")
	private String userId;//="user05"; 
	@Value("#{configProperties['password']}")//用户名
	private String password;//="3495754ECA918A56";			        //密码
	
	private static final String	RETURN_TYPE_NAMESPACE	= "http://www.w3.org/2001/XMLSchema";
	private static final String	RETURN_TYPE_STRING		= "string";
	private static final String	NAMESPACE				= "http://tempurl.org";
	private static final String	METHOD					= "processdata";
	private static final String	USERID					= "userid";
	private static final String	PASSWORD				= "password";
	private static final String	CMDID					= "cmdid";
	private static final String	INPUTPARA				= "inputpara"; 
	private static final String	OUTPUTPARA				= "outputpara";
	private static final String	RETURNSTR				= "rtn";
	private static final String	ERRORMSG				= "errormsg";
	

	/**
	 * 创建所需要的Call对象
	 * @return
	 * @throws Exception
	 */
	public Call crateCallPart() throws Exception {
		org.apache.axis.client.Service service = new org.apache.axis.client.Service();
		Call call = (Call) service.createCall();
		call.setTargetEndpointAddress(new java.net.URL(dataHubUrl));
		call.setUseSOAPAction(true);
		return call;
	}

	/**
	 * 调用远程接口获取返回json字符串
	 * @param method
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	public String getOutputParamentByAxis(String cmid, String inputParam) throws Exception {
		Call call = this.crateCallPart();
		call.setReturnType(new QName(RETURN_TYPE_NAMESPACE, RETURN_TYPE_STRING));
		call.setOperationName(new QName(NAMESPACE, METHOD));
		logger.info("Request Remote Address【" + NAMESPACE + METHOD + "】");
		call.setSOAPActionURI(NAMESPACE + "/" + METHOD);
		QName qout = new QName(NAMESPACE, OUTPUTPARA);
		call.addParameter(new QName(NAMESPACE, USERID), XMLType.XSD_STRING, ParameterMode.IN);
		call.addParameter(new QName(NAMESPACE, PASSWORD), XMLType.XSD_STRING, ParameterMode.IN);
		call.addParameter(new QName(NAMESPACE, CMDID), XMLType.XSD_STRING, ParameterMode.IN);
		call.addParameter(new QName(NAMESPACE, INPUTPARA), XMLType.XSD_STRING, ParameterMode.IN);
		call.addParameter(qout, XMLType.XSD_STRING, ParameterMode.IN);
		call.addParameter(new QName(NAMESPACE, RETURNSTR), XMLType.XSD_INT, ParameterMode.IN);
		call.addParameter(new QName(NAMESPACE, ERRORMSG), XMLType.XSD_STRING, ParameterMode.IN);
		
		String outputParam = "";
		String ret = "0";
		String errorMsg = "";
		Object[] obj = new Object[] { userId, password, cmid, inputParam, outputParam, ret, errorMsg };
		logger.info("请求参数：" + userId + ";" + password + ";" + cmid + ";" + inputParam + ";" + outputParam + ";" + ret
				+ ";" + errorMsg);
		String result = (String) call.invoke(obj);
		Map<QName, String> outparams = call.getOutputParams();
		if (outparams != null) {
			return outparams.get(qout);
		}
		logger.info("return=" + ret + ";errorMsg=" + errorMsg + ";outputParam=" + outputParam);
		logger.info("=========" + result + "=========");
		return result;

	}

}
