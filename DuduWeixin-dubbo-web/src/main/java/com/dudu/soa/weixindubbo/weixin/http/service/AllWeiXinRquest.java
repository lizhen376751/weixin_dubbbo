package com.dudu.soa.weixindubbo.weixin.http.service;

import com.dudu.soa.framework.exception.DuduExceptionUtil;
import com.dudu.soa.weixindubbo.shopinfo.module.ShopInfo;
import com.dudu.soa.weixindubbo.shopinfo.service.ShopInfoService;
import com.dudu.soa.weixindubbo.weixin.http.accesstoken.service.AccessTokenService;
import com.dudu.soa.weixindubbo.weixin.http.api.ApiAllWeiXiRequest;
import com.dudu.soa.weixindubbo.weixin.http.module.menu.Menu;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.AccessToken;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.OauthOpenIdToken;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.SweepPay;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.Ticket;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.WeiXinUserInfo;
import com.dudu.soa.weixindubbo.weixin.weixinconfig.module.WeiXinConfig;
import com.dudu.soa.weixindubbo.weixin.weixinconfig.service.WeiXinConfigService;
import com.dudu.soa.weixindubbo.weixin.weixinmessage.ParamSendWeChat;
import com.dudu.soa.weixindubbo.weixin.weixinmessage.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信通讯相关所有的入口
 * Created by lizhen on 2017/4/22.
 */
@Service
public class AllWeiXinRquest implements ApiAllWeiXiRequest {
    /**
     * 引入店铺信息
     */
    @Autowired
    private ShopInfoService shopInfoService;
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
     * 微信公众号的token
     */
    @Autowired
    private AccessTokenService accessTokenService;
    /**
     * 联盟微信的配置
     */
    @Autowired
    private WeiXinConfigService weiXinConfigService;

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
    public String createMenu(Menu menu, String appid, String appSecret) {
        String menu1 = weChatTask.createMenu(menu, appid, appSecret);
        return menu1;
    }

    /**
     * 获取开发者的token
     *
     * @param appid     appid
     * @param appSecret appSecret
     * @return 开发者的token tokenget ticket
     */
    @Override
    public AccessToken getTokengetTicket(String appid, String appSecret) {
        AccessToken tokengetTicket = accessTokenService.getAccessToken(appid, appSecret);
        return tokengetTicket;
    }

    /**
     * 用店铺编码或者联盟编码获取开发者的token
     *
     * @param shopCode 店铺编码
     * @param lmcode   联盟编码
     * @return 开发者的token tokenget ticket
     */
    @Override
    public AccessToken getTokenByCode(String shopCode, String lmcode) {
        String appId = "";
        String xAppSecret = "";
        if (!"".equals(shopCode) && null != shopCode && !"null".equals(shopCode)) {
            ShopInfo shopInfo = shopInfoService.getShopInfo(shopCode);
            appId = shopInfo.getwXAppId();
            xAppSecret = shopInfo.getwXAppSecret();
        } else if (!"".equals(lmcode) && null != lmcode && !"null".equals(lmcode)) {
            WeiXinConfig weiXinConfig = weiXinConfigService.getWeiXinConfig(lmcode);
            appId = weiXinConfig.getAppid();
            xAppSecret = weiXinConfig.getAppserect();
        } else {
            throw DuduExceptionUtil.throwException("微信appid以及appsecret配置未找到...");
        }
        AccessToken tokengetTicket = accessTokenService.getAccessToken(appId, xAppSecret);
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
     * 利用code获取用户的基本信息
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
     * 通过OpenID来获取用户基本信息
     *
     * @param shopCode 店铺编码
     * @param lmcode   联盟编码
     * @param openid   openid
     * @return 微信用户
     */
    @Override
    public WeiXinUserInfo getWeiXinUserInfoByOpenid(String shopCode, String lmcode, String openid) {
        WeiXinUserInfo weiXinUserInfo = weChatTask.getWeiXinUserInfoByOpenid(shopCode, lmcode, openid);
        return weiXinUserInfo;
    }

    /**
     * 接收微信端消息处理并做分发
     */
    @Override
    public String receivemessage(Map<String, String> map) {
        String back = "";
        try {
            ShopInfo shopInfo = new ShopInfo();
            String shopcode = map.get("shopcode");
            if (shopcode != null) {
                shopInfo = shopInfoService.getShopInfo(shopcode);
            }
            String message = MsgDispatcher.processMessage(map, shopInfo); //进入消息处理
            return message;
        } catch (Exception e) {
            e.printStackTrace();
            back = e.getMessage() + e.getCause();
        }
        return back;
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
    public String sendTemplateMsg(String appid, String appSecret, Template template) {
        String b = weChatTask.sendTemplateMsg(appid, appSecret, template);
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
     * 微信图文消息群发(仅限单条)
     *
     * @param paramSendWeChat 接口所需要的参数
     * @return
     */
    @Override
    public String sendGroupMessage(ParamSendWeChat paramSendWeChat) {
        return weChatTask.sendGroupMessage(paramSendWeChat);
    }

    /**
     * 微信支付统一下单接口
     *
     * @param sweepPay 请求生成微信二维码的url
     * @return 微信二维码的url
     */
    @Override
    public String weixinpay(SweepPay sweepPay) {
        return weChatTask.weixinpay(sweepPay);
    }

    /**
     * 客服接口-发送消息
     *
     * @param token 第三方开发平台的token
     * @param json  消息转换为json类型
     * @return 发送成功后的回调
     */
    @Override
    public String customerSmsSend(String token, String json) {
        return weChatTask.customerSmsSend(token, json);
    }

    /**
     * 生成微信的临时二维码
     *
     * @param ticket 需要传入店铺编码或者联盟编码,以及需要传入的参数
     * @return ticket获取url即可
     */
    @Override
    public Ticket getTicket(Ticket ticket) {
        return weChatTask.getTicket(ticket);
    }


}
