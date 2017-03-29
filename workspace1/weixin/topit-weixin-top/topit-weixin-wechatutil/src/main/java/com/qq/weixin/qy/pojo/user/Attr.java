package com.qq.weixin.qy.pojo.user;

/**
 * 属性(人员信息扩展属性)
 * @author zhang.p
 *
 */
public class Attr {
	//属性名
	private String name;
	//属性值
	private String value;
	
	public Attr(){
		
	}
	
	public Attr(String name,String value){
		this.name=name;
		this.value=value;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
