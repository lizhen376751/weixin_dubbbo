package com.dudu.soa.weixindubbo.weixin.http;


import com.alibaba.fastjson.JSONObject;
import com.dudu.soa.weixindubbo.weixin.api.ApiWeiXindUtil;
import com.dudu.soa.weixindubbo.weixin.base.AccessToken;
import com.dudu.soa.weixindubbo.weixin.base.HttpMethod;
import com.dudu.soa.weixindubbo.weixin.base.WeixinActionMethodDefine;
import com.dudu.soa.weixindubbo.weixin.module.Menu;
import com.dudu.soa.weixindubbo.weixin.module.OauthOpenIdToken;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * 关于微信的服务
 */
@Service
public class WeChatTask implements ApiWeiXindUtil {

    /**
     * 获取到开发者的token
     *
     * @return AccessToken
     * @throws Exception Exception
     */
    public AccessToken getTokengetTicket() throws IOException, URISyntaxException {
        AccessToken accessToken = new AccessToken();
        if (null == accessToken || null == accessToken.getToken() || System.currentTimeMillis() - accessToken.getCreateTime() > accessToken.getExpiresIn() * 1000) {
            WeixinActionMethodDefine weixinActionMethodDefine = new WeixinActionMethodDefine()
                    .setIsNeedAccssToken(false)
                    .setHttpMethod(HttpMethod.GET)
                    .setUri("/cgi-bin/token")
                    .putActionConfigParamter("grant_type", "client_credential");
            String jstoken = HttpUtils.request(weixinActionMethodDefine);
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
     * 生成菜单
     *
     * @param menu menu
     * @throws Exception IOException
     */
    @Override
    public void createMenu(Menu menu) throws IOException, URISyntaxException {
        //需要token,(appid,sercert)
        AccessToken tokengetTicket = this.getTokengetTicket();
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", tokengetTicket.getToken());
        String jsonMenu = JSONObject.toJSONString(menu);
        String rs = HttpUtils.sendPostJson(url, jsonMenu);
        System.out.println("创建菜单成功!");
    }

    /**
     * 获取网页授权access_token及用户的openID
     *
     * @param code      微信code
     * @return WeixinOauth2Token
     * @throws Exception Exception
     */
//    @Override
    public OauthOpenIdToken getOauthAccessToken(String code) throws Exception {
        WeixinActionMethodDefine weixinActionMethodDefine = new WeixinActionMethodDefine()
                .setHttpMethod(HttpMethod.GET)
                .setIsNeedAccssToken(false)
                .setUri("/sns/oauth2/access_token")
                .putActionConfigParamter("grant_type", "authorization_code")
                .putActionConfigParamter("code", code);
        String request = HttpUtils.request(weixinActionMethodDefine);
        //TODO 获取基本信息
        System.out.println("获取openid=========================" + request);
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

//        //1.获取开发者的access_token
//        AccessToken tokengetTicket = this.getTokengetTicket(appid, secret);
//        String token = tokengetTicket.getToken();
//        //2.获取openid
//        OauthOpenIdToken oauthAccessToken = this.getOauthAccessToken(appid, secret, code);
//        String openId = oauthAccessToken.getOpenId();
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("lang", "zh_CN");
//        params.put("access_token", token);
//        params.put("openid", openId);
//        String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/info";
//        String s = HttpUtils.sendGet(requestUrl, params);
//        //获取用户的昵称
//        String nickname = JSONObject.parseObject(s).getString("nickname");
        //TODO 需要新建实体类,作为返回数据

    }
//TODO 配置url的方法
}
