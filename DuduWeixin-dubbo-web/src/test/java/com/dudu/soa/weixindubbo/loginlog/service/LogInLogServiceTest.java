package com.dudu.soa.weixindubbo.loginlog.service;

import com.alibaba.fastjson.JSONObject;
import com.dudu.soa.weixindubbo.loginlog.module.LogInLog;
import com.dudu.soa.weixindubbo.thirdmessage.module.Dsasd;
import com.dudu.soa.weixindubbo.thirdmessage.module.TextContent;
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
            logInLog.setNickname("李振");
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

    @Test
    public void  setLogInLo(){
        String ss = "{\n" +
                "    \"touser\":\"OPENID\",\n" +
                "    \"msgtype\":\"text\",\n" +
                "    \"text\":\n" +
                "    {\n" +
                "         \"content\":\"Hello World\"\n" +
                "    }\n" +
                "}";
        JSONObject jsonObject = JSONObject.parseObject(ss);
        Dsasd dsasd = JSONObject.toJavaObject(jsonObject, Dsasd.class);
        System.out.println("========================"+dsasd.toString());
        Dsasd dsasd1 = new Dsasd();
        TextContent textContent = new TextContent();
        textContent.setContent("Hello World");
        dsasd1.setMsgtype("text").setText(textContent).setTouser("OPENID");
        Object o = JSONObject.toJSON(dsasd1);
        System.out.println("======================="+o.toString());

    }

}