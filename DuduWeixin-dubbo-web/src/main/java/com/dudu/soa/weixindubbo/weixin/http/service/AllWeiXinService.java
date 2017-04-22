package com.dudu.soa.weixindubbo.weixin.http.service;


import com.alibaba.fastjson.JSONObject;
import com.dudu.soa.weixindubbo.weixin.http.module.http.HttpMethod;
import com.dudu.soa.weixindubbo.weixin.http.module.http.WeixinActionMethodDefine;
import com.dudu.soa.weixindubbo.weixin.http.module.http.WeixinBaseParamter;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.AccessToken;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.OauthOpenIdToken;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.WeiXinUserInfo;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 微信基本入口的逻辑包装
 * 关于微信的服务
 */
@Service
public class AllWeiXinService {


    /**
     * 获取开发者的token
     * @param appid     appid
     * @param appSecret appSecret
     * @return 开发者的token
     * @throws IOException        网络异常
     * @throws URISyntaxException 异常
     */
    public static AccessToken getTokengetTicket(String appid, String appSecret) {
        AccessToken accessToken = new AccessToken();
        if (null == accessToken || null == accessToken.getToken() || System.currentTimeMillis() - accessToken.getCreateTime() > accessToken.getExpiresIn() * 1000) {
            WeixinActionMethodDefine weixinActionMethodDefine = new WeixinActionMethodDefine()
                    .setIsNeedAccssToken(false)
                    .setHttpMethod(HttpMethod.GET)
                    .setUri("/cgi-bin/token")
                    .setWeixinBaseParamter(new WeixinBaseParamter().setAppid(appid).setSecret(appSecret))
                    .putActionConfigParamter("grant_type", "client_credential");
            String jstoken = null;
            try {
                jstoken = HttpUtils.request(weixinActionMethodDefine);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String accesstoken = JSONObject.parseObject(jstoken).getString("access_token");
            int expiresin = Integer.parseInt(JSONObject.parseObject(jstoken).getString("expires_in"));
            // 获取到token并赋值保存
            accessToken.setCreateTime(System.currentTimeMillis())
                    .setToken(accesstoken)
                    .setExpiresIn(expiresin);
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
                    + "token为==============================" + accesstoken);
        }
        return accessToken;
    }





    /**
     * 获取网页授权access_token及用户的openID
     *
     * @param appid     appid
     * @param appSecret appSecret
     * @param code      微信code
     * @return WeixinOauth2Token
     * @throws Exception Exception
     */
//    @Override
    public OauthOpenIdToken getOauthAccessToken(String code, String appid, String appSecret) {
        try {
            WeixinActionMethodDefine weixinActionMethodDefine = new WeixinActionMethodDefine()
                    .setHttpMethod(HttpMethod.GET)
                    .setIsNeedAccssToken(false)
                    .setUri("/sns/oauth2/access_token")
                    .putActionConfigParamter("grant_type", "authorization_code")
                    .putActionConfigParamter("code", code)
                    .setWeixinBaseParamter(new WeixinBaseParamter().setAppid(appid).setSecret(appSecret));
            String request = HttpUtils.request(weixinActionMethodDefine);
            System.out.println("获取openid=========================" + request);
            OauthOpenIdToken oauthOpenIdTokennew = new OauthOpenIdToken();
            oauthOpenIdTokennew.setExpiresIn(Integer.parseInt(pareJsonDate(request, "expires_in")));
            oauthOpenIdTokennew.setOpenId(pareJsonDate(request, "openid"));
            oauthOpenIdTokennew.setScope(pareJsonDate(request, "scope"));
            oauthOpenIdTokennew.setRefreshToken(pareJsonDate(request, "refresh_token"));
            oauthOpenIdTokennew.setAccessToken(pareJsonDate(request, "access_token"));
            return oauthOpenIdTokennew;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //TODO 获取基本信息
        return null;
    }

    /**
     * 获取用户的基本信息
     *
     * @param code   权限code
     * @param appid  微信appId
     * @param secret 微信appSecret
     * @return 微信用户的基本信息
     * @throws Exception 异常
     */
    public WeiXinUserInfo getWeiXinUserInfo(String code, String appid, String secret) {
        //1.获取开发者的access_token
        AccessToken tokengetTicket = null;
        try {
            tokengetTicket = this.getTokengetTicket(appid, secret);
            String token = tokengetTicket.getToken();
            //2.获取openid
            OauthOpenIdToken oauthAccessToken = this.getOauthAccessToken(code, appid, secret);
            String openId = oauthAccessToken.getOpenId();
            WeixinActionMethodDefine weixinActionMethodDefine = new WeixinActionMethodDefine()
                    .setHttpMethod(HttpMethod.GET)
                    .setIsNeedAppid(false)
                    .setUri("/cgi-bin/user/info")
                    .putActionConfigParamter("lang", "zh_CN")
                    .putActionConfigParamter("openid", openId)
                    .setWeixinBaseParamter(new WeixinBaseParamter().setAppid(appid).setSecret(secret).setToken(token));
            String s = HttpUtils.request(weixinActionMethodDefine);
            //获取用户的昵称
            WeiXinUserInfo weiXinUserInfo = new WeiXinUserInfo()
                    .setCity(pareJsonDate(s, "city"))
                    .setCountry(pareJsonDate(s, "country"))
                    .setGroupid(pareJsonDate(s, "groupid"))
                    .setHeadimgurl(pareJsonDate(s, "headimgurl"))
                    .setLanguage(pareJsonDate(s, "language"))
                    .setNickname(pareJsonDate(s, "nickname"))
                    .setOpenid(pareJsonDate(s, "openid"))
                    .setProvince(pareJsonDate(s, "province"))
                    .setRemark(pareJsonDate(s, "remark"))
                    .setSex(pareJsonDate(s, "sex"))
                    .setSubscribe(pareJsonDate(s, "subscribe"))
                    .setSubscribetime(pareJsonDate(s, "subscribe_time"))
                    .setUnionid(pareJsonDate(s, "unionid"));
            return weiXinUserInfo;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
//TODO 配置url的方法

    /**
     * 在返回的json字符串中获取想要的属性
     *
     * @param jsonData json字符串
     * @param param    想要获取的属性参数
     * @return 得到的参数
     */
    public String pareJsonDate(String jsonData, String param) {
        String params = JSONObject.parseObject(jsonData).getString(param);
        return params;
    }
}