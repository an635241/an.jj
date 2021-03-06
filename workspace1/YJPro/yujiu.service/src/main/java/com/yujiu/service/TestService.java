package com.yujiu.service;

import com.yujiu.base.dao.BaseCurdMapper;
import com.yujiu.base.service.BaseCurdService;
import com.yujiu.dao.TestMapper;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * ��д�������; 
 * @author an.jj
 * @date  2017-03-30 16:08:39
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
@Service("testService")
public class TestService extends BaseCurdService {
    @Resource
    private TestMapper testMapper;

    @Override
    public BaseCurdMapper init() {
        return testMapper;
    }
}