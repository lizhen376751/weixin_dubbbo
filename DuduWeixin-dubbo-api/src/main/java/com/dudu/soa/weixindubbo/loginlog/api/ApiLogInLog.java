package com.dudu.soa.weixindubbo.loginlog.api;

import com.dudu.soa.weixindubbo.loginlog.module.LogInLog;

import java.io.InputStream;

/**
 * 微信用户登录记录
 * Created by lizhen on 2017/3/30.
 */

public interface ApiLogInLog {
    /**
     * @param logInLog logInLog
     * @return 一条短息记录
     */
    LogInLog getLogInLog(LogInLog logInLog);

    /**
     * 修改登录记录
     *
     * @param logInLog logInLog
     */
    void updateLogInLog(LogInLog logInLog);

    /**
     * 新增登录记录
     *
     * @param logInLog logInLog
     */
    void addLogInLog(LogInLog logInLog);

    /**
     * 删除短信记录
     *
     * @param logInLog logInLog
     */
    void deleLogInLog(LogInLog logInLog);

    /**
     * 接收微信端消息处理并做分发
     *
     * @param inputStream 从request中获取inputStream
     */
     void receivemessage(InputStream inputStream);
}
