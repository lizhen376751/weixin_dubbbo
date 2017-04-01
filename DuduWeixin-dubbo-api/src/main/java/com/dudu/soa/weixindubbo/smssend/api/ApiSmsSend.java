package com.dudu.soa.weixindubbo.smssend.api;


import com.dudu.soa.weixindubbo.smssend.module.SmsSendLog;

/**
 * Created by Administrator on 2017/3/29.
 * 短信验证码及密码修改记录
 */

public interface ApiSmsSend {
    /**
     * 获取验证码实体类
     * @param smsSend 验证码信息
     * @return 验证码实体类
     */
    SmsSendLog getSmsSend(SmsSendLog smsSend);

    /**
     * 新增验证码
     * @param smsSend 验证码信息
     */
    void addSmsSend(SmsSendLog smsSend);

    /**
     * 删除短信验证码
     * @param smsSend 验证码信息
     */
    void deleteSmsSend(SmsSendLog smsSend);

}
