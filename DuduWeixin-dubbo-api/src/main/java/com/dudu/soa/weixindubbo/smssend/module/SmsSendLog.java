package com.dudu.soa.weixindubbo.smssend.module;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/29.
 */
public class SmsSendLog implements Serializable {
    /**
     * 主键id
     */
    private int id;
    /**
     * 业务类型
     */
    private String serviceType;
    /**
     * 手机号码
     */
    private String mobilePhone;
    /**
     * 发送时间
     */
    private Date sendTime;
    /**
     * 验证码
     */
    private String identifyingCode;
    /**
     * 车牌号
     */
    private String plateNumber;
    /**
     * 联盟code
     */
    private String lmcode;

    /**
     * Gets id.
     *
     * @return id id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets service type.
     *
     * @return serviceType serviceType
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * Sets service type.
     *
     * @param serviceType serviceType
     */
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    /**
     * Gets mobile phone.
     *
     * @return mobilePhone mobile phone
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * Sets mobile phone.
     *
     * @param mobilePhone mobilePhone
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * Gets send time.
     *
     * @return sendTime send time
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * sendTime
     *
     * @param sendTime sendTime
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * Gets identifying code.
     *
     * @return identifyingCode identifying code
     */
    public String getIdentifyingCode() {
        return identifyingCode;
    }

    /**
     * Sets identifying code.
     *
     * @param identifyingCode identifyingCode
     */
    public void setIdentifyingCode(String identifyingCode) {
        this.identifyingCode = identifyingCode;
    }

    /**
     * Gets plate number.
     *
     * @return plateNumber plate number
     */
    public String getPlateNumber() {
        return plateNumber;
    }

    /**
     * Sets plate number.
     *
     * @param plateNumber plateNumber
     */
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    /**
     * Gets lmcode.
     *
     * @return lmcode lmcode
     */
    public String getLmcode() {
        return lmcode;
    }

    /**
     * Sets lmcode.
     *
     * @param lmcode lmcode
     */
    public void setLmcode(String lmcode) {
        this.lmcode = lmcode;
    }

    /**
     * @return 实体类转换成字符串
     */
    @Override
    public String toString() {
        return "SmsSend{"
                + "id=" + id
                + ", serviceType='" + serviceType + '\''
                + ", mobilePhone='" + mobilePhone + '\''
                + ", sendTime=" + sendTime
                + ", identifyingCode='" + identifyingCode
                + ", plateNumber='" + plateNumber + "}";
    }
}
