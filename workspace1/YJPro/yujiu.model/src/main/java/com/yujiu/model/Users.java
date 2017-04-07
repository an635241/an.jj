package com.yujiu.model;

import java.util.Date;

/**
 * 请写出类的用途 
 * @author an.jj
 * @date  2017-04-07 15:47:00
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
public class Users {
    /**
     * 
     */
    private Integer id;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户类型(0管理员，1操作员)
     */
    private Integer type;

    /**
     * 可查看的页面
     */
    private Integer pages;

    /**
     * 可管理的设备
     */
    private Integer devices;

    /**
     * 
     */
    private Date insertTime;

    /**
     * 
     */
    private Integer insertUser;

    /**
     * 
     */
    private Integer updateUser;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     * {@linkplain #id}
     *
     * @return the value of users.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * {@linkplain #id}
     * @param id the value for users.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * {@linkplain #password}
     *
     * @return the value of users.password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * {@linkplain #password}
     * @param password the value for users.password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 
     * {@linkplain #username}
     *
     * @return the value of users.username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * {@linkplain #username}
     * @param username the value for users.username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * {@linkplain #type}
     *
     * @return the value of users.type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 
     * {@linkplain #type}
     * @param type the value for users.type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 
     * {@linkplain #pages}
     *
     * @return the value of users.pages
     */
    public Integer getPages() {
        return pages;
    }

    /**
     * 
     * {@linkplain #pages}
     * @param pages the value for users.pages
     */
    public void setPages(Integer pages) {
        this.pages = pages;
    }

    /**
     * 
     * {@linkplain #devices}
     *
     * @return the value of users.devices
     */
    public Integer getDevices() {
        return devices;
    }

    /**
     * 
     * {@linkplain #devices}
     * @param devices the value for users.devices
     */
    public void setDevices(Integer devices) {
        this.devices = devices;
    }

    /**
     * 
     * {@linkplain #insertTime}
     *
     * @return the value of users.insert_time
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * 
     * {@linkplain #insertTime}
     * @param insertTime the value for users.insert_time
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * 
     * {@linkplain #insertUser}
     *
     * @return the value of users.insert_user
     */
    public Integer getInsertUser() {
        return insertUser;
    }

    /**
     * 
     * {@linkplain #insertUser}
     * @param insertUser the value for users.insert_user
     */
    public void setInsertUser(Integer insertUser) {
        this.insertUser = insertUser;
    }

    /**
     * 
     * {@linkplain #updateUser}
     *
     * @return the value of users.update_user
     */
    public Integer getUpdateUser() {
        return updateUser;
    }

    /**
     * 
     * {@linkplain #updateUser}
     * @param updateUser the value for users.update_user
     */
    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 
     * {@linkplain #updateTime}
     *
     * @return the value of users.update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 
     * {@linkplain #updateTime}
     * @param updateTime the value for users.update_time
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}