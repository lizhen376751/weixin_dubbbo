package com.dudu.soa.weixindubbo.loginlog.service;

import com.dudu.soa.weixindubbo.loginlog.api.ApiLogInLog;
import com.dudu.soa.weixindubbo.loginlog.mapper.LogInLogDao;
import com.dudu.soa.weixindubbo.loginlog.module.LogInLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lizhen on 2017/3/30.
 */
@Service
public class LogInLogService implements ApiLogInLog {
    /**
     * 引入dao层
     */
    @Autowired
    private LogInLogDao logInLogDao;

    @Override
    public LogInLog getLogInLog(LogInLog logInLog) {
        return logInLogDao.getLogInLog(logInLog);
    }

    @Override
    @Transactional
    public void updateLogInLog(LogInLog logInLog) {
        logInLogDao.updateLogInLog(logInLog);
    }

    @Override
    @Transactional
    public void addLogInLog(LogInLog logInLog) {
        logInLogDao.addLogInLog(logInLog);
    }

    @Override
    @Transactional
    public void deleLogInLog(LogInLog logInLog) {
        logInLogDao.deleLogInLog(logInLog);
    }
}
