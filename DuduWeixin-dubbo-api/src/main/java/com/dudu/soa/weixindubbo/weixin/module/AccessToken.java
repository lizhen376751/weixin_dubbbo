package com.dudu.soa.weixindubbo.weixin.module;

import java.io.Serializable;

/**
 * AccessToken凭证的实体类(微信的各个接口都需要它)
 * Created by lizhen on 2017/4/7.
 */

public class AccessToken implements Serializable {
    /**
     * 获取到的凭证
     */
    private String token;
    /**
     * 凭证有效时间，单位：秒
     */
    private int expiresIn;

    /**
     *
     * @return 获取到的凭证
     */
    public String getToken() {
        return token;
    }

    /**
     *
     * @param token 获取到的凭证
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     *
     * @return expiresIn
     */
    public int getExpiresIn() {
        return expiresIn;
    }

    /**
     *
     * @param expiresIn expiresIn
     */
    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
