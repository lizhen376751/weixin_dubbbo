package com.dudu.soa.weixindubbo.weixin.http.accesstoken.service;

import com.alibaba.fastjson.JSONObject;
import com.dudu.soa.weixindubbo.weixin.http.accesstoken.mapper.AccessTokenDao;
import com.dudu.soa.weixindubbo.weixin.http.module.http.HttpMethod;
import com.dudu.soa.weixindubbo.weixin.http.module.http.WeixinActionMethodDefine;
import com.dudu.soa.weixindubbo.weixin.http.module.http.WeixinBaseParamter;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.AccessToken;
import com.dudu.soa.weixindubbo.weixin.http.service.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 公众号的token的service层
 * Created by lizhen on 2017/8/11.
 */
@Service
public class AccessTokenService {

    /**
     * 日志打印
     */
    private static Logger log = LoggerFactory.getLogger(AccessTokenService.class);
    /**
     * token信息的dao层
     */
    @Autowired
    private AccessTokenDao accessTokenDao;



    /**
     * 获取公众号的token
     *
     * @param appid     微信公众号的appid
     * @param appSecret 微信公众号的appsecret
     * @return token
     */
    public AccessToken getAccessToken(String appid, String appSecret) {
        //1.先去数据库查询
        //2.有的话先判断是否过期  1.过期走下面的 2.没有过去直接返回数据库的
        //3.没有的话去获取
        AccessToken accessToken = new AccessToken();
        accessToken.setAppid(appid);
        Long time = new Date().getTime() / 1000;
        accessToken = accessTokenDao.getAccessToken(accessToken);
        //不为空就在数据库中获取,过期了就重新刷新
        if (null != accessToken) {
            if (null != accessToken.getToken() && !"".equals(accessToken.getToken())) {
                Long authorizationInfoTime = accessToken.getCreateTime();
                int expiresIn = accessToken.getExpiresIn();
                //如果失效,重新获取
                if (time - authorizationInfoTime > expiresIn) {
                    accessToken = addAccessToken(appid, appSecret);
                    Integer integer = accessTokenDao.updateAccessToken(accessToken);
                    log.debug("刷新token的id" + integer);
                    return accessToken;
                }
                return accessToken;
            }

        }
        accessToken = addAccessToken(appid, appSecret);
        Integer integer = accessTokenDao.addAccessToken(accessToken);
        log.debug("新增token的id" + integer);
        return accessToken;
    }


    /**
     * 获取开发者的token和jssdk的jsapiticket
     *
     * @param appid     appid
     * @param appSecret appSecret
     * @return 开发者的token
     */
    public AccessToken addAccessToken(String appid, String appSecret) {
        AccessToken accessToken = new AccessToken();
        WeixinActionMethodDefine weixinActionMethodDefine = new WeixinActionMethodDefine()
                .setIsNeedAccssToken(false)
                .setHttpMethod(HttpMethod.GET)
                .setUri("/cgi-bin/token")
                .setWeixinBaseParamter(new WeixinBaseParamter().setAppid(appid).setSecret(appSecret))
                .putActionConfigParamter("grant_type", "client_credential");
        String jstoken = null;
        //调用微信JS接口的临时票据
        String jsticket = null;
        //token
        String accesstoken = null;
        try {
            jstoken = HttpUtils.request(weixinActionMethodDefine);
            accesstoken = JSONObject.parseObject(jstoken).getString("access_token");
            WeixinActionMethodDefine weixinActionMethodDefine2 = new WeixinActionMethodDefine()
                    .setHttpMethod(HttpMethod.GET)
                    .setIsNeedAppid(false)
                    .setUri("/cgi-bin/ticket/getticket")
                    .putActionConfigParamter("type", "jsapi")
                    .setWeixinBaseParamter(new WeixinBaseParamter().setToken(accesstoken));
            jsticket = HttpUtils.request(weixinActionMethodDefine2);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String jsapiticket = JSONObject.parseObject(jsticket).getString("ticket");
        String expiresin1 = JSONObject.parseObject(jstoken).getString("expires_in");
        int expiresin = 0;
        if (null != expiresin1 && !"".equals(expiresin1)) {
            expiresin = Integer.parseInt(expiresin1);
        }
        // 获取到token并赋值保存
        accessToken.setCreateTime(System.currentTimeMillis() / 1000)
                .setToken(accesstoken)
                .setExpiresIn(expiresin)
                .setTicket(jsapiticket)
                .setAppid(appid)
                .setAppsecret(appSecret);

        log.info(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
                + "token为==============================" + accesstoken
                + "jsticket为==============================" + jsapiticket);
        return accessToken;
    }


}
