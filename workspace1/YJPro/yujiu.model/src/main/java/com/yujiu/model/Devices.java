package com.yujiu.model;

/**
 * 请写出类的用途 
 * @author an.jj
 * @date  2017-04-06 14:18:30
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
public class Devices {
    /**
     * 
     */
    private Integer id;

    /**
     * 设备名称
     */
    private String name;

    /**
     * 协议类别
     */
    private String type;

    /**
     * 串口号
     */
    private String serialPort;

    /**
     * 串口参数
     */
    private String serialParam;

    /**
     * 设备地址
     */
    private String address;

    /**
     * 通讯速率
     */
    private Integer rate;

    /**
     * 超时次数
     */
    private Integer overtime;

    /**
     * 级别
     */
    private Integer rank;

    /**
     * 0不屏蔽，1屏蔽
     */
    private Byte shield;

    /**
     * 
     * {@linkplain #id}
     *
     * @return the value of devices.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * {@linkplain #id}
     * @param id the value for devices.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * {@linkplain #name}
     *
     * @return the value of devices.name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * {@linkplain #name}
     * @param name the value for devices.name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * {@linkplain #type}
     *
     * @return the value of devices.type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * {@linkplain #type}
     * @param type the value for devices.type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * {@linkplain #serialPort}
     *
     * @return the value of devices.serial_port
     */
    public String getSerialPort() {
        return serialPort;
    }

    /**
     * 
     * {@linkplain #serialPort}
     * @param serialPort the value for devices.serial_port
     */
    public void setSerialPort(String serialPort) {
        this.serialPort = serialPort;
    }

    /**
     * 
     * {@linkplain #serialParam}
     *
     * @return the value of devices.serial_param
     */
    public String getSerialParam() {
        return serialParam;
    }

    /**
     * 
     * {@linkplain #serialParam}
     * @param serialParam the value for devices.serial_param
     */
    public void setSerialParam(String serialParam) {
        this.serialParam = serialParam;
    }

    /**
     * 
     * {@linkplain #address}
     *
     * @return the value of devices.address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 
     * {@linkplain #address}
     * @param address the value for devices.address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 
     * {@linkplain #rate}
     *
     * @return the value of devices.rate
     */
    public Integer getRate() {
        return rate;
    }

    /**
     * 
     * {@linkplain #rate}
     * @param rate the value for devices.rate
     */
    public void setRate(Integer rate) {
        this.rate = rate;
    }

    /**
     * 
     * {@linkplain #overtime}
     *
     * @return the value of devices.overtime
     */
    public Integer getOvertime() {
        return overtime;
    }

    /**
     * 
     * {@linkplain #overtime}
     * @param overtime the value for devices.overtime
     */
    public void setOvertime(Integer overtime) {
        this.overtime = overtime;
    }

    /**
     * 
     * {@linkplain #rank}
     *
     * @return the value of devices.rank
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * 
     * {@linkplain #rank}
     * @param rank the value for devices.rank
     */
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    /**
     * 
     * {@linkplain #shield}
     *
     * @return the value of devices.shield
     */
    public Byte getShield() {
        return shield;
    }

    /**
     * 
     * {@linkplain #shield}
     * @param shield the value for devices.shield
     */
    public void setShield(Byte shield) {
        this.shield = shield;
    }
}