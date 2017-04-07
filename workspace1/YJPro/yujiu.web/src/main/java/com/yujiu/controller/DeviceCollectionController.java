package com.yujiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yujiu.base.web.controller.BaseCurdController;
import com.yujiu.model.DeviceCollection;
import com.yujiu.service.DeviceCollectionSevice;

@Controller
@RequestMapping(value="/collection")
public class DeviceCollectionController extends BaseCurdController<DeviceCollection> {
	@Autowired
	private DeviceCollectionSevice collectionSevice;

	@Override
	protected BaseCurdController<DeviceCollection>.CrudInfo init() {
		// TODO Auto-generated method stub
		return new CrudInfo("collection/", collectionSevice);
	}

}
