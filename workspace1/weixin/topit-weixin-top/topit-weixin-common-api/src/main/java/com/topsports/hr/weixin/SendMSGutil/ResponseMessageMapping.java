package com.topsports.hr.weixin.SendMSGutil;

import java.util.HashMap;
import java.util.Map;

public class ResponseMessageMapping {
	public static final Map<String, String>	ERROR_MAPPING						= new HashMap<String, String>();
	public static final String				SUCCESS_FLAG						= "0";
	public static final String				POINT_BALANCE_RESPONSE_SUCCESS_FLAG	= "100";
	static {
		ERROR_MAPPING.put("10001", "平台代号不能为空");
		ERROR_MAPPING.put("10002", "订单编号不能为空");
		ERROR_MAPPING.put("10003", "会员名称不能为空");
		ERROR_MAPPING.put("10004", "身份证输入有误[位数15/18]");
		ERROR_MAPPING.put("10005", "手机号不能为空或长度超过11位");
		ERROR_MAPPING.put("10006", "性别输入有误[0-2]");
		ERROR_MAPPING.put("10007", "生日不能为空");
		ERROR_MAPPING.put("10008", "卡类型有误（1=66卡2=88卡3=33卡）");
		ERROR_MAPPING.put("10009", "会员卡号有误[长度大于20]");
		ERROR_MAPPING.put("10010", "变更时间不能为空");
		ERROR_MAPPING.put("10011", "变更原因不能为空");
		ERROR_MAPPING.put("100110", "变更原因长度不能超过250");
		ERROR_MAPPING.put("10012", "变更积分不能为空");
		ERROR_MAPPING.put("10013", "KEY不能为空");
		ERROR_MAPPING.put("10014", "解密积分有误");
		ERROR_MAPPING.put("10015", "KEY匹配有误");
		ERROR_MAPPING.put("10016", "优客卡号不能为空");
		ERROR_MAPPING.put("10017", "短信内容不能为空");
		ERROR_MAPPING.put("10018", "短信帐号不能为空");
		ERROR_MAPPING.put("10019", "解密短信帐号有误");
		ERROR_MAPPING.put("10020", "帐号信息不存在");
		ERROR_MAPPING.put("10021", "短信平台发送消息失败");
		ERROR_MAPPING.put("20001", "传入登陆门店不存在");
		ERROR_MAPPING.put("20002", "当前手机号已提交过会员申请单.不可重复申请");
		ERROR_MAPPING.put("20003", "会员卡生成有误");
		ERROR_MAPPING.put("20004", "当前身份证已提交过会员申请单.不可重复申请");
		ERROR_MAPPING.put("20005", "增加积分超过设置最大值");
		ERROR_MAPPING.put("20006", "扣减积分超过设置最大值");
		ERROR_MAPPING.put("20007", "不存在当前会员卡信息");
		ERROR_MAPPING.put("20008", "当前会员卡扣减积分不足");
		ERROR_MAPPING.put("20009", "短信发送失败");//发送短信时余额不足
		ERROR_MAPPING.put("40004", "未知错误");
	}

	private Result							RESULT;

	public static class Result {
		private String	ERRCODE;

		public String getERRCODE() {
			return ERRCODE;
		}

		public void setERRCODE(String errcode) {
			this.ERRCODE = errcode;
		}
	}

	public Result getRESULT() {
		return RESULT;
	}

	public void setRESULT(Result result) {
		this.RESULT = result;
	}
}
