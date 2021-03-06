package com.yujiu.base.common.enums;
/**
 * @author wei.b
 * @email wei.b@yougou.com
 * create time: 2013-6-26
 */
public enum CommonOperatorEnum {
	DELETED("deleted"),
	UPDATED("updated"),
	INSERTED("inserted");
	
	private String operator;
	
	CommonOperatorEnum(String operator){
		this.operator=operator;
	}

	public String getOperator() {
		return operator;
	}
}