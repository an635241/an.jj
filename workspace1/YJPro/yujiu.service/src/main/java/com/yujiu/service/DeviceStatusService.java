package com.yujiu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yujiu.base.dao.BaseCurdMapper;
import com.yujiu.base.service.BaseCurdService;
import com.yujiu.dao.DeviceStatusMapper;

@Service
public class DeviceStatusService extends BaseCurdService {
	
	@Autowired
	private DeviceStatusMapper deviceStatusMapper;

	@Override
	public BaseCurdMapper init() {
		// TODO Auto-generated method stub
		return deviceStatusMapper;
	}

}
