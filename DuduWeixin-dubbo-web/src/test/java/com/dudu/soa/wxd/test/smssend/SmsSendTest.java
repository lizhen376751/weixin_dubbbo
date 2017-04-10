package com.dudu.soa.wxd.test.smssend;

import com.dudu.soa.weixindubbo.smssend.module.SmsSendLog;
import com.dudu.soa.weixindubbo.smssend.service.SmsSendService;
import com.dudu.soa.wxd.test.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


/**
 * Created by lizhen on 2017/3/29.
 */
public class SmsSendTest extends TestBase {
    @Autowired
    private SmsSendService smsSendService;

    @Test
    public void getSmsSend() {
        try{
            SmsSendLog smsSend = new SmsSendLog();
            smsSend.setId(0);
            smsSend.setMobilePhone("18560042032");
            smsSend.setPlateNumber("鲁A556644");
            smsSend.setLmcode("cs000");
            smsSend.setServiceType("验证码");
            SmsSendLog smsSend1 = smsSendService.getSmsSend(smsSend);
            System.out.println("============="+smsSend1);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void addSmsSend() {
        try{
            SmsSendLog smsSend = new SmsSendLog();
            smsSend.setIdentifyingCode("556688");
            smsSend.setMobilePhone("18560042032");
            smsSend.setPlateNumber("鲁A556644");
            Date date = new Date();
            smsSend.setSendTime(date);
            smsSend.setServiceType("验证码");
            smsSend.setLmcode("cs000");
            smsSendService.addSmsSend(smsSend);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteSmsSend() {
        try{
            SmsSendLog smsSend = new SmsSendLog();
            smsSend.setMobilePhone("18560042032");
            smsSend.setPlateNumber("鲁A556644");
            smsSend.setServiceType("验证码");
            smsSend.setLmcode("cs000");
            smsSendService.deleteSmsSend(smsSend);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
