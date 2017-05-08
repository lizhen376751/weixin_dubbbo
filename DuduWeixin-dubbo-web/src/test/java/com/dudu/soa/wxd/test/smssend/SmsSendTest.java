package com.dudu.soa.wxd.test.smssend;

import com.dudu.soa.weixindubbo.smssend.module.SmsSendLog;
import com.dudu.soa.weixindubbo.smssend.service.SmsSendService;
import com.dudu.soa.wxd.test.TestBase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


/**
 * Created by lizhen on 2017/3/29.
 */
public class SmsSendTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger(SmsSendTest.class);
    @Autowired
    private SmsSendService smsSendService;

    @Test
    public void getSmsSend() {
        try {
            SmsSendLog smsSend = new SmsSendLog();
            smsSend.setId(0);
            smsSend.setMobilePhone("18560042032");
            smsSend.setPlateNumber("鲁A556644");
            smsSend.setLmcode("cs000");
            smsSend.setServiceType("验证码");
            SmsSendLog smsSend1 = smsSendService.getSmsSend(smsSend);
            System.out.println("=============" + smsSend1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void addSmsSend() {
        try {
            SmsSendLog smsSend = new SmsSendLog();
            smsSend.setIdentifyingCode("556688");
            smsSend.setMobilePhone("18560042032");
            smsSend.setPlateNumber("鲁A556644");
            Date date = new Date();
            smsSend.setSendTime(date);
            smsSend.setServiceType("验证码");
            smsSend.setLmcode("cs000");
            smsSendService.addSmsSend(smsSend);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteSmsSend() {
        try {
            SmsSendLog smsSend = new SmsSendLog();
            smsSend.setMobilePhone("18560042032");
            smsSend.setPlateNumber("鲁A556644");
            smsSend.setServiceType("验证码");
            smsSend.setLmcode("cs000");
            Integer integer = smsSendService.deleteSmsSend(smsSend);
            log.info("删除数据的条数为:==============================" + integer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
