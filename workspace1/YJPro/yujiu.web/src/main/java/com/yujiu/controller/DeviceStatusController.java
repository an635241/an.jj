package com.yujiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yujiu.base.web.controller.BaseCurdController;
import com.yujiu.base.web.controller.BaseCurdController.CrudInfo;
import com.yujiu.model.DeviceStatus;
import com.yujiu.service.DeviceStatusService;

@Controller
@RequestMapping(value="/status")
public class DeviceStatusController extends BaseCurdController<DeviceStatus> {
	@Autowired
	private DeviceStatusService deviceStatusService;

	@Override
	protected BaseCurdController<DeviceStatus>.CrudInfo init() {
		// TODO Auto-generated method stub
		return new CrudInfo("status/", deviceStatusService);
	}

}
