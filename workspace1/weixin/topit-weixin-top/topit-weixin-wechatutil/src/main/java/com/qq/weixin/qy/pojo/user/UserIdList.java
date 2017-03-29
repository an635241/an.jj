package com.qq.weixin.qy.pojo.user;

import java.util.List;

/**
 * 批量删除用户，ID列表
 * @author zhang.p
 *
 */
public class UserIdList {
	//用户ID列表
	private List<String> useridlist;

	public List<String> getUseridlist() {
		return useridlist;
	}

	public void setUseridlist(List<String> useridlist) {
		this.useridlist = useridlist;
	}

}
