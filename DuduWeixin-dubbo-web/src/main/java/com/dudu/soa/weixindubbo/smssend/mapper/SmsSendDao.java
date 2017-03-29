package com.dudu.soa.weixindubbo.smssend.mapper;

import com.dudu.soa.weixindubbo.smssend.module.SmsSend;

/**
 * Created by Administrator on 2017/3/29.
 */
public interface SmsSendDao {
    /**
     * 获取验证码实体类
     * @param smsSend 验证码信息
     * @return
     */
    SmsSend getSmsSend(SmsSend smsSend);

    /**
     * 新增验证码
     * @param smsSend 验证码信息
     */
    void addSmsSend(SmsSend smsSend);
}
