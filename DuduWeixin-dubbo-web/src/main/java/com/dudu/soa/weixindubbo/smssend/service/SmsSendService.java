package com.dudu.soa.weixindubbo.smssend.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.dudu.soa.weixindubbo.smssend.api.ApiSmsSend;
import com.dudu.soa.weixindubbo.smssend.mapper.SmsSendDao;
import com.dudu.soa.weixindubbo.smssend.module.SmsSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/3/29.
 */
@Service
public class SmsSendService implements ApiSmsSend{
    /**
     * 引入dao层
     */
    @Autowired
    private SmsSendDao smsSendDao;
    @Override
    public SmsSend getSmsSend(SmsSend smsSend) {
        return smsSendDao.getSmsSend(smsSend);
    }

    @Override
    @Transactional
    public void addSmsSend(SmsSend smsSend) {
        smsSendDao.addSmsSend(smsSend);

    }
}
