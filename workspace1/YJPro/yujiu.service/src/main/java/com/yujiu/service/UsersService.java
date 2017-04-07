package com.yujiu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yujiu.base.dao.BaseCurdMapper;
import com.yujiu.base.service.BaseCurdService;
import com.yujiu.dao.UsersMapper;

@Service
public class UsersService extends BaseCurdService {
	@Autowired
	private UsersMapper usersMapper;

	@Override
	public BaseCurdMapper init() {
		// TODO Auto-generated method stub
		return usersMapper;
	}

}
