package com.dudu.soa.weixindubbo.weixin.api;


import com.dudu.soa.weixindubbo.weixin.module.Menu;
import com.dudu.soa.weixindubbo.weixin.module.OauthOpenIdToken;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * 微信的接口
 * Created by lizhen on 2017/4/10.
 */

public interface ApiWeiXindUtil {
    /**
     * 获取网页授权AccessToken
     *
     * @param appId     微信appId
     * @param appSecret 微信appSecret
     * @param code      微信code
     * @return WeixinOauth2Token
     */
    OauthOpenIdToken getOauthAccessToken(String code) throws Exception;

    /**
     * 获取开发者的access_token
     *
     * @param appid  凭证
     * @param secret 密钥
     * @return AccessToken
     */
//    AccessToken getTokengetTicket(String appid, String secret);


    /**
     * 创建菜单
     *
     * @param menu 菜单实例
     * @return 0表示成功，其他值表示失败
     */
    void createMenu(Menu menu) throws IOException, URISyntaxException;
}
