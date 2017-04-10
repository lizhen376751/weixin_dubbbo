package com.dudu.soa.weixindubbo.weixin.api;

import com.dudu.soa.weixindubbo.weixin.module.WeixinOauth2Token;

/**
 * 微信的接口
 * Created by lizhen on 2017/4/10.
 */

public interface ApiWeiXindUtil {
    /**
     * 获取网页授权AccessToken
     * @param appId 微信appId
     * @param appSecret 微信appSecret
     * @param code 微信code
     * @return  WeixinOauth2Token
     */
    WeixinOauth2Token getOauth2AccessToken(String appId, String appSecret, String code);
}
