package com.dudu.soa.weixindubbo.weixin.http.api;


import com.dudu.soa.weixindubbo.weixin.http.module.menu.Menu;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.AccessToken;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.OauthOpenIdToken;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.WeiXinUserInfo;
import com.dudu.soa.weixindubbo.weixin.weixinmessage.Template;
import org.dom4j.Document;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

/**
 * 微信的接口
 * Created by lizhen on 2017/4/10.
 */

public interface ApiAllWeiXiRequest {
    /**
     * 将token、timestamp、nonce三个参数进行字典序排序
     *
     * @param signature 微信加密签名
     * @param timestamp 日期戳
     * @param nonce     随机数字
     * @param token     开发者的token
     * @return true代表匹配, false代表不匹配
     */
    boolean checkSignature(String signature, String timestamp, String nonce, String token);

    /**
     * 生成菜单
     *
     * @param menu      菜单
     * @param appid     appid
     * @param appSecret appSecret
     * @return true或者false
     */
    boolean createMenu(Menu menu, String appid, String appSecret);

    /**
     * 获取开发者的token
     *
     * @param appid     appid
     * @param appSecret appSecret
     * @return 开发者的token
     * @throws IOException        网络异常
     * @throws URISyntaxException 异常
     */
    AccessToken getTokengetTicket(String appid, String appSecret);

    /**
     * 获取网页授权access_token及用户的openID
     *
     * @param appid     appid
     * @param appSecret appSecret
     * @param code      微信code
     * @return WeixinOauth2Token
     * @throws Exception Exception
     */

    OauthOpenIdToken getOauthAccessToken(String code, String appid, String appSecret);

    /**
     * 获取用户的基本信息
     *
     * @param code   权限code
     * @param appid  微信appId
     * @param secret 微信appSecret
     * @return 微信用户的基本信息
     * @throws Exception 异常
     */
    WeiXinUserInfo getWeiXinUserInfo(String code, String appid, String secret);

    /**
     * 接收微信端消息处理并做分发
     *
     * @param inputStream 从request中获取inputStream
     */
    void receivemessage(Document document);

    /**
     * 模板消息的发送
     *
     * @param appid     微信appid
     * @param appSecret appsecret
     * @param template  微信的消息模板
     * @return template
     */
    boolean sendTemplateMsg(String appid, String appSecret, Template template);
    /**
     * 前端jssdk页面配置需要用到的配置参数
     *
     * @param url       前段页面传入的url(动态的,当前网页的URL，不包含#及其后面部分）
     * @param appid     微信的appid
     * @param appSecret 微信的appSecret
     * @return map 签名参数
     * @throws Exception 异常
     */
     HashMap<String, String> jsSDKSign(String appid, String appSecret, String url);
}
