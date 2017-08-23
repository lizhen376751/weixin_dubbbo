package com.dudu.soa.weixindubbo.weixin.http.api;


import com.dudu.soa.weixindubbo.weixin.http.module.menu.Menu;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.AccessToken;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.OauthOpenIdToken;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.SweepPay;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.Ticket;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.WeiXinUserInfo;
import com.dudu.soa.weixindubbo.weixin.weixinmessage.ParamSendWeChat;
import com.dudu.soa.weixindubbo.weixin.weixinmessage.Template;

import java.util.HashMap;
import java.util.Map;

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
     * @return true或者false string
     */
    String createMenu(Menu menu, String appid, String appSecret);

    /**
     * 获取开发者的token
     *
     * @param appid     appid
     * @param appSecret appSecret
     * @return 开发者的token tokenget ticket
     */
    AccessToken getTokengetTicket(String appid, String appSecret);

    /**
     * 获取网页授权access_token及用户的openID
     *
     * @param code      微信code
     * @param appid     appid
     * @param appSecret appSecret
     * @return WeixinOauth2Token oauth access token
     * @throws Exception Exception
     */
    OauthOpenIdToken getOauthAccessToken(String code, String appid, String appSecret);

    /**
     * 获取用户的基本信息
     *
     * @param code   权限code
     * @param appid  微信appId
     * @param secret 微信appSecret
     * @return 微信用户的基本信息 wei xin user info
     * @throws Exception 异常
     */
    WeiXinUserInfo getWeiXinUserInfo(String code, String appid, String secret);


    /**
     * 接收微信端消息处理并做分发
     *
     * @param map map类型
     * @return 从request中获取获取参数并将其封装成的map string
     */
    String receivemessage(Map<String, String> map);

    /**
     * 模板消息的发送
     *
     * @param appid     微信appid
     * @param appSecret appsecret
     * @param template  微信的消息模板
     * @return template string
     */
    String sendTemplateMsg(String appid, String appSecret, Template template);

    /**
     * 前端jssdk页面配置需要用到的配置参数
     *
     * @param appid     微信的appid
     * @param appSecret 微信的appSecret
     * @param url       前段页面传入的url(动态的,当前网页的URL，不包含#及其后面部分）
     * @return map 签名参数
     * @throws Exception 异常
     */
    HashMap<String, String> jsSDKSign(String appid, String appSecret, String url);

    /**
     * 微信消息群发(仅限单条群发)
     *
     * @param paramSendWeChat 接口所需要的参数
     * @return 字符串 string
     */
    String sendGroupMessage(ParamSendWeChat paramSendWeChat);


    /**
     * 微信支付统一下单接口
     *
     * @param sweepPay 请求生成微信二维码的url
     * @return 微信二维码的url string
     */
    String weixinpay(SweepPay sweepPay);


    /**
     * 客服接口-发消息
     *
     * @param token 第三方开发平台的token
     * @param json  消息转换为json类型
     * @return 发送成功后的回调
     */
    String customerSmsSend(String token, String json);

    /**
     * 生成微信的临时二维码
     *
     * @param ticket 需要传入店铺编码或者联盟编码,以及需要传入的参数
     * @return ticket获取url即可
     */
    Ticket getTicket(Ticket ticket);
}
