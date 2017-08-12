package com.dudu.soa.weixindubbo.weixin.http.accesstoken.service;

import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.AccessToken;
import com.dudu.soa.wxd.test.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/8/12.
 */
public class sssssServiceTest extends TestBase{
    @Autowired
    private SssssService SssssService;
    @Test
    public void getAccessToken() throws Exception {
        AccessToken accessToken = new AccessToken();
        accessToken.setAppsecret("sad").setToken("sd").setAppid("44545");
        AccessToken accessToken1 = SssssService.getAccessToken(accessToken);
        System.out.println("===================="+accessToken1.toString());
    }

    @Test
    public void addAccessToken() throws Exception {
        AccessToken accessToken = new AccessToken();
        accessToken.setAppsecret("sad").setToken("sd").setAppid("8454").setExpiresIn(7200).setCreateTime(784484845).setAppid("44545");
        System.out.println(null == SssssService);
        Integer integer = SssssService.addAccessToken(accessToken);
        System.out.println("==========="+integer);
    }

    @Test
    public void updateAccessToken() throws Exception {
        AccessToken accessToken = new AccessToken();
        accessToken.setAppsecret("sad").setToken("sd45415215454").setTicket("45阿萨德撒").setExpiresIn(7200).setCreateTime(784484845).setAppid("44545");
        System.out.println(null == SssssService);
        Integer integer = SssssService.updateAccessToken(accessToken);
        System.out.println("==========="+integer);
    }

    @Test
    public void deletAccessToken() throws Exception {

    }

}