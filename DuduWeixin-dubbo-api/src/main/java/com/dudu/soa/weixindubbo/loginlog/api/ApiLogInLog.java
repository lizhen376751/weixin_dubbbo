package com.dudu.soa.weixindubbo.loginlog.api;

import com.dudu.soa.weixindubbo.loginlog.module.LogInLog;


/**
 * 微信用户登录记录
 * Created by lizhen on 2017/3/30.
 */
public interface ApiLogInLog {
    /**
     * Gets log in log.
     *
     * @param logInLog logInLog
     * @return 一条短息记录 log in log
     */
    LogInLog getLogInLog(LogInLog logInLog);


    /**
     * 修改登录记录
     *
     * @param logInLog 登录记录
     * @return logInLog logInLog
     */
    Integer updateLogInLog(LogInLog logInLog);


    /**
     * 新增登录记录
     *
     * @param logInLog 新增登录记录
     * @return 新增数据条数 integer
     */
    Integer addLogInLog(LogInLog logInLog);

    /**
     * 删除短信记录
     *
     * @param logInLog 新增登录记录
     * @return 删除数据条数 integer
     */
    Integer deleLogInLog(LogInLog logInLog);


}
