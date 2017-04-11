package com.dudu.soa.weixindubbo.weixin.api;

import com.dudu.soa.weixindubbo.weixin.module.AccessToken;
import com.dudu.soa.weixindubbo.weixin.module.Menu;
import com.dudu.soa.weixindubbo.weixin.module.WeixinOauth2Token;

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
    WeixinOauth2Token getOauth2AccessToken(String appId, String appSecret, String code);

    /**
     * 获取开发者的access_token
     *
     * @param appid     凭证
     * @param appsecret 密钥
     * @return AccessToken
     */
    AccessToken getAccessToken(String appid, String appsecret);

    /**
     * 创建菜单
     *
     * @param menu        菜单实例
     * @param accessToken 有效的access_token
     * @return 0表示成功，其他值表示失败
     */
    int createMenu(Menu menu, String accessToken);
}
