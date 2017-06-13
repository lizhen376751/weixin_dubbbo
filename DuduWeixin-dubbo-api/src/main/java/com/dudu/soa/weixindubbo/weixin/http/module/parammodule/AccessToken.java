package com.dudu.soa.weixindubbo.weixin.http.module.parammodule;

import java.io.Serializable;
import java.util.Date;

/**
 * 开发者的token的实体类
 * Created by lizhen on 2017/4/14.
 */
public class AccessToken implements Serializable {

    /**
     * token
     */
    private String token;
    /**
     * 调用微信JS接口的临时票据
     */
    private String ticket;
    /**
     * 有效时间
     */
    private int expiresIn;
    /**
     * token以及ticket创建时间
     */
    private long createTime = new Date().getTime() / 1000;


    /**
     * AccessToken(开发者的token的实体类) 字符串形式
     *
     * @return AccessToken(开发者的token的实体类)字符串
     */
    @Override
    public String toString() {
        return "token:" + token + ",ticket:" + ticket + ",expiresIn:" + expiresIn + ",createTime:" + createTime;
    }

    /**
     * 获取 token
     *
     * @return token token
     */
    public String getToken() {
        return this.token;
    }

    /**
     * 设置 token
     *
     * @param token token
     * @return 返回 AccessToken(开发者的token的实体类)
     */
    public AccessToken setToken(String token) {
        this.token = token;
        return this;
    }

    /**
     * 获取 前端页面的ticket
     *
     * @return ticket 前端页面的ticket
     */
    public String getTicket() {
        return this.ticket;
    }

    /**
     * 设置 前端页面的ticket
     *
     * @param ticket 前端页面的ticket
     * @return 返回 AccessToken(开发者的token的实体类)
     */
    public AccessToken setTicket(String ticket) {
        this.ticket = ticket;
        return this;
    }

    /**
     * 获取 有效时间
     *
     * @return expiresIn 有效时间
     */
    public int getExpiresIn() {
        return this.expiresIn;
    }

    /**
     * 设置 有效时间
     *
     * @param expiresIn 有效时间
     * @return 返回 AccessToken(开发者的token的实体类)
     */
    public AccessToken setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    /**
     * 获取 token以及ticket创建时间
     *
     * @return createTime token以及ticket创建时间
     */
    public long getCreateTime() {
        return this.createTime;
    }

    /**
     * 设置 token以及ticket创建时间
     *
     * @param createTime token以及ticket创建时间
     * @return 返回 AccessToken(开发者的token的实体类)
     */
    public AccessToken setCreateTime(long createTime) {
        this.createTime = createTime;
        return this;
    }
}
