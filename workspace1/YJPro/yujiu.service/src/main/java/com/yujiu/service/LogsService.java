package com.yujiu.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yujiu.base.dao.BaseCurdMapper;
import com.yujiu.base.service.BaseCurdService;
import com.yujiu.dao.LogsMapper;

@Service
public class LogsService extends BaseCurdService {
	
	@Autowired
	private LogsMapper logsMapper;

	@Override
	public BaseCurdMapper init() {
		// TODO Auto-generated method stub
		return logsMapper;
	}
	
	public List<HashMap<String,Object>> search(HashMap<String, Object> param){
		return logsMapper.search(param);
	}

}
