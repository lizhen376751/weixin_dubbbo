package com.dudu.soa.weixindubbo.weixin.http.api;


import com.dudu.soa.weixindubbo.weixin.http.module.menu.Menu;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.OauthOpenIdToken;

/**
 * 微信的接口
 * Created by lizhen on 2017/4/10.
 */

public interface ApiWeiXindUtil {
    /**
     * 获取网页授权AccessToken
     * @param code      微信code
     * @return WeixinOauth2Token
     */
    OauthOpenIdToken getOauthAccessToken(String code);

    /**
     * 获取开发者的access_token
     *
     * @param appid  凭证
     * @param secret 密钥
     * @return
     */


    /**
     * 创建菜单
     *
     * @param menu 菜单实例
     * @return 0表示成功，其他值表示失败
     */
    void createMenu(Menu menu);
}
