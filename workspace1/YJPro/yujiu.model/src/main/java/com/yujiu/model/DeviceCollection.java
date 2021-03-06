package com.yujiu.model;

/**
 * 请写出类的用途 
 * @author an.jj
 * @date  2017-04-06 20:05:06
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
public class DeviceCollection {
    /**
     * 
     */
    private Integer id;

    /**
     * 数据项名称
     */
    private String name;

    /**
     * 
     */
    private Integer deviceId;

    /**
     * 变比
     */
    private String ratio;

    /**
     * 告警上限
     */
    private Integer alarmUp;

    /**
     * 告警下线
     */
    private Integer alarmLow;

    /**
     * 恢复上线
     */
    private Integer recoverUp;

    /**
     * 恢复下线
     */
    private String recoverLow;

    /**
     * 命令
     */
    private String command;

    /**
     * 命令参数
     */
    private String commandParam;

    /**
     * 告警级别
     */
    private Integer alarmRank;

    /**
     * 告警延时
     */
    private Integer alarmDelay;

    /**
     * 恢复延时
     */
    private Integer recoverDelay;

    /**
     * 最大值
     */
    private Integer max;

    /**
     * 最小值
     */
    private Integer min;

    /**
     * 是否屏蔽 0不屏蔽，1屏蔽
     */
    private Byte shield;

    /**
     * 是否保存历史数据0不保存，1保存
     */
    private Byte historicalData;

    /**
     * 是否保存历史变化率
     */
    private Integer historicalChange;

    /**
     * 保存间隔
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
     * @return the value of device_collection.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * {@linkplain #id}
     * @param id the value for device_collection.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * {@linkplain #name}
     *
     * @return the value of device_collection.name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * {@linkplain #name}
     * @param name the value for device_collection.name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * {@linkplain #deviceId}
     *
     * @return the value of device_collection.device_id
     */
    public Integer getDeviceId() {
        return deviceId;
    }

    /**
     * 
     * {@linkplain #deviceId}
     * @param deviceId the value for device_collection.device_id
     */
    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * 
     * {@linkplain #ratio}
     *
     * @return the value of device_collection.ratio
     */
    public String getRatio() {
        return ratio;
    }

    /**
     * 
     * {@linkplain #ratio}
     * @param ratio the value for device_collection.ratio
     */
    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    /**
     * 
     * {@linkplain #alarmUp}
     *
     * @return the value of device_collection.alarm_up
     */
    public Integer getAlarmUp() {
        return alarmUp;
    }

    /**
     * 
     * {@linkplain #alarmUp}
     * @param alarmUp the value for device_collection.alarm_up
     */
    public void setAlarmUp(Integer alarmUp) {
        this.alarmUp = alarmUp;
    }

    /**
     * 
     * {@linkplain #alarmLow}
     *
     * @return the value of device_collection.alarm_low
     */
    public Integer getAlarmLow() {
        return alarmLow;
    }

    /**
     * 
     * {@linkplain #alarmLow}
     * @param alarmLow the value for device_collection.alarm_low
     */
    public void setAlarmLow(Integer alarmLow) {
        this.alarmLow = alarmLow;
    }

    /**
     * 
     * {@linkplain #recoverUp}
     *
     * @return the value of device_collection.recover_up
     */
    public Integer getRecoverUp() {
        return recoverUp;
    }

    /**
     * 
     * {@linkplain #recoverUp}
     * @param recoverUp the value for device_collection.recover_up
     */
    public void setRecoverUp(Integer recoverUp) {
        this.recoverUp = recoverUp;
    }

    /**
     * 
     * {@linkplain #recoverLow}
     *
     * @return the value of device_collection.recover_low
     */
    public String getRecoverLow() {
        return recoverLow;
    }

    /**
     * 
     * {@linkplain #recoverLow}
     * @param recoverLow the value for device_collection.recover_low
     */
    public void setRecoverLow(String recoverLow) {
        this.recoverLow = recoverLow;
    }

    /**
     * 
     * {@linkplain #command}
     *
     * @return the value of device_collection.command
     */
    public String getCommand() {
        return command;
    }

    /**
     * 
     * {@linkplain #command}
     * @param command the value for device_collection.command
     */
    public void setCommand(String command) {
        this.command = command;
    }

    /**
     * 
     * {@linkplain #commandParam}
     *
     * @return the value of device_collection.command_param
     */
    public String getCommandParam() {
        return commandParam;
    }

    /**
     * 
     * {@linkplain #commandParam}
     * @param commandParam the value for device_collection.command_param
     */
    public void setCommandParam(String commandParam) {
        this.commandParam = commandParam;
    }

    /**
     * 
     * {@linkplain #alarmRank}
     *
     * @return the value of device_collection.alarm_rank
     */
    public Integer getAlarmRank() {
        return alarmRank;
    }

    /**
     * 
     * {@linkplain #alarmRank}
     * @param alarmRank the value for device_collection.alarm_rank
     */
    public void setAlarmRank(Integer alarmRank) {
        this.alarmRank = alarmRank;
    }

    /**
     * 
     * {@linkplain #alarmDelay}
     *
     * @return the value of device_collection.alarm_delay
     */
    public Integer getAlarmDelay() {
        return alarmDelay;
    }

    /**
     * 
     * {@linkplain #alarmDelay}
     * @param alarmDelay the value for device_collection.alarm_delay
     */
    public void setAlarmDelay(Integer alarmDelay) {
        this.alarmDelay = alarmDelay;
    }

    /**
     * 
     * {@linkplain #recoverDelay}
     *
     * @return the value of device_collection.recover_delay
     */
    public Integer getRecoverDelay() {
        return recoverDelay;
    }

    /**
     * 
     * {@linkplain #recoverDelay}
     * @param recoverDelay the value for device_collection.recover_delay
     */
    public void setRecoverDelay(Integer recoverDelay) {
        this.recoverDelay = recoverDelay;
    }

    /**
     * 
     * {@linkplain #max}
     *
     * @return the value of device_collection.max
     */
    public Integer getMax() {
        return max;
    }

    /**
     * 
     * {@linkplain #max}
     * @param max the value for device_collection.max
     */
    public void setMax(Integer max) {
        this.max = max;
    }

    /**
     * 
     * {@linkplain #min}
     *
     * @return the value of device_collection.min
     */
    public Integer getMin() {
        return min;
    }

    /**
     * 
     * {@linkplain #min}
     * @param min the value for device_collection.min
     */
    public void setMin(Integer min) {
        this.min = min;
    }

    /**
     * 
     * {@linkplain #shield}
     *
     * @return the value of device_collection.shield
     */
    public Byte getShield() {
        return shield;
    }

    /**
     * 
     * {@linkplain #shield}
     * @param shield the value for device_collection.shield
     */
    public void setShield(Byte shield) {
        this.shield = shield;
    }

    /**
     * 
     * {@linkplain #historicalData}
     *
     * @return the value of device_collection.historical_data
     */
    public Byte getHistoricalData() {
        return historicalData;
    }

    /**
     * 
     * {@linkplain #historicalData}
     * @param historicalData the value for device_collection.historical_data
     */
    public void setHistoricalData(Byte historicalData) {
        this.historicalData = historicalData;
    }

    /**
     * 
     * {@linkplain #historicalChange}
     *
     * @return the value of device_collection.historical_change
     */
    public Integer getHistoricalChange() {
        return historicalChange;
    }

    /**
     * 
     * {@linkplain #historicalChange}
     * @param historicalChange the value for device_collection.historical_change
     */
    public void setHistoricalChange(Integer historicalChange) {
        this.historicalChange = historicalChange;
    }

    /**
     * 
     * {@linkplain #historicalInterval}
     *
     * @return the value of device_collection.historical_interval
     */
    public Integer getHistoricalInterval() {
        return historicalInterval;
    }

    /**
     * 
     * {@linkplain #historicalInterval}
     * @param historicalInterval the value for device_collection.historical_interval
     */
    public void setHistoricalInterval(Integer historicalInterval) {
        this.historicalInterval = historicalInterval;
    }

    /**
     * 
     * {@linkplain #deviceName}
     *
     * @return the value of device_collection.device_name
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * 
     * {@linkplain #deviceName}
     * @param deviceName the value for device_collection.device_name
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}