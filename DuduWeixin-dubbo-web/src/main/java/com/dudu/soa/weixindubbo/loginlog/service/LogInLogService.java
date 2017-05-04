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
    public Integer updateLogInLog(LogInLog logInLog) {
        return logInLogDao.updateLogInLog(logInLog);
    }

    @Override
    @Transactional
    public Integer addLogInLog(LogInLog logInLog) {
        return logInLogDao.addLogInLog(logInLog);
    }

    @Override
    @Transactional
    public Integer deleLogInLog(LogInLog logInLog) {
        return logInLogDao.deleLogInLog(logInLog);
    }
}
