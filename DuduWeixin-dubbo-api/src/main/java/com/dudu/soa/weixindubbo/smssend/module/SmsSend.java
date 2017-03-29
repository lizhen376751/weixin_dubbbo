package com.dudu.soa.weixindubbo.smssend.module;

import java.sql.Time;

/**
 * Created by Administrator on 2017/3/29.
 */

public class SmsSend {
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
    private Time sendTime;
    /**
     * 验证码
     */
    private String identifyingCode;

}
