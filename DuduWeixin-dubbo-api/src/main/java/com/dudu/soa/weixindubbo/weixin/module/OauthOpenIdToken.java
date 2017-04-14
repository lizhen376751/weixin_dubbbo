package com.dudu.soa.weixindubbo.weixin.module;

import java.io.Serializable;

/**
 * 通过code换取网页授权access_token及用户的openid
 */
public class OauthOpenIdToken implements Serializable{
    /**
     * 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     */
    private String accessToken;
    /**
     * access_token接口调用凭证超时时间，单位（秒）
     */
    private int expiresIn;
    /**
     * 用户刷新access_token
     */
    private String refreshToken;
    /**
     * 用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID
     */
    private String openId;
    /**
     * 用户授权的作用域，使用逗号（,）分隔
     */
    private String scope;
    /**
     * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     */
    private String nickname;

    /**
     * @return 网页授权
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * @param accessToken accessToken
     */
    public void setAccessToken(String accessToken) {
        accessToken = accessToken;
    }

    /**
     * @return 有效时间
     */
    public int getExpiresIn() {
        return expiresIn;
    }

    /**
     * @param expiresIn 有效时间
     */
    public void setExpiresIn(int expiresIn) {
        expiresIn = expiresIn;
    }

    /**
     * @return 用户刷新access_token
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * @param refreshToken 用户刷新access_token
     */
    public void setRefreshToken(String refreshToken) {
        refreshToken = refreshToken;
    }

    /**
     * @return 用户的openid
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * @param openId 用户的openid
     */
    public void setOpenId(String openId) {
        openId = openId;
    }

    /**
     * @return 作用域
     */
    public String getScope() {
        return scope;
    }

    /**
     * @param scope 作用域
     */
    public void setScope(String scope) {
        scope = scope;
    }

    /**
     * @return 不知道
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname 不知道
     */
    public void setNickname(String nickname) {
        nickname = nickname;
    }


}
