package com.dudu.soa.weixindubbo.weixin.http;


import com.alibaba.fastjson.JSONObject;
import com.dudu.soa.weixindubbo.weixin.api.ApiWeiXindUtil;
import com.dudu.soa.weixindubbo.weixin.base.AccessToken;
import com.dudu.soa.weixindubbo.weixin.module.Menu;
import com.dudu.soa.weixindubbo.weixin.module.OauthOpenIdToken;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * 关于微信的服务
 */
@Service
public class WeChatTask implements ApiWeiXindUtil {

    /**
     * /
     * 获取到开发者的token
     *
     * @param appid  appid
     * @param secret secret
     * @return AccessToken
     * @throws Exception Exception
     */

    public AccessToken getTokengetTicket(String appid, String secret) throws Exception {
        AccessToken accessToken = new AccessToken();
        if (null == accessToken || null == accessToken.getToken() || System.currentTimeMillis() - accessToken.getCreateTime() > accessToken.getExpiresIn() * 1000) {
            Map<String, String> params = new HashMap<String, String>();
            params.put("grant_type", "client_credential");
            params.put("appid", appid);
            params.put("secret", secret);
            String jstoken = HttpUtils.sendGet("https://api.weixin.qq.com/cgi-bin/token", params);
            String accesstoken = JSONObject.parseObject(jstoken).getString("access_token");
            int expiresin = Integer.parseInt(JSONObject.parseObject(jstoken).getString("expires_in"));
            // 获取到token并赋值保存
            accessToken.setCreateTime(System.currentTimeMillis());
            accessToken.setToken(accesstoken);
            accessToken.setExpiresIn(expiresin);
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
                    + "token为==============================" + accesstoken);
        }
        return accessToken;
    }

    /**
     * 生成菜单
     *
     * @param appid  appid
     * @param secret secret
     * @param menu   menu
     * @throws Exception IOException
     */
    @Override
    public void createMenu(String appid, String secret, Menu menu) throws Exception {
        //需要token,(appid,sercert)
        AccessToken tokengetTicket = this.getTokengetTicket(appid, secret);
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", tokengetTicket.getToken());
        String jsonMenu = JSONObject.toJSONString(menu);
        String rs = HttpUtils.sendPostJson(url, jsonMenu);
        System.out.println("创建菜单成功!");
    }

    /**
     * 获取网页授权access_token及用户的openID
     *
     * @param appId     微信appId
     * @param appSecret 微信appSecret
     * @param code      微信code
     * @return WeixinOauth2Token
     * @throws Exception Exception
     */
    @Override
    public OauthOpenIdToken getOauthAccessToken(String appId, String appSecret, String code) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("grant_type", "authorization_code");
        params.put("appid", appId);
        params.put("secret", appSecret);
        params.put("code", code);
        String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token";
        String s = HttpUtils.sendGet(requestUrl, params);
        System.out.println("获取openid=========================" + s);
        return null;
    }

    /**
     * 获取用户的基本信息
     *
     * @param appid  微信appId
     * @param secret 微信appSecret
     * @param code   微信code
     * @throws Exception 异常
     */
    public void getWeiXinUserInfo(String appid, String secret, String code) throws Exception {

        //1.获取开发者的access_token
        AccessToken tokengetTicket = this.getTokengetTicket(appid, secret);
        String token = tokengetTicket.getToken();
        //2.获取openid
        OauthOpenIdToken oauthAccessToken = this.getOauthAccessToken(appid, secret, code);
        String openId = oauthAccessToken.getOpenId();
        Map<String, String> params = new HashMap<String, String>();
        params.put("lang", "zh_CN");
        params.put("access_token", token);
        params.put("openid", openId);
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/info";
        String s = HttpUtils.sendGet(requestUrl, params);
        //获取用户的昵称
        String nickname = JSONObject.parseObject(s).getString("nickname");
        //TODO 需要新建实体类,作为返回数据


    }

}
