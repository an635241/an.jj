package com.yujiu.dao;

import java.util.List;
import java.util.HashMap;

import com.yujiu.base.dao.BaseCurdMapper;

/**
 * ��д�������; 
 * @author an.jj
 * @date  2017-04-07 14:54:26
 * @version 1.0.0
 * @copyright (C) 2013 WonHigh Information Technology Co.,Ltd 
 * All Rights Reserved. 
 * 
 * The software for the WonHigh technology development, without the 
 * company's written consent, and any other individuals and 
 * organizations shall not be used, Copying, Modify or distribute 
 * the software.
 * 
 */
public interface LogsMapper extends BaseCurdMapper {
	
	List<HashMap<String,Object>> search(HashMap<String, Object> param);
}