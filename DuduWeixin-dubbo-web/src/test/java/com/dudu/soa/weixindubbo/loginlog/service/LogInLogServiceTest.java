package com.dudu.soa.weixindubbo.loginlog.service;

import com.dudu.soa.weixindubbo.loginlog.module.LogInLog;
import com.dudu.soa.wxd.test.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/3/30.
 */
public class LogInLogServiceTest extends TestBase {
    @Autowired
    private LogInLogService logInLogService;

    @Test
    public void addLogInLog() throws Exception {
        try {
            LogInLog logInLog = new LogInLog();
            logInLog.setLmcode("cs000");
            logInLog.setPlateNumber("鲁A0000");
            logInLog.setOpenid("hdhsklodaskl");
            logInLog.setUserid(89);
            logInLogService.addLogInLog(logInLog);
        } catch (Exception e) {
            System.out.println("==========================" + e.getMessage());
            e.printStackTrace();
        }

    }

    @Test
    public void getLogInLog() throws Exception {
        try {
            LogInLog logInLog = new LogInLog();
            logInLog.setLmcode("cs000");
            logInLog.setPlateNumber("鲁A0000");
            logInLog.setOpenid("hdhsklodaskl");
            logInLog.setUserid(89);
            LogInLog logInLog1 = logInLogService.getLogInLog(logInLog);
            System.out.println("==========================" + logInLog1.toString());

        } catch (Exception e) {
            System.out.println("==========================" + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void updateLogInLog() throws Exception {
        try{
        LogInLog logInLog = new LogInLog();
            logInLog.setLmcode("cs0001");
            logInLog.setPlateNumber("鲁A00010");
            logInLog.setOpenid("hdhsklodaskl2");
            logInLog.setUserid(90);
            logInLog.setId(3);
        logInLogService.updateLogInLog(logInLog);
    } catch (Exception e) {
        System.out.println("==========================" + e.getMessage());
        e.printStackTrace();
    }
    }



    @Test
    public void deleLogInLog() throws Exception {
        try{
        LogInLog logInLog = new LogInLog();
        logInLog.setOpenid("hdhsklodaskl");
        logInLogService.deleLogInLog(logInLog);
    } catch (Exception e) {
        System.out.println("==========================" + e.getMessage());
        e.printStackTrace();
    }
    }

}