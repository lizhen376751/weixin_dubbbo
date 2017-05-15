package com.dudu.soa.weixindubbo.weixin.http.service;

import com.dudu.soa.weixindubbo.weixin.http.api.ApiAllWeiXiRequest;
import com.dudu.soa.weixindubbo.weixin.http.module.menu.Menu;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.AccessToken;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.OauthOpenIdToken;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.WeiXinUserInfo;
import com.dudu.soa.weixindubbo.weixin.weixinmessage.ParamSendWeChat;
import com.dudu.soa.weixindubbo.weixin.weixinmessage.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
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
     * 引入获取js签名的服务
     */
    @Autowired
    private JSSDKConfig jssdkConfig;

    /**
     * 将token、timestamp、nonce三个参数进行字典序排序
     *
     * @param signature 微信加密签名
     * @param timestamp 日期戳
     * @param nonce     随机数字
     * @param token     开发者的token
     * @return true代表匹配, false代表不匹配
     */
    @Override
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
    @Override
    public boolean createMenu(Menu menu, String appid, String appSecret) {
        boolean menu1 = weChatTask.createMenu(menu, appid, appSecret);
        return menu1;
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
    @Override
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
    @Override
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
    @Override
    public WeiXinUserInfo getWeiXinUserInfo(String code, String appid, String secret) {
        WeiXinUserInfo weiXinUserInfo = weChatTask.getWeiXinUserInfo(code, appid, secret);
        return weiXinUserInfo;
    }

    /**
     * 接收微信端消息处理并做分发
     */
    @Override
    public String receivemessage(Map<String, String> map) {
        try {
            String msgtype = map.get("MsgType");
            String message = MsgDispatcher.processMessage(map); //进入消息处理
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 模板消息的发送
     *
     * @param appid     微信appid
     * @param appSecret appsecret
     * @param template  微信的消息模板
     * @return template
     */
    @Override
    public boolean sendTemplateMsg(String appid, String appSecret, Template template) {
        boolean b = weChatTask.sendTemplateMsg(appid, appSecret, template);
        return b;
    }

    /**
     * 前端jssdk页面配置需要用到的配置参数
     *
     * @param url       前段页面传入的url(动态的,当前网页的URL，不包含#及其后面部分）
     * @param appid     微信的appid
     * @param appSecret 微信的appSecret
     * @return map 签名参数
     * @throws Exception 异常
     */
    @Override
    public HashMap<String, String> jsSDKSign(String appid, String appSecret, String url) {
        HashMap<String, String> stringStringHashMap = null;
        try {
            stringStringHashMap = jssdkConfig.jsSDKSign(appid, appSecret, url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringStringHashMap;
    }

    /**
     * 微信消息群发(仅限单条)
     *
     * @param paramSendWeChat 接口所需要的参数
     * @return
     */
    @Override
    public String sendGroupMessage(ParamSendWeChat paramSendWeChat) {
        return weChatTask.sendGroupMessage(paramSendWeChat);
    }
}
