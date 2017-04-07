package com.yujiu.model;

/**
 * ��д�������; 
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
     * ����������
     */
    private String name;

    /**
     * 
     */
    private Integer deviceId;

    /**
     * ���
     */
    private String ratio;

    /**
     * �澯����
     */
    private Integer alarmUp;

    /**
     * �澯����
     */
    private Integer alarmLow;

    /**
     * �ָ�����
     */
    private Integer recoverUp;

    /**
     * �ָ�����
     */
    private String recoverLow;

    /**
     * ����
     */
    private String command;

    /**
     * �������
     */
    private String commandParam;

    /**
     * �澯����
     */
    private Integer alarmRank;

    /**
     * �澯��ʱ
     */
    private Integer alarmDelay;

    /**
     * �ָ���ʱ
     */
    private Integer recoverDelay;

    /**
     * ���ֵ
     */
    private Integer max;

    /**
     * ��Сֵ
     */
    private Integer min;

    /**
     * �Ƿ����� 0�����Σ�1����
     */
    private Byte shield;

    /**
     * �Ƿ񱣴���ʷ����0�����棬1����
     */
    private Byte historicalData;

    /**
     * �Ƿ񱣴���ʷ�仯��
     */
    private Integer historicalChange;

    /**
     * ������
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