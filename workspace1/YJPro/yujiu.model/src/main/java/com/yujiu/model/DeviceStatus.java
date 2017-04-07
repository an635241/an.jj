package com.yujiu.model;

/**
 * 请写出类的用途 
 * @author an.jj
 * @date  2017-04-07 10:31:57
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
public class DeviceStatus {
    /**
     * 
     */
    private Integer id;

    /**
     * 查询名称
     */
    private String name;

    /**
     * 设备号
     */
    private Integer deviceId;

    /**
     * 0级别
     */
    private Integer zeroRank;

    /**
     * 0事件
     */
    private String zeroEvent;

    /**
     * 1级别
     */
    private Integer oneRank;

    /**
     * 1事件
     */
    private String oneEvent;

    /**
     * 命令
     */
    private String command;

    /**
     * 命令参数
     */
    private String commandParam;

    /**
     * 0变1延时
     */
    private Integer zerotoone;

    /**
     * 1变0延时
     */
    private Integer onetozero;

    /**
     * 是否屏蔽
     */
    private Byte shield;

    /**
     * 是否保存历史数据
     */
    private Byte historicalData;

    /**
     * 保存历史数据间隔
     */
    private Integer historicalInterval;

    /**
     * 
     */
    private String deviceName;

    /**
     * 
     * {@linkplain #id}
     *
     * @return the value of device_status.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * {@linkplain #id}
     * @param id the value for device_status.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * {@linkplain #name}
     *
     * @return the value of device_status.name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * {@linkplain #name}
     * @param name the value for device_status.name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * {@linkplain #deviceId}
     *
     * @return the value of device_status.device_id
     */
    public Integer getDeviceId() {
        return deviceId;
    }

    /**
     * 
     * {@linkplain #deviceId}
     * @param deviceId the value for device_status.device_id
     */
    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * 
     * {@linkplain #zeroRank}
     *
     * @return the value of device_status.zero_rank
     */
    public Integer getZeroRank() {
        return zeroRank;
    }

    /**
     * 
     * {@linkplain #zeroRank}
     * @param zeroRank the value for device_status.zero_rank
     */
    public void setZeroRank(Integer zeroRank) {
        this.zeroRank = zeroRank;
    }

    /**
     * 
     * {@linkplain #zeroEvent}
     *
     * @return the value of device_status.zero_event
     */
    public String getZeroEvent() {
        return zeroEvent;
    }

    /**
     * 
     * {@linkplain #zeroEvent}
     * @param zeroEvent the value for device_status.zero_event
     */
    public void setZeroEvent(String zeroEvent) {
        this.zeroEvent = zeroEvent;
    }

    /**
     * 
     * {@linkplain #oneRank}
     *
     * @return the value of device_status.one_rank
     */
    public Integer getOneRank() {
        return oneRank;
    }

    /**
     * 
     * {@linkplain #oneRank}
     * @param oneRank the value for device_status.one_rank
     */
    public void setOneRank(Integer oneRank) {
        this.oneRank = oneRank;
    }

    /**
     * 
     * {@linkplain #oneEvent}
     *
     * @return the value of device_status.one_event
     */
    public String getOneEvent() {
        return oneEvent;
    }

    /**
     * 
     * {@linkplain #oneEvent}
     * @param oneEvent the value for device_status.one_event
     */
    public void setOneEvent(String oneEvent) {
        this.oneEvent = oneEvent;
    }

    /**
     * 
     * {@linkplain #command}
     *
     * @return the value of device_status.command
     */
    public String getCommand() {
        return command;
    }

    /**
     * 
     * {@linkplain #command}
     * @param command the value for device_status.command
     */
    public void setCommand(String command) {
        this.command = command;
    }

    /**
     * 
     * {@linkplain #commandParam}
     *
     * @return the value of device_status.command_param
     */
    public String getCommandParam() {
        return commandParam;
    }

    /**
     * 
     * {@linkplain #commandParam}
     * @param commandParam the value for device_status.command_param
     */
    public void setCommandParam(String commandParam) {
        this.commandParam = commandParam;
    }

    /**
     * 
     * {@linkplain #zerotoone}
     *
     * @return the value of device_status.zerotoone
     */
    public Integer getZerotoone() {
        return zerotoone;
    }

    /**
     * 
     * {@linkplain #zerotoone}
     * @param zerotoone the value for device_status.zerotoone
     */
    public void setZerotoone(Integer zerotoone) {
        this.zerotoone = zerotoone;
    }

    /**
     * 
     * {@linkplain #onetozero}
     *
     * @return the value of device_status.onetozero
     */
    public Integer getOnetozero() {
        return onetozero;
    }

    /**
     * 
     * {@linkplain #onetozero}
     * @param onetozero the value for device_status.onetozero
     */
    public void setOnetozero(Integer onetozero) {
        this.onetozero = onetozero;
    }

    /**
     * 
     * {@linkplain #shield}
     *
     * @return the value of device_status.shield
     */
    public Byte getShield() {
        return shield;
    }

    /**
     * 
     * {@linkplain #shield}
     * @param shield the value for device_status.shield
     */
    public void setShield(Byte shield) {
        this.shield = shield;
    }

    /**
     * 
     * {@linkplain #historicalData}
     *
     * @return the value of device_status.historical_data
     */
    public Byte getHistoricalData() {
        return historicalData;
    }

    /**
     * 
     * {@linkplain #historicalData}
     * @param historicalData the value for device_status.historical_data
     */
    public void setHistoricalData(Byte historicalData) {
        this.historicalData = historicalData;
    }

    /**
     * 
     * {@linkplain #historicalInterval}
     *
     * @return the value of device_status.historical_interval
     */
    public Integer getHistoricalInterval() {
        return historicalInterval;
    }

    /**
     * 
     * {@linkplain #historicalInterval}
     * @param historicalInterval the value for device_status.historical_interval
     */
    public void setHistoricalInterval(Integer historicalInterval) {
        this.historicalInterval = historicalInterval;
    }

    /**
     * 
     * {@linkplain #deviceName}
     *
     * @return the value of device_status.device_name
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * 
     * {@linkplain #deviceName}
     * @param deviceName the value for device_status.device_name
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}