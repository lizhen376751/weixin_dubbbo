package com.dudu.soa.weixindubbo.weixin.api;



import com.dudu.soa.weixindubbo.weixin.module.Menu;
import com.dudu.soa.weixindubbo.weixin.module.OauthOpenIdToken;

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
    OauthOpenIdToken getOauthAccessToken(String appId, String appSecret, String code) throws Exception;

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
     * @param menu   菜单实例
     * @param appid  有效的access_token
     * @param secret secret
     * @return 0表示成功，其他值表示失败
     */
    void createMenu(String appid, String secret, Menu menu) throws Exception;
}
