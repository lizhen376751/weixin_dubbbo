package com.dudu.soa.weixindubbo.smssend.mapper;

import com.dudu.soa.weixindubbo.smssend.module.SmsSendLog;

/**
 * Created by Administrator on 2017/3/29.
 */
public interface SmsSendDao {
    /**
     * 获取验证码实体类
     * @param smsSendLog 验证码信息
     * @return 验证码实体类
     */
    SmsSendLog getSmsSend(SmsSendLog smsSendLog);

    /**
     * 新增验证码
     * @param smsSendLog 验证码信息
     */
    void addSmsSend(SmsSendLog smsSendLog);
    /**
     * 删除短信验证码
     * @param smsSend 验证码信息
     */
    void deleteSmsSend(SmsSendLog smsSend);
}
