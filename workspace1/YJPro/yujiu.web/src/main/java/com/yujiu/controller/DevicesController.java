package com.yujiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yujiu.base.service.BaseCurdService;
import com.yujiu.base.web.controller.BaseCurdController;
import com.yujiu.model.Devices;
import com.yujiu.service.DevicesService;

@Controller
@RequestMapping(value="/devices")
public class DevicesController extends BaseCurdController<Devices> {
	@Autowired
	private DevicesService devicesService;

	@Override
	protected BaseCurdController<Devices>.CrudInfo init() {
		// TODO Auto-generated method stub
		return new CrudInfo("devices/", devicesService);
	}

}
