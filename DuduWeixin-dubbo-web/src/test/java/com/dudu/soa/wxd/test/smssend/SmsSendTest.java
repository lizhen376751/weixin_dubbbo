package com.dudu.soa.wxd.test.smssend;

import com.dudu.soa.weixindubbo.smssend.module.SmsSend;
import com.dudu.soa.weixindubbo.smssend.service.SmsSendService;
import com.dudu.soa.wxd.test.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


/**
 * Created by Administrator on 2017/3/29.
 */
public class SmsSendTest extends TestBase {
    /**
     * 引入service
     */
    @Autowired
    private SmsSendService smsSendService;

    @Test
    public void getSmsSend() {
        try{
            SmsSend smsSend = new SmsSend();
            smsSend.setMobilePhone("18560042032");
            smsSend.setPlateNumber("鲁A556644");
            smsSend.setLmcode("cs000");
            smsSend.setServiceType("验证码");
            SmsSend smsSend1 = smsSendService.getSmsSend(smsSend);
            System.out.println("============="+smsSend1);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void addSmsSend() {
        try{
            SmsSend smsSend = new SmsSend();
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

}
