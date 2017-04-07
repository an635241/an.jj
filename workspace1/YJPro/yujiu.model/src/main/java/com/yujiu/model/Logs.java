package com.yujiu.model;

import java.util.Date;

/**
 * 请写出类的用途 
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
public class Logs {
    /**
     * 日志
     */
    private Integer id;

    /**
     * 
     */
    private String logInfo;

    /**
     * 插入时间
     */
    private Date insertTime;

    /**
     * 
     */
    private Integer insertUser;

    /**
     * 
     */
    private String username;

    /**
     * 
     * {@linkplain #id}
     *
     * @return the value of logs.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * {@linkplain #id}
     * @param id the value for logs.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * {@linkplain #logInfo}
     *
     * @return the value of logs.log_info
     */
    public String getLogInfo() {
        return logInfo;
    }

    /**
     * 
     * {@linkplain #logInfo}
     * @param logInfo the value for logs.log_info
     */
    public void setLogInfo(String logInfo) {
        this.logInfo = logInfo;
    }

    /**
     * 
     * {@linkplain #insertTime}
     *
     * @return the value of logs.insert_time
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * 
     * {@linkplain #insertTime}
     * @param insertTime the value for logs.insert_time
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * 
     * {@linkplain #insertUser}
     *
     * @return the value of logs.insert_user
     */
    public Integer getInsertUser() {
        return insertUser;
    }

    /**
     * 
     * {@linkplain #insertUser}
     * @param insertUser the value for logs.insert_user
     */
    public void setInsertUser(Integer insertUser) {
        this.insertUser = insertUser;
    }

    /**
     * 
     * {@linkplain #username}
     *
     * @return the value of logs.username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * {@linkplain #username}
     * @param username the value for logs.username
     */
    public void setUsername(String username) {
        this.username = username;
    }
}