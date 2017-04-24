package com.dudu.soa.weixindubbo.weixin.http.service;

import com.alibaba.fastjson.JSONObject;
import com.dudu.soa.weixindubbo.weixin.http.api.ApiAllWeiXiRequest;
import com.dudu.soa.weixindubbo.weixin.http.module.menu.Menu;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.AccessToken;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.OauthOpenIdToken;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.WeiXinUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * 微信通讯相关所有的入口
 * Created by lizhen on 2017/4/22.
 */
@Service
public class AllWeiXinRquest implements ApiAllWeiXiRequest {
    /**
     * 引入微信服务所有方法
     */
    @Autowired
    private AllWeiXinService weChatTask;

    /**
     * 将token、timestamp、nonce三个参数进行字典序排序
     *
     * @param signature 微信加密签名
     * @param timestamp 日期戳
     * @param nonce     随机数字
     * @param token     开发者的token
     * @return true代表匹配, false代表不匹配
     */
    public boolean checkSignature(String signature, String timestamp, String nonce, String token) {
        boolean b = SignUtil.checkSignature(signature, timestamp, nonce, token);
        return b;
    }

    /**
     * 生成菜单
     *
     * @param menu      菜单
     * @param appid     appid
     * @param appSecret appSecret
     */
    public void createMenu(Menu menu, String appid, String appSecret) {
        //需要token,(appid,sercert)
        AccessToken tokengetTicket = null;
        try {
            tokengetTicket = this.getTokengetTicket(appid, appSecret);
            String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", tokengetTicket.getToken());
            String jsonMenu = JSONObject.toJSONString(menu);
            String rs = HttpUtils.sendPostJson(url, jsonMenu);
            System.out.println("创建菜单成功!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取开发者的token
     *
     * @param appid     appid
     * @param appSecret appSecret
     * @return 开发者的token
     * @throws IOException        网络异常
     * @throws URISyntaxException 异常
     */
    public AccessToken getTokengetTicket(String appid, String appSecret) {
        AccessToken tokengetTicket = AllWeiXinService.getTokengetTicket(appid, appSecret);
        return tokengetTicket;
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

    public OauthOpenIdToken getOauthAccessToken(String code, String appid, String appSecret) {
        OauthOpenIdToken oauthAccessToken = weChatTask.getOauthAccessToken(code, appid, appSecret);
        return oauthAccessToken;

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
        WeiXinUserInfo weiXinUserInfo = weChatTask.getWeiXinUserInfo(code, appid, secret);
        return weiXinUserInfo;
    }

    /**
     * 接收微信端消息处理并做分发
     *
     * @param inputStream 从request中获取inputStream
     */
    public void receivemessage(InputStream inputStream) {
        try {
            Map<String, String> map = MessageUtil.parseXml(inputStream);
            String msgtype = map.get("MsgType");
            MsgDispatcher.processMessage(map); //进入消息处理
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
